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
package org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.ui.swt;

import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.ui.internal.provider.CalibrationListLabelProvider;
import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.ui.internal.provider.CalibrationListTableComparator;
import org.eclipse.chemclipse.support.ui.provider.ListContentProvider;
import org.eclipse.chemclipse.support.ui.swt.ExtendedTableViewer;
import org.eclipse.swt.widgets.Composite;

public class CalibrationFileListUI extends ExtendedTableViewer {

	public CalibrationFileListUI(Composite parent, int style) {

		super(parent, style);
		createColumns();
	}

	private void createColumns() {

		createColumns(CalibrationListLabelProvider.TITLES, CalibrationListLabelProvider.BOUNDS);
		setLabelProvider(new CalibrationListLabelProvider());
		setContentProvider(new ListContentProvider());
		setComparator(new CalibrationListTableComparator());
	}
}