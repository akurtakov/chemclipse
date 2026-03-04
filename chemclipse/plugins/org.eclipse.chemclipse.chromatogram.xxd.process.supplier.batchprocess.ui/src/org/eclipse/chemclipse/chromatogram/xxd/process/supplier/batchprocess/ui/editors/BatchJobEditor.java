/*******************************************************************************
 * Copyright (c) 2018, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Christoph Läubrich - rework dirty flag handling
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.xxd.process.supplier.batchprocess.ui.editors;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.stream.XMLStreamException;

import org.eclipse.chemclipse.chromatogram.xxd.process.supplier.batchprocess.core.BatchProcess;
import org.eclipse.chemclipse.chromatogram.xxd.process.supplier.batchprocess.io.JobWriter;
import org.eclipse.chemclipse.chromatogram.xxd.process.supplier.batchprocess.model.BatchProcessJob;
import org.eclipse.chemclipse.chromatogram.xxd.process.supplier.batchprocess.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.chromatogram.xxd.process.supplier.batchprocess.ui.Activator;
import org.eclipse.chemclipse.chromatogram.xxd.process.supplier.batchprocess.ui.internal.runnables.ExportRunnable;
import org.eclipse.chemclipse.chromatogram.xxd.process.supplier.batchprocess.ui.internal.runnables.ImportRunnable;
import org.eclipse.chemclipse.converter.model.ChromatogramInputEntry;
import org.eclipse.chemclipse.converter.model.IChromatogramInputEntry;
import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.model.handler.IModificationHandler;
import org.eclipse.chemclipse.model.types.DataType;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.methods.ProcessMethod;
import org.eclipse.chemclipse.processing.supplier.IProcessSupplierContext;
import org.eclipse.chemclipse.processing.ui.support.ProcessingInfoPartSupport;
import org.eclipse.chemclipse.rcp.ui.icons.core.ApplicationImageFactory;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImage;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImageProvider;
import org.eclipse.chemclipse.support.ui.workbench.EditorSupport;
import org.eclipse.chemclipse.ux.extension.ui.editors.IChemClipseEditor;
import org.eclipse.chemclipse.ux.extension.xxd.ui.swt.BatchJobUI;
import org.eclipse.chemclipse.xxd.process.support.ProcessTypeSupport;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.model.application.ui.MDirtyable;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;

public class BatchJobEditor implements IRunnableWithProgress, IModificationHandler, IChemClipseEditor {

	public static final String ID = "org.eclipse.chemclipse.chromatogram.xxd.batchprocess.ui.editors.BatchProcessJobEditor";
	public static final String CONTRIBUTION_URI = "bundleclass://org.eclipse.chemclipse.chromatogram.xxd.process.supplier.batchprocess.ui/org.eclipse.chemclipse.chromatogram.xxd.process.supplier.batchprocess.ui.editors.BatchJobEditor";
	public static final String ICON_URI = ApplicationImageFactory.getInstance().getURI(IApplicationImage.IMAGE_BATCHPROCESS, IApplicationImageProvider.SIZE_16x16);
	public static final String TOOLTIP = "Batch Process Job";

	private static final Logger logger = Logger.getLogger(BatchJobEditor.class);

	@Inject
	private MPart part;
	@Inject
	private MDirtyable dirtyable;

	private File file;
	private BatchProcessJob batchProcessJob;
	private BatchJobUI batchJobUI;

	private IProcessSupplierContext supplierContext;

	@Focus
	public void setFocus() {

		if(batchJobUI != null) {
			batchJobUI.setFocus();
		}
	}

	@Persist
	public void save() {

		if(file != null) {
			try {
				JobWriter writer = new JobWriter();
				batchProcessJob = getBatchProcessJob(batchJobUI.getDataType());
				writer.writeBatchProcessJob(file, batchProcessJob, new NullProgressMonitor());
				dirtyable.setDirty(false);
			} catch(FileNotFoundException e) {
				logger.warn(e);
			} catch(IOException e) {
				logger.warn(e);
			} catch(XMLStreamException e) {
				logger.warn(e);
			}
		}
	}

	@Override
	public boolean saveAs() {

		Display display = Display.getCurrent();
		Shell shell = display.getActiveShell();
		FileDialog dialog = new FileDialog(shell, SWT.SAVE);
		dialog.setText("Save the batch job");
		dialog.setFileName("ChromatogramBatchJob.obj");
		String fileName = dialog.open();
		if(fileName != null) {
			File exportFile = new File(fileName);
			batchProcessJob = getBatchProcessJob(batchJobUI.getDataType());
			ExportRunnable runnable = new ExportRunnable(exportFile, batchProcessJob);
			ProgressMonitorDialog monitor = new ProgressMonitorDialog(shell);
			try {
				monitor.run(false, false, runnable);
				dirtyable.setDirty(false);
				return true;
			} catch(InvocationTargetException e) {
				logger.warn(e);
				logger.warn(e.getCause());
			} catch(InterruptedException e) {
				logger.warn(e);
				Thread.currentThread().interrupt();
			}
		}
		return false;
	}

	@PostConstruct
	public void initialize(Composite parent) {

		Object object = part.getObject();
		if(object instanceof Map<?, ?> map) {
			Object fileObject = map.get(EditorSupport.MAP_FILE);
			if(fileObject instanceof String filePath) {
				file = new File(filePath);
				ImportRunnable runnable = new ImportRunnable(file);
				ProgressMonitorDialog monitor = new ProgressMonitorDialog(parent.getShell());
				try {
					monitor.run(false, false, runnable);
					batchProcessJob = runnable.getBatchProcessJob();
				} catch(InvocationTargetException e) {
					logger.warn(e);
				} catch(InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		}
		/*
		 * Create the UI.
		 */
		parent.setLayout(new FillLayout());
		supplierContext = new ProcessTypeSupport();
		if(batchProcessJob != null) {
			DataType dataType = batchProcessJob.getDataType();
			batchJobUI = new BatchJobUI(parent, supplierContext, Activator.getDefault().getPreferenceStore(), PreferenceSupplier.P_FILTER_PATH_IMPORT_RECORDS, dataType, this);
			batchJobUI.setModificationHandler(this);
			batchJobUI.doLoad(getBatchJobFiles(), new ProcessMethod(batchProcessJob.getProcessMethod()));
		}
	}

	@Override
	public void setDirty(boolean dirty) {

		dirtyable.setDirty(dirty);
	}

	@Override
	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {

		DataType dataType = batchProcessJob.getDataType();
		BatchProcess batchProcess = new BatchProcess(dataType, supplierContext);
		IProcessingInfo<?> processingInfo = batchProcess.execute(getBatchProcessJob(dataType), monitor);
		ProcessingInfoPartSupport.getInstance().update(processingInfo);
	}

	private List<File> getBatchJobFiles() {

		List<IChromatogramInputEntry> chromatogramInputEntries = batchProcessJob.getChromatogramInputEntries();
		List<File> files = new ArrayList<>();
		for(IChromatogramInputEntry entry : chromatogramInputEntries) {
			files.add(new File(entry.getInputFile()));
		}

		return files;
	}

	private BatchProcessJob getBatchProcessJob(DataType dataType) {

		BatchProcessJob batchProcessJob = new BatchProcessJob(batchJobUI.getMethod().getProcessMethod());
		batchProcessJob.setDataType(dataType);

		List<IChromatogramInputEntry> entries = batchProcessJob.getChromatogramInputEntries();
		for(File file : batchJobUI.getDataList().getFiles()) {
			entries.add(new ChromatogramInputEntry(file.getAbsolutePath()));
		}

		return batchProcessJob;
	}
}
