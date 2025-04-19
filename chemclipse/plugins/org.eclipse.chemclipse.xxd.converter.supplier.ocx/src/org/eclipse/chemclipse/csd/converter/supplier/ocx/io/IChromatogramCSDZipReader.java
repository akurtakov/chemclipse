/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.csd.converter.supplier.ocx.io;

import java.io.IOException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import org.eclipse.chemclipse.csd.converter.io.IChromatogramCSDReader;
import org.eclipse.chemclipse.csd.model.core.IChromatogramCSD;
import org.eclipse.core.runtime.IProgressMonitor;

public interface IChromatogramCSDZipReader extends IChromatogramCSDReader {

	IChromatogramCSD read(ZipInputStream zipInputStream, String directoryPrefix, IProgressMonitor monitor) throws IOException;

	IChromatogramCSD read(ZipFile zipFile, String directoryPrefix, IProgressMonitor monitor) throws IOException;
}
