/*******************************************************************************
 * Copyright (c) 2020, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.xxd.ui.custom;

public class PeakChartSettings {

	private boolean showChromatogramTIC = true;
	private boolean showChromatogramTraces = true;
	private boolean showBaseline = true;

	public boolean isShowChromatogramTIC() {

		return showChromatogramTIC;
	}

	public void setShowChromatogramTIC(boolean showChromatogramTIC) {

		this.showChromatogramTIC = showChromatogramTIC;
	}

	public boolean isShowChromatogramTraces() {

		return showChromatogramTraces;
	}

	public void setShowChromatogramTraces(boolean showChromatogramTraces) {

		this.showChromatogramTraces = showChromatogramTraces;
	}

	public boolean isShowBaseline() {

		return showBaseline;
	}

	public void setShowBaseline(boolean showBaseline) {

		this.showBaseline = showBaseline;
	}
}
