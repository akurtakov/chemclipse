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
 * Christoph Läubrich - add generics
 *******************************************************************************/
package org.eclipse.chemclipse.msd.converter.peak;

import java.io.File;

import org.eclipse.chemclipse.converter.core.IImportConverter;
import org.eclipse.chemclipse.msd.model.core.IPeaksMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.IProgressMonitor;

public interface IPeakImportConverter extends IImportConverter {

	/**
	 * Converts the peaks stored in the file to an instance of IPeaks.
	 * 
	 * @param file
	 * @param monitor
	 * @return IProcessingInfo
	 */
	IProcessingInfo<IPeaksMSD> convert(File file, IProgressMonitor monitor);
}
