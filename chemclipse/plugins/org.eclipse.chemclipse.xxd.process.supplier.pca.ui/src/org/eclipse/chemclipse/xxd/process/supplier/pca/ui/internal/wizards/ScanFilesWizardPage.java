/*******************************************************************************
 * Copyright (c) 2017, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Jan Holy - initial API and implementation
 * Christoph Läubrich - change to new Wizard API
 * Philip Wenig - get rid of JavaFX
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.ui.internal.wizards;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.model.types.DataType;
import org.eclipse.chemclipse.ux.extension.xxd.ui.wizards.InputEntriesWizard;
import org.eclipse.chemclipse.ux.extension.xxd.ui.wizards.InputWizardSettings;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.DataInputEntry;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IDataInputEntry;
import org.eclipse.chemclipse.xxd.process.supplier.pca.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.xxd.process.supplier.pca.ui.Activator;

public class ScanFilesWizardPage extends DataInputPageWizard {

	public ScanFilesWizardPage() {

		super("DataInputFiles");
		setTitle("Chromatogram MSD Input Files");
		setDescription("This wizard lets you select chromatogram MSD input files and set bulk group name.");
	}

	@Override
	protected void addFiles() {

		InputWizardSettings inputWizardSettings = InputWizardSettings.create(Activator.getDefault().getPreferenceStore(), PreferenceSupplier.N_INPUT_FILE, DataType.MSD);
		inputWizardSettings.setTitle("Chromatogram MSD Input Files");
		inputWizardSettings.setDescription("This wizard lets you select several chromatogram MSD input files.");
		//
		List<IDataInputEntry> dataInputEntries = new ArrayList<>();
		for(File file : InputEntriesWizard.openWizard(getShell(), inputWizardSettings).keySet()) {
			dataInputEntries.add(new DataInputEntry(file.getAbsolutePath()));
		}
		//
		addInputFiles(dataInputEntries);
		update();
	}
}
