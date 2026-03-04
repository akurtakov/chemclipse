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
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.xxd.ui.internal.editors;

import java.io.File;

import org.eclipse.chemclipse.processing.converter.ISupplier;
import org.eclipse.chemclipse.rcp.ui.icons.core.ApplicationImageFactory;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImage;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImageProvider;

public class BatchJobFileSupplier implements ISupplier {

	public static final String EDITOR_ID = "org.eclipse.chemclipse.chromatogram.xxd.batchprocess.ui.editors.BatchProcessJobEditor";
	public static final String EDITOR_CONTRIBUTION_URI = "bundleclass://org.eclipse.chemclipse.chromatogram.xxd.process.supplier.batchprocess.ui/org.eclipse.chemclipse.chromatogram.xxd.process.supplier.batchprocess.ui.editors.BatchJobEditor";
	public static final String EDITOR_ICON_URI = ApplicationImageFactory.getInstance().getURI(IApplicationImage.IMAGE_BATCHPROCESS, IApplicationImageProvider.SIZE_16x16);
	public static final String EDITOR_TOOLTIP = "Batch Process Job";

	@Override
	public String getId() {

		return "org.eclipse.chemclipse.ux.extension.xxd.ui.internal.editors.obj.file";
	}

	@Override
	public String getDescription() {

		return "This is the *.obj Batch Job File support.";
	}

	@Override
	public String getFilterName() {

		return "Batch Job File";
	}

	@Override
	public String getFileExtension() {

		return ".obj";
	}

	@Override
	public String getFileName() {

		return "Batch Job";
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
		if(fileName.endsWith(".obj")) {
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
