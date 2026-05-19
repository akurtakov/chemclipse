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

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.eclipse.chemclipse.model.statistics.IMassToChargeRatio;
import org.eclipse.chemclipse.model.statistics.IPeakNumber;
import org.eclipse.chemclipse.model.statistics.IRetentionIndex;
import org.eclipse.chemclipse.model.statistics.IRetentionTime;
import org.eclipse.chemclipse.model.statistics.ISample;
import org.eclipse.chemclipse.model.statistics.ISampleData;
import org.eclipse.chemclipse.model.statistics.ITarget;
import org.eclipse.chemclipse.model.statistics.IVariable;
import org.eclipse.chemclipse.model.statistics.MassToChargeRatio;
import org.eclipse.chemclipse.model.statistics.PeakNumber;
import org.eclipse.chemclipse.model.statistics.RetentionIndex;
import org.eclipse.chemclipse.model.statistics.RetentionTime;
import org.eclipse.chemclipse.model.statistics.Target;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.IPreprocessingSettings;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.PreprocessingSettings;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.preprocessing.CenteringMean;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.preprocessing.CenteringMedian;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.preprocessing.HalfMinimumValuesReplacer;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.preprocessing.ICentering;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.preprocessing.INormalization;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.preprocessing.IReplacer;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.preprocessing.ITransformation;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.preprocessing.MeanValuesReplacer;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.preprocessing.MedianValuesReplacer;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.preprocessing.Normalization1Norm;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.preprocessing.Normalization2Norm;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.preprocessing.NormalizationInfNorm;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.preprocessing.ScalingAuto;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.preprocessing.ScalingLevel;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.preprocessing.ScalingNone;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.preprocessing.ScalingPareto;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.preprocessing.ScalingRange;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.preprocessing.ScalingVast;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.preprocessing.SmallValuesReplacer;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.preprocessing.TransformationLOG10;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.preprocessing.TransformationPower;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.Algorithm;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.AnalysisSettings;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.EvaluationPCA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.Feature;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.FeatureDataMatrix;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IAnalysisSettings;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IResultMVA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IResultsMVA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.ISamplesPCA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.LabelOptionPCA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.PeakSampleData;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.ResultMVA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.ResultsPCA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.Sample;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.Samples;

public class EvaluationPCAMapper {

	private EvaluationPCAMapper() {

	}

	public static EvaluationPCADTO toDTO(EvaluationPCA evaluation) {

		EvaluationPCADTO dto = new EvaluationPCADTO();
		ISample[] sampleArray = evaluation.getSamples().getSamples().toArray(ISample[]::new);
		IVariable[] variableArray = evaluation.getSamples().getVariables().toArray(IVariable[]::new);
		dto.setSamples(samplesToDTO(evaluation.getSamples()));
		if(evaluation.getResults() != null) {
			dto.setResults(resultsToPCADTO(evaluation.getResults(), sampleArray));
		}
		if(evaluation.getFeatureDataMatrix() != null) {
			dto.setFeatureDataMatrix(featureDataMatrixToDTO(evaluation.getFeatureDataMatrix()));
		}
		dto.setHighlightedSampleIndices(indiciesOf(evaluation.getHighlightedSamples(), sampleArray));
		dto.setHighlightedVariableIndices(indiciesOf(evaluation.getHighlightedVariables(), variableArray));
		return dto;
	}

	public static EvaluationPCA toDomain(EvaluationPCADTO dto) {

		Samples samples = dtoToSamples(dto.getSamples());
		AnalysisSettings analysisSettings = dtoToAnalysisSettings(dto.getSamples().getAnalysisSettings());
		samples.setAnalysisSettings(analysisSettings);
		ResultsPCA results = null;
		if(dto.getResults() != null) {
			results = dtoToResultsPCA(dto.getResults(), samples.getSamples(), analysisSettings);
		}
		@SuppressWarnings("unchecked")
		ISamplesPCA<IVariable, ISample> samplesTyped = (ISamplesPCA<IVariable, ISample>)(Object) samples;
		EvaluationPCA evaluation = new EvaluationPCA(samplesTyped, results);
		if(dto.getFeatureDataMatrix() != null) {
			evaluation.setFeatureDataMatrix(dtoToFeatureDataMatrix(dto.getFeatureDataMatrix()));
		}
		List<ISample> allSamples = new ArrayList<>(samples.getSamples());
		List<ISample> highlightedSamples = new ArrayList<>();
		for(int idx : dto.getHighlightedSampleIndices()) {
			if(idx >= 0 && idx < allSamples.size()) {
				highlightedSamples.add(allSamples.get(idx));
			}
		}
		evaluation.setHighlightedSamples(highlightedSamples);
		List<IVariable> allVariables = samples.getVariables();
		List<IVariable> highlightedVariables = new ArrayList<>();
		for(int idx : dto.getHighlightedVariableIndices()) {
			if(idx >= 0 && idx < allVariables.size()) {
				highlightedVariables.add(allVariables.get(idx));
			}
		}
		evaluation.setHighlightedVariables(highlightedVariables);
		return evaluation;
	}

