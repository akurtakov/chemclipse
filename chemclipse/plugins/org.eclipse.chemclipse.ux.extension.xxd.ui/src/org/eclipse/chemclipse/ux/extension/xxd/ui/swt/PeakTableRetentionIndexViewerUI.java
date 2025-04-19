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
package org.eclipse.chemclipse.ux.extension.xxd.ui.swt;

import org.eclipse.chemclipse.support.ui.provider.ListContentProvider;
import org.eclipse.chemclipse.support.ui.swt.ExtendedTableViewer;
import org.eclipse.chemclipse.ux.extension.xxd.ui.internal.provider.PeakTableRetentionIndexLabelProvider;
import org.eclipse.swt.widgets.Composite;

public class PeakTableRetentionIndexViewerUI extends ExtendedTableViewer {

	private String[] titles = {"Retention Time (Minutes)", "Retention Index", "S/N", "Peak Area"};
	private int[] bounds = {150, 150, 150, 150};

	public PeakTableRetentionIndexViewerUI(Composite parent) {
		super(parent);
		initialize();
	}

	public PeakTableRetentionIndexViewerUI(Composite parent, int style) {
		super(parent, style);
		initialize();
	}

	private void initialize() {

		createColumns(titles, bounds);
		setLabelProvider(new PeakTableRetentionIndexLabelProvider());
		setContentProvider(new ListContentProvider());
	}
}
