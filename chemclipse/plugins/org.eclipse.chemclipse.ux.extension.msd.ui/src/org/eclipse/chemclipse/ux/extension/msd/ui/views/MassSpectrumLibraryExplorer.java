/*******************************************************************************
 * Copyright (c) 2014, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Christoph Läubrich - use DataExplorerUI
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.msd.ui.views;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.chemclipse.ux.extension.msd.ui.Activator;
import org.eclipse.chemclipse.ux.extension.msd.ui.support.DatabaseSupport;
import org.eclipse.chemclipse.ux.extension.ui.model.DataExplorerTreeSettings;
import org.eclipse.chemclipse.ux.extension.ui.swt.MultiDataExplorerTreeUI;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import jakarta.inject.Inject;

public class MassSpectrumLibraryExplorer {

	private AtomicReference<MultiDataExplorerTreeUI> dataExplorerControl = new AtomicReference<>();

	@Inject
	public MassSpectrumLibraryExplorer(Composite parent) {

		MultiDataExplorerTreeUI explorerUI = new MultiDataExplorerTreeUI(parent, SWT.NONE, new DataExplorerTreeSettings(Activator.getDefault().getPreferenceStore()));
		explorerUI.setSupplierFileIdentifier((Collections.singleton(DatabaseSupport.getInstanceEditorSupport())));
		explorerUI.expandLastDirectoryPath();

		dataExplorerControl.set(explorerUI);
	}

	@Focus
	private void setFocus() {

		dataExplorerControl.get().setFocus();
	}
}