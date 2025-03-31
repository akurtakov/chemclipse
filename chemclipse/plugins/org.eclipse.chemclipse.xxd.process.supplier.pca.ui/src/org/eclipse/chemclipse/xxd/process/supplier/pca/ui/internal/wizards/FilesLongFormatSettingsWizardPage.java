/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Lorenz Gerber - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.ui.internal.wizards;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.rcp.ui.icons.core.ApplicationImageFactory;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImage;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImageProvider;
import org.eclipse.chemclipse.support.ui.provider.AbstractLabelProvider;
import org.eclipse.chemclipse.support.ui.swt.EnhancedComboViewer;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.PcaExtractionFileLongText;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.Algorithm;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.DataInputEntry;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IDataInputEntry;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.ISamplesPCA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.preferences.PreferenceSupplier;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

public class FilesLongFormatSettingsWizardPage extends AbstractAnalysisWizardPage {

	private File file;
	private Text dataTextFile;
	private Text filterTextFile;
	private Algorithm[] algorithms = Algorithm.values();
	@SuppressWarnings("unused")
	private ISamplesPCA<?, ?> samples;

	public FilesLongFormatSettingsWizardPage() {

		super("Main Properties");
		setTitle("PCA");
		setDescription("Set Main PCA parameters");
	}

	public void setFile(File file) {

		this.file = file;
	}

