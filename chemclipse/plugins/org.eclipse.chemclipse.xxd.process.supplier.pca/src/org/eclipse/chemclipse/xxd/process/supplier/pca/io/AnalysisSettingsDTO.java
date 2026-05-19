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
package org.eclipse.chemclipse.xxd.process.supplier.pca.io;

import java.util.TreeMap;

public class AnalysisSettingsDTO {

	private String title = "";
	private int numberOfPrincipalComponents;
	private int numberOfSamplesToFilter;
	private String algorithm;
	private boolean removeUselessVariables;
	private boolean crossValidation;
	private TreeMap<Integer, Integer> filterDistribution = new TreeMap<>();
	private String labelOptionPCA;
	private String colorScheme;
	private String oplsTargetGroupName;
	private String comparisonGroup1;
	private String comparisonGroup2;
	private String variableLinePlotVariable;
	private long variableLinePlotFontSize;
	private PreprocessingSettingsDTO preprocessingSettings;

	public String getTitle() {

		return title;
	}

	public void setTitle(String title) {

		this.title = title;
	}

	public int getNumberOfPrincipalComponents() {

		return numberOfPrincipalComponents;
	}

	public void setNumberOfPrincipalComponents(int numberOfPrincipalComponents) {

		this.numberOfPrincipalComponents = numberOfPrincipalComponents;
	}

	public int getNumberOfSamplesToFilter() {

		return numberOfSamplesToFilter;
	}

	public void setNumberOfSamplesToFilter(int numberOfSamplesToFilter) {

		this.numberOfSamplesToFilter = numberOfSamplesToFilter;
	}

	public String getAlgorithm() {

		return algorithm;
	}

	public void setAlgorithm(String algorithm) {

		this.algorithm = algorithm;
	}

	public boolean isRemoveUselessVariables() {

		return removeUselessVariables;
	}

	public void setRemoveUselessVariables(boolean removeUselessVariables) {

		this.removeUselessVariables = removeUselessVariables;
	}

	public boolean isCrossValidation() {

		return crossValidation;
	}

	public void setCrossValidation(boolean crossValidation) {

		this.crossValidation = crossValidation;
	}

	public TreeMap<Integer, Integer> getFilterDistribution() {

		return filterDistribution;
	}

	public void setFilterDistribution(TreeMap<Integer, Integer> filterDistribution) {

		this.filterDistribution = filterDistribution;
	}

	public String getLabelOptionPCA() {

		return labelOptionPCA;
	}

	public void setLabelOptionPCA(String labelOptionPCA) {

		this.labelOptionPCA = labelOptionPCA;
	}

	public String getColorScheme() {

		return colorScheme;
	}

	public void setColorScheme(String colorScheme) {

		this.colorScheme = colorScheme;
	}

	public String getOplsTargetGroupName() {

		return oplsTargetGroupName;
	}

	public void setOplsTargetGroupName(String oplsTargetGroupName) {

		this.oplsTargetGroupName = oplsTargetGroupName;
	}

	public String getComparisonGroup1() {

		return comparisonGroup1;
	}

	public void setComparisonGroup1(String comparisonGroup1) {

		this.comparisonGroup1 = comparisonGroup1;
	}

	public String getComparisonGroup2() {

		return comparisonGroup2;
	}

	public void setComparisonGroup2(String comparisonGroup2) {

		this.comparisonGroup2 = comparisonGroup2;
	}

	public String getVariableLinePlotVariable() {

		return variableLinePlotVariable;
	}

	public void setVariableLinePlotVariable(String variableLinePlotVariable) {

		this.variableLinePlotVariable = variableLinePlotVariable;
	}

	public long getVariableLinePlotFontSize() {

		return variableLinePlotFontSize;
	}

	public void setVariableLinePlotFontSize(long variableLinePlotFontSize) {

		this.variableLinePlotFontSize = variableLinePlotFontSize;
	}

	public PreprocessingSettingsDTO getPreprocessingSettings() {

		return preprocessingSettings;
	}

	public void setPreprocessingSettings(PreprocessingSettingsDTO preprocessingSettings) {

		this.preprocessingSettings = preprocessingSettings;
	}
}
