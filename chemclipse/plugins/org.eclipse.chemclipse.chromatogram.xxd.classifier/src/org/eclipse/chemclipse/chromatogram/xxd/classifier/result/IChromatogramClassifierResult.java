/*******************************************************************************
 * Copyright (c) 2011, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.classifier.result;

public interface IChromatogramClassifierResult {

	/**
	 * Returns the result status of the applied filter.
	 * 
	 * @return {@link ResultStatus}
	 */
	ResultStatus getResultStatus();

	/**
	 * Returns a description of the applied classifier or the failure that has been
	 * occurred.
	 * 
	 * @return String
	 */
	String getDescription();
}