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

import org.eclipse.chemclipse.chromatogram.alignment.converter.exceptions.FileIsNotWriteableException;
import org.eclipse.chemclipse.chromatogram.alignment.model.core.IRetentionIndices;

public interface IRetentionIndicesExportConverter {

	/**
	 * This method returns the file of the written retention indices.
	 * 
	 * @param file
	 * @param retentionIndices
	 * @return File
	 * @throws FileNotFoundException
	 * @throws FileIsNotWriteableException
	 * @throws IOException
	 */
	File convert(File file, IRetentionIndices retentionIndices) throws FileIsNotWriteableException, IOException;

	/**
	 * This class checks the file attributes and throws an exception if
	 * something is wrong.
	 * 
	 * @param file
	 * @throws FileNotFoundException
	 * @throws FileIsNotWriteableException
	 * @throws IOException
	 */
	void validate(File file) throws FileIsNotWriteableException, IOException;
}
