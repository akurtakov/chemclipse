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
package org.eclipse.chemclipse.ux.extension.xxd.ui.swt;

import java.util.List;

import org.eclipse.chemclipse.support.ui.provider.ListContentProvider;
import org.eclipse.chemclipse.support.ui.swt.ExtendedTableViewer;
import org.eclipse.chemclipse.support.updates.IUpdateListener;
import org.eclipse.chemclipse.ux.extension.xxd.ui.internal.provider.TraceRange1DEditingSupport;
import org.eclipse.chemclipse.ux.extension.xxd.ui.internal.provider.TraceRange1DFilter;
import org.eclipse.chemclipse.ux.extension.xxd.ui.internal.provider.TraceRange1DLabelProvider;
import org.eclipse.chemclipse.ux.extension.xxd.ui.internal.provider.TraceRange1DTableComparator;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.widgets.Composite;

public class TraceRanges1DListUI extends ExtendedTableViewer {

	private static final String[] TITLES = TraceRange1DLabelProvider.TITLES;
	private static final int[] BOUNDS = TraceRange1DLabelProvider.BOUNDS;

	private TraceRange1DLabelProvider labelProvider = new TraceRange1DLabelProvider();
	private TraceRange1DTableComparator tableComparator = new TraceRange1DTableComparator();
	private TraceRange1DFilter listFilter = new TraceRange1DFilter();

	private IUpdateListener updateListener;

	public TraceRanges1DListUI(Composite parent, int style) {

		super(parent, style);
		createColumns();
	}

	public void setUpdateListener(IUpdateListener updateListener) {

		this.updateListener = updateListener;
	}

	public void updateContent() {

		if(updateListener != null) {
			updateListener.update();
		}
	}

	public void clear() {

		setInput(null);
	}

	public void setSearchText(String searchText, boolean caseSensitive) {

		listFilter.setSearchText(searchText, caseSensitive);
		refresh();
	}

	private void createColumns() {

		createColumns(TITLES, BOUNDS);
		setLabelProvider(labelProvider);
		setContentProvider(new ListContentProvider());
		setComparator(tableComparator);
		setEditingSupport();
	}

	private void setEditingSupport() {

		List<TableViewerColumn> tableViewerColumns = getTableViewerColumns();
		for(int i = 0; i < tableViewerColumns.size(); i++) {
			TableViewerColumn tableViewerColumn = tableViewerColumns.get(i);
			String label = tableViewerColumn.getColumn().getText();
			tableViewerColumn.setEditingSupport(new TraceRange1DEditingSupport(this, label));
		}
	}
}