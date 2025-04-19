/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.pcr.converter.supplier.rdml.internal.v10.model;

import jakarta.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

	public ObjectFactory() {

	}

	public Rdml createRdml() {

		return new Rdml();
	}

	public RdmlIdType createRdmlIdType() {

		return new RdmlIdType();
	}

	public ExperimenterType createExperimenterType() {

		return new ExperimenterType();
	}

	public DocumentationType createDocumentationType() {

		return new DocumentationType();
	}

	public SampleType createSampleType() {

		return new SampleType();
	}

	public TargetType createTargetType() {

		return new TargetType();
	}

	public ThermalCyclingConditionsType createThermalCyclingConditionsType() {

		return new ThermalCyclingConditionsType();
	}

	public ExperimentType createExperimentType() {

		return new ExperimentType();
	}

	public ThirdPartyExtensionsType createThirdPartyExtensionsType() {

		return new ThirdPartyExtensionsType();
	}

	public QuantityType createQuantityType() {

		return new QuantityType();
	}

	public IdReferencesType createIdReferencesType() {

		return new IdReferencesType();
	}

	public TemperatureType createTemperatureType() {

		return new TemperatureType();
	}

	public StepType createStepType() {

		return new StepType();
	}

	public RunType createRunType() {

		return new RunType();
	}

	public OligoType createOligoType() {

		return new OligoType();
	}

	public LidOpenType createLidOpenType() {

		return new LidOpenType();
	}

	public GradientType createGradientType() {

		return new GradientType();
	}

	public DpMeltingCurveType createDpMeltingCurveType() {

		return new DpMeltingCurveType();
	}

	public ReactType createReactType() {

		return new ReactType();
	}

	public PauseType createPauseType() {

		return new PauseType();
	}

	public DataCollectionSoftwareType createDataCollectionSoftwareType() {

		return new DataCollectionSoftwareType();
	}

	public DataType createDataType() {

		return new DataType();
	}

	public CdnaSynthesisMethodType createCdnaSynthesisMethodType() {

		return new CdnaSynthesisMethodType();
	}

	public DpAmpCurveType createDpAmpCurveType() {

		return new DpAmpCurveType();
	}

	public LoopType createLoopType() {

		return new LoopType();
	}

	public CommercialAssayType createCommercialAssayType() {

		return new CommercialAssayType();
	}

	public SequencesType createSequencesType() {

		return new SequencesType();
	}

	public TemplateQualityType createTemplateQualityType() {

		return new TemplateQualityType();
	}

	public XRefType createXRefType() {

		return new XRefType();
	}
}