	// ---- samples -----------------------------------------------------------

	private static SamplesDTO samplesToDTO(ISamplesPCA<IVariable, ISample> pcaSamples) {

		SamplesDTO dto = new SamplesDTO();
		List<SampleDTO> sampleDTOs = new ArrayList<>();
		for(ISample s : pcaSamples.getSamples()) {
			sampleDTOs.add(sampleToDTO(s));
		}
		dto.setSamples(sampleDTOs);
		List<VariableDTO> varDTOs = new ArrayList<>();
		for(IVariable v : pcaSamples.getVariables()) {
			varDTOs.add(variableToDTO(v));
		}
		dto.setVariables(varDTOs);
		dto.setAnalysisSettings(analysisSettingsToDTO(pcaSamples.getAnalysisSettings()));
		return dto;
	}

	private static SampleDTO sampleToDTO(ISample sample) {

		SampleDTO dto = new SampleDTO();
		dto.setSampleName(sample.getSampleName());
		dto.setSampleDetails(sample.getSampleDetails());
		dto.setGroupName(sample.getGroupName());
		dto.setClassification(sample.getClassification());
		dto.setDescription(sample.getDescription());
		dto.setSelected(sample.isSelected());
		dto.setPredicted(sample.isPredicted());
		dto.setRgb(sample.getRGB());
		List<PeakSampleDataDTO> dataDTOs = new ArrayList<>();
		for(ISampleData<?> d : sample.getSampleData()) {
			PeakSampleDataDTO dataDTO = new PeakSampleDataDTO();
			dataDTO.setData(d.getData());
			dataDTO.setNormalizedData(d.getModifiedData());
			dataDTOs.add(dataDTO);
		}
		dto.setSampleData(dataDTOs);
		return dto;
	}

	private static Samples dtoToSamples(SamplesDTO dto) {

		List<Sample> samples = new ArrayList<>();
		for(SampleDTO sampleDTO : dto.getSamples()) {
			Sample sample = new Sample(sampleDTO.getSampleName(), sampleDTO.getSampleDetails(), sampleDTO.getGroupName(), sampleDTO.getClassification(), sampleDTO.getDescription());
			sample.setSelected(sampleDTO.isSelected());
			sample.setPredicted(sampleDTO.isPredicted());
			sample.setRGB(sampleDTO.getRgb());
			for(PeakSampleDataDTO dataDTO : sampleDTO.getSampleData()) {
				PeakSampleData peakData = new PeakSampleData(dataDTO.getData(), null);
				peakData.setModifiedData(dataDTO.getNormalizedData());
				sample.getSampleData().add(peakData);
			}
			samples.add(sample);
		}
		Samples pcaSamples = new Samples(samples);
		for(VariableDTO varDTO : dto.getVariables()) {
			pcaSamples.getVariables().add(dtoToVariable(varDTO));
		}
		return pcaSamples;
	}

	// ---- variables ---------------------------------------------------------

	private static VariableDTO variableToDTO(IVariable v) {

		VariableDTO dto = new VariableDTO();
		dto.setDescription(v.getDescription());
		dto.setSelected(v.isSelected());
		dto.setClassification(v.getClassification());
		if(v instanceof IRetentionTime rt) {
			dto.setType("RetentionTime");
			dto.setRetentionTime(rt.getRetentionTime());
		} else if(v instanceof IRetentionIndex ri) {
			dto.setType("RetentionIndex");
			dto.setRetentionIndex(ri.getRetentionIndex());
		} else if(v instanceof IMassToChargeRatio mz) {
			dto.setType("MassToChargeRatio");
			dto.setMz(mz.getMassToChargeRatio());
		} else if(v instanceof IPeakNumber pn) {
			dto.setType("PeakNumber");
			dto.setPeakNumber(pn.getPeakNumber());
		} else if(v instanceof ITarget t) {
			dto.setType("Target");
			dto.setTarget(t.getTarget());
		} else {
			dto.setType("Unknown");
		}
		return dto;
	}

