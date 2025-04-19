/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.vsd.model.core;

import java.util.Set;
import java.util.TreeSet;

import org.eclipse.chemclipse.model.core.IScan;

public interface IScanVSD extends IScan {

	SignalType getSignalType();

	TreeSet<ISignalVSD> getProcessedSignals();

	double getRotationAngle();

	void setRotationAngle(double rotationAngle);

	double[] getRawSignals();

	void setRawSignals(double[] rawSignals);

	double[] getBackgroundSignals();

	void setBackgroundSignals(double[] backgroundSignals);

	void removeWavenumbers(Set<Integer> wavenumbers);

	void keepWavenumbers(Set<Integer> wavenumbers);
}
