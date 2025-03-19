/*******************************************************************************
 * Copyright (c) 2013, 2025 Lablicate GmbH.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Dr. Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.fsd.converter.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.eclipse.chemclipse.converter.exceptions.FileIsNotWriteableException;
import org.eclipse.chemclipse.converter.io.IChromatogramWriter;
import org.eclipse.chemclipse.fsd.model.core.IChromatogramFSD;
import org.eclipse.core.runtime.IProgressMonitor;

public interface IChromatogramFSDWriter extends IChromatogramWriter {

	/**
	 * Writes the chromatogram to the given file.
	 * 
	 * @param file
	 * @param chromatogram
	 * @throws FileNotFoundException
	 * @throws FileIsNotWriteableException
	 * @throws IOException
	 */
	void writeChromatogram(File file, IChromatogramFSD chromatogram, IProgressMonitor monitor) throws FileIsNotWriteableException, IOException;
}
