/*******************************************************************************
 * Copyright (c) 2013, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.quantitation.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.chromatogram.xxd.quantitation.exceptions.NoPeakQuantifierAvailableException;
import org.junit.jupiter.api.Test;

public class PeakQuantifier_1_Test {

	private IPeakQuantifierSupport support = PeakQuantifier.getPeakQuantifierSupport();

	@Test
	public void testGetMassSpectrumComparatorSupport_3() throws NoPeakQuantifierAvailableException {

		List<String> ids = support.getAvailablePeakQuantifierIds();
		List<String> rcs = new ArrayList<String>();
		for(String id : ids) {
			rcs.add(id);
		}
		String id;
		for(int i = 0; i < rcs.size(); i++) {
			id = support.getPeakQuantifierId(i);
			assertEquals(id, rcs.get(i));
		}
	}

	@Test
	public void testGetMassSpectrumComparisonSupplier_1() {

		assertThrows(NoPeakQuantifierAvailableException.class, () -> {
			support.getPeakQuantifierSupplier("");
		});
	}

	@Test
	public void testGetMassSpectrumComparisonSupplier_2() {

		assertThrows(NoPeakQuantifierAvailableException.class, () -> {
			support.getPeakQuantifierSupplier(null);
		});
	}
}
