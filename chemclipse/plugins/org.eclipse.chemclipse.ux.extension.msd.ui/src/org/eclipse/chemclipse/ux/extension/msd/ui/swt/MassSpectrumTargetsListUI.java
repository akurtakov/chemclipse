/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Matthias Mailänder - adapted for MALDI
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.msd.ui.swt;

import org.eclipse.chemclipse.support.ui.provider.ListContentProvider;
import org.eclipse.chemclipse.support.ui.swt.ExtendedTableViewer;
import org.eclipse.chemclipse.support.ui.swt.IRecordTableComparator;
import org.eclipse.chemclipse.support.updates.IUpdateListener;
import org.eclipse.chemclipse.ux.extension.msd.ui.internal.provider.TargetsComparator;
import org.eclipse.chemclipse.ux.extension.msd.ui.internal.provider.TargetsLabelProvider;
import org.eclipse.chemclipse.ux.extension.ui.provider.TargetListFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class MassSpectrumTargetsListUI extends ExtendedTableViewer {

	private static final String[] TITLES = TargetsLabelProvider.TITLES;
	private static final int[] BOUNDS = TargetsLabelProvider.BOUNDS;

	private final TargetsLabelProvider labelProvider = new TargetsLabelProvider();
	private final TargetsComparator targetsComparator = new TargetsComparator();
	private final TargetListFilter targetListFilter = new TargetListFilter();

	private IUpdateListener updateListener;

	public MassSpectrumTargetsListUI(Composite parent, int style) {

		this(parent, TITLES, style);
	}

	public void setComparator(boolean active) {

		if(active) {
			setComparator(targetsComparator);
			sortTable();
		} else {
			setComparator(null);
			refresh();
		}
	}

	public void setUpdateListener(IUpdateListener updateListener) {

		this.updateListener = updateListener;
	}

	public void updateContent() {

		if(updateListener != null) {
			updateListener.update();
		}
	}

	public MassSpectrumTargetsListUI(Composite parent, String[] alternativeTitles, int style) {

		super(parent, style | SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);

		createColumns(alternativeTitles, BOUNDS);
		setLabelProvider(labelProvider);
		setContentProvider(new ListContentProvider());
		setComparator(false);
		setFilters(targetListFilter);
	}

	public void setSearchText(String searchText, boolean caseSensitive) {

		targetListFilter.setSearchText(searchText, caseSensitive);
		refresh();
	}

	public void clear() {

		setInput(null);
	}

	public void sortTable() {

		if(getComparator() != null) {
			int column = 0;
			int sortOrder = IRecordTableComparator.DESCENDING;

			targetsComparator.setColumn(column);
			targetsComparator.setDirection(sortOrder);
			refresh();
			targetsComparator.setDirection(1 - sortOrder);
			targetsComparator.setColumn(column);
		}
	}
}