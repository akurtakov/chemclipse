/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Matthias Mailänder - initial API
 *******************************************************************************/
package org.eclipse.chemclipse.fsd.model.core;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.model.wavelengths.IMarkedWavelengths;

public interface IScanFSD extends IScan {

	IScanSignalFSD getScanSignal(int scan);

	/**
	 * method return signal on exact wavelength
	 * 
	 * @param wavelength
	 * @return signal scan
	 */
	Optional<IScanSignalFSD> getScanSignal(float wavelength);

	void deleteScanSignals();

	void addScanSignal(IScanSignalFSD scanSignalFSD);

	void removeScanSignal(IScanSignalFSD scanSignalFSD);

	int getNumberOfScanSignals();

	List<IScanSignalFSD> getScanSignals();

	void removeScanSignal(int scan);

	void removeScanSignals(Set<Integer> wavelengths);

	boolean hasScanSignals();

	float getTotalSignal(IMarkedWavelengths excludedWavelenths);
}
