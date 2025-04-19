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
package org.eclipse.chemclipse.msd.model.core;

public interface IIonBounds {

	/**
	 * This method returns the ion with the lowest ion value of the
	 * scan you have received this object from.<br/>
	 * Be careful, it is possible that IIon contains null.
	 * 
	 * @return {@link IIon}
	 */
	public IIon getLowestIon();

	/**
	 * This method returns the ion with the highest ion value of the
	 * scan you have received this object from.<br/>
	 * Be careful, it is possible that IIon contains null.
	 * 
	 * @return {@link IIon}
	 */
	public IIon getHighestIon();
}
