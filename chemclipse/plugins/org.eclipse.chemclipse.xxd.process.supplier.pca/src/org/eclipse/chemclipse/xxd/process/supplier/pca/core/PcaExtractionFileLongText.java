/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Lorenz Gerber - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.model.statistics.IVariable;
import org.eclipse.chemclipse.model.statistics.Target;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IDataInputEntry;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.PeakSampleData;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.Sample;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.Samples;
import org.eclipse.core.runtime.IProgressMonitor;

public class PcaExtractionFileLongText implements IExtractionData {

	private static final Logger logger = Logger.getLogger(PcaExtractionFileLongText.class);
	public static final String DESCRIPTION = "PCA Data Long Format";
	public static final String FILE_EXTENSION = ".pdl";
	public static final String FILE_NAME = DESCRIPTION.replaceAll("\\s", "") + FILE_EXTENSION;
	public static final String FILTER_EXTENSION = "*" + FILE_EXTENSION;
	public static final String FILTER_NAME = DESCRIPTION + " (*" + FILE_EXTENSION + ")";
	private final List<IDataInputEntry> dataInputEntries;
	private final List<IDataInputEntry> filterDataInputEntries;

	public PcaExtractionFileLongText(List<IDataInputEntry> dataInputEntries, List<IDataInputEntry> filterDataInputEntries) {

		this.dataInputEntries = dataInputEntries;
		this.filterDataInputEntries = filterDataInputEntries;
	}

	@Override
	public Samples process(IProgressMonitor monitor) {

		return extract();
	}

	private Samples extract() {

		Map<String, Sample> sampleMap = new HashMap<>();
		Map<String, Map<String, Target>> samplesVariablesMap = new HashMap<>();
		readFile(dataInputEntries, sampleMap, samplesVariablesMap, "0");
		readFile(filterDataInputEntries, sampleMap, samplesVariablesMap, "1");
		/*
		 * extract all variables
		 */
		List<Sample> sampleList = new ArrayList<>(sampleMap.values());
		Collections.sort(sampleList, (s1, s2) -> s1.getSampleName().compareTo(s2.getSampleName()));
		Samples samples = new Samples(sampleList);
		List<? extends IVariable> variables = extractVariables(samplesVariablesMap);
		samples.getVariables().addAll(variables);
		setExtractData(samplesVariablesMap, samples);
		return samples;
	}

	private void readFile(List<IDataInputEntry> dataInputEntries, Map<String, Sample> sampleMap, Map<String, Map<String, Target>> samplesVariablesMap, String classification) {

		for(IDataInputEntry dataInputEntry : dataInputEntries) {
			String inputFile = dataInputEntry.getInputFile();
			File file = new File(inputFile);
			if(file.exists()) {
				try (FileReader reader = new FileReader(file)) {
					/*
					 * Data
					 */
					CSVFormat csvFormat = CSVFormat.TDF.builder().setHeader().build();
					CSVParser parser = new CSVParser(reader, csvFormat);
					for(CSVRecord record : parser.getRecords()) {
						int size = record.size();
						if(size == 7) {
							/*
							 * Header
							 */
							String sampleName = record.get(0).trim();
							String sampleDetails = record.get(1).trim();
							String variableName = record.get(2).trim();
							String variableNameLong = record.get(3).trim();
							Double value = Double.parseDouble(record.get(4).trim().replaceAll(",", "."));
							String groupName = record.get(5).trim();
							String description = record.get(6).trim();
							if(!sampleName.isEmpty()) {
								Sample sample = sampleMap.get(sampleName);
								if(sample == null) {
									sample = new Sample(sampleName, sampleDetails, groupName, classification, description);
									sampleMap.put(sampleName, sample);
								}
								Map<String, Target> variablesMap = samplesVariablesMap.get(sampleName);
								if(variablesMap == null) {
									variablesMap = new HashMap<>();
									samplesVariablesMap.put(sampleName, variablesMap);
								}
								String targetName = variableName;
								Target target = new Target(targetName);
								target.setValue(Double.toString(value));
								target.setDescription(variableNameLong);
								variablesMap.put(targetName, target);
							}
						}
					}
					parser.close();
				} catch(FileNotFoundException e) {
					logger.warn(e);
				} catch(IOException e) {
					logger.warn(e);
				}
			}
		}
	}

	/**
	 * Map - sample id, Map
	 * Map - variable id, IVariable
	 * 
	 * @param samplesVariablesMap
	 * @return
	 */
	private List<? extends IVariable> extractVariables(Map<String, Map<String, Target>> samplesVariablesMap) {

		Map<String, Target> targets = new HashMap<>();
		/*
		 * Map the variables
		 */
		for(Map<String, Target> variableMap : samplesVariablesMap.values()) {
			for(Target mappedVariable : variableMap.values()) {
				//
				String key = mappedVariable.getTarget();
				Target target = targets.get(key);
				if(target == null) {
					target = new Target(key);
					target.setDescription(mappedVariable.getDescription());
					targets.put(key, target);
				}
			}
		}
		List<? extends IVariable> variables = new ArrayList<>(targets.values());
		Collections.sort(variables, Comparable::compareTo);
		return variables;
	}

	private void setExtractData(Map<String, Map<String, Target>> samplesVariablesMap, Samples samples) {

		List<IVariable> variables = samples.getVariables();
		for(Sample sample : samples.getSamples()) {
			Iterator<IVariable> iterator = variables.iterator();
			Map<String, Target> extractPeak = samplesVariablesMap.get(sample.getSampleName());
			while(iterator.hasNext()) {
				String variable = iterator.next().getValue();
				Target target = extractPeak.get(variable);
				boolean addEmpty = true;
				if(target != null) {
					try {
						double value = Double.parseDouble(target.getValue());
						PeakSampleData sampleData = new PeakSampleData(value, null);
						sample.getSampleData().add(sampleData);
						addEmpty = false;
					} catch(NumberFormatException e) {
						logger.warn(e);
					}
				}
				if(addEmpty) {
					PeakSampleData sampleData = new PeakSampleData();
					sample.getSampleData().add(sampleData);
				}
			}
		}
	}
}
