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
package org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.ui.internal.provider;

import org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.model.TargetTrace;
import org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.ui.swt.TargetTraceListUI;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TextCellEditor;

public class TargetTraceEditingSupport extends EditingSupport {

	private TextCellEditor cellEditor;
	private TargetTraceListUI tableViewer;

	public TargetTraceEditingSupport(TargetTraceListUI tableViewer) {

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
		if(element instanceof TargetTrace targetTrace) {
			object = targetTrace.getName();
		}
		return object;
	}

	@Override
	protected void setValue(Object element, Object value) {

		if(element instanceof TargetTrace targetTrace) {
			targetTrace.setName(value.toString().trim());
			tableViewer.refresh();
			tableViewer.updateContent();
		}
	}
}