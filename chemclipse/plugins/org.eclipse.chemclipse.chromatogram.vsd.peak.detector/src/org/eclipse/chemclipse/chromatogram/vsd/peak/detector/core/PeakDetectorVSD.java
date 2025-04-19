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
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.vsd.peak.detector.core;

import org.eclipse.chemclipse.chromatogram.vsd.peak.detector.settings.IPeakDetectorSettingsVSD;
import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.IProcessingMessage;
import org.eclipse.chemclipse.processing.core.MessageType;
import org.eclipse.chemclipse.processing.core.ProcessingInfo;
import org.eclipse.chemclipse.processing.core.ProcessingMessage;
import org.eclipse.chemclipse.vsd.model.core.selection.IChromatogramSelectionVSD;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;

public class PeakDetectorVSD {

	private static final Logger logger = Logger.getLogger(PeakDetectorVSD.class);
	private static final String EXTENSION_POINT = "org.eclipse.chemclipse.chromatogram.vsd.peak.detector.peakDetectorSupplier";
	/*
	 * These are the attributes of the extension point elements.
	 */
	private static final String ID = "id";
	private static final String DESCRIPTION = "description";
	private static final String PEAK_DETECTOR_NAME = "peakDetectorName";
	private static final String PEAK_DETECTOR = "peakDetector";
	private static final String PEAK_DETECTOR_SETTINGS = "peakDetectorSettings";
	//
	private static final String NO_PEAK_DETECTOR_AVAILABLE = "There is no peak detector available.";

	private PeakDetectorVSD() {

	}

	public static IProcessingInfo<?> detect(IChromatogramSelectionVSD chromatogramSelection, IPeakDetectorSettingsVSD peakDetectorSettings, String peakDetectorId, IProgressMonitor monitor) {

		IProcessingInfo<?> processingInfo;
		IPeakDetectorVSD peakDetector = getPeakDetector(peakDetectorId);
		if(peakDetector != null) {
			processingInfo = peakDetector.detect(chromatogramSelection, peakDetectorSettings, monitor);
		} else {
			processingInfo = getNoPeakDetectorAvailableProcessingInfo();
		}
		return processingInfo;
	}

	public static IProcessingInfo<?> detect(IChromatogramSelectionVSD chromatogramSelection, String peakDetectorId, IProgressMonitor monitor) {

		IProcessingInfo<?> processingInfo;
		IPeakDetectorVSD peakDetector = getPeakDetector(peakDetectorId);
		if(peakDetector != null) {
			processingInfo = peakDetector.detect(chromatogramSelection, monitor);
		} else {
			processingInfo = getNoPeakDetectorAvailableProcessingInfo();
		}
		return processingInfo;
	}

	public static IPeakDetectorVSDSupport getPeakDetectorSupport() {

		PeakDetectorVSDSupplier supplier;
		PeakDetectorVSDSupport peakDetectorSupport = new PeakDetectorVSDSupport();
		/*
		 * Search in the extension registry and fill the comparison support
		 * object with supplier information.
		 */
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = registry.getConfigurationElementsFor(EXTENSION_POINT);
		for(IConfigurationElement element : extensions) {
			String id = element.getAttribute(ID);
			String description = element.getAttribute(DESCRIPTION);
			String peakDetectorName = element.getAttribute(PEAK_DETECTOR_NAME);
			supplier = new PeakDetectorVSDSupplier(id, description, peakDetectorName);
			if(element.getAttribute(PEAK_DETECTOR_SETTINGS) != null) {
				try {
					IPeakDetectorSettingsVSD instance = (IPeakDetectorSettingsVSD)element.createExecutableExtension(PEAK_DETECTOR_SETTINGS);
					supplier.setSettingsClass(instance.getClass());
				} catch(CoreException e) {
					logger.error(e);
					// settings class is optional, set null instead
					supplier.setSettingsClass(null);
				}
			}
			peakDetectorSupport.add(supplier);
		}
		return peakDetectorSupport;
	}

	private static IPeakDetectorVSD getPeakDetector(final String peakDetectorId) {

		IConfigurationElement element;
		element = getConfigurationElement(peakDetectorId);
		IPeakDetectorVSD instance = null;
		if(element != null) {
			try {
				instance = (IPeakDetectorVSD)element.createExecutableExtension(PEAK_DETECTOR);
			} catch(CoreException e) {
				logger.warn(e);
			}
		}
		return instance;
	}

	/**
	 * Returns an IPeakDetector instance or null if none is available.
	 * 
	 * @param peakDetectorId
	 * @return IConfigurationElement
	 */
	private static IConfigurationElement getConfigurationElement(final String peakDetectorId) {

		if("".equals(peakDetectorId)) {
			return null;
		}
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] elements = registry.getConfigurationElementsFor(EXTENSION_POINT);
		for(IConfigurationElement element : elements) {
			if(element.getAttribute(ID).equals(peakDetectorId)) {
				return element;
			}
		}
		return null;
	}

	private static IProcessingInfo<?> getNoPeakDetectorAvailableProcessingInfo() {

		IProcessingInfo<?> processingInfo = new ProcessingInfo<>();
		IProcessingMessage processingMessage = new ProcessingMessage(MessageType.ERROR, "Peak Detector VSD", NO_PEAK_DETECTOR_AVAILABLE);
		processingInfo.addMessage(processingMessage);
		return processingInfo;
	}
}