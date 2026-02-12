/*******************************************************************************
 * Copyright (c) 2013, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.filter.result;

public interface IPeakFilterResult {

	/**
	 * Returns the result status of the applied filter.
	 * 
	 * @return {@link ResultStatus}
	 */
	ResultStatus getResultStatus();

	/**
	 * Returns a description of the applied filter or the failure that has been
	 * occurred.
	 * 
	 * @return String
	 */
	String getDescription();
}
