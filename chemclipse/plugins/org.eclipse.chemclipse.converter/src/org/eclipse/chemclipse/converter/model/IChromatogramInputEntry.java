/*******************************************************************************
 * Copyright (c) 2010, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.converter.model;

public interface IChromatogramInputEntry {

	/**
	 * Returns the path to the input file.
	 * 
	 * @return String
	 */
	String getInputFile();

	/**
	 * Returns the name of the input file.
	 * 
	 * @return String
	 */
	String getName();
}
