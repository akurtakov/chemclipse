/*******************************************************************************
 * Copyright (c) 2025, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.process.supplier.pca.ui.internal.wizards;

import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.chemclipse.model.statistics.ISample;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.LongFileExtractor;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IDataInputEntry;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.Samples;
import org.eclipse.chemclipse.xxd.process.supplier.pca.preferences.PreferenceSupplier;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

public class FilesLongFormatFilterWizardPage extends AbstractAnalysisWizardPage {

	private static final DecimalFormat COSINE_FORMAT = new DecimalFormat("0.000000");

	private static class RankedSampleRow {

		private final int rank;
		private final String sampleName;
		private final String sampleDetails;
		private final double cosineSimilarity;

		public RankedSampleRow(int rank, String sampleName, String sampleDetails, double cosineSimilarity) {

			this.rank = rank;
			this.sampleName = sampleName;
			this.sampleDetails = sampleDetails;
			this.cosineSimilarity = cosineSimilarity;
		}

		public int getRank() {

			return rank;
		}

		public String getSampleName() {

			return sampleName;
		}

		public String getSampleDetails() {

			return sampleDetails;
		}

		public double getCosineSimilarity() {

			return cosineSimilarity;
		}
	}

	private TableViewer rankingTableViewer;
	private Samples samples;
	private Spinner sampleSpinner;
	private Group sampleSpinnerGroup;
	private List includeList;
	private List excludeList;
	private CheckboxTableViewer groupViewer;
	private Label matchCountLabel;
	private LongFileExtractor extractor;
	private int extractInitial;
	private java.util.List<IDataInputEntry> mainFile;
	private java.util.List<IDataInputEntry> filterFile;
	private java.util.List<ISample> samplesToRemove;

	private String previousMainFilePath = null;
	private String previousFilterFilePath = null;

	private Button chkCountPunish;
	private Text txtCountExponent;
	private Button chkSumPunish;
	private Text txtSumExponent;
	private Button applyButton;

	protected FilesLongFormatFilterWizardPage() {

		super("Name Filter");
		setTitle("Name Filter Entries");
		setDescription("Filter Entries");
	}

	@Override
	public void createControl(Composite parent) {

		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(2, false));

		createRankingTableArea(container);
		createControlArea(container);

		setControl(container);
	}

	private void createRankingTableArea(Composite parent) {

		rankingTableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.H_SCROLL);
		Table table = rankingTableViewer.getTable();
		GridData gd = new GridData(SWT.FILL, SWT.FILL, false, true);
		gd.widthHint = 700;
		gd.heightHint = 300;
		table.setLayoutData(gd);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		rankingTableViewer.setContentProvider(ArrayContentProvider.getInstance());

		TableViewerColumn rankColumn = new TableViewerColumn(rankingTableViewer, SWT.NONE);
		rankColumn.getColumn().setText("Rank");
		rankColumn.getColumn().setWidth(70);
		rankColumn.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {

				if(element instanceof RankedSampleRow row) {
					return Integer.toString(row.getRank());
				}
				return "";
			}
		});

		TableViewerColumn sampleColumn = new TableViewerColumn(rankingTableViewer, SWT.NONE);
		sampleColumn.getColumn().setText("Sample");
		sampleColumn.getColumn().setWidth(220);
		sampleColumn.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {

				if(element instanceof RankedSampleRow row) {
					return row.getSampleName();
				}
				return "";
			}
		});

		TableViewerColumn detailsColumn = new TableViewerColumn(rankingTableViewer, SWT.NONE);
		detailsColumn.getColumn().setText("Sample Detail");
		detailsColumn.getColumn().setWidth(280);
		detailsColumn.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {

				if(element instanceof RankedSampleRow row) {
					return row.getSampleDetails() != null ? row.getSampleDetails() : "";
				}
				return "";
			}
		});

		TableViewerColumn similarityColumn = new TableViewerColumn(rankingTableViewer, SWT.NONE);
		similarityColumn.getColumn().setText("Cosine Similarity");
		similarityColumn.getColumn().setWidth(140);
		similarityColumn.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {

				if(element instanceof RankedSampleRow row) {
					return COSINE_FORMAT.format(row.getCosineSimilarity());
				}
				return "";
			}
		});
	}

	private void createControlArea(Composite parent) {

		Composite container = new Composite(parent, SWT.NONE);
		GridLayout controlsLayout = new GridLayout(1, false);
		container.setLayout(controlsLayout);

		GridData controlsData = new GridData(SWT.FILL, SWT.FILL, true, true);
		container.setLayoutData(controlsData);

		createSampleSpinner(container);
		createInExClusionSelection(container);
		createGroupSelection(container);
		createPunishmentControls(container);
		createApplyButton(container);
		createMatchCount(container);
	}

	private void createSampleSpinner(Composite parent) {

		sampleSpinnerGroup = new Group(parent, SWT.NONE);
		sampleSpinnerGroup.setText("# of Samples to use");
		sampleSpinnerGroup.setLayout(new GridLayout(1, false));
		sampleSpinnerGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		sampleSpinnerGroup.setVisible(false);
		((GridData)sampleSpinnerGroup.getLayoutData()).exclude = true;

		sampleSpinner = new Spinner(sampleSpinnerGroup, SWT.BORDER);
		sampleSpinner.setToolTipText("Number of Samples to Filter");
		sampleSpinner.setMinimum(PreferenceSupplier.MIN_NUMBER_OF_SAMPLES_TO_FILTER);
		sampleSpinner.setIncrement(1);
		sampleSpinner.setSelection(PreferenceSupplier.DEF_NUMBER_OF_SAMPLES_TO_FILTER);
		sampleSpinner.setMaximum(PreferenceSupplier.MAX_NUMBER_OF_SAMPLES_TO_FILTER);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = 2;
		sampleSpinner.setLayoutData(gridData);

		sampleSpinner.addListener(SWT.Selection, e -> {

			if(extractor != null && filterFile != null && !filterFile.isEmpty()) {
				samples = extractor.filter(sampleSpinner.getSelection());
				updateRankingTable();
			}
			updateMatchCount();
		});
	}

	private void createInExClusionSelection(Composite parent) {

		Composite nameSelection = new Composite(parent, SWT.NONE);
		nameSelection.setLayout(new GridLayout(2, false));
		nameSelection.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		Group includeGroup = new Group(nameSelection, SWT.NONE);
		includeGroup.setText("Include names");
		includeGroup.setLayout(new GridLayout(1, false));
		includeGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		Composite includeInputArea = new Composite(includeGroup, SWT.NONE);
		includeInputArea.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		includeInputArea.setLayout(new GridLayout(2, false));

		Text includeText = new Text(includeInputArea, SWT.BORDER);
		includeText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Button includeAddBtn = new Button(includeInputArea, SWT.PUSH);
		includeAddBtn.setText("Add");

		includeList = new List(includeGroup, SWT.BORDER | SWT.V_SCROLL);
		GridData includeGD = new GridData(SWT.FILL, SWT.FILL, true, false);
		includeGD.heightHint = 70;
		includeList.setLayoutData(includeGD);

		Button includeRemoveBtn = new Button(includeGroup, SWT.PUSH);
		includeRemoveBtn.setText("Remove selected");

		Group excludeGroup = new Group(nameSelection, SWT.NONE);
		excludeGroup.setText("Exclude names");
		excludeGroup.setLayout(new GridLayout(1, false));
		excludeGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		Composite excludeInputArea = new Composite(excludeGroup, SWT.NONE);
		excludeInputArea.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		excludeInputArea.setLayout(new GridLayout(2, false));

		Text excludeText = new Text(excludeInputArea, SWT.BORDER);
		excludeText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Button excludeAddBtn = new Button(excludeInputArea, SWT.PUSH);
		excludeAddBtn.setText("Add");

		excludeList = new List(excludeGroup, SWT.BORDER | SWT.V_SCROLL);
		GridData excludeGD = new GridData(SWT.FILL, SWT.FILL, true, false);
		excludeGD.heightHint = 70;
		excludeList.setLayoutData(excludeGD);

		Button excludeRemoveBtn = new Button(excludeGroup, SWT.PUSH);
		excludeRemoveBtn.setText("Remove selected");

		includeAddBtn.addListener(SWT.Selection, e -> {
			String text = includeText.getText().trim();
			if(!text.isEmpty()) {
				includeList.add(text);
				includeText.setText("");
				if(extractor != null && filterFile != null && !filterFile.isEmpty()) {
					samples = extractor.filter(sampleSpinner.getSelection());
					updateRankingTable();
				}
				updateMatchCount();
			}
		});

		includeRemoveBtn.addListener(SWT.Selection, e -> {
			int idx = includeList.getSelectionIndex();
			if(idx >= 0) {
				includeList.remove(idx);
				if(extractor != null && filterFile != null && !filterFile.isEmpty()) {
					samples = extractor.filter(sampleSpinner.getSelection());
					updateRankingTable();
				}
				updateMatchCount();
			}
		});

		excludeAddBtn.addListener(SWT.Selection, e -> {
			String text = excludeText.getText().trim();
			if(!text.isEmpty()) {
				excludeList.add(text);
				excludeText.setText("");
				if(extractor != null && filterFile != null && !filterFile.isEmpty()) {
					samples = extractor.filter(sampleSpinner.getSelection());
					updateRankingTable();
				}
				updateMatchCount();
			}
		});

		excludeRemoveBtn.addListener(SWT.Selection, e -> {
			int idx = excludeList.getSelectionIndex();
			if(idx >= 0) {
				excludeList.remove(idx);
				if(extractor != null && filterFile != null && !filterFile.isEmpty()) {
					samples = extractor.filter(sampleSpinner.getSelection());
					updateRankingTable();
				}
				updateMatchCount();
			}
		});
	}

	private void createGroupSelection(Composite parent) {

		Label groupLabel = new Label(parent, SWT.NONE);
		groupLabel.setText("Groups to include:");

		groupViewer = CheckboxTableViewer.newCheckList(parent, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);

		GridData groupGD = new GridData(SWT.FILL, SWT.FILL, true, false);
		groupGD.heightHint = 60;
		groupViewer.getTable().setLayoutData(groupGD);

		groupViewer.setContentProvider(ArrayContentProvider.getInstance());

		String[] groups = new String[]{};
		groupViewer.setInput(groups);

		groupViewer.setAllChecked(true);

		groupViewer.addCheckStateListener(e -> {
			if(extractor != null && filterFile != null && !filterFile.isEmpty()) {
				samples = extractor.filter(sampleSpinner.getSelection());
				updateRankingTable();
			}
			updateMatchCount();
		});
	}

	private void createPunishmentControls(Composite parent) {

		Group punishGroup = new Group(parent, SWT.NONE);
		punishGroup.setText("Similarity Punishments");
		punishGroup.setLayout(new GridLayout(3, false));
		punishGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));

		chkCountPunish = new Button(punishGroup, SWT.CHECK);
		chkCountPunish.setText("Enable count-based punishment (Matching Count Features / total Count Features)");
		GridData chkGd = new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1);
		chkCountPunish.setLayoutData(chkGd);
		chkCountPunish.setSelection(false);

		Label lblCountExp = new Label(punishGroup, SWT.NONE);
		lblCountExp.setText("Count exponent (0.0 - 10.0):");
		txtCountExponent = new Text(punishGroup, SWT.BORDER);
		txtCountExponent.setText("1.0");
		txtCountExponent.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		new Label(punishGroup, SWT.NONE);

		chkSumPunish = new Button(punishGroup, SWT.CHECK);
		chkSumPunish.setText("Enable sum-based punishment (sum Matching Features / sum Total Features)");
		GridData chkGd2 = new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1);
		chkSumPunish.setLayoutData(chkGd2);
		chkSumPunish.setSelection(false);

		Label lblSumExp = new Label(punishGroup, SWT.NONE);
		lblSumExp.setText("Sum exponent (0.0 - 10.0):");
		txtSumExponent = new Text(punishGroup, SWT.BORDER);
		txtSumExponent.setText("1.0");
		txtSumExponent.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		new Label(punishGroup, SWT.NONE);

	}

	/**
	 * Create the Apply button (user triggers recalculation) and place it above the match count label.
	 */
	private void createApplyButton(Composite parent) {

		Composite applyArea = new Composite(parent, SWT.NONE);
		applyArea.setLayout(new GridLayout(2, false));
		applyArea.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		applyButton = new Button(applyArea, SWT.PUSH);
		applyButton.setText("Apply");
		applyButton.setToolTipText("Apply changes to punishment factors and (re)load the data.");
		applyButton.addListener(SWT.Selection, e -> {
			applyPunishmentSettingsToExtractor();
			if(extractor == null) {
				extractor = new LongFileExtractor(mainFile, filterFile, 100);
			}
			startLoadingData(true);
		});

		// filler label to align layout
		new Label(applyArea, SWT.NONE);
	}

	/**
	 * Read values from the UI, sanitize and apply to the extractor.
	 */
	private void applyPunishmentSettingsToExtractor() {

		if(extractor == null)
			return;
		
		boolean useCount = chkCountPunish != null && !chkCountPunish.isDisposed() && chkCountPunish.getSelection();
		double countExp = parseExponent(txtCountExponent.getText(), 1.0);
		extractor.setUseCountPunishment(useCount);
		extractor.setCountExponent(countExp);

		boolean useSum = chkSumPunish != null && !chkSumPunish.isDisposed() && chkSumPunish.getSelection();
		double sumExp = parseExponent(txtSumExponent.getText(), 1.0);
		extractor.setUseSumPunishment(useSum);
		extractor.setSumExponent(sumExp);
	}

	private double parseExponent(String text, double def) {

		if(text == null)
			return def;
		try {
			double v = Double.parseDouble(text.trim());
			if(Double.isNaN(v) || Double.isInfinite(v))
				return def;
			if(v < 0.0)
				v = 0.0;
			if(v > 10.0)
				v = 10.0;
			return v;
		} catch(NumberFormatException ex) {
			return def;
		}
	}

	private void createMatchCount(Composite parent) {

		matchCountLabel = new Label(parent, SWT.NONE);
		matchCountLabel.setText("Matches: 0 of 0 samples");
	}

	public void setMainFile(java.util.List<IDataInputEntry> mainFile) {

		this.mainFile = mainFile;
	}

	public void setFilterFile(java.util.List<IDataInputEntry> filterFile) {

		this.filterFile = filterFile;
	}

	public Samples getFilteredSamples() {

		if(samples != null) {
			samples.getSamples().removeAll(samplesToRemove);
		}
		return samples;
	}

	private boolean matchesCurrentFilters(ISample sample) {

		if(sample == null) {
			return false;
		}

		boolean includeOK = includeList.getItemCount() == 0;
		for(String rule : includeList.getItems()) {
			if(matches(sample.getSampleName(), rule) || matches(sample.getSampleDetails(), rule)) {
				includeOK = true;
				break;
			}
		}

		boolean excludeHit = false;
		for(String rule : excludeList.getItems()) {
			if(matches(sample.getSampleName(), rule) || matches(sample.getSampleDetails(), rule)) {
				excludeHit = true;
				break;
			}
		}

		Object[] checked = groupViewer.getCheckedElements();
		Set<String> includedGroups = Arrays.stream(checked).map(String.class::cast).collect(Collectors.toSet());
		boolean groupIncluded = includedGroups.contains(sample.getDescription());

		return includeOK && !excludeHit && groupIncluded;
	}

	private ISample findSampleByName(String sampleName) {

		if(sampleName == null || samples == null || samples.getSamples() == null) {
			return null;
		}

		for(ISample sample : samples.getSamples()) {
			if(sampleName.equals(sample.getSampleName())) {
				return sample;
			}
		}
		return null;
	}

	private void updateMatchCount() {

		samplesToRemove = new ArrayList<>();

		Samples allSamples = samples;
		if(allSamples == null) {
			matchCountLabel.setText("Matches: 0 of 0 samples");
			matchCountLabel.getParent().layout();
			return;
		}

		int matched = 0;

		for(ISample sample : allSamples.getSamples()) {
			if(matchesCurrentFilters(sample)) {
				matched++;
			} else {
				if("0".equals(sample.getClassification())) {
					samplesToRemove.add(sample);
				}
			}
		}
		int total = samples.getSamples().size();

		matchCountLabel.setText("Matches: " + matched + " of " + total + " samples");
		matchCountLabel.getParent().layout();
	}

	private boolean matches(String sample, String rule) {

		if(sample == null || rule == null) {
			return false;
		}
		return sample.toLowerCase().contains(rule.toLowerCase());
	}

	private boolean filesHaveChanged() {

		String currentMainPath = getFilePath(mainFile);
		String currentFilterPath = getFilePath(filterFile);

		boolean changed = !Objects.equals(previousMainFilePath, currentMainPath) || !Objects.equals(previousFilterFilePath, currentFilterPath);

		if(changed) {
			previousMainFilePath = currentMainPath;
			previousFilterFilePath = currentFilterPath;
		}

		return changed;
	}

	private String getFilePath(java.util.List<IDataInputEntry> fileList) {

		if(fileList == null || fileList.isEmpty()) {
			return null;
		}
		return fileList.get(0).getInputFile();
	}

	@Override
	public void setVisible(boolean visible) {

		super.setVisible(visible);
		if(visible) {
			boolean needsReload = filesHaveChanged();

			if(filterFile != null && !filterFile.isEmpty()) {
				rankingTableViewer.getTable().setVisible(true);
				GridData gd = (GridData)rankingTableViewer.getTable().getLayoutData();
				gd.exclude = false;
				sampleSpinnerGroup.setVisible(true);
				GridData gdGroup = (GridData)sampleSpinnerGroup.getLayoutData();
				gdGroup.exclude = false;

				if(needsReload) {
					extractor = new LongFileExtractor(mainFile, filterFile, 100);
					startLoadingData(true);
					extractInitial = sampleSpinner.getSelection();
				}
				rankingTableViewer.getTable().getParent().layout(true, true);

			} else {
				rankingTableViewer.getTable().setVisible(false);

				if(needsReload) {
					extractor = new LongFileExtractor(mainFile, filterFile, 100);
					startLoadingData(true);
				}
				GridData gd = (GridData)rankingTableViewer.getTable().getLayoutData();
				gd.exclude = true;

				sampleSpinnerGroup.setVisible(false);
				GridData gdGroup = (GridData)sampleSpinnerGroup.getLayoutData();
				gdGroup.exclude = true;
				rankingTableViewer.getTable().getParent().layout(true, true);
			}
		}
	}

	/**
	 * Start loading data. If modal==true a modal progress dialog is shown and controls are disabled
	 * until the load finishes. If modal==false a background Job is used but controls still disabled
	 * until the background work completes.
	 */
	private void startLoadingData(boolean modal) {

		if(extractor == null)
			return;

		setControlsEnabled(false);

		final Samples[] loaded = new Samples[1];

		IRunnableWithProgress runnable = monitor -> {
			monitor.beginTask("Loading PCA long-format data...", IProgressMonitor.UNKNOWN);
			try {
				// ensure extractor has latest settings from UI in case Apply was pressed earlier
				Display.getDefault().syncExec(() -> applyPunishmentSettingsToExtractor());

				extractor.readData();

				if(filterFile != null && !filterFile.isEmpty()) {
					loaded[0] = extractor.filter(extractInitial);
				} else {
					loaded[0] = extractor.extract();
				}
			} finally {
				monitor.done();
			}
		};

		if(modal) {
			ProgressMonitorDialog dialog = new ProgressMonitorDialog(getShell());
			try {
				dialog.run(true, true, runnable);
			} catch(InvocationTargetException e) {
			} catch(InterruptedException e) {
			}
			final Samples result = loaded[0];
			Display.getDefault().asyncExec(() -> {
				if(result != null) {
					samples = result;
					java.util.List<String> groups = samples.getSamples().stream().map(x -> x.getDescription()).distinct().toList();
					groupViewer.setInput(groups);
					groupViewer.setAllChecked(true);

					if(filterFile != null && !filterFile.isEmpty()) {
						updateRankingTable();
					}
					updateMatchCount();
				}
				setControlsEnabled(true);
			});
		} else {
			Job loadJob = new Job("Loading data") {

				@Override
				protected IStatus run(IProgressMonitor monitor) {

					try {
						runnable.run(monitor);
					} catch(Exception e) {
					}
					return Status.OK_STATUS;
				}
			};

			loadJob.addJobChangeListener(new JobChangeAdapter() {

				@Override
				public void done(IJobChangeEvent event) {

					Display.getDefault().asyncExec(() -> {
						Samples res = loaded[0];
						if(res != null) {
							samples = res;
							java.util.List<String> groups = samples.getSamples().stream().map(x -> x.getDescription()).distinct().toList();
							groupViewer.setInput(groups);
							groupViewer.setAllChecked(true);

							if(filterFile != null && !filterFile.isEmpty()) {
								updateRankingTable();
							}
							updateMatchCount();
						}
						setControlsEnabled(true);
					});
				}
			});

			loadJob.schedule();
		}
	}

	private void updateRankingTable() {

		if(extractor == null || rankingTableViewer == null || rankingTableViewer.getTable().isDisposed()) {
			return;
		}

		java.util.List<Map.Entry<String, Double>> rankedSamples = extractor.getRankedSamples();
		java.util.List<RankedSampleRow> rows = new ArrayList<>();

		int limit = rankedSamples.size();
		if(sampleSpinner != null && !sampleSpinner.isDisposed()) {
			int selected = sampleSpinner.getSelection();
			if(selected > 0) {
				limit = Math.min(limit, selected);
			}
		}

		int rank = 1;
		for(Map.Entry<String, Double> entry : rankedSamples) {
			ISample sample = findSampleByName(entry.getKey());
			if(matchesCurrentFilters(sample)) {
				String sampleDetails = sample != null ? sample.getSampleDetails() : "";
				rows.add(new RankedSampleRow(rank++, entry.getKey(), sampleDetails, entry.getValue()));
				if(rows.size() >= limit) {
					break;
				}
			}
		}

		rankingTableViewer.setInput(rows);

		for(org.eclipse.swt.widgets.TableColumn column : rankingTableViewer.getTable().getColumns()) {
			column.pack();
		}
	}

	/**
	 * Enable/disable interactive controls while loading to prevent concurrent edits.
	 */
	private void setControlsEnabled(boolean enabled) {

		if(includeList != null && !includeList.isDisposed())
			includeList.setEnabled(enabled);
		if(excludeList != null && !excludeList.isDisposed())
			excludeList.setEnabled(enabled);
		if(groupViewer != null && !groupViewer.getTable().isDisposed())
			groupViewer.getTable().setEnabled(enabled);
		if(sampleSpinner != null && !sampleSpinner.isDisposed())
			sampleSpinner.setEnabled(enabled);

		if(chkCountPunish != null && !chkCountPunish.isDisposed())
			chkCountPunish.setEnabled(enabled);
		if(txtCountExponent != null && !txtCountExponent.isDisposed())
			txtCountExponent.setEnabled(enabled);
		if(chkSumPunish != null && !chkSumPunish.isDisposed())
			chkSumPunish.setEnabled(enabled);
		if(txtSumExponent != null && !txtSumExponent.isDisposed())
			txtSumExponent.setEnabled(enabled);

		if(applyButton != null && !applyButton.isDisposed())
			applyButton.setEnabled(enabled);

		if(rankingTableViewer != null && !rankingTableViewer.getTable().isDisposed())
			rankingTableViewer.getTable().setEnabled(enabled);
	}
}
