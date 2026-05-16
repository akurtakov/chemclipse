/*******************************************************************************
 * Copyright (c) 2025, 2026 Lablicate GmbH.
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
	public static final int MAX_RANKED_SAMPLES = 5000;

	private final List<IDataInputEntry> dataInputEntries;
	private final List<IDataInputEntry> filterDataInputEntries;
	private int numberOfSamplesToFilter;
	private final boolean filterFileExists;
	//
	private TreeMap<Integer, Integer> featureOverlapDistribution;
	private List<Map.Entry<String, Integer>> featureOverlapList;
	private List<Map.Entry<String, Double>> sampleRankingList;
	//
	private Map<String, Integer> featureOverlap = new HashMap<>();
	private Map<String, Double> filterRanking = new HashMap<>();
	private Map<String, Sample> sampleMap = new HashMap<>();
	private Map<String, Map<String, Target>> samplesVariablesMap = new HashMap<>();
	private Map<String, Target> targetMap = new HashMap<>();
	private boolean dataRead = false;
	//
	private Map<String, Double> normalizedFilterVector = new HashMap<>();
	private boolean useCountPunishment = false;
	private double countExponent = 0.0;
	private boolean useSumPunishment = false;
	private double sumExponent = 0.0;

	// Small floor to avoid NaN/pow(0, x) surprises; set to 0.0 to allow exact zero
	private static final double MIN_RATIO = 1e-12;


	public LongFileExtractor(List<IDataInputEntry> dataInputEntries, List<IDataInputEntry> filterDataInputEntries, int numberOfSamplesToFilter) {

		this.dataInputEntries = dataInputEntries;
		this.filterDataInputEntries = filterDataInputEntries;
		this.numberOfSamplesToFilter = numberOfSamplesToFilter;
		this.filterFileExists = !filterDataInputEntries.isEmpty();
	}

	public void setUseCountPunishment(boolean useCountPunishment) {

		this.useCountPunishment = useCountPunishment;
	}

	public boolean isUseCountPunishment() {

		return useCountPunishment;
	}

	public void setCountExponent(double countExponent) {

		if(countExponent < 0.0)
			countExponent = 0.0;
		if(countExponent > 10.0)
			countExponent = 10.0;
		this.countExponent = countExponent;
	}

	public double getCountExponent() {

		return countExponent;
	}

	public void setUseSumPunishment(boolean useSumPunishment) {

		this.useSumPunishment = useSumPunishment;
	}

	public boolean isUseSumPunishment() {

		return useSumPunishment;
	}

	public void setSumExponent(double sumExponent) {

		if(sumExponent < 0.0)
			sumExponent = 0.0;
		if(sumExponent > 10.0)
			sumExponent = 10.0;
		this.sumExponent = sumExponent;
	}

	public double getSumExponent() {

		return sumExponent;
	}

	public void readData() {

		clearData();

		featureOverlapDistribution = new TreeMap<>();
		if(filterFileExists) {
			readFilterFile(filterDataInputEntries);
		}
		readFile(dataInputEntries, false);
		if(filterFileExists) {
			calculateFilterRanking();
			calculateFeatureOverlapDistribution();
		}
		dataRead = true;
	}

	public Samples filter(int numberOfSamplesToFilter) {

		if(!dataRead) {
			return null;
		}
		this.numberOfSamplesToFilter = numberOfSamplesToFilter;
		if(filterFileExists) {
			List<Map.Entry<String, Double>> rankedSamples = new ArrayList<>();
			if(this.numberOfSamplesToFilter > sampleRankingList.size() || this.numberOfSamplesToFilter == 0) {
				this.numberOfSamplesToFilter = sampleRankingList.size();
			}
			for(int i = 0; i < this.numberOfSamplesToFilter; i++) {
				rankedSamples.add(sampleRankingList.get(i));
			}
			filterRanking.clear();
			for(Map.Entry<String, Double> entry : rankedSamples) {
				filterRanking.put(entry.getKey(), entry.getValue());
			}
		}
		/*
		 * Get Filter entries. These are additional to the user selected number of samples to extract
		 */
		readFile(filterDataInputEntries, true);

		return applyFilter();
	}

	public Samples extract() {

		clearData();

		if(filterFileExists) {
			readFilterFile(filterDataInputEntries);
		}
		readFile(dataInputEntries, false);
		if(filterFileExists) {
			calculateFilterRanking();
			readFile(filterDataInputEntries, true);
		}
		return applyFilter();
	}

	private Samples applyFilter() {

		List<Sample> sampleList = new ArrayList<>(sampleMap.values());
		if(filterFileExists) {
			sampleList = sampleList.stream().filter(s -> filterRanking.containsKey(s.getSampleName())).collect(Collectors.toList());
		}
		Collections.sort(sampleList, (s1, s2) -> s1.getSampleName().compareTo(s2.getSampleName()));
		Samples samples = new Samples(sampleList);
		List<IVariable> variables = extractVariables(samplesVariablesMap);
		samples.getVariables().addAll(variables);
		setExtractData(samplesVariablesMap, samples);
		IAnalysisSettings settings = samples.getAnalysisSettings();
		settings.setFilterDistribution(featureOverlapDistribution);
		samples.setAnalysisSettings(settings);
		return samples;
	}

	public List<Map.Entry<String, Double>> getRankedSamples() {

		if(sampleRankingList == null) {
			return Collections.emptyList();
		}
		int max = Math.min(sampleRankingList.size(), MAX_RANKED_SAMPLES);
		return new ArrayList<>(sampleRankingList.subList(0, max));
	}

	/**
	 * Updated ranking calculation:
	 * - Compute cosine similarity
	 * - Compute count-based and sum-based punishments (both yield [0,1])
	 * - Adjust similarity = cosine * p1 * p2
	 */
	private void calculateFilterRanking() {

		filterRanking.clear();

		double dotProduct;
		double magnitude;
		double sumSqA;
		double sumSqB;
		double similarity;

		for(String sample : samplesVariablesMap.keySet()) {
			if(featureOverlap.containsKey(sample)) {
				dotProduct = 0;
				magnitude = 0;
				sumSqA = normalizedFilterVector.values().stream().mapToDouble(v -> v * v).sum();
				sumSqB = 0;
				similarity = 0;

				int matchingCount = 0;
				int totalMainCount = 0;
				double sumMatchingValues = 0.0;
				double sumMainValues = 0.0;

				Map<String, Target> mainVars = samplesVariablesMap.get(sample);
				totalMainCount = mainVars.size();

				for(String feature : mainVars.keySet()) {
					double target = 0.0;
					try {
						target = Double.parseDouble(mainVars.get(feature).getValue());
					} catch(NumberFormatException e) {
						target = 0.0;
					}
					sumMainValues += target;
					if(normalizedFilterVector.get(feature) != null) {
						double value = normalizedFilterVector.get(feature);
						dotProduct += value * target;
						matchingCount++;
						sumMatchingValues += target;
					}
					sumSqB += target * target;
				}

				magnitude = Math.sqrt(sumSqA) * Math.sqrt(sumSqB);
				if(magnitude != 0.0) {
					similarity = dotProduct / magnitude;

					// p1: count-based
					double p1 = 1.0;
					if(useCountPunishment) {
						if(totalMainCount <= 0) {
							p1 = 1.0;
						} else {
							double ratioCount = (double)matchingCount / (double)totalMainCount;
							ratioCount = Math.max(MIN_RATIO, Math.min(1.0, ratioCount));
							p1 = Math.pow(ratioCount, countExponent);
						}
					}

					// p2: sum-based
					double p2 = 1.0;
					if(useSumPunishment) {
						if(sumMainValues <= 0.0) {
							// can't compute ratio; skip punishment
							p2 = 1.0;
						} else {
							double ratioSum = sumMatchingValues / sumMainValues;
							ratioSum = Math.max(MIN_RATIO, Math.min(1.0, ratioSum));
							p2 = Math.pow(ratioSum, sumExponent);
						}
					}

					double adjusted = similarity * p1 * p2;
					// clamp into [0,1]
					adjusted = Math.max(0.0, Math.min(1.0, adjusted));
					filterRanking.put(sample, adjusted);
				}
			}
		}

		sampleRankingList = new ArrayList<>(filterRanking.entrySet());
		sampleRankingList.sort(Map.Entry.<String, Double> comparingByValue().reversed());
	}

	private void clearData() {

		featureOverlap.clear();
		filterRanking.clear();
		sampleMap.clear();
		samplesVariablesMap.clear();
		targetMap.clear();
		sampleRankingList = new ArrayList<>();
	}

	private void calculateFeatureOverlapDistribution() {

		featureOverlapList = new ArrayList<>(featureOverlap.entrySet());
		Collections.sort(featureOverlapList, (s1, s2) -> s1.getValue().compareTo(s2.getValue()));
		featureOverlapList = featureOverlapList.reversed();

		featureOverlapDistribution = new TreeMap<>();
		ListIterator<Entry<String, Integer>> iterator = featureOverlapList.listIterator();
		while(iterator.hasNext()) {
			Map.Entry<String, Integer> entry = iterator.next();
			int value = entry.getValue();
			if(featureOverlapDistribution.containsKey(value)) {
				int oldCount = featureOverlapDistribution.get(value);
				featureOverlapDistribution.put(value, oldCount + 1);
			} else {
				featureOverlapDistribution.put(value, 1);
			}
		}
	}

	private void readFile(List<IDataInputEntry> dataInputEntries, boolean readFilterFile) {

		for(IDataInputEntry dataInputEntry : dataInputEntries) {
			String inputFile = dataInputEntry.getInputFile();
			File file = new File(inputFile);
			if(file.exists()) {
				try (FileReader reader = new FileReader(file)) {
					List<String> filterFileNames = new ArrayList<>();
					CSVParser parser = CSVParser.parse(reader, CSVFormat.TDF.builder().setHeader().get());
					String sampleName = "";
					for(CSVRecord record : parser.getRecords()) {
						int size = record.size();
						if(size == 7) {
							sampleName = record.get(0).trim();
							String sampleDetails = record.get(1).trim();
							String variableName = record.get(2).trim();
							String variableNameLong = record.get(3).trim();
							Double value = Double.parseDouble(record.get(4).trim().replace(",", "."));
							String groupName = record.get(5).trim();
							String description = record.get(6).trim();
							if(!sampleName.isEmpty()) {
								Sample sample = sampleMap.get(sampleName);
								if(sample == null) {
									sample = new Sample(sampleName, sampleDetails, groupName, (readFilterFile) ? "1" : "0", description);
									sampleMap.put(sampleName, sample);
									if(readFilterFile) {
										if(!filterFileNames.contains("sampleName")) {
											filterFileNames.add(sampleName);
										}
									}
								} else {
									if(readFilterFile) {
										if(!filterFileNames.contains(sampleName)) {
											sampleName = sampleName + "_F";
										}
										sample = new Sample(sampleName, sampleDetails, groupName, (readFilterFile) ? "1" : "0", description);
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
									if(featureOverlap.containsKey(sampleName)) {
										int count = featureOverlap.get(sampleName) + 1;
										featureOverlap.replace(sampleName, count);
									} else {
										featureOverlap.put(sampleName, 1);
									}
								}
							}
						}
					}
					if(readFilterFile) {
						filterRanking.put(sampleName, 1.0);
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

	private void readFilterFile(List<IDataInputEntry> dataInputEntries) {

		Map<String, Map<String, Double>> filterVectors = new HashMap<>();
		String currentFilter = "";
		Map<String, Double> currentFilterVector = new HashMap<>();

		for(IDataInputEntry dataInputEntry : dataInputEntries) {
			String inputFile = dataInputEntry.getInputFile();
			File file = new File(inputFile);
			if(file.exists()) {
				try (FileReader reader = new FileReader(file)) {
					CSVParser parser = CSVParser.parse(reader, CSVFormat.TDF.builder().setHeader().get());

					for(CSVRecord record : parser.getRecords()) {
						int size = record.size();
						if(size == 7) {
							String filterName = record.get(0).trim();
							String variableName = record.get(2).trim();
							String variableNameLong = record.get(3).trim();
							Double value = Double.parseDouble(record.get(4).trim().replace(",", "."));
							if(!filterName.isEmpty()) {
								if(currentFilter.contentEquals("")) {
									currentFilter = filterName;
								}
								if(filterName.equals(currentFilter)) {
									currentFilterVector.put(variableName, value);
									if(!targetMap.containsKey(variableName)) {
										String targetName = variableName;
										Target target = new Target(targetName);
										target.setValue(Double.toString(value));
										target.setDescription(variableNameLong);
										targetMap.put(targetName, target);
									}
								} else {
									filterVectors.put(currentFilter, currentFilterVector);
									currentFilter = filterName;
									currentFilterVector = new HashMap<>();
									currentFilterVector.put(variableName, value);
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
					}
					filterVectors.put(currentFilter, currentFilterVector);

					parser.close();
				} catch(FileNotFoundException e) {
					logger.warn(e);
				} catch(IOException e) {
					logger.warn(e);
				}
			}
		}
		filterVectors.put(currentFilter, currentFilterVector);
		normalizedFilterVector = normalizeFilterVector(filterVectors);
	}

	private Map<String, Double> normalizeFilterVector(Map<String, Map<String, Double>> filterVectors) {

		HashMap<String, Double> aggregatedMap = new HashMap<>();
		double totalSum = 0.0;

		for(Map<String, Double> innerMap : filterVectors.values()) {
			for(Map.Entry<String, Double> entry : innerMap.entrySet()) {
				String key = entry.getKey();
				Double value = entry.getValue();

				aggregatedMap.put(key, aggregatedMap.getOrDefault(key, 0.0) + value);
				totalSum += value;
			}
		}

		if(totalSum == 0) {
			return aggregatedMap;
		}

		for(Map.Entry<String, Double> entry : aggregatedMap.entrySet()) {
			double normalizedValue = (entry.getValue() / totalSum) * 100.0;
			aggregatedMap.put(entry.getKey(), normalizedValue);
		}

		return aggregatedMap;
	}

	private List<IVariable> extractVariables(Map<String, Map<String, Target>> samplesVariablesMap) {

		Map<String, Target> targets = new HashMap<>();
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