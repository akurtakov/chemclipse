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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import org.eclipse.chemclipse.model.statistics.ISample;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.LongFileExtractor;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IDataInputEntry;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.ISamplesPCA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.Samples;
import org.eclipse.chemclipse.xxd.process.supplier.pca.preferences.PreferenceSupplier;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
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
import org.eclipse.swt.widgets.Text;
import org.eclipse.swtchart.IAxis;
import org.eclipse.swtchart.IBarSeries;
import org.eclipse.swtchart.IBarSeries.BarWidthStyle;
import org.eclipse.swtchart.ISeries;
import org.eclipse.swtchart.Range;
import org.eclipse.swtchart.extensions.barcharts.BarChart;
import org.eclipse.swtchart.extensions.barcharts.BarSeriesData;
import org.eclipse.swtchart.extensions.barcharts.IBarSeriesData;
import org.eclipse.swtchart.extensions.barcharts.IBarSeriesSettings;
import org.eclipse.swtchart.extensions.core.BaseChart;
import org.eclipse.swtchart.extensions.core.IChartSettings;
import org.eclipse.swtchart.extensions.core.IPrimaryAxisSettings;
import org.eclipse.swtchart.extensions.core.ISeriesData;
import org.eclipse.swtchart.extensions.core.RangeRestriction;
import org.eclipse.swtchart.extensions.core.SeriesData;

public class FilesLongFormatFilterWizardPage extends AbstractAnalysisWizardPage {

	private BarChart chart;
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

	protected FilesLongFormatFilterWizardPage() {

		super("Name Filter");
		setTitle("Name Filter Entries");
		setDescription("Filter Entries");
	}

	@Override
	public void createControl(Composite parent) {

		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(2, false));

		createChartArea(container);
		createControlArea(container);

