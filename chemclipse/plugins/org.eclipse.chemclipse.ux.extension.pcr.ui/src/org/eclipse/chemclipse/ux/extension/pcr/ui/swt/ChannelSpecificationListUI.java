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
package org.eclipse.chemclipse.ux.extension.pcr.ui.swt;

import org.eclipse.chemclipse.pcr.model.core.IChannelSpecification;
import org.eclipse.chemclipse.support.ui.provider.ListContentProvider;
import org.eclipse.chemclipse.support.ui.swt.ExtendedTableViewer;
import org.eclipse.chemclipse.support.ui.swt.IRecordTableComparator;
import org.eclipse.chemclipse.ux.extension.pcr.ui.provider.ChannelSpecificationLabelProvider;
import org.eclipse.chemclipse.ux.extension.pcr.ui.provider.ChannelSpecificationListFilter;
import org.eclipse.chemclipse.ux.extension.pcr.ui.provider.ChannelSpecificationTableComparator;
import org.eclipse.swt.widgets.Composite;

public class ChannelSpecificationListUI extends ExtendedTableViewer {

	private ChannelSpecificationTableComparator tableComparator = new ChannelSpecificationTableComparator();
	private ChannelSpecificationListFilter listFilter = new ChannelSpecificationListFilter();
	private ChannelSpecificationLabelProvider labelProvider = new ChannelSpecificationLabelProvider();
	private String[] titles = ChannelSpecificationLabelProvider.TITLES;
	private int[] bounds = ChannelSpecificationLabelProvider.BOUNDS;

	private IChannelSpecification channelSpecification = null;

	public ChannelSpecificationListUI(Composite parent, int style) {

		super(parent, style);
		createColumns();
	}

	public void setSearchText(String searchText, boolean caseSensitive) {

		listFilter.setSearchText(searchText, caseSensitive);
		refresh();
	}

	public void setInput(IChannelSpecification channelSpecification) {

		this.channelSpecification = channelSpecification;
		if(channelSpecification != null) {
			super.setInput(channelSpecification.getHeaderDataMap());
		} else {
			clear();
		}
	}

	public void clear() {

		super.setInput(null);
	}

	public IChannelSpecification getChannelSpecification() {

		return channelSpecification;
	}

	public void sortTable() {

		int column = 0;
		int sortOrder = IRecordTableComparator.DESCENDING;

		tableComparator.setColumn(column);
		tableComparator.setDirection(sortOrder);
		refresh();
	}

	private void createColumns() {

		createColumns(titles, bounds);
		setLabelProvider(labelProvider);
		setContentProvider(new ListContentProvider());
		setComparator(tableComparator);
		setFilters(listFilter);
	}
}
