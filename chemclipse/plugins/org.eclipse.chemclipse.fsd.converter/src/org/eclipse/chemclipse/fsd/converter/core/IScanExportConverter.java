/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.fsd.converter.core;

import java.io.File;

import org.eclipse.chemclipse.converter.core.IExportConverter;
import org.eclipse.chemclipse.fsd.model.core.ISpectrumFSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.IProgressMonitor;

public interface IScanExportConverter extends IExportConverter {

	IProcessingInfo<File> convert(File file, ISpectrumFSD scan, IProgressMonitor monitor);
}
