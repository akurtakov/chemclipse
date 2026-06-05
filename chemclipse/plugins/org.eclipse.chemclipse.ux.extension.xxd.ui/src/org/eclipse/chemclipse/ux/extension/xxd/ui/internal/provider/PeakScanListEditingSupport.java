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
 * Christoph Läubrich - add support for name editing, improve classifier support
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.xxd.ui.internal.provider;

import org.eclipse.chemclipse.model.core.IPeak;
import org.eclipse.chemclipse.support.ui.swt.ExtendedTableViewer;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;

public class PeakScanListEditingSupport extends EditingSupport {

	private final CellEditor cellEditor;
	private final ExtendedTableViewer tableViewer;
	private final String column;

	public PeakScanListEditingSupport(ExtendedTableViewer tableViewer, String column) {

		super(tableViewer);
		this.column = column;
		this.cellEditor = new CheckboxCellEditor(tableViewer.getTable());
		this.tableViewer = tableViewer;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {

		return cellEditor;
	}

	@Override
	protected boolean canEdit(Object element) {

		return element instanceof IPeak && column.equals(PeakScanListLabelProvider.ACTIVE_FOR_ANALYSIS);
	}

	@Override
	protected Object getValue(Object element) {

		if(element instanceof IPeak peak && column.equals(PeakScanListLabelProvider.ACTIVE_FOR_ANALYSIS)) {
			return peak.isActiveForAnalysis();
		}
		return Boolean.FALSE;
	}

	@Override
	protected void setValue(Object element, Object value) {

		if(element instanceof IPeak peak) {
			if(column.equals(PeakScanListLabelProvider.ACTIVE_FOR_ANALYSIS)) {
				peak.setActiveForAnalysis((boolean)value);
			}
			tableViewer.refresh(element);
		}
	}
}
