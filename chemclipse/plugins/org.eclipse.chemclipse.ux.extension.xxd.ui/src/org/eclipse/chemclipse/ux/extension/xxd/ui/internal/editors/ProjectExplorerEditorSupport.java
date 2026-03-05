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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.chemclipse.model.core.IMeasurement;
import org.eclipse.chemclipse.model.core.IMeasurementInfo;
import org.eclipse.chemclipse.model.core.support.HeaderField;
import org.eclipse.chemclipse.model.types.DataType;
import org.eclipse.chemclipse.processing.converter.ISupplier;
import org.eclipse.chemclipse.ux.extension.ui.provider.AbstractSupplierFileEditorSupport;
import org.eclipse.chemclipse.ux.extension.ui.provider.ISupplierEditorSupport;

public class ProjectExplorerEditorSupport extends AbstractSupplierFileEditorSupport implements ISupplierEditorSupport {

	private String type = "";

	public ProjectExplorerEditorSupport(DataType dataType) {

		super(getSupplier(dataType));
		initialize(dataType);
	}

	private static List<ISupplier> getSupplier(DataType dataType) {

		List<ISupplier> supplier = new ArrayList<>();
		switch(dataType) {
			case CAL:
				supplier.add(new CalibrationFileSupplier());
				break;
			case OBJ:
				supplier.add(new BatchJobFileSupplier());
				break;
			default:
				// No action
		}

		return supplier;
	}

	private void initialize(DataType dataType) {

		switch(dataType) {
			case CAL:
				type = TYPE_CAL;
				break;
			case OBJ:
				type = TYPE_OBJ;
				break;
			default:
				type = "";
		}
	}

	@Override
	public String getType() {

		return type;
	}

	@Override
	public boolean openEditor(File file, Map<HeaderField, String> headerMap) {

		return openEditor(file, headerMap, false);
	}

	@Override
	public boolean openEditor(final File file, Map<HeaderField, String> headerMap, boolean batch) {

		if(TYPE_CAL.equals(type)) {
			/*
			 * Open the calibration file as a pure E4 part.
			 * null is passed for the 'object' parameter since the editor reads
			 * the file from the map set via EditorSupport.MAP_FILE.
			 */
			openEditor(file, null, CalibrationFileSupplier.EDITOR_ID, CalibrationFileSupplier.EDITOR_CONTRIBUTION_URI, CalibrationFileSupplier.EDITOR_ICON_URI, CalibrationFileSupplier.EDITOR_TOOLTIP, headerMap, batch);
			return true;
		} else if(TYPE_OBJ.equals(type)) {
			/*
			 * Open the batch job as a pure E4 part.
			 * null is passed for the 'object' parameter since the editor reads
			 * the file from the map set via EditorSupport.MAP_FILE.
			 */
			openEditor(file, null, BatchJobFileSupplier.EDITOR_ID, BatchJobFileSupplier.EDITOR_CONTRIBUTION_URI, BatchJobFileSupplier.EDITOR_ICON_URI, BatchJobFileSupplier.EDITOR_TOOLTIP, headerMap, batch);
			return true;
		}
		return false;
	}

	@Override
	public void openEditor(IMeasurement measurement) {

	}

	@Override
	public void openOverview(final File file) {

	}

	@Override
	public void openOverview(IMeasurementInfo measurementInfo) {

	}

	@Override
	public boolean openEditor(File file, Map<HeaderField, String> headerMap, ISupplier supplier) {

		return openEditor(file, headerMap);
	}
}