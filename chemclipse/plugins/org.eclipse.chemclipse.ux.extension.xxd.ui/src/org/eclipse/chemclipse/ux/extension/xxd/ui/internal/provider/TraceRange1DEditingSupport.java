/*******************************************************************************
 * Copyright (c) 2024, 2025 Lablicate GmbH.
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

import org.eclipse.chemclipse.tsd.model.core.TraceRange1D;
import org.eclipse.chemclipse.ux.extension.xxd.ui.swt.TraceRanges1DListUI;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TextCellEditor;

public class TraceRange1DEditingSupport extends EditingSupport {

	private String column;
	private CellEditor cellEditor;
	private TraceRanges1DListUI tableViewer;

	public TraceRange1DEditingSupport(TraceRanges1DListUI tableViewer, String column) {

		super(tableViewer);
		this.column = column;
		this.cellEditor = new TextCellEditor(tableViewer.getTable());
		this.tableViewer = tableViewer;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {

		return cellEditor;
	}

	@Override
	protected boolean canEdit(Object element) {

		boolean canEdit = false;
		if(tableViewer.isEditEnabled()) {
			canEdit = column.equals(TraceRange1DLabelProvider.NAME) || //
					column.equals(TraceRange1DLabelProvider.TRACES);
		}

		return canEdit;
	}

	@Override
	protected Object getValue(Object element) {

		if(element instanceof TraceRange1D traceRange) {
			switch(column) {
				case TraceRange2DLabelProvider.NAME:
					return traceRange.getName();
				case TraceRange2DLabelProvider.TRACES:
					return traceRange.getTraces();
			}
		}
		return false;
	}

	@Override
	protected void setValue(Object element, Object value) {

		if(element instanceof TraceRange1D traceRange) {
			switch(column) {
				case TraceRange1DLabelProvider.NAME:
					traceRange.setName(value.toString());
					break;
				case TraceRange1DLabelProvider.TRACES:
					traceRange.setTraces(value.toString());
					break;
			}

			tableViewer.refresh();
			tableViewer.updateContent();
		}
	}
}