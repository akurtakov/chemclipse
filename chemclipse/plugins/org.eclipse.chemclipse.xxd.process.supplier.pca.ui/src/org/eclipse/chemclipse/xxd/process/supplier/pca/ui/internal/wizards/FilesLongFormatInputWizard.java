/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Lorenz Gerber - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.ui.internal.wizards;

import java.io.File;
import java.util.List;

import org.eclipse.chemclipse.xxd.process.supplier.pca.core.IExtractionData;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.IPreprocessingSettings;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.PcaExtractionFileLongText;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IAnalysisSettings;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IDataInputEntry;
import org.eclipse.jface.wizard.Wizard;

public class FilesLongFormatInputWizard extends Wizard implements IInputWizard {

	private FilesLongFormatSettingsWizardPage filesLongFormatSettingsWizardPage = new FilesLongFormatSettingsWizardPage();
	private PreprocessingWizardPage preprocessingWizardPage = new PreprocessingWizardPage();
	private IExtractionData extractionData;
	private File file;

	public FilesLongFormatInputWizard() {

		this(null);
	}

	public FilesLongFormatInputWizard(File file) {

		this.file = file;
	}

	@Override
	public void addPages() {

		filesLongFormatSettingsWizardPage.setFile(file);
		addPage(filesLongFormatSettingsWizardPage);
		addPage(preprocessingWizardPage);
	}

	@Override
	public IExtractionData getExtractionData() {

		return extractionData;
	}

	@Override
	public List<IDataInputEntry> getDataInputEntries() {

		return filesLongFormatSettingsWizardPage.getMainDataInputEntries();
	}

	public List<IDataInputEntry> getFilterDataInputEntries() {

		return filesLongFormatSettingsWizardPage.getFilterDataInputEntries();
	}

	@Override
	public IAnalysisSettings getAnalysisSettings() {

		return filesLongFormatSettingsWizardPage.getAnalysisSettings();
	}

	@Override
	public IPreprocessingSettings getPreprocessingSettings() {

		return preprocessingWizardPage.getPreprocessingSettings();
	}

	@Override
	public boolean performFinish() {

		List<IDataInputEntry> dataInputEntries = getDataInputEntries();
		List<IDataInputEntry> filterDataInputEntries = getFilterDataInputEntries();
		File file = getFile(dataInputEntries);
		if(file != null && file.getName().endsWith(PcaExtractionFileLongText.FILE_EXTENSION)) {
			extractionData = new PcaExtractionFileLongText(dataInputEntries, filterDataInputEntries, getAnalysisSettings().getNumberOfSamplesToFilter());
			return true;
		}
		return false;
	}

	private File getFile(List<IDataInputEntry> dataInputEntries) {

		for(IDataInputEntry dataInputEntry : dataInputEntries) {
			String inputFile = dataInputEntry.getInputFile();
			File file = new File(inputFile);
			if(file.exists()) {
				return file;
			}
		}
		//
		return null;
	}
}
