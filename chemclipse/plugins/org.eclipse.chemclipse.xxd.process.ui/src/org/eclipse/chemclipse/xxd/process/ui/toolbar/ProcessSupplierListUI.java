/*******************************************************************************
 * Copyright (c) 2021, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.process.ui.toolbar;

import org.eclipse.chemclipse.support.ui.provider.ListContentProvider;
import org.eclipse.chemclipse.support.ui.swt.ExtendedTableViewer;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.widgets.Composite;

public class ProcessSupplierListUI extends ExtendedTableViewer {

	private static final String[] TITLES = ProcessorLabelProvider.TITLES;
	private static final int[] BOUNDS = ProcessorLabelProvider.BOUNDS;

	private IBaseLabelProvider labelProvider = new ProcessorLabelProvider();
	private ViewerComparator tableComparator = new ProcessorTableComparator();
	private ProcessorListFilter viewerFilter = new ProcessorListFilter();

	public ProcessSupplierListUI(Composite parent, int style) {

		super(parent, style);
		createColumns();
	}

	public void setSearchText(String searchText, boolean caseSensitive) {

		viewerFilter.setSearchText(searchText, caseSensitive);
		refresh();
	}

	public void enableSorting(boolean enableSorting) {

		if(enableSorting) {
			setComparator(tableComparator);
		} else {
			setComparator(null);
		}
	}

	private void createColumns() {

		createColumns(TITLES, BOUNDS);
		setLabelProvider(labelProvider);
		setContentProvider(new ListContentProvider());
		setFilters(viewerFilter);
	}
}