		setControl(container);
	}

	private void createChartArea(Composite parent) {

		chart = new BarChart(parent, SWT.NONE);
		GridData gd = new GridData(SWT.FILL, SWT.FILL, false, true);
		gd.widthHint = 500;
		gd.heightHint = 200;
		chart.setLayoutData(gd);

		IChartSettings chartSettings = chart.getChartSettings();
		chartSettings.clearHandledEventProcessors();
		chartSettings.setHorizontalSliderVisible(false);
		chartSettings.setVerticalSliderVisible(false);
		chartSettings.setOrientation(SWT.HORIZONTAL);
		chartSettings.setCreateMenu(false);
		chartSettings.setTitle("... Loading Data...");
		chartSettings.setTitleVisible(true);

		IPrimaryAxisSettings xAxisSettings = chartSettings.getPrimaryAxisSettingsX();
		xAxisSettings.setTitle("# of Analyte overlaps");

		IPrimaryAxisSettings yAxisSettings = chartSettings.getPrimaryAxisSettingsY();
		yAxisSettings.setTitle("Sample count");

		RangeRestriction rangeRestriction = chartSettings.getRangeRestriction();
		rangeRestriction.setZeroY(true);
		rangeRestriction.setForceZeroMinY(true);

		chart.applySettings(chartSettings);

		double[] xValues = new double[]{0, 1, 2, 3};
		double[] yValues = new double[]{0.0, 0.0, 0.0, 0.0};
		String[] xLabels = DoubleStream.of(xValues).mapToObj(d -> Integer.toString((int)d)).toArray(String[]::new);
		ISeriesData seriesData = new SeriesData(xValues, yValues, "Distribution");
		IBarSeriesData barSeriesData = new BarSeriesData(seriesData);

		IBarSeriesSettings barSeriesSettings = barSeriesData.getSettings();
		barSeriesSettings.setBarWidthStyle(BarWidthStyle.STRETCHED);

		IAxis xAxis = chart.getBaseChart().getAxisSet().getXAxis(0);
		xAxis.enableCategory(true);
		xAxis.setRange(new Range(0, yValues.length));
		xAxis.setCategorySeries(xLabels);

		ArrayList<IBarSeriesData> barSeriesDataList = new ArrayList<>();
		barSeriesDataList.add(barSeriesData);

		chart.addSeriesData(barSeriesDataList);

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
		createMatchCount(container);

	}

	private void createSampleSpinner(Composite parent) {

		/*
		 * Grouping Sample number Spinner
		 */
		sampleSpinnerGroup = new Group(parent, SWT.NONE);
		sampleSpinnerGroup.setText("# of Samples to use");
		sampleSpinnerGroup.setLayout(new GridLayout(1, false));
		sampleSpinnerGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		sampleSpinnerGroup.setVisible(false);
		((GridData)sampleSpinnerGroup.getLayoutData()).exclude = true;

		/*
		 * Number of Samples Spinner
		 */
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

			if(extractor != null && filterFile.size() != 0) {
				samples = extractor.filter(sampleSpinner.getSelection());
			}
			updateMatchCount();

		});

	}

	private void createInExClusionSelection(Composite parent) {

		/*
		 * Two Columns for in/exclusion selection
		 */
		Composite nameSelection = new Composite(parent, SWT.NONE);
		nameSelection.setLayout(new GridLayout(2, false));
		nameSelection.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		/*
		 * Grouping for in/exclusion
		 */
		Group includeGroup = new Group(nameSelection, SWT.NONE);
		includeGroup.setText("Include names");
		includeGroup.setLayout(new GridLayout(1, false));
		includeGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		/*
		 * Name Inclusion Selection
		 */
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

		/*
		 * Name Exclusion Selection
		 */
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
				if(extractor != null && filterFile.size() != 0) {
					samples = extractor.filter(sampleSpinner.getSelection());
				}
				updateMatchCount();
			}
		});

		includeRemoveBtn.addListener(SWT.Selection, e -> {
			int idx = includeList.getSelectionIndex();
			if(idx >= 0) {
				includeList.remove(idx);
				if(extractor != null && filterFile.size() != 0) {
					samples = extractor.filter(sampleSpinner.getSelection());
				}
				updateMatchCount();
			}
		});

		excludeAddBtn.addListener(SWT.Selection, e -> {
			String text = excludeText.getText().trim();
			if(!text.isEmpty()) {
				excludeList.add(text);
				excludeText.setText("");
				if(extractor != null && filterFile.size() != 0) {
					samples = extractor.filter(sampleSpinner.getSelection());
				}
				updateMatchCount();
			}
		});

		excludeRemoveBtn.addListener(SWT.Selection, e -> {
			int idx = excludeList.getSelectionIndex();
			if(idx >= 0) {
				excludeList.remove(idx);
				if(extractor != null && filterFile.size() != 0) {
					samples = extractor.filter(sampleSpinner.getSelection());
				}
				updateMatchCount();
			}
		});

	}

	private void createGroupSelection(Composite parent) {

		/*
		 * Group Selection
		 */
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
			if(extractor != null && filterFile.size() != 0) {
				samples = extractor.filter(sampleSpinner.getSelection());
			}
			updateMatchCount();
		});

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

	private void updateMatchCount() {

		samplesToRemove = new ArrayList<>();

		Samples allSamples = samples;

		int matched = 0;

		for(ISample sample : allSamples.getSamples()) {
			boolean includeOK = includeList.getItemCount() == 0;

			for(String rule : includeList.getItems()) {
				if(matches(sample.getSampleName(), rule)) {
					includeOK = true;
					break;
				}
				if(matches(sample.getSampleDetails(), rule)) {
					includeOK = true;
					break;
				}
			}

			boolean excludeHit = false;
			for(String rule : excludeList.getItems()) {
				if(matches(sample.getSampleName(), rule)) {
					excludeHit = true;
					break;
				}
				if(matches(sample.getSampleDetails(), rule)) {
					excludeHit = true;
					break;
				}
			}

			Object[] checked = groupViewer.getCheckedElements();
			Set<String> includedGroups = Arrays.stream(checked).map(String.class::cast).collect(Collectors.toSet());
			boolean groupIncluded = includedGroups.contains(sample.getDescription());

			if(includeOK && !excludeHit && groupIncluded) {
				matched++;
			} else {
				if(sample.getClassification() == "0") {
					samplesToRemove.add(sample);
				}

			}
		}
		int total = samples.getSamples().size();

		matchCountLabel.setText("Matches: " + matched + " of " + total + " samples");
		matchCountLabel.getParent().layout();
	}

	private boolean matches(String sample, String rule) {

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
			boolean needsReload = filesHaveChanged(); // || !dataAlreadyLoaded;

			if(filterFile.size() != 0) {
				chart.setVisible(true);
				GridData gd = (GridData)chart.getLayoutData();
				gd.exclude = false;
				sampleSpinnerGroup.setVisible(true);
				GridData gdGroup = (GridData)sampleSpinnerGroup.getLayoutData();
				gdGroup.exclude = false;

				if(needsReload) {
					extractor = new LongFileExtractor(mainFile, filterFile, 100);
					extractInitial = sampleSpinner.getSelection();
				}
				chart.getParent().layout(true, true);

				if(needsReload) {
					startLoadingData();
				}
			} else {
				chart.setVisible(false);

				if(needsReload) {
					extractor = new LongFileExtractor(mainFile, filterFile, 100);
				}
				GridData gd = (GridData)chart.getLayoutData();
				gd.exclude = true;

				sampleSpinnerGroup.setVisible(false);
				GridData gdGroup = (GridData)sampleSpinnerGroup.getLayoutData();
				gdGroup.exclude = true;
				chart.getParent().layout(true, true);

				if(needsReload) {
					startLoadingData();
				}
			}
		}
	}

	private void startLoadingData() {

		Job loadJob = new Job("Loading data") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {

				if(filterFile.size() != 0) {
					extractor.readData();
					samples = extractor.filter(extractInitial);
				} else {
					samples = extractor.extract();
				}

				Display.getDefault().asyncExec(() -> {
					if(chart.isDisposed()) {
						return;
					}
					if(filterFile.size() != 0) {
						updateChart(samples);
					}
					java.util.List<String> groups = samples.getSamples().stream().map(x -> x.getDescription()).distinct().toList();
					groupViewer.setInput(groups);
					groupViewer.setAllChecked(true);

					updateMatchCount();

				});

				return Status.OK_STATUS;
			}

		};

		loadJob.schedule();
	}

	private void updateChart(ISamplesPCA<?, ?> samples) {

		double fixedUpperChartRange = 2000.0;

		IChartSettings chartSettings = chart.getChartSettings();
		chartSettings.setTitle("");
		chart.applySettings(chartSettings);

		double[] yValues = new double[samples.getAnalysisSettings().getFilterDistribution().values().size()];
		int index = samples.getAnalysisSettings().getFilterDistribution().values().size() - 1;
		for(Map.Entry<Integer, Integer> entry : samples.getAnalysisSettings().getFilterDistribution().entrySet()) {
			yValues[index--] = (entry.getValue() > fixedUpperChartRange) ? fixedUpperChartRange : entry.getValue();
		}

		Set<Integer> keys = samples.getAnalysisSettings().getFilterDistribution().reversed().keySet();
		String[] xLabels = keys.stream().map(Object::toString).toArray(String[]::new);

		double[] xValues = keys.stream().mapToDouble(Integer::doubleValue).toArray();

		BaseChart baseChart = chart.getBaseChart();
		ISeries<?> series = baseChart.getSeriesSet().getSeries("Distribution");
		if(series instanceof IBarSeries) {

			IBarSeries<?> barSeries = (IBarSeries<?>)series;

			barSeries.setXSeries(xValues);
			barSeries.setYSeries(yValues);

			IAxis xAxis = baseChart.getAxisSet().getXAxis(0);
			xAxis.enableCategory(true);
			xAxis.setRange(new Range(0, yValues.length));
			xAxis.setCategorySeries(xLabels);

			IAxis yAxis = baseChart.getAxisSet().getYAxis(0);
			yAxis.setRange(new Range(0, fixedUpperChartRange));

			baseChart.redraw();

		}

	}

}
