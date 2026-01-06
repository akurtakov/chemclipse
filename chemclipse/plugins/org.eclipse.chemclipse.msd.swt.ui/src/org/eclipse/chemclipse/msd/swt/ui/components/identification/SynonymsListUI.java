/*******************************************************************************
 * Copyright (c) 2014, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.swt.ui.components.identification;

import java.util.List;

import org.eclipse.chemclipse.model.identifier.ILibraryInformation;
import org.eclipse.chemclipse.msd.swt.ui.internal.editingsupport.SynonymsTextEditingSupport;
import org.eclipse.chemclipse.msd.swt.ui.internal.provider.SynonymsListContentProvider;
import org.eclipse.chemclipse.msd.swt.ui.internal.provider.SynonymsListLabelProvider;
import org.eclipse.chemclipse.msd.swt.ui.internal.provider.SynonymsListTableComparator;
import org.eclipse.chemclipse.support.ui.swt.ExtendedTableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.widgets.Composite;

public class SynonymsListUI extends ExtendedTableViewer {

	private String[] titles = {"Synonym"};
	private int[] bounds = {300};

	public SynonymsListUI(Composite parent) {

		super(parent);
		createColumns();
	}

	public SynonymsListUI(Composite parent, int style) {

		super(parent, style);
		createColumns();
	}

	private void createColumns() {

		createColumns(titles, bounds);

		setLabelProvider(new SynonymsListLabelProvider());
		setContentProvider(new SynonymsListContentProvider());
		setComparator(new SynonymsListTableComparator());
		setEditingSupport();
	}

	public void update(ILibraryInformation libraryInformation, boolean forceReload) {

		if(libraryInformation != null) {
			setInput(libraryInformation.getSynonyms());
		}
	}

	private void setEditingSupport() {

		List<TableViewerColumn> tableViewerColumns = getTableViewerColumns();
		TableViewerColumn tableViewerColumn = tableViewerColumns.get(0);
		tableViewerColumn.setEditingSupport(new SynonymsTextEditingSupport(this));
	}
}
