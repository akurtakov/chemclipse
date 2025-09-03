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
 * Philip Wenig - added a title field
 * Lorenz Gerber - added Opls Target Group field
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.model;

import java.util.TreeMap;

import org.eclipse.chemclipse.xxd.process.supplier.pca.core.IPreprocessingSettings;

public interface IAnalysisSettings {

	void setTitle(String title);

	String getTitle();

	void setNumberOfPrincipalComponents(int numberOfPrincipalComponents);

	void setNumberOfSamplesToFilter(int numberOfSamplesToFilter);

	int getNumberOfPrincipalComponents();

	int getNumberOfSamplesToFilter();

	Algorithm getAlgorithm();

	void setAlgorithm(Algorithm algorithm);

	String getOplsTargetGroupName();

	void setOplsTargetGroupName(String groupName);

	boolean isRemoveUselessVariables();

	void setRemoveUselessVariables(boolean removeUselessVariables);

	LabelOptionPCA getLabelOptionPCA();

	void setLabelOptionPCA(LabelOptionPCA labelOptionPCA);

	void setPreprocessingSettings(IPreprocessingSettings preprocessingSettings);

	IPreprocessingSettings getPreprocessingSettings();

	void setColorScheme(String colorScheme);

	String getColorScheme();

	boolean getCrossValidation();

	void setCrossValidation(boolean crossValidation);

	String getComparisonGroup1();

	void setComparisonGroup1(String comparisonGroup1);

	String getComparisonGroup2();

	void setComparisonGroup2(String comparisonGroup2);

	TreeMap<Integer, Integer> getFilterDistribution();

	void setFilterDistribution(TreeMap<Integer, Integer> distribution);
}