/*******************************************************************************
 * Copyright (c) 2018, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.xxd.ui.internal.editors;

import java.io.File;

import org.eclipse.chemclipse.processing.converter.ISupplier;
import org.eclipse.chemclipse.rcp.ui.icons.core.ApplicationImageFactory;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImage;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImageProvider;

public class CalibrationFileSupplier implements ISupplier {

	public static final String EDITOR_ID = "org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.ui.editors.editorCalibration";
	public static final String EDITOR_CONTRIBUTION_URI = "bundleclass://org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.ui/org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.ui.editors.EditorCalibration";
	public static final String EDITOR_ICON_URI = ApplicationImageFactory.getInstance().getURI(IApplicationImage.IMAGE_REPORT, IApplicationImageProvider.SIZE_16x16);
	public static final String EDITOR_TOOLTIP = "Retention Index Calibration";

	@Override
	public String getId() {

		return "org.eclipse.chemclipse.ux.extension.xxd.ui.internal.editors.cal.file";
	}

	@Override
	public String getDescription() {

		return "This is the AMDIS *.cal Calibration File support.";
	}

	@Override
	public String getFilterName() {

		return "AMDIS Calibration File";
	}

	@Override
	public String getFileExtension() {

		return ".cal";
	}

	@Override
	public String getFileName() {

		return "Calibration";
	}

	@Override
	public String getDirectoryExtension() {

		return "";
	}

	@Override
	public boolean isExportable() {

		return true;
	}

	@Override
	public boolean isImportable() {

		return true;
	}

	@Override
	public boolean isMatchMagicNumber(File file) {

		String fileName = file.getName().toLowerCase();
		if(fileName.endsWith(".cal")) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isMatchContent(File file) {

		return true;
	}
}
