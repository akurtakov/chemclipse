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
import java.util.Collections;
import java.util.Map;

import org.eclipse.chemclipse.model.core.support.HeaderField;
import org.eclipse.chemclipse.processing.converter.ISupplier;
import org.eclipse.chemclipse.ux.extension.ui.provider.AbstractSupplierFileEditorSupport;
import org.eclipse.chemclipse.ux.extension.ui.provider.ISupplierFileEditorSupport;
import org.eclipse.chemclipse.ux.extension.xxd.ui.internal.editors.CalibrationFileSupplier;

public class CalibrationEditorSupport extends AbstractSupplierFileEditorSupport implements ISupplierFileEditorSupport {

	public CalibrationEditorSupport() {

		super(Collections.singletonList(new CalibrationFileSupplier()));
	}

	@Override
	public String getType() {

		return TYPE_CAL;
	}

	@Override
	public boolean openEditor(File file, Map<HeaderField, String> headerMap) {

		return openEditor(file, headerMap, false);
	}

	@Override
	public boolean openEditor(final File file, Map<HeaderField, String> headerMap, boolean batch) {

		if(isSupplierFile(file)) {
			openEditor(file, null, EditorCalibration.ID, EditorCalibration.CONTRIBUTION_URI, EditorCalibration.ICON_URI, EditorCalibration.TOOLTIP, headerMap, batch);
			return true;
		}
		return false;
	}

	@Override
	public boolean openEditor(File file, Map<HeaderField, String> headerMap, ISupplier supplier) {

		return openEditor(file, headerMap);
	}
}
