/*******************************************************************************
 * Copyright (c) 2025, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
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
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.ExtractionDataFilter;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IAnalysisSettings;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IDataInputEntry;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.Samples;
import org.eclipse.chemclipse.xxd.process.supplier.pca.preferences.PreferenceSupplier;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;

public class FilesLongFormatInputWizard extends Wizard implements IInputWizard {

	private FilesLongFormatSettingsWizardPage mainPage = new FilesLongFormatSettingsWizardPage();
	private FilesLongFormatFilterWizardPage filterPage = new FilesLongFormatFilterWizardPage();
	private PreprocessingWizardPage preprocessingPage = new PreprocessingWizardPage();
	private IExtractionData extractionData;
	private File file;

	public FilesLongFormatInputWizard() {

		this(new File(PreferenceSupplier.getMainDataFile()));
	}

	public FilesLongFormatInputWizard(File file) {

		this.file = file;
	}

	@Override
	public void addPages() {

		mainPage.setFile(file);
		addPage(mainPage);
		addPage(filterPage);
		addPage(preprocessingPage);
	}

	@Override
	public IExtractionData getExtractionData() {

		return extractionData;
	}

	@Override
	public List<IDataInputEntry> getDataInputEntries() {

		return mainPage.getMainDataInputEntries();
	}

	public List<IDataInputEntry> getFilterDataInputEntries() {

		return mainPage.getFilterDataInputEntries();
	}

	@Override
	public IAnalysisSettings getAnalysisSettings() {

		return mainPage.getAnalysisSettings();
	}

	@Override
	public IPreprocessingSettings getPreprocessingSettings() {

		return preprocessingPage.getPreprocessingSettings();
	}

	@Override
	public boolean performFinish() {

		List<IDataInputEntry> dataInputEntries = getDataInputEntries();
		List<IDataInputEntry> filterDataInputEntries = getFilterDataInputEntries();
		file = getFile(dataInputEntries);
		Samples samples = filterPage.getFilteredSamples();
		if(samples != null) {
			extractionData = new ExtractionDataFilter(samples);
			return true;
		}
		if(file != null && file.getName().endsWith(PcaExtractionFileLongText.FILE_EXTENSION)) {
			extractionData = new PcaExtractionFileLongText(dataInputEntries, filterDataInputEntries, getAnalysisSettings().getNumberOfSamplesToFilter());
			return true;
		}
		return false;
	}

	private File getFile(List<IDataInputEntry> dataInputEntries) {

		for(IDataInputEntry dataInputEntry : dataInputEntries) {
			String inputFile = dataInputEntry.getInputFile();
			file = new File(inputFile);
			if(file.exists()) {
				return file;
			}
		}

		return null;

	}

	@Override
	public IWizardPage getNextPage(IWizardPage page) {

		if(page == mainPage) {
			filterPage.setMainFile(mainPage.getMainDataInputEntries());
			filterPage.setFilterFile(mainPage.getFilterDataInputEntries());
		}

		return super.getNextPage(page);

	}

}
