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
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.xxd.ui.swt;

import org.eclipse.chemclipse.support.ui.provider.ListContentProvider;
import org.eclipse.chemclipse.support.ui.swt.ExtendedTableViewer;
import org.eclipse.chemclipse.support.ui.swt.IRecordTableComparator;
import org.eclipse.chemclipse.ux.extension.xxd.ui.internal.provider.SequenceFilesFilter;
import org.eclipse.chemclipse.ux.extension.xxd.ui.internal.provider.SequenceFilesLabelProvider;
import org.eclipse.chemclipse.ux.extension.xxd.ui.internal.provider.SequenceFilesTableComparator;
import org.eclipse.swt.widgets.Composite;

public class SequenceFilesUI extends ExtendedTableViewer {

	private SequenceFilesTableComparator sequenceListTableComparator;
	private SequenceFilesFilter sequenceListFilter;

	public SequenceFilesUI(Composite parent, int style) {

		super(parent, style);
		sequenceListTableComparator = new SequenceFilesTableComparator();
		createColumns();
	}

	public void setSearchText(String searchText, boolean caseSensitive) {

		sequenceListFilter.setSearchText(searchText, caseSensitive);
		refresh();
	}

	public void clear() {

		setInput(null);
	}

	public void sortTable() {

		int column = 0;
		int sortOrder = IRecordTableComparator.DESCENDING;

		sequenceListTableComparator.setColumn(column);
		sequenceListTableComparator.setDirection(sortOrder);
		refresh();
		sequenceListTableComparator.setDirection(1 - sortOrder);
		sequenceListTableComparator.setColumn(column);
	}

	private void createColumns() {

		createColumns(SequenceFilesLabelProvider.TITLES, SequenceFilesLabelProvider.BOUNDS);
		setLabelProvider(new SequenceFilesLabelProvider());
		setContentProvider(new ListContentProvider());
		setComparator(sequenceListTableComparator);
		sequenceListFilter = new SequenceFilesFilter();
		setFilters(sequenceListFilter);
	}
}
