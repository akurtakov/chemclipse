/*******************************************************************************
 * Copyright (c) 2016, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.swt.ui.components.peaks;

import java.util.List;

import org.eclipse.chemclipse.model.support.PeakQuantitation;
import org.eclipse.chemclipse.model.support.PeakQuantitations;
import org.eclipse.chemclipse.support.ui.provider.ListContentProvider;
import org.eclipse.chemclipse.support.ui.swt.ExtendedTableViewer;
import org.eclipse.chemclipse.swt.ui.internal.provider.PeakQuantitationListLabelProvider;
import org.eclipse.chemclipse.swt.ui.internal.provider.PeakQuantitationListTableComparator;
import org.eclipse.swt.widgets.Composite;

public class PeakQuantitationListUI extends ExtendedTableViewer {

	public static final String TIME = "Time [min]";
	public static final String NAME = "Name";
	public static final String CAS = "CAS#";
	public static final String REFERENCE_ID = "Reference Identifier";
	public static final String AREA = "Area";
	public static final String CLASSIFIER = "Classifier";
	public static final String QUANTIFIER = "Quantifier";
	/*
	 * This is a reminder to adjust the header columns correctly.
	 */
	public static final int INDEX_QUANTITATIONS = PeakQuantitation.INDEX_QUANTITATIONS;
	private static final int DEFAULT_COLUMN_WIDTH = 100;

	private static final String[] TITLES = { //
			TIME, //
			NAME, //
			CAS, //
			REFERENCE_ID, //
			AREA, //
			CLASSIFIER, //
			QUANTIFIER //
	};

	private static final int[] BOUNDS = { //
			100, //
			200, //
			100, //
			100, //
			100, //
			100, //
			100 //
	};

	public PeakQuantitationListUI(Composite parent, int style) {

		super(parent, style);
		setColumns(TITLES, BOUNDS);
	}

	public void update(PeakQuantitations peakQuantitations) {

		getTable().clearAll();
		if(peakQuantitations != null) {
			List<String> quantitationTitles = peakQuantitations.getTitles();
			int length = quantitationTitles.size();
			String[] titles;
			int[] bounds;
			if(length == 0) {
				titles = TITLES;
				bounds = BOUNDS;
			} else {
				titles = new String[length];
				bounds = new int[length];

				for(int i = 0; i < length; i++) {
					titles[i] = quantitationTitles.get(i);
					bounds[i] = DEFAULT_COLUMN_WIDTH;
				}
			}
			/*
			 * Set the columns
			 */
			setColumns(titles, bounds);
			setInput(peakQuantitations.getQuantitationEntries());
		} else {
			setInput(null);
		}
	}

	public void clear() {

		setInput(null);
	}

	private void setColumns(String[] titles, int bounds[]) {

		createColumns(titles, bounds);

		setLabelProvider(new PeakQuantitationListLabelProvider());
		setContentProvider(new ListContentProvider());
		setComparator(new PeakQuantitationListTableComparator());
	}
}