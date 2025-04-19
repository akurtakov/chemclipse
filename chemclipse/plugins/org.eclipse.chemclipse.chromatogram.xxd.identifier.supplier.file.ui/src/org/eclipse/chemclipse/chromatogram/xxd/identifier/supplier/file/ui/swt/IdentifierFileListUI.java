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
package org.eclipse.chemclipse.chromatogram.xxd.identifier.supplier.file.ui.swt;

import org.eclipse.chemclipse.chromatogram.xxd.identifier.supplier.file.ui.internal.provider.IdentifierListLabelProvider;
import org.eclipse.chemclipse.chromatogram.xxd.identifier.supplier.file.ui.internal.provider.IdentifierListTableComparator;
import org.eclipse.chemclipse.support.ui.provider.ListContentProvider;
import org.eclipse.chemclipse.support.ui.swt.ExtendedTableViewer;
import org.eclipse.swt.widgets.Composite;

public class IdentifierFileListUI extends ExtendedTableViewer {

	public IdentifierFileListUI(Composite parent, int style) {

		super(parent, style);
		createColumns();
	}

	private void createColumns() {

		createColumns(IdentifierListLabelProvider.TITLES, IdentifierListLabelProvider.BOUNDS);
		setLabelProvider(new IdentifierListLabelProvider());
		setContentProvider(new ListContentProvider());
		setComparator(new IdentifierListTableComparator());
	}
}