	@Override
	public void createControl(Composite parent) {

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(3, false));
		//
		createLabel(composite, "Title:");
		createTextTitle(composite, 2);
		//
		createLabel(composite, "Number of PCs:");
		createSpinnerPrincipleComponents(composite);
		//
		createLabel(composite, "Algorithm:");
		createComboViewerAlgorithm(composite);
		//
		createLabel(composite, "Main Data File:");
		dataTextFile = createTextMainFile(composite);
		createButtonSelectDataFile(composite);
		//
		createLabel(composite, "Filter Data File:");
		filterTextFile = createTextFilterFile(composite);
		createButtonSelectFilterFile(composite);
		//
		setControl(composite);
	}

	public List<IDataInputEntry> getMainDataInputEntries() {

		List<IDataInputEntry> dataInputEntries = new ArrayList<>();
		String dataPath = dataTextFile.getText().trim();
		File dataFile = new File(dataPath);
		if(dataFile.exists()) {
			DataInputEntry dataInputEntry = new DataInputEntry(dataPath);
			dataInputEntries.add(dataInputEntry);
		}
		return dataInputEntries;
	}

	public List<IDataInputEntry> getFilterDataInputEntries() {

		List<IDataInputEntry> dataInputEntries = new ArrayList<>();
		String filterPath = filterTextFile.getText().trim();
		File filterFile = new File(filterPath);
		if(filterFile.exists()) {
			DataInputEntry dataInputEntry = new DataInputEntry(filterPath);
			dataInputEntries.add(dataInputEntry);
		}
		return dataInputEntries;
	}

	private Label createLabel(Composite parent, String text) {

		Label label = new Label(parent, SWT.NONE);
		label.setText(text);
		return label;
	}

	private Spinner createSpinnerPrincipleComponents(Composite parent) {

		Spinner spinner = new Spinner(parent, SWT.BORDER);
		spinner.setToolTipText("Number of Principal Components");
		spinner.setMinimum(PreferenceSupplier.MIN_NUMBER_OF_COMPONENTS);
		spinner.setIncrement(1);
		spinner.setSelection(analysisSettings.getNumberOfPrincipalComponents());
		spinner.setMaximum(PreferenceSupplier.MAX_NUMBER_OF_COMPONENTS);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = 2;
		spinner.setLayoutData(gridData);
		spinner.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				analysisSettings.setNumberOfPrincipalComponents(spinner.getSelection());
			}
		});
		//
		return spinner;
	}

	private ComboViewer createComboViewerAlgorithm(Composite parent) {

		ComboViewer comboViewer = new EnhancedComboViewer(parent, SWT.READ_ONLY);
		comboViewer.setContentProvider(ArrayContentProvider.getInstance());
		comboViewer.setInput(algorithms);
		comboViewer.setLabelProvider(new AbstractLabelProvider() {

			@Override
			public String getText(Object element) {

				if(element instanceof Algorithm algorithm) {
					return algorithm.label();
				}
				return null;
			}
		});
		//
		Combo combo = comboViewer.getCombo();
		combo.setToolTipText("PCA Algorithm");
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = 2;
		combo.setLayoutData(gridData);
		combo.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				Object object = comboViewer.getStructuredSelection().getFirstElement();
				if(object instanceof Algorithm algorithm) {
					analysisSettings.setAlgorithm(algorithm);
				}
			}
		});
		//
		combo.select(getSelectedAlgorithmIndex());
		//
		return comboViewer;
	}

	private Text createTextMainFile(Composite parent) {

		Text text = new Text(parent, SWT.BORDER);
		text.setText("");
		text.setToolTipText("Path to long format data  file.");
		text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		//
		if(file != null) {
			text.setText(file.getAbsolutePath());
		} else {
			text.setText("");
		}
		//
		return text;
	}

	private Text createTextFilterFile(Composite parent) {

		Text text = new Text(parent, SWT.BORDER);
		text.setText("");
		text.setToolTipText("Path to long format filter file.");
		text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		//
		if(file != null) {
			text.setText(file.getAbsolutePath());
		} else {
			text.setText("");
		}
		//
		return text;
	}

	private void createButtonSelectDataFile(Composite parent) {

		Button button = new Button(parent, SWT.PUSH);
		button.setText("");
		button.setToolTipText("Select the data matrix.");
		button.setImage(ApplicationImageFactory.getInstance().getImage(IApplicationImage.IMAGE_FILE, IApplicationImageProvider.SIZE_16x16));
		button.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				FileDialog fileDialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.READ_ONLY);
				fileDialog.setText("Import");
				fileDialog.setFilterExtensions(new String[]{PcaExtractionFileLongText.FILTER_EXTENSION + ";"});
				fileDialog.setFilterNames(new String[]{PcaExtractionFileLongText.FILTER_NAME + ";"});
				fileDialog.setFilterPath(PreferenceSupplier.getPathImportFile());
				String path = fileDialog.open();
				if(path != null) {
					File file = new File(path);
					if(file.exists()) {
						PreferenceSupplier.setPathImportFile(fileDialog.getFilterPath());
						dataTextFile.setText(file.getAbsolutePath());
					}
				}
			}
		});
	}

	private void createButtonSelectFilterFile(Composite parent) {

		Button button = new Button(parent, SWT.PUSH);
		button.setText("");
		button.setToolTipText("Select the filter data file.");
		button.setImage(ApplicationImageFactory.getInstance().getImage(IApplicationImage.IMAGE_FILE, IApplicationImageProvider.SIZE_16x16));
		button.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				FileDialog fileDialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.READ_ONLY);
				fileDialog.setText("Import");
				fileDialog.setFilterExtensions(new String[]{PcaExtractionFileLongText.FILTER_EXTENSION + ";"});
				fileDialog.setFilterNames(new String[]{PcaExtractionFileLongText.FILTER_NAME + ";"});
				fileDialog.setFilterPath(PreferenceSupplier.getPathImportFile());
				String path = fileDialog.open();
				if(path != null) {
					File file = new File(path);
					if(file.exists()) {
						PreferenceSupplier.setPathImportFile(fileDialog.getFilterPath());
						filterTextFile.setText(file.getAbsolutePath());
					}
				}
			}
		});
	}

	private int getSelectedAlgorithmIndex() {

		for(int i = 0; i < algorithms.length; i++) {
			Algorithm algorithm = algorithms[i];
			if(algorithm.equals(analysisSettings.getAlgorithm())) {
				return i;
			}
		}
		return -1;
	}
}
