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
 * Matthias Mailänder - add support for saving version 1.10
 *******************************************************************************/
package org.eclipse.chemclipse.msd.converter.supplier.mzml.converter.io;

import java.io.File;
import java.io.IOException;

import org.eclipse.chemclipse.converter.exceptions.FileIsNotWriteableException;
import org.eclipse.chemclipse.converter.io.AbstractChromatogramWriter;
import org.eclipse.chemclipse.msd.converter.io.IChromatogramMSDWriter;
import org.eclipse.chemclipse.msd.converter.supplier.mzml.io.ChromatogramWriterVersion110;
import org.eclipse.chemclipse.msd.converter.supplier.mzml.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.xxd.converter.supplier.mzml.io.XmlReader110;
import org.eclipse.core.runtime.IProgressMonitor;

public class ChromatogramWriter extends AbstractChromatogramWriter implements IChromatogramMSDWriter {

	@Override
	public void writeChromatogram(File file, IChromatogramMSD chromatogram, IProgressMonitor monitor) throws FileIsNotWriteableException, IOException {

		final IChromatogramMSDWriter chromatogramWriter = getChromatogramWriter();
		if(chromatogramWriter != null) {
			chromatogramWriter.writeChromatogram(file, chromatogram, monitor);
		}
	}

	private IChromatogramMSDWriter getChromatogramWriter() {

		String versionSave = PreferenceSupplier.getChromatogramVersionSave();
		if(versionSave.equals(XmlReader110.VERSION)) {
			return new ChromatogramWriterVersion110();
		}
		return null;
	}
}
