/*******************************************************************************
 * Copyright (c) 2023, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.pcr.converter.supplier.rdml.fragement.test.io;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import org.eclipse.chemclipse.converter.PathResolver;
import org.eclipse.chemclipse.pcr.converter.supplier.rdml.core.PCRImportConverter;
import org.eclipse.chemclipse.pcr.converter.supplier.rdml.fragment.test.TestPathHelper;
import org.eclipse.chemclipse.pcr.model.core.IChannel;
import org.eclipse.chemclipse.pcr.model.core.IPlate;
import org.eclipse.chemclipse.pcr.model.core.IWell;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.osgi.framework.FrameworkUtil;

@TestInstance(Lifecycle.PER_CLASS)
public class Test_Example_12_ITest {

	private IPlate plate;

	@BeforeAll
	public void setUp() throws IOException {

		File importFile = PathResolver.getFile(FrameworkUtil.getBundle(getClass()), TestPathHelper.EXAMPLE_1_2);
		IProcessingInfo<IPlate> importProcessingInfo = PCRImportConverter.getInstance().convert(importFile, new NullProgressMonitor());
		plate = importProcessingInfo.getProcessingResult();
	}

	@Test
	public void testDate() {

		LocalDateTime localDateTime = LocalDateTime.of(2011, Month.JANUARY, 9, 17, 04, 55);
		ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
		Date date = java.util.Date.from(zonedDateTime.toInstant());
		assertEquals(date, plate.getDate());
	}

	@Test
	public void testWells() {

		assertEquals(90, plate.getWells().size());
		IWell well = plate.getWell(0);
		assertEquals("A1: gDNA", well.getLabel());
		IChannel channel = well.getChannels().get(0);
		assertEquals(0, channel.getId());
		assertEquals("SYBRGreen I", channel.getDetectionName());
		assertEquals(668.4299926757812, channel.getFluorescence().get(0), 0);
	}
}
