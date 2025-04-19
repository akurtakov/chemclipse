/*******************************************************************************
 * Copyright (c) 2011, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Christoph Läubrich - simplify API
 *******************************************************************************/
package org.eclipse.chemclipse.msd.converter.peak;

import java.io.File;

import org.eclipse.chemclipse.converter.core.IExportConverter;
import org.eclipse.chemclipse.msd.model.core.IPeaksMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.IProgressMonitor;

public interface IPeakExportConverter extends IExportConverter {

	/**
	 * Writes a the peak list to a file.
	 * 
	 * @param file
	 * @param peaks
	 * @param append
	 * @param monitor
	 * @return IProcessingInfo
	 */
	IProcessingInfo<File> convert(File file, IPeaksMSD peaks, boolean append, IProgressMonitor monitor);
}
