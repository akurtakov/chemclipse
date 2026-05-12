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
 *******************************************************************************/
package org.eclipse.chemclipse.msd.converter.supplier.amdis.internal.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class SpecificationValidatorMSL_1_Test {

	private File file;
	private String spec;

	@BeforeAll
	public void setUp() {

		spec = new File("testData/files/import/msl/MASSSPECTRA.msl").getAbsolutePath();
	}

	@Test
	public void testValidateAgilentSpecification_1() {

		file = new File("testData/files/import/msl/MASSSPECTRA.msl");
		file = SpecificationValidatorMSL.validateSpecification(file);
		assertEquals(spec, file.getAbsolutePath());
	}

	@Test
	public void testValidateAgilentSpecification_3() {

		file = new File("testData/files/import/msl/MASSSPECTRA");
		file = SpecificationValidatorMSL.validateSpecification(file);
		assertEquals(spec, file.getAbsolutePath());
	}

	@Test
	public void testValidateAgilentSpecification_4() {

		file = new File("testData/files/import/msl");
		file = SpecificationValidatorMSL.validateSpecification(file);
		assertEquals(spec, file.getAbsolutePath());
	}
}
