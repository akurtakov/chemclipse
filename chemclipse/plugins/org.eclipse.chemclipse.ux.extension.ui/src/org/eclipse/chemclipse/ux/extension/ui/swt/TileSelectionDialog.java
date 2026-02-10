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
 * Christoph Läubrich - initial API and implementation
 * Philip Wenig - adjust tile definition
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.ui.swt;

import org.eclipse.chemclipse.ux.extension.ui.definitions.ITileDefinition;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class TileSelectionDialog extends Dialog {

	private ITileDefinition[] elements;
	private CellLabelProvider labelProvider;
	private ITileDefinition selectedElement;

	public TileSelectionDialog(Shell parentShell, ITileDefinition[] elements, CellLabelProvider labelProvider) {

		super(parentShell);
		this.elements = elements;
		this.labelProvider = labelProvider;
	}

	@Override
	protected Control createDialogArea(Composite parent) {

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout());
		TableViewer tableViewer = new TableViewer(composite);
		TableViewerColumn column = new TableViewerColumn(tableViewer, SWT.NONE);
		column.setLabelProvider(labelProvider);
		column.getColumn().setWidth(300);
		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		tableViewer.setInput(elements);
		Control control = tableViewer.getControl();
		control.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));
		tableViewer.addSelectionChangedListener(event -> {

			ISelection selection = event.getSelection();
			if(selection instanceof IStructuredSelection structuredSelection) {
				Object selected = structuredSelection.getFirstElement();
				if(selected instanceof ITileDefinition tileDefinition) {
					selectedElement = tileDefinition;
				} else {
					selectedElement = null;
				}
			}
		});
		return composite;
	}

	public ITileDefinition getSelectedElement() {

		return selectedElement;
	}
}