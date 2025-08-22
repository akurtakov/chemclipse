/*******************************************************************************
 * Copyright (c) 2017, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Jan Holy - initial API and implementation
 * Philip Wenig - added a title
 * Lorenz Gerber - Opls Target Selection
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.model;

import java.util.TreeMap;

import org.eclipse.chemclipse.xxd.process.supplier.pca.core.IPreprocessingSettings;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.PreprocessingSettings;
import org.eclipse.chemclipse.xxd.process.supplier.pca.preferences.PreferenceSupplier;

public class AnalysisSettings implements IAnalysisSettings {

	private String title = "";
	private int numberOfPrincipalComponents = PreferenceSupplier.getNumberOfPrincipalComponents();
	private int numberOfSamplesToFilter = PreferenceSupplier.getNumberOfSamplesToFilter();
	private Algorithm algorithm = PreferenceSupplier.getAlgorithm();
	private boolean removeUselessVariables = PreferenceSupplier.isRemoveUselessVariables();
	private boolean crossValidation = PreferenceSupplier.isCrossValidation();
	private TreeMap<Integer, Integer> filterDistribution = new TreeMap<>();
	private LabelOptionPCA labelOptionPCA = PreferenceSupplier.getLabelOptionPCA();
	private String colorScheme = PreferenceSupplier.getColorScheme();
	private String groupName = "--";

	private IPreprocessingSettings preprocessingSettings = new PreprocessingSettings();

	public AnalysisSettings() {

	}

	public AnalysisSettings(IAnalysisSettings analysisSettings) {

		this.numberOfPrincipalComponents = analysisSettings.getNumberOfPrincipalComponents();
		this.numberOfSamplesToFilter = analysisSettings.getNumberOfSamplesToFilter();
		this.algorithm = analysisSettings.getAlgorithm();
		this.crossValidation = analysisSettings.getCrossValidation();
		this.filterDistribution = analysisSettings.getFilterDistribution();
		this.removeUselessVariables = analysisSettings.isRemoveUselessVariables();
		this.labelOptionPCA = analysisSettings.getLabelOptionPCA();

		this.preprocessingSettings = new PreprocessingSettings(analysisSettings.getPreprocessingSettings());
	}

	@Override
	public String getTitle() {

		return title;
	}

	@Override
	public void setTitle(String title) {

		this.title = title;
	}

	@Override
	public int getNumberOfPrincipalComponents() {

		return numberOfPrincipalComponents;
	}

	@Override
	public void setNumberOfPrincipalComponents(int numberOfPrincipalComponents) {

		this.numberOfPrincipalComponents = numberOfPrincipalComponents;
	}

	@Override
	public int getNumberOfSamplesToFilter() {

		return numberOfSamplesToFilter;
	}

	public void setNumberOfSamplesToFilter(int numberOfSamplesToFilter) {

		this.numberOfSamplesToFilter = numberOfSamplesToFilter;
	}

	@Override
	public Algorithm getAlgorithm() {

		return this.algorithm;
	}

	@Override
	public void setAlgorithm(Algorithm algorithm) {

		this.algorithm = algorithm;
	}

	@Override
	public boolean getCrossValidation() {

		return this.crossValidation;
	}

	@Override
	public void setCrossValidation(boolean crossValidation) {

		this.crossValidation = crossValidation;
	}

	@Override
	public String getOplsTargetGroupName() {

		return this.groupName;
	}

	@Override
	public void setOplsTargetGroupName(String groupName) {

		this.groupName = groupName;
	}

	@Override
	public boolean isRemoveUselessVariables() {

		return removeUselessVariables;
	}

	@Override
	public void setRemoveUselessVariables(boolean removeUselessVariables) {

		this.removeUselessVariables = removeUselessVariables;
	}

	@Override
	public LabelOptionPCA getLabelOptionPCA() {

		return labelOptionPCA;
	}

	@Override
	public void setLabelOptionPCA(LabelOptionPCA labelOptionPCA) {

		this.labelOptionPCA = labelOptionPCA;
	}

	@Override
	public String getColorScheme() {

		return colorScheme;
	}

	@Override
	public void setColorScheme(String colorScheme) {

		this.colorScheme = colorScheme;
	}

	@Override
	public IPreprocessingSettings getPreprocessingSettings() {

		return preprocessingSettings;
	}

	@Override
	public void setPreprocessingSettings(IPreprocessingSettings preprocessingSettings) {

		this.preprocessingSettings = preprocessingSettings;
	}

	@Override
	public TreeMap<Integer, Integer> getFilterDistribution() {

		return filterDistribution;
	}

	@Override
	public void setFilterDistribution(TreeMap<Integer, Integer> distribution) {

		this.filterDistribution = distribution;
	}
}