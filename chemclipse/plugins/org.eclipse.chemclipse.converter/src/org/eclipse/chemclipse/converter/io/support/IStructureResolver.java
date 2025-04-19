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
package org.eclipse.chemclipse.converter.io.support;

public interface IStructureResolver {

	/**
	 * Formats a integer value e.g. like this:
	 * 0 1 0 0 0 0 0 0 | 0 1 0 0 0 1 0 0 | 1 1 0 1 0 0 1 0 | 1 1 0 1 1 0 0 1
	 * 
	 * @param value
	 * @return String
	 */
	String formatAsBinary(int value);

	/**
	 * Formats a long value e.g. like this:
	 * 0 1 0 0 0 0 0 0 | 0 1 0 0 0 1 0 0 | 1 1 0 1 0 0 1 0 | ...
	 * 
	 * @param value
	 * @return String
	 */
	String formatAsBinary(long value);

	String formatAsBinary(float value);

	String formatAsBinary(double value);
}
