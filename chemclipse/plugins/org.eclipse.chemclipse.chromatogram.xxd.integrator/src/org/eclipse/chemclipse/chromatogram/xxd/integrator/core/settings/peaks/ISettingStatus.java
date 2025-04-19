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
package org.eclipse.chemclipse.chromatogram.xxd.integrator.core.settings.peaks;

public interface ISettingStatus {

	/**
	 * Returns whether the peak should be used in the integration report or not.<br/>
	 * This decision depends on several factors. If for example a minimum peak
	 * area of 10000 was chosen and the actual peak has an area of 9999, it will
	 * not be reported.<br/>
	 * 
	 * @return boolean
	 */
	boolean report();

	/**
	 * Returns whether the area of a peak should be summed.
	 * 
	 * @return boolean
	 */
	boolean sumOn();
}
