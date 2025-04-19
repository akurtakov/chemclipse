/*******************************************************************************
 * Copyright (c) 2008, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Matthias Mailänder - add support for saving version 3.2
 *******************************************************************************/
package org.eclipse.chemclipse.msd.converter.supplier.mzxml.io;

import java.io.File;
import java.io.IOException;

import org.eclipse.chemclipse.converter.exceptions.FileIsNotWriteableException;
import org.eclipse.chemclipse.converter.io.AbstractChromatogramWriter;
import org.eclipse.chemclipse.msd.converter.io.IChromatogramMSDWriter;
import org.eclipse.chemclipse.msd.converter.supplier.mzxml.internal.io.ChromatogramWriterVersion32;
import org.eclipse.chemclipse.msd.converter.supplier.mzxml.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
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
		if(versionSave.equals(ChromatogramWriterVersion32.VERSION)) {
			return new ChromatogramWriterVersion32();
		}
		return null;
	}
}
