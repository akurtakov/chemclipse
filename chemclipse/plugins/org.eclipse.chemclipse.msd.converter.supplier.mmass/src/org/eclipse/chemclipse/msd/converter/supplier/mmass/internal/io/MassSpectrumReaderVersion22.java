/*******************************************************************************
 * Copyright (c) 2022, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.converter.supplier.mmass.internal.io;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Optional;
import java.util.zip.DataFormatException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.chemclipse.converter.l10n.ConverterMessages;
import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.model.core.IMassSpectrumPeak;
import org.eclipse.chemclipse.model.core.MassSpectrumPeak;
import org.eclipse.chemclipse.model.identifier.ComparisonResult;
import org.eclipse.chemclipse.model.identifier.ILibraryInformation;
import org.eclipse.chemclipse.model.identifier.LibraryInformation;
import org.eclipse.chemclipse.model.implementation.IdentificationTarget;
import org.eclipse.chemclipse.msd.converter.supplier.mmass.converter.model.IVendorIon;
import org.eclipse.chemclipse.msd.converter.supplier.mmass.converter.model.IVendorMassSpectra;
import org.eclipse.chemclipse.msd.converter.supplier.mmass.converter.model.VendorIon;
import org.eclipse.chemclipse.msd.converter.supplier.mmass.converter.model.VendorMassSpectra;
import org.eclipse.chemclipse.msd.model.core.IMassSpectra;
import org.eclipse.chemclipse.msd.model.core.IStandaloneMassSpectrum;
import org.eclipse.chemclipse.msd.model.core.MassSpectrumType;
import org.eclipse.chemclipse.msd.model.implementation.StandaloneMassSpectrum;
import org.eclipse.core.runtime.IProgressMonitor;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MassSpectrumReaderVersion22 extends AbstractMassSpectrumReader {

	private static final Logger logger = Logger.getLogger(MassSpectrumReaderVersion22.class);

	@Override
	public IMassSpectra read(File file, IProgressMonitor monitor) throws IOException {

		IStandaloneMassSpectrum massSpectrum = null;
		try {
			massSpectrum = new StandaloneMassSpectrum();
			massSpectrum.setFile(file);
			massSpectrum.setIdentifier(file.getName());

			NodeList nodeList = getTopNode(file);
			for(int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element)node;
					readDescription(element, massSpectrum);
					readSpectrum(element, massSpectrum, monitor);
					readPeakList(element, massSpectrum);
					readAnnotations(element, massSpectrum);
					// TODO: sequences
				}
			}
		} catch(SAXException e) {
			logger.warn(e);
		} catch(ParserConfigurationException e) {
			logger.warn(e);
		} catch(DOMException e) {
			logger.warn(e);
		} catch(DataFormatException e) {
			logger.warn(e);
		}

		IVendorMassSpectra massSpectra = new VendorMassSpectra();
		massSpectra.setName(file.getName());
		massSpectra.addMassSpectrum(massSpectrum);
		return massSpectra;
	}

	private NodeList getTopNode(File file) throws SAXException, IOException, ParserConfigurationException {

		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(file);
		// document.getDocumentElement().normalize();
		return document.getElementsByTagName("mSD");
	}

	private void readSpectrum(Element element, IStandaloneMassSpectrum massSpectrum, IProgressMonitor monitor) throws DOMException, DataFormatException {

		int points = 0;
		float[] mzs = null;
		float[] intensities = null;
		NodeList spectrumList = element.getElementsByTagName("spectrum");
		int spectrumLength = spectrumList.getLength();
		if(spectrumLength > 0) {
			massSpectrum.setMassSpectrumType(MassSpectrumType.PROFILE);
		}
		for(int i = 0; i < spectrumLength; i++) {
			Node node = spectrumList.item(i);
			Element spectrum = (Element)node;
			Node mzArray = spectrum.getElementsByTagName("mzArray").item(0);
			checkArray(mzArray.getAttributes());
			mzs = decodeFloatArray(decompress(Base64.getDecoder().decode(mzArray.getTextContent())));
			Node intArray = spectrum.getElementsByTagName("intArray").item(0);
			checkArray(intArray.getAttributes());
			intensities = decodeFloatArray(decompress(Base64.getDecoder().decode(intArray.getTextContent())));
			if(spectrum.hasAttribute("points")) {
				points = Integer.parseInt(spectrum.getAttribute("points"));
			} else {
				points = Math.min(mzs.length, intensities.length);
			}
		}
		monitor.beginTask(ConverterMessages.importScan, points);
		for(int i = 0; i < points; i++) {
			IVendorIon ion = new VendorIon(mzs[i], intensities[i]);
			massSpectrum.addIon(ion, false);
			monitor.worked(1);
		}
	}

	private void readPeakList(Element element, IStandaloneMassSpectrum massSpectrum) throws DOMException {

		NodeList peakList = element.getElementsByTagName("peaklist");
		for(int i = 0; i < peakList.getLength(); i++) {
			Node node = peakList.item(i);
			Element peakListElement = (Element)node;
			NodeList peakNodeList = peakListElement.getElementsByTagName("peak");
			for(int n = 0; n < peakNodeList.getLength(); n++) {
				Node peak = peakNodeList.item(n);
				Element peakElement = (Element)peak;
				MassSpectrumPeak massSpectrumPeak = new MassSpectrumPeak();
				String mz = peakElement.getAttribute("mz");
				massSpectrumPeak.setIon(Double.parseDouble(mz));
				String intensity = peakElement.getAttribute("intensity");
				massSpectrumPeak.setAbundance(Double.parseDouble(intensity));
				String sn = peakElement.getAttribute("sn");
				massSpectrumPeak.setSignalToNoise(Double.parseDouble(sn));
				massSpectrum.getPeaks().add(massSpectrumPeak);
			}
		}
	}

	private void readAnnotations(Element element, IStandaloneMassSpectrum massSpectrum) throws DOMException {

		NodeList annotationsList = element.getElementsByTagName("annotations");
		for(int i = 0; i < annotationsList.getLength(); i++) {
			Node node = annotationsList.item(i);
			Element annotationsElement = (Element)node;
			NodeList annotationList = annotationsElement.getElementsByTagName("annotation");
			for(int n = 0; n < annotationList.getLength(); n++) {
				Node annotationNode = annotationList.item(n);
				Element annotationElement = (Element)annotationNode;
				String peakMZ = annotationElement.getAttribute("peakMZ");
				Optional<IMassSpectrumPeak> nearestPeak = massSpectrum.getPeaks().stream().filter(p -> p.getIon() == Double.parseDouble(peakMZ)).findFirst();
				if(nearestPeak.isPresent()) {
					ILibraryInformation libraryInformation = new LibraryInformation();
					String calcMZ = annotationElement.getAttribute("calcMZ");
					if(!calcMZ.isEmpty()) {
						libraryInformation.setMolWeight(Double.parseDouble(calcMZ));
					}
					libraryInformation.setName(annotationElement.getTextContent());
					ComparisonResult comparisionResult = new ComparisonResult(1f, 1f, 1f, 1f);
					IdentificationTarget identificationTarget = new IdentificationTarget(libraryInformation, comparisionResult);
					identificationTarget.setIdentifier("mMass annotation");
					nearestPeak.get().getTargets().add(identificationTarget);
				}
			}
		}
	}
}
