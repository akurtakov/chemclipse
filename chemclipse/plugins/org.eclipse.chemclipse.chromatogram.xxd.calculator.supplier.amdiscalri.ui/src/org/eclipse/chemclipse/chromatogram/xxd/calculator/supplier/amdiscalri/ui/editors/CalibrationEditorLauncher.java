/*******************************************************************************
 * Copyright (c) 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.ui.editors;

import java.io.File;

import org.eclipse.chemclipse.model.types.DataType;
import org.eclipse.chemclipse.ux.extension.ui.provider.ISupplierEditorSupport;
import org.eclipse.chemclipse.ux.extension.xxd.ui.internal.editors.ProjectExplorerSupportFactory;
import org.eclipse.core.runtime.IPath;
import org.eclipse.ui.IEditorLauncher;

public class CalibrationEditorLauncher implements IEditorLauncher {

	@Override
	public void open(IPath path) {

		File file = path.toFile();
		ISupplierEditorSupport supplierEditorSupport = new ProjectExplorerSupportFactory(DataType.CAL).getInstanceEditorSupport();
		supplierEditorSupport.openEditor(file);
	}
}
