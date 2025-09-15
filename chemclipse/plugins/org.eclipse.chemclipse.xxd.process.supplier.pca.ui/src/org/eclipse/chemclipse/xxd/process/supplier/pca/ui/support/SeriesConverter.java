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
 * Philip Wenig - getting rid of JavaFX
 * Lorenz Gerber - fix sample selection
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.ui.support;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.inference.TTest;
import org.apache.commons.math3.util.FastMath;
import org.eclipse.chemclipse.model.statistics.ISample;
import org.eclipse.chemclipse.model.statistics.IVariable;
import org.eclipse.chemclipse.swt.ui.support.Colors;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IResultMVA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IResultsMVA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.ISamplesPCA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.LabelOptionPCA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.xxd.process.supplier.pca.ui.Activator;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swtchart.ILineSeries.PlotSymbolType;
import org.eclipse.swtchart.extensions.core.ISeriesData;
import org.eclipse.swtchart.extensions.core.SeriesData;
import org.eclipse.swtchart.extensions.scattercharts.IScatterSeriesData;
import org.eclipse.swtchart.extensions.scattercharts.IScatterSeriesSettings;
import org.eclipse.swtchart.extensions.scattercharts.ScatterSeriesData;

public class SeriesConverter {

	public static List<IScatterSeriesData> basisVectorsToSeries(IResultsMVA pcaResults, List<IVariable> highlighted, int pcX, int pcY) {

		IPreferenceStore preferenceStore = Activator.getDefault().getPreferenceStore();
		List<IScatterSeriesData> scatterSeriesDataList = new ArrayList<>();
		List<IVariable> variables = pcaResults.getExtractedVariables();

		for(int i = 0; i < variables.size(); i++) {
			IVariable variable = variables.get(i);
			String name = variables.get(i).getValue();

			double x = 0;
			if(pcX != 0) {
				x = pcaResults.getLoadingVectors().get(pcX - 1)[i];
			} else {
				x = i;
			}
			double y = pcaResults.getLoadingVectors().get(pcY - 1)[i];
			ISeriesData seriesData = new SeriesData(new double[]{x}, new double[]{y}, name);
			IScatterSeriesData scatterSeriesData = new ScatterSeriesData(seriesData);
			IScatterSeriesSettings scatterSeriesSettings = scatterSeriesData.getSettings();
			scatterSeriesSettings.setSymbolColor(variable.isSelected() ? Colors.RED : Colors.GRAY);
			scatterSeriesSettings.setSymbolType(createFromSettings(preferenceStore, PreferenceSupplier.P_LOADING_PLOT_2D_SYMBOL_TYPE));
			if(highlighted.contains(variable)) {
				scatterSeriesSettings.setSymbolType(createFromSettings(preferenceStore, PreferenceSupplier.P_LOADING_PLOT_2D_HIGHLIGHT_SYMBOL_TYPE));
			}
			scatterSeriesSettings.setSymbolSize(preferenceStore.getInt(PreferenceSupplier.P_LOADING_PLOT_2D_SYMBOL_SIZE));
			IScatterSeriesSettings scatterSeriesSettingsHighlight = (IScatterSeriesSettings)scatterSeriesSettings.getSeriesSettingsHighlight();
			scatterSeriesSettingsHighlight.setSymbolColor(Colors.RED);
			scatterSeriesSettingsHighlight.setSymbolSize(preferenceStore.getInt(PreferenceSupplier.P_LOADING_PLOT_2D_SYMBOL_SIZE) + 2);
			scatterSeriesDataList.add(scatterSeriesData);
		}
		return scatterSeriesDataList;
	}

