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
import java.util.zip.ZipOutputStream;

import org.eclipse.chemclipse.msd.converter.io.IChromatogramMSDWriter;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.core.runtime.IProgressMonitor;

public interface IChromatogramMSDZipWriter extends IChromatogramMSDWriter {

	/**
	 * The directoryPrefix could be "" to write the data to the root of the zip file.
	 * 
	 * @param zipOutputStream
	 * @param directoryPrefix
	 * @param chromatogram
	 * @param monitor
	 * @throws IOException
	 */
	void writeChromatogram(ZipOutputStream zipOutputStream, String directoryPrefix, IChromatogramMSD chromatogram, IProgressMonitor monitor) throws IOException;
}
