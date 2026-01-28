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
 * Lorenz Gerber - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.ui.chart2d;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.model.statistics.ISample;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.EvaluationPCA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IResultMVA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IResultsMVA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.ui.support.ScoreRow;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class ScoreTable extends Composite {

	private TableViewer tableViewer;
	private EvaluationPCA evaluationPCA;
	private int numberOfComponents = 0;
	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.0000");

	public ScoreTable(Composite parent, int style) {

		super(parent, style);
		setLayout(new GridLayout(1, true));
		createTable();
	}

	public void setInput(EvaluationPCA evaluationPCA) {

		this.evaluationPCA = evaluationPCA;
		updateTable();
	}

	public TableViewer getTableViewer() {

		return tableViewer;
	}

	private void createTable() {

		tableViewer = new TableViewer(this, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		Table table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setLayoutData(new GridData(GridData.FILL_BOTH));
		tableViewer.setContentProvider(new ArrayContentProvider());
	}

	private void updateTable() {

		// Clear existing columns
		Table table = tableViewer.getTable();
		while(table.getColumnCount() > 0) {
			table.getColumn(0).dispose();
		}

		if(evaluationPCA == null) {
			tableViewer.setInput(null);
			return;
		}

		IResultsMVA results = evaluationPCA.getResults();
		if(results == null) {
			tableViewer.setInput(null);
			return;
		}

		numberOfComponents = results.getExplainedVariances().length;

		createSampleNameColumn();
		createGroupNameColumn();
		createClassificationColumn();
		createDescriptionColumn();

		for(int i = 0; i < numberOfComponents; i++) {
			createPCColumn(i);
		}

		List<ScoreRow> rows = createScoreRows();
		tableViewer.setInput(rows);

		for(int i = 0; i < table.getColumnCount(); i++) {
			table.getColumn(i).pack();
		}

		tableViewer.refresh();
		layout(true, true);
	}

	private void createSampleNameColumn() {

		TableViewerColumn viewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn column = viewerColumn.getColumn();
		column.setText("Sample Name");
		column.setWidth(200);
		column.setResizable(true);
		column.setMoveable(false);

		viewerColumn.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {

				if(element instanceof ScoreRow) {
					return ((ScoreRow)element).getSampleName();
				}
				return "";
			}
		});

		// Make sortable (alphabetically)
		column.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				tableViewer.setComparator(new ViewerComparator() {

					@Override
					public int compare(org.eclipse.jface.viewers.Viewer viewer, Object e1, Object e2) {

						ScoreRow r1 = (ScoreRow)e1;
						ScoreRow r2 = (ScoreRow)e2;
						int direction = getSortDirection(column);
						return direction * r1.getSampleName().compareTo(r2.getSampleName());
					}
				});
				updateSortDirection(column);
			}
		});
	}

	private void createGroupNameColumn() {

		TableViewerColumn viewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn column = viewerColumn.getColumn();
		column.setText("Group Name");
		column.setWidth(150);
		column.setResizable(true);
		column.setMoveable(true);

		viewerColumn.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {

				if(element instanceof ScoreRow) {
					String groupName = ((ScoreRow)element).getGroupName();
					return groupName != null ? groupName : "";
				}
				return "";
			}
		});

		column.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				tableViewer.setComparator(new ViewerComparator() {

					@Override
					public int compare(org.eclipse.jface.viewers.Viewer viewer, Object e1, Object e2) {

						ScoreRow r1 = (ScoreRow)e1;
						ScoreRow r2 = (ScoreRow)e2;
						String g1 = r1.getGroupName() != null ? r1.getGroupName() : "";
						String g2 = r2.getGroupName() != null ? r2.getGroupName() : "";
						int direction = getSortDirection(column);
						return direction * g1.compareTo(g2);
					}
				});
				updateSortDirection(column);
			}
		});
	}

	private void createClassificationColumn() {

		TableViewerColumn viewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn column = viewerColumn.getColumn();
		column.setText("Classification");
		column.setWidth(120);
		column.setResizable(true);
		column.setMoveable(true);

		viewerColumn.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {

				if(element instanceof ScoreRow) {
					String classification = ((ScoreRow)element).getClassification();
					return classification != null ? classification : "";
				}
				return "";
			}
		});

		column.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				tableViewer.setComparator(new ViewerComparator() {

					@Override
					public int compare(org.eclipse.jface.viewers.Viewer viewer, Object e1, Object e2) {

						ScoreRow r1 = (ScoreRow)e1;
						ScoreRow r2 = (ScoreRow)e2;
						String c1 = r1.getClassification() != null ? r1.getClassification() : "";
						String c2 = r2.getClassification() != null ? r2.getClassification() : "";
						int direction = getSortDirection(column);
						return direction * c1.compareTo(c2);
					}
				});
				updateSortDirection(column);
			}
		});
	}

	private void createDescriptionColumn() {

		TableViewerColumn viewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn column = viewerColumn.getColumn();
		column.setText("Description");
		column.setWidth(200);
		column.setResizable(true);
		column.setMoveable(true);

		viewerColumn.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {

				if(element instanceof ScoreRow) {
					String description = ((ScoreRow)element).getDescription();
					return description != null ? description : "";
				}
				return "";
			}
		});

		column.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				tableViewer.setComparator(new ViewerComparator() {

					@Override
					public int compare(org.eclipse.jface.viewers.Viewer viewer, Object e1, Object e2) {

						ScoreRow r1 = (ScoreRow)e1;
						ScoreRow r2 = (ScoreRow)e2;
						String d1 = r1.getDescription() != null ? r1.getDescription() : "";
						String d2 = r2.getDescription() != null ? r2.getDescription() : "";
						int direction = getSortDirection(column);
						return direction * d1.compareTo(d2);
					}
				});
				updateSortDirection(column);
			}
		});
	}

	private void createPCColumn(final int pcIndex) {

		TableViewerColumn viewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn column = viewerColumn.getColumn();

		double explainedVariance = 0.0;
		if(evaluationPCA != null && evaluationPCA.getResults() != null) {
			double[] variances = evaluationPCA.getResults().getExplainedVariances();
			if(pcIndex < variances.length) {
				explainedVariance = variances[pcIndex] * 100;
			}
		}

		column.setText(String.format("PC%d (%.1f%%)", pcIndex + 1, explainedVariance));
		column.setWidth(120);
		column.setResizable(true);
		column.setMoveable(true);

		viewerColumn.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {

				if(element instanceof ScoreRow) {
					double[] scores = ((ScoreRow)element).getScores();
					if(pcIndex < scores.length) {
						return DECIMAL_FORMAT.format(scores[pcIndex]);
					}
				}
				return "";
			}
		});

		// Make sortable numerically
		column.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				tableViewer.setComparator(new ViewerComparator() {

					@Override
					public int compare(org.eclipse.jface.viewers.Viewer viewer, Object e1, Object e2) {

						ScoreRow r1 = (ScoreRow)e1;
						ScoreRow r2 = (ScoreRow)e2;
						double[] scores1 = r1.getScores();
						double[] scores2 = r2.getScores();

						if(pcIndex >= scores1.length || pcIndex >= scores2.length) {
							return 0;
						}

						int direction = getSortDirection(column);
						return direction * Double.compare(scores1[pcIndex], scores2[pcIndex]);
					}
				});
				updateSortDirection(column);
			}
		});
	}

	private List<ScoreRow> createScoreRows() {

		List<ScoreRow> rows = new ArrayList<>();

		if(evaluationPCA == null) {
			return rows;
		}

		IResultsMVA results = evaluationPCA.getResults();
		if(results == null) {
			return rows;
		}

		List<IResultMVA> resultList = results.getPcaResultList();
		for(IResultMVA result : resultList) {
			ISample sample = result.getSample();
			String sampleName = sample.getSampleName();
			String groupName = sample.getGroupName();
			String classification = sample.getClassification();
			String description = sample.getDescription();
			double[] scoreVector = result.getScoreVector();
			rows.add(new ScoreRow(sampleName, groupName, classification, description, scoreVector));
		}

		return rows;
	}

	private int getSortDirection(TableColumn column) {

		Table table = tableViewer.getTable();
		if(column == table.getSortColumn()) {
			return table.getSortDirection() == SWT.UP ? -1 : 1;
		}
		return 1;
	}

	private void updateSortDirection(TableColumn column) {

		Table table = tableViewer.getTable();
		if(column == table.getSortColumn()) {
			int direction = table.getSortDirection() == SWT.UP ? SWT.DOWN : SWT.UP;
			table.setSortDirection(direction);
		} else {
			table.setSortColumn(column);
			table.setSortDirection(SWT.UP);
		}
		tableViewer.refresh();
	}
}