	private static IVariable dtoToVariable(VariableDTO dto) {

		if(dto == null) {
			return null;
		}
		IVariable variable = switch(dto.getType()) {
			case "RetentionTime" -> {
				RetentionTime rt = new RetentionTime(dto.getRetentionTime());
				rt.setDescription(dto.getDescription());
				yield rt;
			}
			case "RetentionIndex" -> {
				RetentionIndex ri = new RetentionIndex(dto.getRetentionIndex());
				ri.setDescription(dto.getDescription());
				yield ri;
			}
			case "MassToChargeRatio" -> {
				MassToChargeRatio mz = new MassToChargeRatio(dto.getMz());
				mz.setDescription(dto.getDescription());
				yield mz;
			}
			case "PeakNumber" -> {
				PeakNumber pn = new PeakNumber(dto.getPeakNumber());
				pn.setDescription(dto.getDescription());
				yield pn;
			}
			case "Target" -> {
				Target t = new Target(dto.getTarget());
				t.setDescription(dto.getDescription());
				yield t;
			}
			default -> throw new IllegalArgumentException("Unknown variable type: " + dto.getType());
		};
		variable.setSelected(dto.isSelected());
		if(dto.getClassification() != null) {
			variable.setClassification(dto.getClassification());
		}
		return variable;
	}

	// ---- analysis settings -------------------------------------------------

	private static AnalysisSettingsDTO analysisSettingsToDTO(IAnalysisSettings settings) {

		AnalysisSettingsDTO dto = new AnalysisSettingsDTO();
		dto.setTitle(settings.getTitle());
		dto.setNumberOfPrincipalComponents(settings.getNumberOfPrincipalComponents());
		dto.setNumberOfSamplesToFilter(settings.getNumberOfSamplesToFilter());
		dto.setAlgorithm(settings.getAlgorithm().name());
		dto.setRemoveUselessVariables(settings.isRemoveUselessVariables());
		dto.setCrossValidation(settings.getCrossValidation());
		dto.setFilterDistribution(new TreeMap<>(settings.getFilterDistribution()));
		dto.setLabelOptionPCA(settings.getLabelOptionPCA().name());
		dto.setColorScheme(settings.getColorScheme());
		dto.setOplsTargetGroupName(settings.getOplsTargetGroupName());
		dto.setComparisonGroup1(settings.getComparisonGroup1());
		dto.setComparisonGroup2(settings.getComparisonGroup2());
		dto.setVariableLinePlotVariable(settings.getVariableLinePlotVariable());
		dto.setVariableLinePlotFontSize(settings.getVariableLinePlotFontSize());
		dto.setPreprocessingSettings(preprocessingToDTO(settings.getPreprocessingSettings()));
		return dto;
	}

	private static AnalysisSettings dtoToAnalysisSettings(AnalysisSettingsDTO dto) {

		AnalysisSettings settings = new AnalysisSettings();
		settings.setTitle(dto.getTitle());
		settings.setNumberOfPrincipalComponents(dto.getNumberOfPrincipalComponents());
		settings.setNumberOfSamplesToFilter(dto.getNumberOfSamplesToFilter());
		settings.setAlgorithm(Algorithm.valueOf(dto.getAlgorithm()));
		settings.setRemoveUselessVariables(dto.isRemoveUselessVariables());
		settings.setCrossValidation(dto.isCrossValidation());
		if(dto.getFilterDistribution() != null) {
			settings.setFilterDistribution(new TreeMap<>(dto.getFilterDistribution()));
		}
		settings.setLabelOptionPCA(LabelOptionPCA.valueOf(dto.getLabelOptionPCA()));
		settings.setColorScheme(dto.getColorScheme());
		settings.setOplsTargetGroupName(dto.getOplsTargetGroupName());
		settings.setComparisonGroup1(dto.getComparisonGroup1());
		settings.setComparisonGroup2(dto.getComparisonGroup2());
		settings.setVariableLinePlotVariable(dto.getVariableLinePlotVariable());
		settings.setVariableLinePlotFontSize(dto.getVariableLinePlotFontSize());
		if(dto.getPreprocessingSettings() != null) {
			settings.setPreprocessingSettings(dtoToPreprocessingSettings(dto.getPreprocessingSettings()));
		}
		return settings;
	}

