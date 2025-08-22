/*******************************************************************************
 * Copyright (c) 2017, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Christoph Läubrich - extend API
 *******************************************************************************/
package org.eclipse.chemclipse.support.ui.swt;

import java.util.List;

import org.eclipse.chemclipse.support.settings.ValueDelimiter;
import org.eclipse.chemclipse.support.ui.swt.columns.ColumnDefinition;
import org.eclipse.chemclipse.support.ui.swt.columns.ColumnDefinitionProvider;
import org.eclipse.jface.viewers.TableViewerColumn;

public interface IExtendedTableViewer {

	ITableSettings getTableSettings();

	void applySettings(ITableSettings chartSettings);

	void createColumns(String[] titles, int[] bounds);

	List<TableViewerColumn> getTableViewerColumns();

	boolean isEditEnabled();

	void setEditEnabled(boolean editEnabled);

	boolean isCopyHeaderToClipboard();

	void setCopyHeaderToClipboard(boolean copyHeaderToClipboard);

	ValueDelimiter getCopyValueDelimiterClipboard();

	void setCopyValueDelimiterClipboard(ValueDelimiter valueDelimiter);

	String getCopyColumnsToClipboard();

	void setCopyColumnsToClipboard(String copyColumnsToClipboard);

	void resetColumnOrder();

	void resetColumnWidth();

	void clearColumns();

	<D, C> TableViewerColumn addColumn(ColumnDefinition<D, C> definition);

	default void addColumns(ColumnDefinitionProvider provider) {

		if(provider == null) {
			return;
		}

		for(ColumnDefinition<?, ?> definition : provider.getColumnDefinitions()) {
			addColumn(definition);
		}
	}
}