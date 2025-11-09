/*******************************************************************************
 * Copyright (c) 2022, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.model.implementation.Chromatogram;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class ProcessSettings_3_Test {

	private ProcessSettingsTest processSettings = new ProcessSettingsTest();
	private IChromatogram chromatogram;

	@BeforeAll
	public void setUp() {

		chromatogram = new Chromatogram();
		chromatogram.putHeaderData("Data Name", "Py-GC/MS");
	}

	@Test
	public void test1() {

		String fileNamePattern = "{chromatogram_dataname}{extension}";
		String fileName = processSettings.getFileName(chromatogram, fileNamePattern, ".ocb");
		assertEquals("Py-GC-MS.ocb", fileName); // Replace OS specific path chars by a '-'.
	}
}
