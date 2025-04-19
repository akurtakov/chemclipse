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
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.alignment.converter.retentionindices;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.eclipse.chemclipse.chromatogram.alignment.converter.exceptions.FileIsEmptyException;
import org.eclipse.chemclipse.chromatogram.alignment.converter.exceptions.FileIsNotReadableException;

public abstract class AbstractRetentionIndicesImportConverter implements IRetentionIndicesImportConverter {

	/**
	 * This method validates the retention indices file.<br/>
	 * A failure will be thrown if the file is not in a valid state.<br/>
	 * It is possible, that there is no file stored on disk or the file is not
	 * readable.<br/>
	 * If the file is empty is handled also.
	 * 
	 * @param retentionIndices
	 * @throws FileNotFoundException
	 * @throws FileIsNotReadableException
	 * @throws FileIsEmptyException
	 * @throws IOException
	 */
	@Override
	public void validate(final File retentionIndices) throws FileIsNotReadableException, FileIsEmptyException, IOException {

		if(!retentionIndices.exists()) {
			throw new FileNotFoundException("The file " + retentionIndices.getAbsoluteFile() + " does not exist.");
		}
		if(retentionIndices.length() == 0) {
			throw new FileIsEmptyException("The file " + retentionIndices.getAbsoluteFile() + " is empty.");
		}
		if(!retentionIndices.canRead()) {
			throw new FileIsNotReadableException("Can't read the chromatogram file: " + retentionIndices.getAbsoluteFile());
		}
	}
}
