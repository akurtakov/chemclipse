/*******************************************************************************
 * Copyright (c) 2015, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Dr. Janos Binder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.msd.model.core;

public interface INamedScanMSD extends IScanMSD {

	String getSubstanceName();

	void setSubstanceName(String substanceName);

	String getOriginName();

	void setOriginName(String originName);

	Long getOriginalReferenceMassSpectrumId();

	void setOriginalReferenceMassSpectrumId(Long originalReferenceMassSpectrumId);

	Double getPeakArea();

	void setPeakArea(Double peakArea);

	Float getPeakTailing();

	void setPeakTailing(Float peakTailing);

	Float getPeakSN();

	void setPeakSN(Float peakSN);
}