	// ---- preprocessing settings --------------------------------------------

	private static PreprocessingSettingsDTO preprocessingToDTO(IPreprocessingSettings settings) {

		PreprocessingSettingsDTO dto = new PreprocessingSettingsDTO();
		IReplacer replacer = settings.getReplacer();
		dto.setReplacerType(replacer != null ? replacer.getClass().getSimpleName() : "SmallValuesReplacer");
		ITransformation transformation = settings.getTransformation();
		dto.setTransformationType(transformation != null ? transformation.getClass().getSimpleName() : null);
		INormalization normalization = settings.getNormalization();
		dto.setNormalizationType(normalization != null ? normalization.getClass().getSimpleName() : null);
		ICentering centering = settings.getCentering();
		if(centering != null) {
			dto.setCenteringType(centering.getClass().getSimpleName());
			dto.setScalingCenteringType(centering.getCenteringType());
		} else {
			dto.setCenteringType(null);
		}
		return dto;
	}

	private static IPreprocessingSettings dtoToPreprocessingSettings(PreprocessingSettingsDTO dto) {

		PreprocessingSettings settings = new PreprocessingSettings();
		settings.setReplacer(createReplacer(dto.getReplacerType()));
		settings.setTransformation(createTransformation(dto.getTransformationType()));
		settings.setNormalization(createNormalization(dto.getNormalizationType()));
		settings.setCentering(createCentering(dto.getCenteringType(), dto.getScalingCenteringType()));
		return settings;
	}

	private static IReplacer createReplacer(String type) {

		if(type == null) {
			return new SmallValuesReplacer();
		}
		return switch(type) {
			case "MeanValuesReplacer" -> new MeanValuesReplacer();
			case "MedianValuesReplacer" -> new MedianValuesReplacer();
			case "HalfMinimumValuesReplacer" -> new HalfMinimumValuesReplacer();
			default -> new SmallValuesReplacer();
		};
	}

	private static ITransformation createTransformation(String type) {

		if(type == null) {
			return null;
		}
		return switch(type) {
			case "TransformationLOG10" -> new TransformationLOG10();
			case "TransformationPower" -> new TransformationPower();
			default -> null;
		};
	}

	private static INormalization createNormalization(String type) {

		if(type == null) {
			return null;
		}
		return switch(type) {
			case "Normalization2Norm" -> new Normalization2Norm();
			case "NormalizationInfNorm" -> new NormalizationInfNorm();
			default -> new Normalization1Norm();
		};
	}

	private static ICentering createCentering(String type, int scalingCenteringType) {

		if(type == null) {
			return null;
		}
		return switch(type) {
			case "ScalingPareto" -> new ScalingPareto(scalingCenteringType);
			case "ScalingLevel" -> new ScalingLevel(scalingCenteringType);
			case "ScalingRange" -> new ScalingRange(scalingCenteringType);
			case "ScalingVast" -> new ScalingVast(scalingCenteringType);
			case "ScalingNone" -> new ScalingNone(scalingCenteringType);
			case "CenteringMean" -> new CenteringMean();
			case "CenteringMedian" -> new CenteringMedian();
			default -> new ScalingAuto(scalingCenteringType);
		};
	}

	// ---- results -----------------------------------------------------------

	private static ResultsPCADTO resultsToPCADTO(IResultsMVA results, ISample[] sampleArray) {

		ResultsPCADTO dto = new ResultsPCADTO();
		dto.setLoadingVectors(results.getLoadingVectors());
		dto.setExplainedVariances(results.getExplainedVariances());
		dto.setCumulativeExplainedVariances(results.getCumulativeExplainedVariances());
		dto.setCrossValidations(results.getCrossValidations());
		dto.setCumulativeCrossValidations(results.getCumulativeCrossValidations());
		dto.setPCovarianceValues(results.getPCovarianceValues());
		dto.setPCorrValues(results.getPCorrValues());
		List<VariableDTO> extractedVarDTOs = new ArrayList<>();
		for(IVariable v : results.getExtractedVariables()) {
			extractedVarDTOs.add(variableToDTO(v));
		}
		dto.setExtractedVariables(extractedVarDTOs);
		List<ResultMVADTO> resultDTOs = new ArrayList<>();
		for(IResultMVA r : results.getPcaResultList()) {
			ResultMVADTO rDto = new ResultMVADTO();
			rDto.setSampleIndex(indexOfIdentity(r.getSample(), sampleArray));
			rDto.setDisplayed(r.isDisplayed());
			rDto.setScoreVector(r.getScoreVector());
			rDto.setErrorMetric(r.getErrorMetric());
			rDto.setSampleData(r.getSampleData());
			rDto.setSelected(r.isSelected());
			resultDTOs.add(rDto);
		}
		dto.setPcaResultList(resultDTOs);
		return dto;
	}

