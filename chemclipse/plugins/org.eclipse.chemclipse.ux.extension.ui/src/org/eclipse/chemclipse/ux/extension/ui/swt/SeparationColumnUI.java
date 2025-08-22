/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.ui.swt;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.chemclipse.model.columns.ISeparationColumn;
import org.eclipse.chemclipse.model.columns.SeparationColumnFactory;
import org.eclipse.chemclipse.support.model.SeparationColumnType;
import org.eclipse.chemclipse.support.ui.provider.AbstractLabelProvider;
import org.eclipse.chemclipse.support.ui.provider.ListContentProvider;
import org.eclipse.chemclipse.support.ui.swt.EnhancedComboViewer;
import org.eclipse.chemclipse.ux.extension.ui.dialogs.ColumnDetailsDialog;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

public class SeparationColumnUI extends Composite {

	private static final String EDIT_COLUMNS = "Edit Columns";

	private AtomicReference<ComboViewer> comboViewerControl = new AtomicReference<>();
	private List<ISeparationColumn> separationColumns = new ArrayList<>();
	private ISeparationColumn separationColumn = null;

	private IColumnUpdateListener columnUpdateListener = null;

	public SeparationColumnUI(Composite parent, int style) {

		super(parent, style);
		createControl();
	}

	public void setColumnUpdateListener(IColumnUpdateListener columnUpdateListener) {

		this.columnUpdateListener = columnUpdateListener;
	}

	public void setInput(List<ISeparationColumn> separationColumns) {

		this.separationColumns.clear();
		this.separationColumns.addAll(separationColumns);
		updateInput();
	}

	public void select(ISeparationColumn separationColumn) {

		this.separationColumn = separationColumn;
		setSelection();
	}

	private void createControl() {

		setLayout(new FillLayout());

		Composite composite = new Composite(this, SWT.NONE);
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginLeft = 0;
		gridLayout.marginRight = 0;
		composite.setLayout(gridLayout);

		createComboViewerColumns(composite);
	}

	private void createComboViewerColumns(Composite parent) {

		ComboViewer comboViewer = new EnhancedComboViewer(parent, SWT.READ_ONLY);
		Combo combo = comboViewer.getCombo();
		comboViewer.setContentProvider(new ListContentProvider());
		comboViewer.setLabelProvider(new AbstractLabelProvider() {

			@Override
			public String getText(Object element) {

				if(element instanceof ISeparationColumn separationColumn) {
					combo.setToolTipText(separationColumn.getName());
					return SeparationColumnFactory.getColumnLabel(separationColumn, 10);
				} else if(element instanceof String value) {
					return value;
				}
				return null;
			}
		});

		combo.setToolTipText("Select a separation column.");
		GridData gridData = new GridData();
		gridData.widthHint = 100;
		combo.setLayoutData(gridData);
		combo.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				Object object = comboViewer.getStructuredSelection().getFirstElement();
				if(object instanceof ISeparationColumn selection) {
					separationColumn = selection;
					fireUpdate(e.display.getActiveShell());
				} else if(object instanceof String value) {
					if(EDIT_COLUMNS.equals(value)) {
						ColumnDetailsDialog columnDetailsDialog = new ColumnDetailsDialog(e.display.getActiveShell());
						columnDetailsDialog.update(separationColumns);
						if(columnDetailsDialog.open() == Window.OK) {
							Map<SeparationColumnType, String> nameMap = columnDetailsDialog.getNameMap();
							for(ISeparationColumn separationColumn : separationColumns) {
								String name = nameMap.get(separationColumn.getSeparationColumnType());
								if(name != null) {
									separationColumn.setName(name);
								}
							}
							fireUpdate(e.display.getActiveShell());
						}
						setSelection();

					}
				}
			}
		});

		comboViewerControl.set(comboViewer);
	}

	private void setSelection() {

		if(separationColumn != null) {
			if(!separationColumns.contains(separationColumn)) {
				separationColumns.add(0, separationColumn);
				updateInput();
			}
			comboViewerControl.get().setSelection(new StructuredSelection(separationColumn));
		}
	}

	private void updateInput() {

		/*
		 * Separation Columns
		 */
		List<Object> items = new ArrayList<>();
		items.addAll(separationColumns);
		/*
		 * The edit functionality needs to be implemented
		 */
		// items.add(EDIT_COLUMNS);

		comboViewerControl.get().setInput(items);
	}

	private void fireUpdate(Shell shell) {

		if(columnUpdateListener != null) {
			columnUpdateListener.update(shell, separationColumn);
		}
	}
}