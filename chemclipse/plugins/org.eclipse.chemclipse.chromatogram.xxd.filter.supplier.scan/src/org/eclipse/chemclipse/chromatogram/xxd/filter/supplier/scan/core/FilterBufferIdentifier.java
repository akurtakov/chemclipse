/*******************************************************************************
 * Copyright (c) 2025, 2026  Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.core;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

import org.eclipse.chemclipse.chromatogram.filter.core.chromatogram.AbstractChromatogramFilter;
import org.eclipse.chemclipse.chromatogram.filter.result.ChromatogramFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.IChromatogramFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.ResultStatus;
import org.eclipse.chemclipse.chromatogram.filter.settings.IChromatogramFilterSettings;
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.model.BufferOption;
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.model.BufferedScanTargets;
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.settings.FilterSettingsBufferIdentifier;
import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.model.core.IMeasurementResult;
import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.model.identifier.IIdentificationTarget;
import org.eclipse.chemclipse.model.implementation.MeasurementResult;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.MessageType;
import org.eclipse.chemclipse.processing.core.ProcessingMessage;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;

public class FilterBufferIdentifier extends AbstractChromatogramFilter {

	private static final String DESCRIPTION = "Buffer the scan targets.";
	private static final String MESSAGE_SUCCESS = "Success";

	@Override
	public IProcessingInfo<IChromatogramFilterResult> applyFilter(IChromatogramSelection chromatogramSelection, IChromatogramFilterSettings chromatogramFilterSettings, IProgressMonitor monitor) {

		IProcessingInfo<IChromatogramFilterResult> processingInfo = validate(chromatogramSelection, chromatogramFilterSettings);
		if(!processingInfo.hasErrorMessages()) {
			if(chromatogramFilterSettings instanceof FilterSettingsBufferIdentifier settings) {
				applyProcessor(chromatogramSelection, settings.getBufferOption(), monitor);
				processingInfo.addMessage(new ProcessingMessage(MessageType.INFO, DESCRIPTION, MESSAGE_SUCCESS));
				processingInfo.setProcessingResult(new ChromatogramFilterResult(ResultStatus.OK, MESSAGE_SUCCESS));
				chromatogramSelection.getChromatogram().setDirty(true);
			}
		}
		return processingInfo;
	}

	@Override
	public IProcessingInfo<IChromatogramFilterResult> applyFilter(IChromatogramSelection chromatogramSelection, IProgressMonitor monitor) {

		FilterSettingsBufferIdentifier settings = new FilterSettingsBufferIdentifier();
		return applyFilter(chromatogramSelection, settings, monitor);
	}

	private void applyProcessor(IChromatogramSelection chromatogramSelection, BufferOption bufferOption, IProgressMonitor monitor) {

		IChromatogram chromatogram = chromatogramSelection.getChromatogram();
		int retentionTimeStart = chromatogramSelection.getStartRetentionTime();
		int retentionTimeStop = chromatogramSelection.getStopRetentionTime();
		int startScan = chromatogram.getScanNumber(retentionTimeStart);
		int stopScan = chromatogram.getScanNumber(retentionTimeStop);

		switch(bufferOption) {
			case BUFFER_TARGERTS:
				bufferTargets(chromatogram, startScan, stopScan, monitor);
				break;
			case RESTORE_TARGERTS:
				restoreTargets(chromatogram, retentionTimeStart, retentionTimeStop, monitor);
				break;
			case CLEAR_BUFFER:
				clearBuffer(chromatogram);
				break;
			default:
				break;
		}

	}

	private void bufferTargets(IChromatogram chromatogram, int startScan, int stopScan, IProgressMonitor monitor) {

		SubMonitor subMonitor = SubMonitor.convert(monitor, DESCRIPTION, stopScan - startScan);
		try {
			/*
			 * Read the existing scan targets into a buffer.
			 */
			BufferedScanTargets bufferedScanTargets = new BufferedScanTargets();
			for(int i = startScan; i <= stopScan; i++) {
				IScan scan = chromatogram.getScan(i);
				Set<IIdentificationTarget> targets = scan.getTargets();
				if(!targets.isEmpty()) {
					Set<IIdentificationTarget> mappedTargets = new HashSet<>();
					mappedTargets.addAll(targets);
					bufferedScanTargets.getMappedTargets().put(scan.getRetentionTime(), mappedTargets);
				}
				subMonitor.worked(1);
			}
			/*
			 * Store the buffered targets in the chromatogram for later retrieval.
			 */
			IMeasurementResult<?> measurementResult = new MeasurementResult(BufferedScanTargets.NAME, BufferedScanTargets.IDENTIFIER, BufferedScanTargets.DESCRIPTION, bufferedScanTargets);
			chromatogram.addMeasurementResult(measurementResult);
		} finally {
			SubMonitor.done(subMonitor);
		}
	}

	private void restoreTargets(IChromatogram chromatogram, int retentionTimeStart, int retentionTimeStop, IProgressMonitor monitor) {

		IMeasurementResult<?> measurementResult = chromatogram.getMeasurementResult(BufferedScanTargets.IDENTIFIER);
		if(measurementResult != null) {
			if(measurementResult.getResult() instanceof BufferedScanTargets bufferedScanTargets) {
				TreeMap<Integer, Set<IIdentificationTarget>> mappedTargets = bufferedScanTargets.getMappedTargets();
				for(int retentionTime : mappedTargets.keySet()) {
					if(retentionTime >= retentionTimeStart && retentionTime <= retentionTimeStop) {
						int scanNumber = chromatogram.getScanNumber(retentionTime);
						if(scanNumber > 0) {
							IScan scan = chromatogram.getScan(scanNumber);
							if(scan != null) {
								scan.getTargets().addAll(mappedTargets.get(retentionTime));
							}
						}
					}
				}
			}
		}
	}

	private void clearBuffer(IChromatogram chromatogram) {

		chromatogram.deleteMeasurementResult(BufferedScanTargets.IDENTIFIER);
	}
}
