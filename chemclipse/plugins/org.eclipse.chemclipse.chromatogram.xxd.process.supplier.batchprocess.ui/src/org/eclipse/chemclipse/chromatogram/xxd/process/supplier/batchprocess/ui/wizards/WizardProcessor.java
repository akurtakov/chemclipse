/*******************************************************************************
 * Copyright (c) 2014, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.process.supplier.batchprocess.ui.wizards;

import java.io.File;

import org.eclipse.chemclipse.chromatogram.xxd.process.supplier.batchprocess.io.JobWriter;
import org.eclipse.chemclipse.chromatogram.xxd.process.supplier.batchprocess.model.BatchProcessJob;
import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.model.types.DataType;
import org.eclipse.chemclipse.support.l10n.SupportMessages;
import org.eclipse.chemclipse.support.ui.wizards.AbstractWizard;
import org.eclipse.chemclipse.ux.extension.ui.provider.ISupplierEditorSupport;
import org.eclipse.chemclipse.ux.extension.xxd.ui.internal.editors.ProjectExplorerSupportFactory;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

public class WizardProcessor extends AbstractWizard {

	private static final Logger logger = Logger.getLogger(WizardProcessor.class);

	private PageDataType pageDataType;
	private BatchProcessWizardElements wizardElements;

	public WizardProcessor() {

		super(new BatchProcessWizardElements());
		this.wizardElements = (BatchProcessWizardElements)getWizardElements();
	}

	@Override
	public void addPages() {

		super.addPages();

		pageDataType = new PageDataType(wizardElements);
		addPage(pageDataType);
	}

	@Override
	public void doFinish(IProgressMonitor monitor) throws CoreException {

		File file = wizardElements.getBatchProcessFile();
		try {
			/*
			 * Create the project.
			 */
			JobWriter jobWriter = new JobWriter();
			jobWriter.writeBatchProcessJob(file, createBatchProcessJob());
		} catch(Exception e) {
			logger.warn(e);
		}

		runOpenEditor(file, monitor);
	}

	private BatchProcessJob createBatchProcessJob() {

		BatchProcessJob batchProcessJob = new BatchProcessJob();
		batchProcessJob.setDataType(pageDataType.getDataType());

		return batchProcessJob;
	}

	private void runOpenEditor(File file, IProgressMonitor monitor) {

		monitor.subTask(SupportMessages.taskOpenEditor);
		ISupplierEditorSupport supplierEditorSupport = new ProjectExplorerSupportFactory(DataType.OBJ).getInstanceEditorSupport();
		getShell().getDisplay().asyncExec(() -> {
			if(!supplierEditorSupport.openEditor(file)) {
				logger.warn("Failed to open editor.");
			}
		});
	}
}