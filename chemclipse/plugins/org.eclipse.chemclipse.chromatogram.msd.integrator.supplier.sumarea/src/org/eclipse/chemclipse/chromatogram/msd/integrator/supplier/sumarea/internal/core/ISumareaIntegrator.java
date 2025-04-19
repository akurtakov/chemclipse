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
package org.eclipse.chemclipse.chromatogram.msd.integrator.supplier.sumarea.internal.core;

import org.eclipse.chemclipse.msd.model.core.selection.IChromatogramSelectionMSD;

public interface ISumareaIntegrator {

	float INTEGRATION_STEPS = 100.0f; // steps of 100 milliseconds.
	String DESCRIPTION = "SumArea";

	/*
	 * Integrates the TIC signal.
	 */
	double integrate(IChromatogramSelectionMSD chromatogramSelection);

	/*
	 * Integrates the selected ion.
	 */
	double integrate(IChromatogramSelectionMSD chromatogramSelection, int ion);
}
