/*******************************************************************************
 * Copyright (c) 2014, 2025 Lablicate GmbH.
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

import org.eclipse.chemclipse.chromatogram.xxd.process.supplier.batchprocess.io.JobWriter;
import org.eclipse.chemclipse.chromatogram.xxd.process.supplier.batchprocess.model.BatchProcessJob;
import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.support.ui.wizards.AbstractFileWizard;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

public class WizardProcessor extends AbstractFileWizard {

	private static final Logger logger = Logger.getLogger(WizardProcessor.class);
	private PageDataType pageDataType;

	public WizardProcessor() {

		super(BatchProcessJob.DESCRIPTION, BatchProcessJob.FILE_EXTENSION);
	}

	@Override
	public void addPages() {

		super.addPages();
		//
		pageDataType = new PageDataType();
		addPage(pageDataType);
	}

	@Override
	public void doFinish(IProgressMonitor monitor) throws CoreException {

		final IFile file = super.prepareProject(monitor);
		//
		try {
			/*
			 * Create the project.
			 */
			JobWriter jobWriter = new JobWriter();
			jobWriter.writeBatchProcessJob(file.getLocation().toFile(), createBatchProcessJob(), monitor);
		} catch(Exception e) {
			logger.warn(e);
		}
		/*
		 * Refresh
		 */
		super.refreshWorkspace(monitor);
		super.runOpenEditor(file, monitor);
	}

	private BatchProcessJob createBatchProcessJob() {

		BatchProcessJob batchProcessJob = new BatchProcessJob();
		batchProcessJob.setDataType(pageDataType.getDataType());
		//
		return batchProcessJob;
	}
}