	private static ResultsPCA dtoToResultsPCA(ResultsPCADTO dto, List<Sample> sampleList, AnalysisSettings analysisSettings) {

		ResultsPCA results = new ResultsPCA(analysisSettings);
		results.setLoadingVectors(dto.getLoadingVectors());
		results.setExplainedVariances(dto.getExplainedVariances());
		results.setCumulativeExplainedVariances(dto.getCumulativeExplainedVariances());
		results.setCrossValidations(dto.getCrossValidations());
		results.setCumulativeCrossValidations(dto.getCumulativeCrossValidations());
		results.setPCovarianceValues(dto.getPCovarianceValues());
		results.setPCorrValues(dto.getPCorrValues());
		for(VariableDTO varDTO : dto.getExtractedVariables()) {
			results.getExtractedVariables().add(dtoToVariable(varDTO));
		}
		for(ResultMVADTO rDto : dto.getPcaResultList()) {
			int idx = rDto.getSampleIndex();
			Sample sample = (idx >= 0 && idx < sampleList.size()) ? sampleList.get(idx) : null;
			ResultMVA result = new ResultMVA(sample);
			result.setDisplayed(rDto.isDisplayed());
			result.setScoreVector(rDto.getScoreVector());
			result.setErrorMetric(rDto.getErrorMetric());
			result.setSampleData(rDto.getSampleData());
			if(rDto.isSelected()) {
				result.toggleSelected();
			}
			results.getPcaResultList().add(result);
		}
		return results;
	}

	// ---- feature data matrix -----------------------------------------------

	private static FeatureDataMatrixDTO featureDataMatrixToDTO(FeatureDataMatrix matrix) {

		FeatureDataMatrixDTO dto = new FeatureDataMatrixDTO();
		dto.setSampleNames(new ArrayList<>(matrix.getSampleNames()));
		dto.setGroupNames(new ArrayList<>(matrix.getGroupNames()));
		List<FeatureDTO> featureDTOs = new ArrayList<>();
		for(Feature feature : matrix.getFeatures()) {
			FeatureDTO fDto = new FeatureDTO();
			fDto.setVariable(variableToDTO(feature.getVariable()));
			List<FeatureSampleDataDTO> dataDTOs = new ArrayList<>();
			for(ISampleData<?> d : feature.getSampleData()) {
				FeatureSampleDataDTO dataDTO = new FeatureSampleDataDTO();
				dataDTO.setData(d.getData());
				dataDTO.setNormalizedData(d.getModifiedData());
				dataDTOs.add(dataDTO);
			}
			fDto.setSampleData(dataDTOs);
			featureDTOs.add(fDto);
		}
		dto.setFeatures(featureDTOs);
		return dto;
	}

	private static FeatureDataMatrix dtoToFeatureDataMatrix(FeatureDataMatrixDTO dto) {

		List<Feature> features = new ArrayList<>();
		for(FeatureDTO fDto : dto.getFeatures()) {
			Feature feature = new Feature(dtoToVariable(fDto.getVariable()));
			for(FeatureSampleDataDTO dataDTO : fDto.getSampleData()) {
				PeakSampleData peakData = new PeakSampleData(dataDTO.getData(), null);
				peakData.setModifiedData(dataDTO.getNormalizedData());
				feature.getSampleData().add(peakData);
			}
			features.add(feature);
		}
		return new FeatureDataMatrix(new ArrayList<>(dto.getSampleNames()), new ArrayList<>(dto.getGroupNames()), features);
	}

	// ---- utilities ---------------------------------------------------------

	private static <T> List<Integer> indiciesOf(List<T> subset, T[] full) {

		List<Integer> indices = new ArrayList<>();
		for(T item : subset) {
			for(int i = 0; i < full.length; i++) {
				if(full[i] == item) {
					indices.add(i);
					break;
				}
			}
		}
		return indices;
	}

	private static int indexOfIdentity(ISample sample, ISample[] array) {

		for(int i = 0; i < array.length; i++) {
			if(array[i] == sample) {
				return i;
			}
		}
		return -1;
	}
}
