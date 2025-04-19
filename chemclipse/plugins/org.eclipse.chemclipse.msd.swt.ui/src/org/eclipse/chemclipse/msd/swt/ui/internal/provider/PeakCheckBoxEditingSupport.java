/*******************************************************************************
 * Copyright (c) 2016, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.swt.ui.internal.provider;

import org.eclipse.chemclipse.model.core.IPeak;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;

public class PeakCheckBoxEditingSupport extends EditingSupport {

	private CheckboxCellEditor cellEditor;
	private TableViewer tableViewer;

	public PeakCheckBoxEditingSupport(TableViewer tableViewer) {

		super(tableViewer);
		this.cellEditor = new CheckboxCellEditor(tableViewer.getTable());
		this.tableViewer = tableViewer;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {

		return cellEditor;
	}

	@Override
	protected boolean canEdit(Object element) {

		return true;
	}

	@Override
	protected Object getValue(Object element) {

		if(element instanceof IPeak peak) {
			return peak.isActiveForAnalysis();
		}
		return false;
	}

	@Override
	protected void setValue(Object element, Object value) {

		if(element instanceof IPeak peak) {
			peak.setActiveForAnalysis((boolean)value);
			tableViewer.refresh();
		}
	}
}
