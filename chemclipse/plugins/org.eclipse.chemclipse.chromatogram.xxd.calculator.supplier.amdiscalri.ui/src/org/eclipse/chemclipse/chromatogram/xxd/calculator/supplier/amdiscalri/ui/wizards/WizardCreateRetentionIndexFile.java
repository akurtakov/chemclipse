/*******************************************************************************
 * Copyright (c) 2016, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Christoph Läubrich - adjust to wizard API
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.ui.wizards;

import java.io.File;

import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.impl.CalibrationFile;
import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.io.CalibrationFileWriter;
import org.eclipse.chemclipse.csd.converter.chromatogram.ChromatogramConverterCSD;
import org.eclipse.chemclipse.csd.model.core.IChromatogramCSD;
import org.eclipse.chemclipse.csd.model.core.selection.IChromatogramSelectionCSD;
import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.model.types.DataType;
import org.eclipse.chemclipse.msd.converter.chromatogram.ChromatogramConverterMSD;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.msd.model.core.selection.IChromatogramSelectionMSD;
import org.eclipse.chemclipse.support.l10n.SupportMessages;
import org.eclipse.chemclipse.support.ui.wizards.AbstractWizard;
import org.eclipse.chemclipse.ux.extension.xxd.ui.Activator;
import org.eclipse.chemclipse.ux.extension.xxd.ui.part.support.SupplierEditorSupport;
import org.eclipse.chemclipse.xxd.converter.supplier.ocx.versions.VersionConstants;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.wizard.IWizardPage;

public class WizardCreateRetentionIndexFile extends AbstractWizard {

	/**
	 * Preferred size of the wizard.
	 */
	public static final int PREFERRED_WIDTH = 300;
	public static final int PREFERRED_HEIGHT = 600;

	private static final Logger logger = Logger.getLogger(WizardCreateRetentionIndexFile.class);

	private RetentionIndexWizardElements wizardElements;

	private PageCalibrationSettings pageCalibrationSettings;
	private PagePeakSelection pagePeakSelection;
	private PagePeakAssignment pagePeakAssignment;
	private PageCalibrationTable pageCalibrationTable;

	public WizardCreateRetentionIndexFile() {

		super(new RetentionIndexWizardElements());
		this.wizardElements = (RetentionIndexWizardElements)getWizardElements();
	}

	@Override
	public void addPages() {

		super.addPages();

		addPage(pageCalibrationSettings = new PageCalibrationSettings(wizardElements));
		addPage(pagePeakSelection = new PagePeakSelection(wizardElements));
		addPage(pagePeakAssignment = new PagePeakAssignment(wizardElements));
		addPage(pageCalibrationTable = new PageCalibrationTable(wizardElements));
	}

	@Override
	public IWizardPage getNextPage(IWizardPage page) {

		IWizardPage nextPage = super.getNextPage(page);

		if(page == pageCalibrationSettings) {
			nextPage = pagePeakSelection;
		} else if(page == pagePeakSelection) {
			nextPage = pagePeakAssignment;
		} else if(page == pagePeakAssignment) {
			nextPage = pageCalibrationTable;
		} else if(page == pageCalibrationTable) {
			nextPage = null;
		}

		setPreviousPages();
		return nextPage;
	}

	private void setPreviousPages() {

		pagePeakSelection.setPreviousPage(pageCalibrationSettings);
		pageCalibrationTable.setPreviousPage(pagePeakAssignment);
		pagePeakAssignment.setPreviousPage(pagePeakSelection);
	}

	@Override
	public boolean canFinish() {

		boolean canFinish = pageCalibrationSettings.canFinish();
		if(canFinish) {
			canFinish = !wizardElements.getSelectedChromatograms().isEmpty();
		}
		if(canFinish) {
			canFinish = pagePeakSelection.canFinish();
		}
		if(canFinish) {
			canFinish = pagePeakAssignment.canFinish();
		}
		if(canFinish) {
			canFinish = wizardElements.getExportFilePath() != null;
		}
		return canFinish;
	}

	@Override
	public void doFinish(IProgressMonitor monitor) throws CoreException {

		File calibrationFile = wizardElements.getExportFilePath();

		monitor.beginTask("Create Chromatogram Evaluation", IProgressMonitor.UNKNOWN);
		try {
			/*
			 * Calibration File.
			 */
			if(!calibrationFile.getAbsolutePath().endsWith(CalibrationFile.FILTER_EXTENSION)) {
				calibrationFile = new File(calibrationFile.getAbsolutePath() + CalibrationFile.FILTER_EXTENSION);
			}
			CalibrationFileWriter calibrationFileWriter = new CalibrationFileWriter();
			calibrationFileWriter.write(calibrationFile, wizardElements.getSeparationColumnIndices());
			/*
			 * Chromatogram File
			 * Export the chromatogram.
			 */
			String path = calibrationFile.getAbsolutePath();
			File chromatogramFile = new File(path.substring(0, path.length() - CalibrationFile.FILTER_EXTENSION.length()) + VersionConstants.FILE_EXTENSION_CHROMATOGRAM);
			IChromatogramSelection chromatogramSelection = wizardElements.getChromatogramSelection();
			if(wizardElements.isUseMassSpectrometryData()) {
				if(chromatogramSelection instanceof IChromatogramSelectionMSD chromatogramSelectionMSD) {
					IChromatogramMSD chromatogramMSD = chromatogramSelectionMSD.getChromatogram();
					ChromatogramConverterMSD.getInstance().convert(chromatogramFile, chromatogramMSD, VersionConstants.CONVERTER_ID_CHROMATOGRAM, monitor);
				}
			} else {
				if(chromatogramSelection instanceof IChromatogramSelectionCSD chromatogramSelectionCSD) {
					IChromatogramCSD chromatogramCSD = chromatogramSelectionCSD.getChromatogram();
					ChromatogramConverterCSD.getInstance().convert(chromatogramFile, chromatogramCSD, VersionConstants.CONVERTER_ID_CHROMATOGRAM, monitor);
				}
			}
		} catch(Exception e) {
			logger.warn(e);
		}
		runOpenEditor(calibrationFile, monitor);
	}

	private void runOpenEditor(File file, IProgressMonitor monitor) {

		monitor.subTask(SupportMessages.taskOpenEditor);
		SupplierEditorSupport supplierEditorSupport = new SupplierEditorSupport(DataType.CAL, () -> Activator.getDefault().getEclipseContext());
		if(!supplierEditorSupport.openEditor(file)) {
			logger.warn("Failed to open editor.");
		}
	}
}