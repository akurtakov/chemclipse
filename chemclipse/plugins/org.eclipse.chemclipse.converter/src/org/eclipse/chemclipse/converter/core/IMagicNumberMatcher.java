/*******************************************************************************
 * Copyright (c) 2016, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.converter.core;

import java.io.File;

public interface IMagicNumberMatcher {

	/**
	 * Shall be used to quickly identify potential files.
	 * Use IFileContentMatcher for more expensive checks.
	 * 
	 * @param file
	 * @return boolean
	 */
	boolean checkFileFormat(File file);
}
