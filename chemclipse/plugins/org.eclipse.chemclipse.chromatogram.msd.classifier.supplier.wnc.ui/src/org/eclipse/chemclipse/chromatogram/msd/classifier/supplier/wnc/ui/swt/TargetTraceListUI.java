/*******************************************************************************
 * Copyright (c) 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.ui.swt;

import java.util.List;

import org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.ui.internal.provider.TargetTraceEditingSupport;
import org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.ui.internal.provider.TargetTraceTableComparator;
import org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.ui.internal.provider.TargetTracesContentProvider;
import org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.ui.internal.provider.TargetTracesLabelProvider;
import org.eclipse.chemclipse.support.ui.swt.ExtendedTableViewer;
import org.eclipse.chemclipse.support.updates.IUpdateListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.widgets.Composite;

public class TargetTraceListUI extends ExtendedTableViewer {

	private static final String[] TITLES = TargetTracesLabelProvider.TITLES;
	private static final int[] BOUNDS = TargetTracesLabelProvider.BOUNDS;

	private LabelProvider labelProvider = new TargetTracesLabelProvider();
	private IStructuredContentProvider contentProvider = new TargetTracesContentProvider();
	private IUpdateListener updateListener;

	public TargetTraceListUI(Composite parent, int style) {

		super(parent, style);
		initialize();
	}

	private void initialize() {

		createColumns(TITLES, BOUNDS);
		setLabelProvider(labelProvider);
		setContentProvider(contentProvider);
		setComparator(new TargetTraceTableComparator());
		setEditingSupport();
	}

	private void setEditingSupport() {

		List<TableViewerColumn> tableViewerColumns = getTableViewerColumns();
		for(TableViewerColumn tableViewerColumn : tableViewerColumns) {
			String columnLabel = tableViewerColumn.getColumn().getText();
			if(columnLabel.equals(TargetTracesLabelProvider.NAME)) {
				tableViewerColumn.setEditingSupport(new TargetTraceEditingSupport(this));
			}
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
}
