/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.xxd.ui.internal.provider;

import org.eclipse.chemclipse.model.columns.IRetentionIndexEntry;
import org.eclipse.chemclipse.ux.extension.xxd.ui.calibration.RetentionIndexTableViewerUI;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TextCellEditor;

public class RetentionIndexEditingSupport extends EditingSupport {

	private TextCellEditor cellEditor;
	private RetentionIndexTableViewerUI tableViewer;

	public RetentionIndexEditingSupport(RetentionIndexTableViewerUI tableViewer) {

		super(tableViewer);
		this.tableViewer = tableViewer;
		cellEditor = new TextCellEditor(tableViewer.getTable());
	}

	@Override
	protected CellEditor getCellEditor(Object element) {

		return cellEditor;
	}

	@Override
	protected boolean canEdit(Object element) {

		return tableViewer.isEditEnabled();
	}

	@Override
	protected Object getValue(Object element) {

		Object object = null;
		if(element instanceof IRetentionIndexEntry retentionIndexEntry) {
			object = retentionIndexEntry.getName();
		}
		return object;
	}

	@Override
	protected void setValue(Object element, Object value) {

		if(element instanceof IRetentionIndexEntry retentionIndexEntry) {
			retentionIndexEntry.setName(value.toString().trim());
			tableViewer.refresh();
			tableViewer.updateContent();
		}
	}
}
