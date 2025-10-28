/*******************************************************************************
 * Copyright (c) 2021, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.ui.swt;

import java.util.List;

import org.eclipse.chemclipse.model.identifier.ILibraryInformation;
import org.eclipse.chemclipse.model.ui.internal.provider.LibraryInformationComparator;
import org.eclipse.chemclipse.model.ui.internal.provider.LibraryInformationContentProvider;
import org.eclipse.chemclipse.model.ui.internal.provider.LibraryInformationFilter;
import org.eclipse.chemclipse.model.ui.internal.provider.LibraryInformationLabelProvider;
import org.eclipse.chemclipse.support.ui.provider.ListContentProvider;
import org.eclipse.chemclipse.support.ui.swt.ExtendedTableViewer;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Composite;

public class LibraryInformationListUI extends ExtendedTableViewer {

	private static final String[] TITLES = LibraryInformationLabelProvider.TITLES;
	private static final int[] BOUNDS = LibraryInformationLabelProvider.BOUNDS;

	private LabelProvider labelProvider = new LibraryInformationLabelProvider();
	private LibraryInformationContentProvider contentProviderLazy = new LibraryInformationContentProvider(this);
	private IContentProvider contentProviderNormal = new ListContentProvider();
	private ViewerComparator comparator = new LibraryInformationComparator();
	private LibraryInformationFilter listFilter = new LibraryInformationFilter();

	public LibraryInformationListUI(Composite parent, int style) {

		super(parent, style);
		initialize();
	}

	public void setSearchText(String searchText, boolean caseSensitive) {

		listFilter.setSearchText(searchText, caseSensitive);
		refresh();
	}

	public void setInput(List<ILibraryInformation> libraryInformations) {

		int size = 0;
		setItemCount(size);

		if(libraryInformations != null) {
			size = libraryInformations.size();
			if(size > 1000) {
				setContentProvider(contentProviderLazy);
				setComparator(null);
				super.setInput(null);
				setUseHashlookup(true);
			} else {
				setContentProvider(contentProviderNormal);
				setComparator(comparator);
				super.setInput(null);
				setUseHashlookup(false);
			}
		}

		super.setInput(libraryInformations);
		setItemCount(size);
	}

	private void initialize() {

		createColumns(TITLES, BOUNDS);
		setLabelProvider(labelProvider);
		setContentProvider(contentProviderLazy);
		setUseHashlookup(true);
		setFilters(new ViewerFilter[]{listFilter});
	}
}