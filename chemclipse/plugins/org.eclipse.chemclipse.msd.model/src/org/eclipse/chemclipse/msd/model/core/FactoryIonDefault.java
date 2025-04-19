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
 * Dr. Alexander Kerner - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.msd.model.core;

import org.eclipse.chemclipse.msd.model.implementation.Ion;

/**
 * Default implementation for {@link FactoryIon}.
 * Newly created instances are of type {@link Ion}.
 *
 * @author <a href="mailto:alexander.kerner@openchrom.net">Alexander Kerner</a>
 *
 */
public class FactoryIonDefault implements FactoryIon {

	@Override
	public IIon create(double mz, float abundance) {

		return new Ion(mz, abundance);
	}
}