	public static List<IScatterSeriesData> basisVectorsToSeriesDescription(IResultsMVA pcaResults, int pcX, int pcY) {

		IPreferenceStore preferenceStore = Activator.getDefault().getPreferenceStore();
		List<IScatterSeriesData> scatterSeriesDataList = new ArrayList<>();
		List<IVariable> variables = pcaResults.getExtractedVariables();

		for(int i = 0; i < variables.size(); i++) {
			IVariable variable = variables.get(i);
			String description = variable.getDescription();
			String name = null;
			if(description == null || description.isEmpty()) {
				name = variables.get(i).getValue();
			} else {
				name = description;
			}

			double x = 0;
			if(pcX != 0) {
				x = pcaResults.getLoadingVectors().get(pcX - 1)[i];
			} else {
				x = i;
			}
			double y = pcaResults.getLoadingVectors().get(pcY - 1)[i];
			ISeriesData seriesData = new SeriesData(new double[]{x}, new double[]{y}, name);
			IScatterSeriesData scatterSeriesData = new ScatterSeriesData(seriesData);
			IScatterSeriesSettings scatterSeriesSettings = scatterSeriesData.getSettings();

			if(variable.isSelected()) {
				scatterSeriesSettings.setSymbolColor(Colors.RED);
			} else {
				scatterSeriesSettings.setSymbolColor(Colors.GRAY);
			}
			scatterSeriesSettings.setSymbolType(createFromSettings(preferenceStore, PreferenceSupplier.P_LOADING_PLOT_2D_SYMBOL_TYPE));
			scatterSeriesSettings.setSymbolSize(preferenceStore.getInt(PreferenceSupplier.P_LOADING_PLOT_2D_SYMBOL_SIZE));
			IScatterSeriesSettings scatterSeriesSettingsHighlight = (IScatterSeriesSettings)scatterSeriesSettings.getSeriesSettingsHighlight();
			scatterSeriesSettingsHighlight.setSymbolColor(Colors.RED);
			scatterSeriesSettingsHighlight.setSymbolSize(preferenceStore.getInt(PreferenceSupplier.P_LOADING_PLOT_2D_SYMBOL_SIZE) + 2);
			scatterSeriesDataList.add(scatterSeriesData);
		}
		return scatterSeriesDataList;
	}

	public static List<IScatterSeriesData> sampleToSeries(IResultsMVA resultsPCA, List<ISample> highlighted, int pcX, int pcY, Map<ISample, IResultMVA> extractedPcaResults) {

		IPreferenceStore preferenceStore = Activator.getDefault().getPreferenceStore();
		List<IScatterSeriesData> scatterSeriesDataList = new ArrayList<>();
		extractedPcaResults.clear();
		/*
		 * Group Colors
		 */
		List<IResultMVA> resultList = resultsPCA.getPcaResultList();
		LabelOptionPCA labelOptionPCA = resultsPCA.getPcaSettings().getLabelOptionPCA();

		for(int i = 0; i < resultList.size(); i++) {
			IResultMVA pcaResult = resultList.get(i);
			/*
			 * Create the series.
			 */
			String sampleName = pcaResult.getSample().getSampleName();
			String description;
			switch(labelOptionPCA) {
				case GROUP_NAME:
					description = pcaResult.getSample().getGroupName();
					break;
				case CLASSIFICATION:
					description = pcaResult.getSample().getClassification();
					break;
				case DESCRIPTION:
					description = pcaResult.getSample().getDescription();
					break;
				default:
					description = sampleName;
					break;
			}

			extractedPcaResults.put(pcaResult.getSample(), pcaResult);
			if(!pcaResult.isDisplayed()) {
				continue;
			}
			double[] eigenSpace = pcaResult.getScoreVector();
			double x = 0;
			if(pcX != 0) {
				x = eigenSpace[pcX - 1]; // e.g. 0 = PC1
			} else {
				x = i;
			}
			double y = eigenSpace[pcY - 1]; // e.g. 1 = PC2
			String sampleInstanceId = pcaResult.getSample().getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(pcaResult.getSample()));
			ISeriesData seriesData = new SeriesData(new double[]{x}, new double[]{y}, sampleInstanceId);
			/*
			 * Set the color.
			 */
			IScatterSeriesData scatterSeriesData = new ScatterSeriesData(seriesData);
			IScatterSeriesSettings scatterSeriesSettings = scatterSeriesData.getSettings();
			scatterSeriesSettings.setDescription(description);
			scatterSeriesSettings.setSymbolType(createFromSettings(preferenceStore, PreferenceSupplier.P_SCORE_PLOT_2D_SYMBOL_TYPE));
			if(highlighted.contains(pcaResult.getSample())) {
				scatterSeriesSettings.setSymbolType(createFromSettings(preferenceStore, PreferenceSupplier.P_SCORE_PLOT_2D_HIGHLIGHT_SYMBOL_TYPE));
			}
			scatterSeriesSettings.setSymbolSize(preferenceStore.getInt(PreferenceSupplier.P_SCORE_PLOT_2D_SYMBOL_SIZE));
			Color color = Colors.getColor(pcaResult.getSample().getRGB());
			if(pcaResult.isSelected()) {
				scatterSeriesSettings.setSymbolColor(Colors.GRAY);
			} else {
				scatterSeriesSettings.setSymbolColor(color);
			}
			IScatterSeriesSettings scatterSeriesSettingsHighlight = (IScatterSeriesSettings)scatterSeriesSettings.getSeriesSettingsHighlight();
			scatterSeriesSettingsHighlight.setSymbolColor(Colors.RED);
			scatterSeriesDataList.add(scatterSeriesData);
		}

