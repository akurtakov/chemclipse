/*******************************************************************************
 * Copyright (c) 2019, 2026 Lablicate GmbH.
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

import java.io.IOException;

import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.processing.supplier.IProcessSupplier;
import org.eclipse.chemclipse.processing.supplier.IProcessSupplierContext;
import org.eclipse.chemclipse.processing.supplier.IProcessorPreferences;
import org.eclipse.chemclipse.processing.system.ProcessSettingsSupport;
import org.eclipse.chemclipse.support.history.IEditInformation;
import org.eclipse.chemclipse.support.history.ProcessSupplierEntry;
import org.eclipse.chemclipse.support.ui.swt.ExtendedTableViewer;
import org.eclipse.chemclipse.ux.extension.ui.methods.SettingsWizard;
import org.eclipse.chemclipse.ux.extension.xxd.ui.Activator;
import org.eclipse.chemclipse.ux.extension.xxd.ui.internal.provider.EditHistoryComparator;
import org.eclipse.chemclipse.ux.extension.xxd.ui.internal.provider.EditHistoryContentProvider;
import org.eclipse.chemclipse.ux.extension.xxd.ui.internal.provider.EditHistoryLabelProvider;
import org.eclipse.chemclipse.ux.extension.xxd.ui.internal.provider.EditHistoryListFilter;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

public class EditHistoryListUI extends ExtendedTableViewer {

	private LabelProvider labelProvider = new EditHistoryLabelProvider();
	private IContentProvider contentProvider = new EditHistoryContentProvider();
	private ViewerComparator comparator = new EditHistoryComparator();
	private EditHistoryListFilter listFilter = new EditHistoryListFilter();

	private static final Logger logger = Logger.getLogger(EditHistoryListUI.class);

	public EditHistoryListUI(Composite parent, int style) {

		super(parent, style);
		createColumns();
		createMouseListener();
	}

	public void setSearchText(String searchText, boolean caseSensitive) {

		listFilter.setSearchText(searchText, caseSensitive);
		refresh();
	}

	private void createColumns() {

		createColumns(EditHistoryLabelProvider.TITLES, EditHistoryLabelProvider.BOUNDS);

		setLabelProvider(labelProvider);
		setContentProvider(contentProvider);
		setComparator(comparator);
		setFilters(listFilter);
	}

	private void createMouseListener() {

		Table table = getTable();
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseDoubleClick(MouseEvent e) {

				Object firstElement = getStructuredSelection().getFirstElement();
				if(firstElement instanceof IEditInformation editInformation) {

					ProcessSupplierEntry processSupplierEntry = editInformation.getProcessSupplierEntry();
					if(processSupplierEntry == null) {
						return;
					}

					Shell shell = getControl().getShell();

					IProcessorPreferences<?> preferences = null;
					try {
						IProcessSupplierContext supplierContext = Activator.getProcessSupplierContext();
						IProcessSupplier<?> processSupplier = supplierContext.getSupplier(processSupplierEntry.getId());
						if(processSupplier != null) {
							preferences = SettingsWizard.getSettings(shell, ProcessSettingsSupport.getWorkspacePreferences(processSupplier), true);
						}
					} catch(IOException ex) {
						logger.warn(ex);
					}

					if(preferences == null || preferences.getSupplier().getSettingsParser().getInputValues().isEmpty()) {
						return;
					}

					SettingsWizard.openEditPreferencesWizard(shell, preferences, false);
				}
			}
		});
	}
}
