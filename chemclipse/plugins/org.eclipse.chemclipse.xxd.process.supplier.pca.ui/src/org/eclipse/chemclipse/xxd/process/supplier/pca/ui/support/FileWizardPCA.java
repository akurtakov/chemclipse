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
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.ui.support;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.chemclipse.xxd.process.supplier.pca.ui.internal.wizards.FilesInputWizard;
import org.eclipse.chemclipse.xxd.process.supplier.pca.ui.internal.wizards.IInputWizard;
import org.eclipse.chemclipse.xxd.process.supplier.pca.ui.quickstart.WizardTile;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.swt.widgets.Shell;

public class FileWizardPCA extends WizardTile {

	private File file;

	public FileWizardPCA(File file) {

		this.file = file;
	}

	public void run(Shell shell, IEclipseContext context) throws InvocationTargetException, InterruptedException {

		/*
		 * Somehow, the wizard is displayed and the editor is created.
		 * But then it fails. Nobody knows why.
		 */
		execute(shell, context);
	}

	@Override
	public String getTitle() {

		return "File Wizard PCA";
	}

	@Override
	protected IInputWizard createWizard() {

		return new FilesInputWizard(file);
	}
}