		return scatterSeriesDataList;
	}

	public static List<IScatterSeriesData> foldChangeToSeries(ISamplesPCA<IVariable, ISample> samples, String group1, String group2) {

		IPreferenceStore preferenceStore = Activator.getDefault().getPreferenceStore();
		List<IScatterSeriesData> scatterSeriesDataList = new ArrayList<>();
		/*
		 * Find Samples per Group
		 */
		List<ISample> samples1 = new ArrayList<>();
		List<ISample> samples2 = new ArrayList<>();
		for(ISample sample : samples.getSamples()) {
			if(sample.getGroupName().equals(group1)) {
				samples1.add(sample);
			} else if(sample.getGroupName().equals(group2)) {
				samples2.add(sample);
			}
		}
		/*
		 * Cycle through all (active) variables
		 */
		for(int i = 0; i < samples.getVariables().size(); i++) {

			if(samples.getVariables().get(i).isSelected()) {
				DescriptiveStatistics stats1 = new DescriptiveStatistics();
				DescriptiveStatistics stats2 = new DescriptiveStatistics();
				for(int j = 0; j < samples1.size(); j++) {
					stats1.addValue(samples1.get(j).getSampleData().get(i).getData());
				}
				for(int j = 0; j < samples2.size(); j++) {

					stats2.addValue(samples2.get(j).getSampleData().get(i).getData());
				}
				if(stats1.getN() > 2 && stats2.getN() > 2) {
					TTest test = new TTest();
					double pValue = test.tTest(stats1.getValues(), stats2.getValues());
					double mean1 = stats1.getMean();
					double mean2 = stats2.getMean();
					double foldChange = mean1 / mean2;
					double minLog10pValue = -FastMath.log10(pValue);
					double log2FoldChange = FastMath.log(foldChange) / FastMath.log(2);
					ISeriesData seriesData = new SeriesData(new double[]{log2FoldChange}, new double[]{minLog10pValue}, Integer.toString(i));
					IScatterSeriesData scatterSeriesData = new ScatterSeriesData(seriesData);
					IScatterSeriesSettings scatterSeriesSettings = scatterSeriesData.getSettings();
					// scatterSeriesSettings.setDescription(samples.getVariables().get(i).getDescription());
					scatterSeriesSettings.setSymbolType(createFromSettings(preferenceStore, PreferenceSupplier.P_FOLD_CHANGE_PLOT_SYMBOL_TYPE));
					scatterSeriesSettings.setSymbolSize(preferenceStore.getInt(PreferenceSupplier.P_FOLD_CHANGE_PLOT_SYMBOL_SIZE));
					if(seriesData.getYSeries()[0] > -FastMath.log10(0.05)) {
						if(seriesData.getXSeries()[0] > 1.0) {
							scatterSeriesSettings.setSymbolColor(Colors.RED);
						} else if(seriesData.getXSeries()[0] > 0.0) {
							scatterSeriesSettings.setSymbolColor(Colors.LIGHT_RED);
						} else if(seriesData.getXSeries()[0] < -1.0) {
							scatterSeriesSettings.setSymbolColor(Colors.BLUE);
						} else {
							scatterSeriesSettings.setSymbolColor(Colors.CYAN);
						}

					} else {
						scatterSeriesSettings.setSymbolColor(Colors.GRAY);
					}

					scatterSeriesDataList.add(scatterSeriesData);
				}

			}
		}

		return scatterSeriesDataList;

	}

	private static PlotSymbolType createFromSettings(IPreferenceStore preferenceStore, String name) {

		try {
			return PlotSymbolType.valueOf(preferenceStore.getString(name));
		} catch(Exception e) {
			return PlotSymbolType.CIRCLE;
		}
	}
}