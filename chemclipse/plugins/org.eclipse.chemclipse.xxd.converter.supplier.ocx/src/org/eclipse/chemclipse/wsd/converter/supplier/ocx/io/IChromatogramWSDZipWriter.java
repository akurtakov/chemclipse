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
import java.util.zip.ZipOutputStream;

import org.eclipse.chemclipse.wsd.converter.io.IChromatogramWSDWriter;
import org.eclipse.chemclipse.wsd.model.core.IChromatogramWSD;
import org.eclipse.core.runtime.IProgressMonitor;

public interface IChromatogramWSDZipWriter extends IChromatogramWSDWriter {

	/**
	 * The directoryPrefix could be "" to write the data to the root of the zip file.
	 * 
	 * @param zipOutputStream
	 * @param directoryPrefix
	 * @param chromatogram
	 * @param monitor
	 * @throws IOException
	 */
	void writeChromatogram(ZipOutputStream zipOutputStream, String directoryPrefix, IChromatogramWSD chromatogram, IProgressMonitor monitor) throws IOException;
}
