/*******************************************************************************
 * Copyright (c) 2020, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.process.supplier.pca.ui.internal.provider;

import org.eclipse.chemclipse.model.statistics.IVariable;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.Feature;
import org.eclipse.chemclipse.xxd.process.supplier.pca.ui.swt.FeatureListUI;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TextCellEditor;

public class FeatureEditingSupport extends EditingSupport {

	private CellEditor cellEditor;
	private final FeatureListUI tableViewer;
	private final String column;

	public FeatureEditingSupport(FeatureListUI tableViewer, String column) {

		super(tableViewer);
		this.column = column;
		if(FeatureLabelProvider.USE.equals(column)) {
			this.cellEditor = new CheckboxCellEditor(tableViewer.getTable());
		} else {
			this.cellEditor = new TextCellEditor(tableViewer.getTable());
		}
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

		if(element instanceof Feature feature) {
			IVariable variable = feature.getVariable();
			switch(column) {
				case FeatureLabelProvider.USE:
					return variable.isSelected();
				case FeatureLabelProvider.CLASSIFICATION:
					String classification = variable.getClassification();
					if(classification == null) {
						return "";
					}
					return classification;
				case FeatureLabelProvider.DESCRIPTION:
					String description = variable.getDescription();
					if(description == null) {
						return "";
					}
					return description;
			}
		}
		return false;
	}

	@Override
	protected void setValue(Object element, Object value) {

		if(element instanceof Feature feature) {
			IVariable variable = feature.getVariable();
			switch(column) {
				case FeatureLabelProvider.USE:
					variable.setSelected((boolean)value);
					break;
				case FeatureLabelProvider.CLASSIFICATION:
					String classification = (String)value;
					if("".equals(classification)) {
						variable.setClassification(null);
					} else {
						variable.setClassification(classification);
					}
					break;
				case FeatureLabelProvider.DESCRIPTION:
					String description = (String)value;
					if("".equals(description)) {
						variable.setDescription(null);
					} else {
						variable.setDescription(description);
					}
					break;
			}

			tableViewer.refresh(element);
			tableViewer.updateContent();
		}
	}
}
