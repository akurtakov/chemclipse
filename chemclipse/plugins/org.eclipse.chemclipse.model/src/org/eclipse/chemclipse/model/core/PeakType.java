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
 * Christoph Läubrich - adding delete type
 * Philip Wenig - delete type doesn't make sense here, moved to IPeak (markedAsDeleted)
 *******************************************************************************/
package org.eclipse.chemclipse.model.core;

import org.eclipse.chemclipse.support.text.ILabel;

/**
 * This enumeration defines values which declare the type of the peak start and
 * end point.<br/>
 * E.g.:<br/>
 * BB - baseline baseline<br/>
 * BV - baseline valley<br/>
 * ... <br/>
 * B - baseline<br/>
 * V - valley<br/>
 * M - manual<br/>
 * D - deconvoluted<br/>
 * P - perpendicular
 *
 */
public enum PeakType implements ILabel {

	/*
	 * Some peak type defaults are listed here.
	 */
	DEFAULT("--"), //
	BB("BB (Baseline)"), //
	BV("BV (Baseline, Valley)"), //
	VV("VV (Valley)"), //
	VB("VB (Valley, Baseline)"), //
	MM("MM (Manual)"), //
	PV("PV (Perpendicular Drop, Valley)"), //
	PB("PB (Perpendicular Drop, Baseline)"), //
	VP("VP (Valley, Perpendicular Drop)"), //
	BP("BP (Baseline, Perpendicular Drop)"), //
	DD("DD (Deconvolution)"), //
	TS("TS (Tangent Skim)"), //
	CB("CB (Chromatogram Baseline)"); //

	private String label = "";

	private PeakType(String label) {

		this.label = label;
	}

	@Override
	public String label() {

		return label;
	}

	public static String[][] getOptions() {

		return ILabel.getOptions(values());
	}
}