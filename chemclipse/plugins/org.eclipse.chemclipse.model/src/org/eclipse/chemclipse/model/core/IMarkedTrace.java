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
 * Jan Holy - initial API and implementation
 * Philip Wenig - comment
 *******************************************************************************/
package org.eclipse.chemclipse.model.core;

/**
 * The marked signal is a generic construct to
 * match MSD (m/z) and WSD (wavelength) traces.
 */
public interface IMarkedTrace {

	double TOTAL_SIGNAL = ISignal.TOTAL_INTENSITY;
	int TOTAL_SIGNAL_AS_INT = (int)Math.round(TOTAL_SIGNAL);

	int castTrace();

	double getTrace();

	void setTrace(double trace);

	int getMagnification();

	void setMagnification(int magnification);
}