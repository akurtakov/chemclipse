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

import org.eclipse.chemclipse.model.identifier.template.TargetTemplate;
import org.eclipse.chemclipse.support.ui.swt.ExtendedTableViewer;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TextCellEditor;

public class TargetTemplateEditingSupport extends EditingSupport {

	private CellEditor cellEditor;
	private ExtendedTableViewer tableViewer;
	private String column;

	public TargetTemplateEditingSupport(ExtendedTableViewer tableViewer, String column) {

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

		return tableViewer.isEditEnabled();
	}

	@Override
	protected Object getValue(Object element) {

		if(element instanceof TargetTemplate targetTemplate) {
			switch(column) {
				// case TargetTemplateLabelProvider.NAME:
				// return targetTemplate.getName();
				case TargetTemplateLabelProvider.CAS:
					return targetTemplate.getCasNumber();
				case TargetTemplateLabelProvider.COMMENTS:
					return targetTemplate.getComments();
				case TargetTemplateLabelProvider.CONTRIBUTOR:
					return targetTemplate.getContributor();
				case TargetTemplateLabelProvider.REFERENCE_ID:
					return targetTemplate.getReferenceId();
			}
		}
		return false;
	}

	@Override
	protected void setValue(Object element, Object value) {

		if(element instanceof TargetTemplate targetTemplate) {
			switch(column) {
				// case TargetTemplateLabelProvider.NAME:
				// targetTemplate.setName((String)value);
				// break;
				case TargetTemplateLabelProvider.CAS:
					targetTemplate.setCasNumber((String)value);
					break;
				case TargetTemplateLabelProvider.COMMENTS:
					targetTemplate.setComments((String)value);
					break;
				case TargetTemplateLabelProvider.CONTRIBUTOR:
					targetTemplate.setContributor((String)value);
					break;
				case TargetTemplateLabelProvider.REFERENCE_ID:
					targetTemplate.setReferenceId((String)value);
					break;
			}
			tableViewer.refresh();
		}
	}
}
