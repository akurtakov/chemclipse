/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.fsd.model.core.implementation;

import java.util.TreeSet;

import org.eclipse.chemclipse.fsd.model.core.ISignalFSD;
import org.eclipse.chemclipse.fsd.model.core.ISpectrumFSD;
import org.eclipse.chemclipse.model.core.AbstractMeasurementInfo;

public class SpectrumFSD extends AbstractMeasurementInfo implements ISpectrumFSD {

	private static final long serialVersionUID = -8354507225461817214L;

	private TreeSet<ISignalFSD> emission = new TreeSet<>();
	private TreeSet<ISignalFSD> excitation = new TreeSet<>();

	@Override
	public TreeSet<ISignalFSD> getExcitation() {

		return emission;
	}

	@Override
	public TreeSet<ISignalFSD> getEmission() {

		return excitation;
	}
}