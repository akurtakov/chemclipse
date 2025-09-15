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
 * Matthias Mailänder - adapted for MALDI
 *******************************************************************************/
package org.eclipse.chemclipse.msd.converter.supplier.mzxml.internal.io;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.chemclipse.converter.l10n.ConverterMessages;
import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.msd.converter.supplier.mzxml.internal.v22.model.DataProcessing;
import org.eclipse.chemclipse.msd.converter.supplier.mzxml.internal.v22.model.Maldi;
import org.eclipse.chemclipse.msd.converter.supplier.mzxml.internal.v22.model.MsRun;
import org.eclipse.chemclipse.msd.converter.supplier.mzxml.internal.v22.model.MzXML;
import org.eclipse.chemclipse.msd.converter.supplier.mzxml.internal.v22.model.ObjectFactory;
import org.eclipse.chemclipse.msd.converter.supplier.mzxml.internal.v22.model.Peaks;
import org.eclipse.chemclipse.msd.converter.supplier.mzxml.internal.v22.model.Scan;
import org.eclipse.chemclipse.msd.converter.supplier.mzxml.model.IVendorMassSpectra;
import org.eclipse.chemclipse.msd.converter.supplier.mzxml.model.VendorIon;
import org.eclipse.chemclipse.msd.converter.supplier.mzxml.model.VendorMassSpectra;
import org.eclipse.chemclipse.msd.model.core.IMassSpectra;
import org.eclipse.chemclipse.msd.model.core.IStandaloneMassSpectrum;
import org.eclipse.chemclipse.msd.model.core.MassSpectrumType;
import org.eclipse.chemclipse.msd.model.core.Polarity;
import org.eclipse.chemclipse.msd.model.implementation.VendorMassSpectrum;
import org.eclipse.core.runtime.IProgressMonitor;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

public class MassSpectrumReaderVersion22 extends AbstractMassSpectrumReader {

	public static final String VERSION = "mzXML_2.2";

	private static final Logger logger = Logger.getLogger(MassSpectrumReaderVersion22.class);

	@Override
	public IMassSpectra read(File file, IProgressMonitor monitor) throws IOException {

		IStandaloneMassSpectrum massSpectrum = null;

		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			documentBuilderFactory.setNamespaceAware(true);
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(file);
			NodeList nodeList = document.getElementsByTagName(AbstractChromatogramReaderVersion.NODE_MZXML);

			JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			MzXML mzXML = (MzXML)unmarshaller.unmarshal(nodeList.item(0));

			massSpectrum = new VendorMassSpectrum();
			massSpectrum.setFile(file);
			massSpectrum.setIdentifier(file.getName());
			MsRun msRun = mzXML.getMsRun();
			for(DataProcessing dataProcessing : msRun.getDataProcessing()) {
				if(Boolean.TRUE.equals(dataProcessing.isCentroided())) {
					massSpectrum.setMassSpectrumType(MassSpectrumType.CENTROID);
				} else {
					massSpectrum.setMassSpectrumType(MassSpectrumType.PROFILE);
				}
			}
			List<Scan> scans = msRun.getScan();
			monitor.beginTask(ConverterMessages.readScans, scans.size());
			for(Scan scan : scans) {
				/*
				 * Polarity
				 */
				if(scan.getPolarity() != null) {
					if(scan.getPolarity().equals("+")) {
						massSpectrum.setPolarity(Polarity.POSITIVE);
					} else if(scan.getPolarity().equals("-")) {
						massSpectrum.setPolarity(Polarity.NEGATIVE);
					}
				}
				/*
				 * Plate
				 */
				Maldi maldi = scan.getMaldi();
				if(maldi != null) {
					massSpectrum.setPlate(maldi.getPlateID());
					massSpectrum.setPosition(maldi.getSpotID());
				}
				/*
				 * Get the ions.
				 */
				Peaks peaks = scan.getPeaks();
				double[] values = readPeaks(peaks.getValue(), peaks.getByteOrder(), peaks.getPrecision(), null);

				for(int peakIndex = 0; peakIndex < values.length - 1; peakIndex += 2) {
					/*
					 * Get m/z and intensity (m/z-int)
					 */
					massSpectrum.addIon(new VendorIon(values[peakIndex], (float)values[peakIndex + 1]), false);
				}
				monitor.worked(1);
			}
		} catch(SAXException e) {
			logger.warn(e);
		} catch(JAXBException e) {
			logger.warn(e);
		} catch(ParserConfigurationException e) {
			logger.warn(e);
		} catch(DataFormatException e) {
			logger.warn(e);
		}

		IVendorMassSpectra massSpectra = new VendorMassSpectra();
		massSpectra.setName(file.getName());
		massSpectra.addMassSpectrum(massSpectrum);
		return massSpectra;
	}
}
