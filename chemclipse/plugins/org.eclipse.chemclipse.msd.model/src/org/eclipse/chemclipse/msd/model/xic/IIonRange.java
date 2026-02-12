/*******************************************************************************
 * Copyright (c) 2008, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.model.xic;

/**
 * A ion range represents the start and stop ion value which should be
 * used for example to compare two mass spectra.
 */
public interface IIonRange {

	int MIN_ION = 1;
	int MAX_ION = 65535;

	/**
	 * Returns the start mass over charge value (ion).
	 * 
	 * @return int
	 */
	int getStartIon();

	/**
	 * Returns the stop mass over charge value (ion).
	 * 
	 * @return int
	 */
	int getStopIon();
}
