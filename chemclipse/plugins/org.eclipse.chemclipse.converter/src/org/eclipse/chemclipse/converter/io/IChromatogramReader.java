/*******************************************************************************
 * Copyright (c) 2012, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.converter.io;

import java.io.File;
import java.io.IOException;

import org.eclipse.chemclipse.model.core.IChromatogramOverview;
import org.eclipse.core.runtime.IProgressMonitor;

public interface IChromatogramReader extends IFileHelper {

	/**
	 * Reads an chromatogram overview.<br/>
	 * If the chromatogram can not be parsed, null will be returned.
	 * 
	 * @param file
	 * @throws IOException
	 */
	IChromatogramOverview readOverview(File file, IProgressMonitor monitor) throws IOException;
}
