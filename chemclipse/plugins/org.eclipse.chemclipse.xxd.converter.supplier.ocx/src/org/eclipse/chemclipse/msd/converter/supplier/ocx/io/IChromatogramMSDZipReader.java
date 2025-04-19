/*******************************************************************************
 * Copyright (c) 2017, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.converter.supplier.ocx.io;

import java.io.IOException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import org.eclipse.chemclipse.msd.converter.io.IChromatogramMSDReader;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.core.runtime.IProgressMonitor;

public interface IChromatogramMSDZipReader extends IChromatogramMSDReader {

	IChromatogramMSD read(ZipInputStream zipInputStream, String directoryPrefix, IProgressMonitor monitor) throws IOException;

	IChromatogramMSD read(ZipFile zipFile, String directoryPrefix, IProgressMonitor monitor) throws IOException;
}
