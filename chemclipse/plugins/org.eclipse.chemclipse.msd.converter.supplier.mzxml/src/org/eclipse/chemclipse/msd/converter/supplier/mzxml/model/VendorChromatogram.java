/*******************************************************************************
 * Copyright (c) 2008, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Matthias Mailänder - metadata
 *******************************************************************************/
package org.eclipse.chemclipse.msd.converter.supplier.mzxml.model;

import org.eclipse.chemclipse.msd.model.core.AbstractChromatogramMSD;

public class VendorChromatogram extends AbstractChromatogramMSD implements IVendorChromatogram {

	private static final long serialVersionUID = 9120477404438842118L;

	@Override
	public String getIonisation() {

		return getHeaderDataOrDefault("Ionisation", "");
	}

	@Override
	public void setIonisation(String ionisation) {

		putHeaderData("Ionisation", ionisation);
	}

	@Override
	public String getMassAnalyzer() {

		return getHeaderDataOrDefault("Mass Analyzer", "");
	}

	@Override
	public void setMassAnalyzer(String massAnalyzer) {

		putHeaderData("Mass Analyzer", massAnalyzer);
	}

	@Override
	public String getMassDetector() {

		return getHeaderDataOrDefault("MS Detector", "");
	}

	@Override
	public void setMassDetector(String massDetector) {

		putHeaderData("MS Detector", massDetector);
	}

	@Override
	public String getSoftware() {

		return getHeaderDataOrDefault("Acquisition Software", "");
	}

	@Override
	public void setSoftware(String software) {

		putHeaderData("Acquisition Software", software);
	}
}
