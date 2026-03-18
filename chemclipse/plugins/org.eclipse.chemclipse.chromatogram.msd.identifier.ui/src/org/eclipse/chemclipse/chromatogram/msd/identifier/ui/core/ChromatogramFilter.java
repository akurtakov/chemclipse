/*******************************************************************************
 * Copyright (c) 2021, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.msd.identifier.ui.core;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.chromatogram.filter.core.chromatogram.AbstractChromatogramFilter;
import org.eclipse.chemclipse.chromatogram.filter.result.ChromatogramFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.IChromatogramFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.ResultStatus;
import org.eclipse.chemclipse.chromatogram.filter.settings.IChromatogramFilterSettings;
import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.msd.identifier.IMassSpectrumIdentifierSupplier;
import org.eclipse.chemclipse.msd.identifier.MassSpectrumIdentifier;
import org.eclipse.chemclipse.msd.identifier.settings.IMassSpectrumIdentifierSettings;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.ux.extension.xxd.ui.support.ProcessorSettingsSupport;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import jakarta.inject.Named;

public class ChromatogramFilter extends AbstractChromatogramFilter {

	@Named(IServiceConstants.ACTIVE_SHELL)
	private Shell shell;

	@Override
	public IProcessingInfo<IChromatogramFilterResult> applyFilter(IChromatogramSelection chromatogramSelection, IChromatogramFilterSettings chromatogramFilterSettings, IProgressMonitor monitor) {

		IProcessingInfo<IChromatogramFilterResult> processingInfo = validate(chromatogramSelection, chromatogramFilterSettings);
		if(!processingInfo.hasErrorMessages()) {
			if(shell != null) {
				identifyScanMaxima(shell, chromatogramSelection, Display.getDefault(), monitor);
			} else {
				Display.getDefault().syncExec(() -> {
					/*
					 * Create a new shell and set
					 * the size to 0 cause only the wizard
					 * will be shown.
					 */
					Shell temporaryShell = new Shell();
					temporaryShell.setSize(0, 0);
					temporaryShell.open();
					identifyScanMaxima(temporaryShell, chromatogramSelection, Display.getDefault(), monitor);
					temporaryShell.close();
				});
			}
			chromatogramSelection.getChromatogram().setDirty(true);
			processingInfo.setProcessingResult(new ChromatogramFilterResult(ResultStatus.OK, "The scan maxima have been identified successfully."));
		}
		return processingInfo;
	}

	@Override
	public IProcessingInfo<IChromatogramFilterResult> applyFilter(IChromatogramSelection chromatogramSelection, IProgressMonitor monitor) {

		IChromatogramFilterSettings filterSettings = new FilterSettings();
		return applyFilter(chromatogramSelection, filterSettings, monitor);
	}

	private void identifyScanMaxima(Shell shell, IChromatogramSelection chromatogramSelection, Display display, IProgressMonitor monitor) {

		ChromatogramFilterDialog dialog = new ChromatogramFilterDialog(shell);
		if(IDialogConstants.OK_ID == dialog.open()) {
			IMassSpectrumIdentifierSupplier massSpectrumIdentifierSupplier = dialog.getMassSpectrumIdentifierSupplier();
			if(massSpectrumIdentifierSupplier != null) {
				/*
				 * Retrieve the settings dynamically
				 */
				String id = massSpectrumIdentifierSupplier.getId();
				IMassSpectrumIdentifierSettings identifierSettings = ProcessorSettingsSupport.getSettings(display.getActiveShell(), id);
				if(identifierSettings != null) {
					/*
					 * Extract the selection.
					 */
					IChromatogram chromatogram = chromatogramSelection.getChromatogram();
					int startScan = chromatogramSelection.getStartScan();
					int stopScan = chromatogramSelection.getStopScan();
					List<IScanMSD> massSpectra = new ArrayList<>();
					for(int i = startScan; i <= stopScan; i++) {
						IScan scan = chromatogram.getScan(i);
						if(scan instanceof IScanMSD scanMSD && !scan.getTargets().isEmpty()) {
							massSpectra.add(scanMSD);
						}
					}
					/*
					 * Identification
					 */
					display.asyncExec(() -> {
						MassSpectrumIdentifier.identify(massSpectra, identifierSettings, id, monitor);
						chromatogram.setDirty(true);
					});
				}
			}
		}
	}
}