/*******************************************************************************
 * Copyright (c) 2023, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.support.ui.swt.dialogs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import org.eclipse.chemclipse.rcp.ui.icons.core.ApplicationImageFactory;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImage;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImageProvider;
import org.eclipse.chemclipse.support.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.support.settings.ValueDelimiter;
import org.eclipse.chemclipse.support.ui.l10n.SupportMessages;
import org.eclipse.chemclipse.support.ui.provider.AbstractLabelProvider;
import org.eclipse.chemclipse.support.ui.support.CopyColumnsSupport;
import org.eclipse.chemclipse.support.ui.swt.ExtendedTableViewer;
import org.eclipse.chemclipse.support.ui.swt.TableSupport;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class ClipboardSettingsDialog extends Dialog {

	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 600;

	private ExtendedTableViewer extendedTableViewer;
	private TableViewer columnTableViewer;
	private List<ColumnEntry> columnEntries = new ArrayList<>();

	private boolean copyHeader = true;
	private ValueDelimiter valueDelimiter = ValueDelimiter.TAB;
	private Set<Integer> columnSelections = new HashSet<>();

	private static class ColumnEntry {

		final String name;
		final String tooltip;
		final int index;
		boolean selected;
		boolean visible;
		int width;

		ColumnEntry(String name, String tooltip, int index, boolean selected, boolean visible, int width) {

			this.name = name;
			this.tooltip = tooltip;
			this.index = index;
			this.selected = selected;
			this.visible = visible;
			this.width = width;
		}
	}

	public ClipboardSettingsDialog(Shell shell) {

		super(shell);
	}

	public boolean isCopyHeader() {

		return copyHeader;
	}

	public ValueDelimiter getValueDelimiter() {

		return valueDelimiter;
	}

	public String getColumnsSelection() {

		/*
		 * If the viewer is null or all columns are selected
		 * then return null, which means print all columns.
		 */
		if(extendedTableViewer != null) {
			if(!columnSelections.isEmpty()) {
				int numberColumns = getNumberColumns();
				if(columnSelections.size() < numberColumns) {
					return CopyColumnsSupport.getColumns(columnSelections);
				}
			}
		}

		return PreferenceSupplier.DEF_CLIPBOARD_COPY_COLUMNS;
	}

	public void setExtendedTableViewer(ExtendedTableViewer extendedTableViewer) {

		this.extendedTableViewer = extendedTableViewer;
	}

	@Override
	protected void configureShell(Shell shell) {

		super.configureShell(shell);
		shell.setText(SupportMessages.clipboardSettings);
	}

	@Override
	protected Point getInitialSize() {

		return new Point(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	@Override
	protected boolean isResizable() {

		return true;
	}

	@Override
	protected Control createDialogArea(Composite parent) {

		Composite composite = (Composite)super.createDialogArea(parent);
		composite.setLayout(new GridLayout(1, true));

		if(extendedTableViewer != null) {
			initialize();
			createSettingsSection(composite);
		} else {
			createInfoSection(composite);
		}

		return composite;
	}

	private void initialize() {

		copyHeader = extendedTableViewer.isCopyHeaderToClipboard();
		valueDelimiter = extendedTableViewer.getCopyValueDelimiterClipboard();
	}

	private void createInfoSection(Composite parent) {

		createLabel(parent, SupportMessages.noClipboardSettingsAvailable);
	}

	private void createSettingsSection(Composite parent) {

		createToolbarMain(parent);
		createToolbarColumns(parent);
		createTableColumnsSection(parent);
	}

	private void createToolbarMain(Composite parent) {

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		composite.setLayout(new GridLayout(2, false));

		createButtonCheck(composite, SupportMessages.copyHeaderToClipboard, SupportMessages.copyHeaderToolTip, copyHeader, selection -> copyHeader = selection);
		createComboViewerDelimiter(composite);
	}

	private void createToolbarColumns(Composite parent) {

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		composite.setLayout(new GridLayout(2, true));

		createSectionExport(composite);
		createSectionVisible(composite);
	}

	private void createSectionExport(Composite parent) {

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		composite.setLayout(new GridLayout(3, false));

		Label exportLabel = new Label(composite, SWT.NONE);
		exportLabel.setText(SupportMessages.export);

		createButtonSelectAll(composite, SupportMessages.selectAll, () -> {
			for(ColumnEntry entry : columnEntries) {
				entry.selected = true;
				columnSelections.add(entry.index);
			}
			if(columnTableViewer != null) {
				columnTableViewer.refresh();
			}
		});

		createButtonDeselectAll(composite, SupportMessages.deselectAll, () -> {
			for(ColumnEntry entry : columnEntries) {
				entry.selected = false;
			}
			columnSelections.clear();
			if(columnTableViewer != null) {
				columnTableViewer.refresh();
			}
		});
	}

	private void createSectionVisible(Composite parent) {

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		composite.setLayout(new GridLayout(3, false));

		Label visibleLabel = new Label(composite, SWT.NONE);
		visibleLabel.setText(SupportMessages.visible);

		createButtonSelectAll(composite, SupportMessages.selectAll, () -> {
			for(ColumnEntry entry : columnEntries) {
				entry.visible = true;
			}
			applyColumnWidths();
			if(columnTableViewer != null) {
				columnTableViewer.refresh();
			}
		});

		createButtonDeselectAll(composite, SupportMessages.deselectAll, () -> {
			for(ColumnEntry entry : columnEntries) {
				entry.visible = false;
			}
			applyColumnWidths();
			if(columnTableViewer != null) {
				columnTableViewer.refresh();
			}
		});
	}

	private void createTableColumnsSection(Composite parent) {

		List<TableViewerColumn> tableViewerColumns = extendedTableViewer.getTableViewerColumns();
		int numberColumns = tableViewerColumns.size();

		columnEntries.clear();
		for(int i = 0; i < numberColumns; i++) {
			TableViewerColumn tableViewerColumn = tableViewerColumns.get(i);
			TableColumn tableColumn = tableViewerColumn.getColumn();
			boolean selected = isColumnSelected(i);
			if(selected) {
				columnSelections.add(i);
			}
			int columnWidth = tableColumn.getWidth();
			boolean visible = columnWidth > 0;
			int savedWidth = visible ? columnWidth : 100;
			columnEntries.add(new ColumnEntry(tableColumn.getText(), tableColumn.getToolTipText(), i, selected, visible, savedWidth));
		}

		columnTableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.H_SCROLL);
		Table table = columnTableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setLayoutData(new GridData(GridData.FILL_BOTH));

		TableViewerColumn columnName = new TableViewerColumn(columnTableViewer, SWT.NONE);
		columnName.getColumn().setText(SupportMessages.columns);
		columnName.getColumn().setWidth(200);
		columnName.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {

				if(element instanceof ColumnEntry entry) {
					return entry.name;
				}
				return "";
			}

			@Override
			public String getToolTipText(Object element) {

				if(element instanceof ColumnEntry entry) {
					return entry.tooltip;
				}
				return "";
			}
		});

		TableViewerColumn columnExport = new TableViewerColumn(columnTableViewer, SWT.CENTER);
		columnExport.getColumn().setText(SupportMessages.export);
		columnExport.getColumn().setWidth(80);
		columnExport.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {

				return "";
			}

			@Override
			public Image getImage(Object element) {

				if(element instanceof ColumnEntry entry) {
					String fileName = entry.selected ? IApplicationImage.IMAGE_SELECTED : IApplicationImage.IMAGE_DESELECTED;
					return ApplicationImageFactory.getInstance().getImage(fileName, IApplicationImageProvider.SIZE_16x16);
				}
				return null;
			}
		});
		columnExport.setEditingSupport(new EditingSupport(columnTableViewer) {

			@Override
			protected CellEditor getCellEditor(Object element) {

				return new CheckboxCellEditor(table);
			}

			@Override
			protected boolean canEdit(Object element) {

				return true;
			}

			@Override
			protected Object getValue(Object element) {

				if(element instanceof ColumnEntry entry) {
					return entry.selected;
				}
				return false;
			}

			@Override
			protected void setValue(Object element, Object value) {

				if(element instanceof ColumnEntry entry) {
					entry.selected = Boolean.TRUE.equals(value);
					if(entry.selected) {
						columnSelections.add(entry.index);
					} else {
						columnSelections.remove(entry.index);
					}
					columnTableViewer.refresh();
				}
			}
		});

		TableViewerColumn columnVisible = new TableViewerColumn(columnTableViewer, SWT.CENTER);
		columnVisible.getColumn().setText(SupportMessages.visible);
		columnVisible.getColumn().setWidth(80);
		columnVisible.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {

				return "";
			}

			@Override
			public Image getImage(Object element) {

				if(element instanceof ColumnEntry entry) {
					String fileName = entry.visible ? IApplicationImage.IMAGE_SELECTED : IApplicationImage.IMAGE_DESELECTED;
					return ApplicationImageFactory.getInstance().getImage(fileName, IApplicationImageProvider.SIZE_16x16);
				}
				return null;
			}
		});
		columnVisible.setEditingSupport(new EditingSupport(columnTableViewer) {

			@Override
			protected CellEditor getCellEditor(Object element) {

				return new CheckboxCellEditor(table);
			}

			@Override
			protected boolean canEdit(Object element) {

				return true;
			}

			@Override
			protected Object getValue(Object element) {

				if(element instanceof ColumnEntry entry) {
					return entry.visible;
				}
				return false;
			}

			@Override
			protected void setValue(Object element, Object value) {

				if(element instanceof ColumnEntry entry) {
					entry.visible = Boolean.TRUE.equals(value);
					applyColumnWidths();
					columnTableViewer.refresh();
				}
			}
		});

		columnTableViewer.setContentProvider(ArrayContentProvider.getInstance());
		columnTableViewer.setInput(columnEntries);
	}

	private void applyColumnWidths() {

		List<TableViewerColumn> viewerColumns = extendedTableViewer.getTableViewerColumns();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < columnEntries.size(); i++) {
			if(i > 0) {
				sb.append(" ");
			}
			ColumnEntry entry = columnEntries.get(i);
			sb.append(entry.visible ? entry.width : 0);
		}
		for(int i = columnEntries.size(); i < viewerColumns.size(); i++) {
			sb.append(" ");
			sb.append(viewerColumns.get(i).getColumn().getWidth());
		}
		TableSupport.setColumnWidth(extendedTableViewer.getTable(), sb.toString());
	}

	private boolean isColumnSelected(int i) {

		int[] copyColumnsToClipboard = CopyColumnsSupport.getColumns(extendedTableViewer.getCopyColumnsToClipboard());
		if(copyColumnsToClipboard != null) {
			for(int j : copyColumnsToClipboard) {
				if(j == i) {
					return true;
				}
			}
		} else {
			return true;
		}

		return false;
	}

	private Button createButtonCheck(Composite parent, String text, String tooltip, boolean selection, Consumer<Boolean> consumer) {

		Button button = new Button(parent, SWT.CHECK);
		button.setText(text);
		button.setToolTipText(tooltip);
		button.setSelection(selection);
		button.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		button.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				consumer.accept(button.getSelection());
			}
		});

		return button;
	}

	private Label createLabel(Composite parent, String text) {

		Label label = new Label(parent, SWT.NONE);
		label.setText(text);
		label.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		return label;
	}

	private Button createButtonSelectAll(Composite parent, String tooltip, Runnable action) {

		Button button = new Button(parent, SWT.PUSH);
		button.setToolTipText(tooltip);
		button.setImage(ApplicationImageFactory.getInstance().getImage(IApplicationImage.IMAGE_CHECK_ALL, IApplicationImageProvider.SIZE_16x16));

		button.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				action.run();
			}
		});

		return button;
	}

	private Button createButtonDeselectAll(Composite parent, String tooltip, Runnable action) {

		Button button = new Button(parent, SWT.PUSH);
		button.setToolTipText(tooltip);
		button.setImage(ApplicationImageFactory.getInstance().getImage(IApplicationImage.IMAGE_UNCHECK_ALL, IApplicationImageProvider.SIZE_16x16));

		button.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				action.run();
			}
		});

		return button;
	}

	private ComboViewer createComboViewerDelimiter(Composite parent) {

		ComboViewer comboViewer = new ComboViewer(parent, SWT.READ_ONLY);
		Combo combo = comboViewer.getCombo();
		comboViewer.setContentProvider(ArrayContentProvider.getInstance());
		comboViewer.setLabelProvider(new AbstractLabelProvider() {

			@Override
			public String getText(Object element) {

				if(element instanceof ValueDelimiter valueDelimiter) {
					return valueDelimiter.label();
				}
				return null;
			}
		});

		combo.setToolTipText(SupportMessages.valueDelimiterToolTip);
		combo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		combo.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				if(comboViewer.getStructuredSelection().getFirstElement() instanceof ValueDelimiter delimiter) {
					valueDelimiter = delimiter;
				}
			}
		});

		comboViewer.setInput(ValueDelimiter.values());
		comboViewer.setSelection(new StructuredSelection(valueDelimiter));

		return comboViewer;
	}

	private int getNumberColumns() {

		if(extendedTableViewer != null) {
			List<TableViewerColumn> tableViewerColumns = extendedTableViewer.getTableViewerColumns();
			return tableViewerColumns.size();
		}

		return -1;
	}
}