/*******************************************************************************
 * Copyright (c) 2015, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.msd.converter.supplier.mzdata.internal.v105.model;

import jakarta.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

	public ObjectFactory() {

	}

	public MzData createMzData() {

		return new MzData();
	}

	public DataProcessingType createDataProcessingType() {

		return new DataProcessingType();
	}

	public InstrumentDescriptionType createInstrumentDescriptionType() {

		return new InstrumentDescriptionType();
	}

	public SpectrumSettingsType createSpectrumSettingsType() {

		return new SpectrumSettingsType();
	}

	public AcqSpecification createAcqSpecification() {

		return new AcqSpecification();
	}

	public SupDataBinaryType createSupDataBinaryType() {

		return new SupDataBinaryType();
	}

	public SpectrumDescType createSpectrumDescType() {

		return new SpectrumDescType();
	}

	public SpectrumList createMzDataSpectrumList() {

		return new SpectrumList();
	}

	public CvLookupType createCvLookupType() {

		return new CvLookupType();
	}

	public Description createMzDataDescription() {

		return new Description();
	}

	public CvParamType createCvParamType() {

		return new CvParamType();
	}

	public SpectrumType createSpectrumType() {

		return new SpectrumType();
	}

	public SupDescType createSupDescType() {

		return new SupDescType();
	}

	public AdminType createAdminType() {

		return new AdminType();
	}

	public SoftwareType createSoftwareType() {

		return new SoftwareType();
	}

	public SupDataType createSupDataType() {

		return new SupDataType();
	}

	public ParamType createParamType() {

		return new ParamType();
	}

	public SourceFileType createSourceFileType() {

		return new SourceFileType();
	}

	public PrecursorType createPrecursorType() {

		return new PrecursorType();
	}

	public PeakListBinaryType createPeakListBinaryType() {

		return new PeakListBinaryType();
	}

	public DescriptionType createDescriptionType() {

		return new DescriptionType();
	}

	public UserParamType createUserParamType() {

		return new UserParamType();
	}

	public PersonType createPersonType() {

		return new PersonType();
	}

	public Software createDataProcessingTypeSoftware() {

		return new Software();
	}

	public AnalyzerList createAnalyzerList() {

		return new AnalyzerList();
	}

	public SpectrumInstrument createSpectrumInstrument() {

		return new SpectrumInstrument();
	}

	public Acquisition createAcquisition() {

		return new Acquisition();
	}

	public Data createSupDataBinaryTypeData() {

		return new Data();
	}

	public PrecursorList createSpectrumDescTypePrecursorList() {

		return new PrecursorList();
	}

	public Spectrum createSpectrum() {

		return new Spectrum();
	}
}
