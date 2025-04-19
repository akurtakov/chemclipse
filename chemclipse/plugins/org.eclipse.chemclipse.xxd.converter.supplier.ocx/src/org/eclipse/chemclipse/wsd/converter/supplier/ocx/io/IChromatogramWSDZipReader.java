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
package org.eclipse.chemclipse.wsd.converter.supplier.ocx.io;

import java.io.IOException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import org.eclipse.chemclipse.wsd.converter.io.IChromatogramWSDReader;
import org.eclipse.chemclipse.wsd.model.core.IChromatogramWSD;
import org.eclipse.core.runtime.IProgressMonitor;

public interface IChromatogramWSDZipReader extends IChromatogramWSDReader {

	IChromatogramWSD read(ZipInputStream zipInputStream, String directoryPrefix, IProgressMonitor monitor) throws IOException;

	IChromatogramWSD read(ZipFile zipFile, String directoryPrefix, IProgressMonitor monitor) throws IOException;
}
