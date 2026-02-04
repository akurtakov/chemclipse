/*******************************************************************************
 * Copyright (c) 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
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
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.model.statistics.IVariable;
import org.eclipse.chemclipse.model.statistics.Target;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IAnalysisSettings;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IDataInputEntry;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.PeakSampleData;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.Sample;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.Samples;

public class LongFileExtractor {

	private static final Logger logger = Logger.getLogger(PcaExtractionFileLongText.class);
	public static final String DESCRIPTION = "PCA Data Long Format";
	public static final String FILE_EXTENSION = ".pdl";
	public static final String FILE_NAME = DESCRIPTION.replaceAll("\\s", "") + FILE_EXTENSION;
	public static final String FILTER_EXTENSION = "*" + FILE_EXTENSION;
	public static final String FILTER_NAME = DESCRIPTION + " (*" + FILE_EXTENSION + ")";
	private final List<IDataInputEntry> dataInputEntries;
	private final List<IDataInputEntry> filterDataInputEntries;
	private int numberOfSamplesToFilter;
	private final boolean filter;
	//
	private TreeMap<Integer, Integer> filterDistribution;
	private List<Map.Entry<String, Integer>> filterOverlapList;
	private Map<String, Integer> filterOverlap = new HashMap<>();
	private Map<String, Sample> sampleMap = new HashMap<>();
	private Map<String, Map<String, Target>> samplesVariablesMap = new HashMap<>();
	private Map<String, Target> targetMap = new HashMap<>();
	private boolean dataRead = false;

	public LongFileExtractor(List<IDataInputEntry> dataInputEntries, List<IDataInputEntry> filterDataInputEntries, int numberOfSamplesToFilter) {

		this.dataInputEntries = dataInputEntries;
		this.filterDataInputEntries = filterDataInputEntries;
		this.numberOfSamplesToFilter = numberOfSamplesToFilter;
		this.filter = !filterDataInputEntries.isEmpty();
	}

	public Samples extract() {

		Map<String, Sample> sampleMap = new HashMap<>();
		Map<String, Map<String, Target>> samplesVariablesMap = new HashMap<>();
		Map<String, Target> targetMap = new HashMap<>();
		Map<String, Integer> filterOverlap = new HashMap<>();
		TreeMap<Integer, Integer> filterDistribution = new TreeMap<>();
		if(filter) {
			readFilterFile(filterDataInputEntries, targetMap);
		}
		readFile(dataInputEntries, sampleMap, samplesVariablesMap, targetMap, filterOverlap, "0");
		if(filter) {
			List<Map.Entry<String, Integer>> filterOverlapList = new ArrayList<>(filterOverlap.entrySet());
			Collections.sort(filterOverlapList, (s1, s2) -> s1.getValue().compareTo(s2.getValue()));
			filterOverlapList = filterOverlapList.reversed();
			filterDistribution = createDistribution(filterOverlapList);

			if(this.numberOfSamplesToFilter > filterOverlapList.size() || this.numberOfSamplesToFilter == 0) {
				this.numberOfSamplesToFilter = filterOverlapList.size();
			}
			List<Map.Entry<String, Integer>> extractedSamples = new ArrayList<>();
			for(int i = 0; i < this.numberOfSamplesToFilter; i++) {
				extractedSamples.add(filterOverlapList.get(i));
			}
			filterOverlap.clear();
			for(Map.Entry<String, Integer> entry : extractedSamples) {
				filterOverlap.put(entry.getKey(), entry.getValue());
			}
		}
		/*
		 * Get Filter entries. These are additional to the user selected number of samples to extract
		 */
		readFile(filterDataInputEntries, sampleMap, samplesVariablesMap, targetMap, filterOverlap, "1");
		/*
		 * extract all variables
		 */
		List<Sample> sampleList = new ArrayList<>(sampleMap.values());
		if(filter) {
			sampleList = sampleList.stream().filter(s -> filterOverlap.containsKey(s.getSampleName())).collect(Collectors.toList());
		}
		Collections.sort(sampleList, (s1, s2) -> s1.getSampleName().compareTo(s2.getSampleName()));
		Samples samples = new Samples(sampleList);
		List<IVariable> variables = extractVariables(samplesVariablesMap);
		samples.getVariables().addAll(variables);
		setExtractData(samplesVariablesMap, samples);
		IAnalysisSettings settings = samples.getAnalysisSettings();
		settings.setFilterDistribution(filterDistribution);
		samples.setAnalysisSettings(settings);
		return samples;
	}

	public void readData() {

		filterDistribution = new TreeMap<>();
		if(filter) {
			readFilterFile(filterDataInputEntries, targetMap);
		}
		readFile(dataInputEntries, sampleMap, samplesVariablesMap, targetMap, filterOverlap, "0");
		if(filter) {
			filterOverlapList = new ArrayList<>(filterOverlap.entrySet());
			Collections.sort(filterOverlapList, (s1, s2) -> s1.getValue().compareTo(s2.getValue()));
			filterOverlapList = filterOverlapList.reversed();
			filterDistribution = createDistribution(filterOverlapList);
		}
		dataRead = true;
	}

	public Samples filter(int numberOfSamplesToFilter) {

		if(!dataRead) {
			return null;
		}
		this.numberOfSamplesToFilter = numberOfSamplesToFilter;
		if(filter) {
			List<Map.Entry<String, Integer>> extractedSamples = new ArrayList<>();
			if(this.numberOfSamplesToFilter > filterOverlapList.size() || this.numberOfSamplesToFilter == 0) {
				this.numberOfSamplesToFilter = filterOverlapList.size();
			}
			for(int i = 0; i < this.numberOfSamplesToFilter; i++) {
				extractedSamples.add(filterOverlapList.get(i));
			}
			filterOverlap.clear();
			for(Map.Entry<String, Integer> entry : extractedSamples) {
				filterOverlap.put(entry.getKey(), entry.getValue());
			}
		}
		/*
		 * Get Filter entries. These are additional to the user selected number of samples to extract
		 */
		readFile(filterDataInputEntries, sampleMap, samplesVariablesMap, targetMap, filterOverlap, "1");
		/*
		 * extract all variables
		 */
		List<Sample> sampleList = new ArrayList<>(sampleMap.values());
		if(filter) {
			sampleList = sampleList.stream().filter(s -> filterOverlap.containsKey(s.getSampleName())).collect(Collectors.toList());
		}
		Collections.sort(sampleList, (s1, s2) -> s1.getSampleName().compareTo(s2.getSampleName()));
		Samples samples = new Samples(sampleList);
		List<IVariable> variables = extractVariables(samplesVariablesMap);
		samples.getVariables().addAll(variables);
		setExtractData(samplesVariablesMap, samples);
		IAnalysisSettings settings = samples.getAnalysisSettings();
		settings.setFilterDistribution(filterDistribution);
		samples.setAnalysisSettings(settings);

		return samples;

	}

	private TreeMap<Integer, Integer> createDistribution(List<Map.Entry<String, Integer>> overlaps) {

		TreeMap<Integer, Integer> filterDistribution = new TreeMap<>();
		ListIterator<Entry<String, Integer>> iterator = overlaps.listIterator();
		while(iterator.hasNext()) {
			Map.Entry<String, Integer> entry = iterator.next();
			int value = entry.getValue();
			if(filterDistribution.containsKey(value)) {
				int oldCount = filterDistribution.get(value);
				filterDistribution.put(value, oldCount + 1);
			} else {
				filterDistribution.put(value, 1);
			}
		}
		return filterDistribution;
	}

	private void readFilterFile(List<IDataInputEntry> dataInputEntries, Map<String, Target> targetMap) {

		for(IDataInputEntry dataInputEntry : dataInputEntries) {
			String inputFile = dataInputEntry.getInputFile();
			File file = new File(inputFile);
			if(file.exists()) {
				try (FileReader reader = new FileReader(file)) {
					/*
					 * Data
					 */
					CSVParser parser = CSVParser.parse(reader, CSVFormat.TDF.builder().setHeader().get());
					for(CSVRecord record : parser.getRecords()) {
						int size = record.size();
						if(size == 7) {
							/*
							 * Header
							 */
							String sampleName = record.get(0).trim();
							String variableName = record.get(2).trim();
							String variableNameLong = record.get(3).trim();
							Double value = Double.parseDouble(record.get(4).trim().replace(",", "."));
							if(!sampleName.isEmpty()) {
								if(!targetMap.containsKey(variableName)) {
									String targetName = variableName;
									Target target = new Target(targetName);
									target.setValue(Double.toString(value));
									target.setDescription(variableNameLong);
									targetMap.put(targetName, target);
								}
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

	private void readFile(List<IDataInputEntry> dataInputEntries, Map<String, Sample> sampleMap, Map<String, Map<String, Target>> samplesVariablesMap, Map<String, Target> targetMap, Map<String, Integer> filterOverlap, String classification) {

		for(IDataInputEntry dataInputEntry : dataInputEntries) {
			String inputFile = dataInputEntry.getInputFile();
			File file = new File(inputFile);
			if(file.exists()) {
				try (FileReader reader = new FileReader(file)) {
					/*
					 * Data
					 */
					List<String> filterFileNames = new ArrayList<>();
					CSVParser parser = CSVParser.parse(reader, CSVFormat.TDF.builder().setHeader().get());
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
							Double value = Double.parseDouble(record.get(4).trim().replace(",", "."));
							String groupName = record.get(5).trim();
							String description = record.get(6).trim();
							if(!sampleName.isEmpty()) {
								Sample sample = sampleMap.get(sampleName);
								if(sample == null) {
									sample = new Sample(sampleName, sampleDetails, groupName, classification, description);
									sampleMap.put(sampleName, sample);
									if(classification.equals("1")) {
										if(!filterFileNames.contains("sampleName")) {
											filterFileNames.add(sampleName);
										}
									}
								} else {
									if(classification.equals("1")) {
										if(!filterFileNames.contains(sampleName)) {
											sampleName = sampleName + "_F";
										}
										sample = new Sample(sampleName, sampleDetails, groupName, classification, description);
										sampleMap.put(sampleName, sample);
									}
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
								if(targetMap.containsKey(targetName)) {
									if(filterOverlap.containsKey(sampleName)) {
										int count = filterOverlap.get(sampleName) + 1;
										filterOverlap.replace(sampleName, count);
									} else {
										filterOverlap.put(sampleName, 1);
									}
								}
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
	private List<IVariable> extractVariables(Map<String, Map<String, Target>> samplesVariablesMap) {

		Map<String, Target> targets = new HashMap<>();
		/*
		 * Map the variables
		 */
		for(Map<String, Target> variableMap : samplesVariablesMap.values()) {
			for(Target mappedVariable : variableMap.values()) {
				String key = mappedVariable.getTarget();
				Target target = targets.get(key);
				if(target == null) {
					target = new Target(key);
					target.setDescription(mappedVariable.getDescription());
					target.setClassification("");
					targets.put(key, target);
				}
			}
		}
		List<IVariable> variables = new ArrayList<>(targets.values());
		Collections.sort(variables, Comparable::compareTo);
		return variables;
	}

	private void setExtractData(Map<String, Map<String, Target>> samplesVariablesMap, Samples samples) {

		List<IVariable> variables = samples.getVariables();
		for(Sample sample : samples.getSamples()) {
			if(sample.getSampleData().size() == 0) {
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

}
