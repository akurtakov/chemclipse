/*******************************************************************************
 * Copyright (c) 2015, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.converter.supplier.mzxml.internal.v21.model;

import javax.xml.namespace.QName;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

	private static final QName _SeparationTechnique_QNAME = new QName("http://sashimi.sourceforge.net/schema_revision/mzXML_2.1", "separationTechnique");

	public ObjectFactory() {

	}

	public MsRun createMsRun() {

		return new MsRun();
	}

	public ParentFile createParentFile() {

		return new ParentFile();
	}

	public MsInstrument createMsInstrument() {

		return new MsInstrument();
	}

	public DataProcessing createDataProcessing() {

		return new DataProcessing();
	}

	public Separation createSeparation() {

		return new Separation();
	}

	public Spotting createSpotting() {

		return new Spotting();
	}

	public Scan createScan() {

		return new Scan();
	}

	public ScanOrigin createScanOrigin() {

		return new ScanOrigin();
	}

	public PrecursorMz createPrecursorMz() {

		return new PrecursorMz();
	}

	public Maldi createMaldi() {

		return new Maldi();
	}

	public Peaks createPeaks() {

		return new Peaks();
	}

	public NameValue createNameValue() {

		return new NameValue();
	}

	public Software createSoftware() {

		return new Software();
	}

	public SeparationTechnique createSeparationTechnique() {

		return new SeparationTechnique();
	}

	public Operator createOperator() {

		return new Operator();
	}

	public OntologyEntry createOntologyEntry() {

		return new OntologyEntry();
	}

	public Plate createPlate() {

		return new Plate();
	}

	public Robot createRobot() {

		return new Robot();
	}

	public Pattern createPattern() {

		return new Pattern();
	}

	public Spot createSpot() {

		return new Spot();
	}

	public Orientation createOrientation() {

		return new Orientation();
	}

	public MsManufacturer createMsManufacturer() {

		return new MsManufacturer();
	}

	public MsMassAnalyzer createMsMassAnalyzer() {

		return new MsMassAnalyzer();
	}

	@XmlElementDecl(namespace = "http://sashimi.sourceforge.net/schema_revision/mzXML_2.1", name = "separationTechnique")
	public JAXBElement<SeparationTechnique> createSeparationTechnique(SeparationTechnique value) {

		return new JAXBElement<>(_SeparationTechnique_QNAME, SeparationTechnique.class, null, value);
	}
}
