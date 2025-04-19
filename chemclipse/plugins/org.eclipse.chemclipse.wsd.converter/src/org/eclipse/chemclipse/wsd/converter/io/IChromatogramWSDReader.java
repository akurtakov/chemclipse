/*******************************************************************************
 * Copyright (c) 2013, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.wsd.converter.io;

import java.io.File;
import java.io.IOException;

import org.eclipse.chemclipse.converter.io.IChromatogramReader;
import org.eclipse.chemclipse.wsd.model.core.IChromatogramWSD;
import org.eclipse.core.runtime.IProgressMonitor;

public interface IChromatogramWSDReader extends IChromatogramReader {

	/**
	 * Reads an chromatogram.<br/>
	 * If the chromatogram can not be parsed, null will be returned.
	 * 
	 * @param file
	 * @return IChromatogram
	 * @throws IOException
	 */
	IChromatogramWSD read(File file, IProgressMonitor monitor) throws IOException;
}
