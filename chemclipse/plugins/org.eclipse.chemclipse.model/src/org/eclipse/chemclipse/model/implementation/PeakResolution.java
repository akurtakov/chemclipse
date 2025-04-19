/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.implementation;

import org.eclipse.chemclipse.model.core.IPeak;
import org.eclipse.chemclipse.model.core.IPeakModel;
import org.eclipse.chemclipse.model.core.IPeakResolution;

public class PeakResolution implements IPeakResolution {

	private IPeak peak1;
	private IPeak peak2;

	@Override
	public IPeak getPeak1() {

		return peak1;
	}

	public void setPeak1(IPeak peak1) {

		this.peak1 = peak1;
	}

	@Override
	public IPeak getPeak2() {

		return peak2;
	}

	public void setPeak2(IPeak peak2) {

		this.peak2 = peak2;
	}

	public PeakResolution(IPeak peak1, IPeak peak2) {

		this.peak1 = peak1;
		this.peak2 = peak2;
	}

	/*
	 * peak resolution, in chromatography: Rs
	 * https://doi.org/10.1351/goldbook.P04465
	 * in
	 * IUPAC. Compendium of Chemical Terminology, 2nd ed. (the "Gold Book").
	 * Compiled by A. D. McNaught and A. Wilkinson.
	 * Blackwell Scientific Publications, Oxford (1997).
	 * Online version (2019-) created by S. J. Chalk.
	 * ISBN 0-9678550-9-8.
	 */
	@Override
	public float calculate() {

		IPeakModel model1 = peak1.getPeakModel();
		int tr1 = model1.getRetentionTimeAtPeakMaximum();
		int wh1 = model1.getWidthByInflectionPoints();
		IPeakModel model2 = peak2.getPeakModel();
		int tr2 = model2.getRetentionTimeAtPeakMaximum();
		int wh2 = model2.getWidthByInflectionPoints();
		return (float)2 * (tr2 - tr1) / (wh1 + wh2);
	}
}
