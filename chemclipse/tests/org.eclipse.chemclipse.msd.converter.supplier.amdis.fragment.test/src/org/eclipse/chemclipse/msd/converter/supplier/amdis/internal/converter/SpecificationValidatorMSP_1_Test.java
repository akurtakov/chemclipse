/*******************************************************************************
 * Copyright (c) 2012, 2025 Lablicate GmbH.
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

import org.eclipse.chemclipse.msd.converter.supplier.amdis.PathResolver;
import org.eclipse.chemclipse.msd.converter.supplier.amdis.TestPathHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class SpecificationValidatorMSP_1_Test {

	private File file;
	private String spec;

	@BeforeAll
	public void setUp() {

		spec = PathResolver.getAbsolutePath(TestPathHelper.VALIDATOR_TEST_SPEC_MSP);
	}

	@Test
	public void testValidateAgilentSpecification_1() {

		file = new File(PathResolver.getAbsolutePath(TestPathHelper.VALIDATOR_TEST_MSP_1));
		file = SpecificationValidatorMSP.validateSpecification(file);
		assertEquals(spec, file.getAbsolutePath());
	}

	@Test
	public void testValidateAgilentSpecification_3() {

		file = new File(PathResolver.getAbsolutePath(TestPathHelper.VALIDATOR_TEST_MSP_2));
		file = SpecificationValidatorMSP.validateSpecification(file);
		assertEquals(spec, file.getAbsolutePath());
	}

	@Test
	public void testValidateAgilentSpecification_4() {

		file = new File(PathResolver.getAbsolutePath(TestPathHelper.VALIDATOR_TEST_MSP_3));
		file = SpecificationValidatorMSP.validateSpecification(file);
		assertEquals(spec, file.getAbsolutePath());
	}
}
