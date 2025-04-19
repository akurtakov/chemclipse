/*******************************************************************************
 * Copyright (c) 2021, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.rtshifter.core.internal.support;

import org.eclipse.chemclipse.csd.model.core.IScanCSD;
import org.eclipse.chemclipse.csd.model.implementation.ScanCSD;
import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.chemclipse.msd.model.implementation.VendorMassSpectrum;
import org.eclipse.chemclipse.vsd.model.core.IScanVSD;
import org.eclipse.chemclipse.vsd.model.implementation.ScanVSD;
import org.eclipse.chemclipse.wsd.model.core.IScanWSD;
import org.eclipse.chemclipse.wsd.model.core.implementation.ScanWSD;

public class ScanUtil {

	/**
	 * Creates an empty scan.
	 * May return null.
	 * 
	 * @param scanReference
	 * @param retentionTime
	 * @return IScan
	 */
	public static IScan createEmptyScan(IScan scanReference, int retentionTime) {

		IScan scan = null;
		//
		if(scanReference instanceof IScanCSD) {
			scan = new ScanCSD(0);
		} else if(scanReference instanceof IScanMSD) {
			scan = new VendorMassSpectrum();
		} else if(scanReference instanceof IScanWSD) {
			scan = new ScanWSD();
		} else if(scanReference instanceof IScanVSD) {
			scan = new ScanVSD();
		}
		//
		if(scan != null) {
			scan.setRetentionTime(retentionTime);
		}
		//
		return scan;
	}
}