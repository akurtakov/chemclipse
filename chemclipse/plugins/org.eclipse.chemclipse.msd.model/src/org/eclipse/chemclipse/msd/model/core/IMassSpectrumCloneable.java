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

/**
 * This interface ensures that it is possible to make a deep copy of a mass
 * spectrum.<br/>
 * It provides some additional methods especially one to return an instance of
 * IMassSpectrum.<br/>
 * Clone and this interface methods perform a "deep copy" instead of a
 * "shallow copy" operation.
 * 
 * @author eselmeister
 */
public interface IMassSpectrumCloneable extends Cloneable {

	/**
	 * Returns a deep copy of the actual mass spectrum.<br/>
	 * This method performs a "deep copy" of this object instead of a
	 * "shallow copy" operation.
	 * 
	 * @throws CloneNotSupportedException
	 * @return {@link IScanMSD}
	 */
	IScanMSD makeDeepCopy() throws CloneNotSupportedException;
}
