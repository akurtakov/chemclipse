/*******************************************************************************
 * Copyright (c) 2012, 2026 Lablicate GmbH.
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
import java.io.IOException;

import org.eclipse.chemclipse.converter.PathResolver;
import org.eclipse.chemclipse.msd.converter.supplier.amdis.TestPathHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.osgi.framework.FrameworkUtil;

@TestInstance(Lifecycle.PER_CLASS)
public class SpecificationValidatorMSP_1_Test {

	private File file;
	private String spec;

	@BeforeAll
	public void setUp() throws IOException {

		spec = PathResolver.getFile(FrameworkUtil.getBundle(getClass()), TestPathHelper.VALIDATOR_TEST_SPEC_MSP).getAbsolutePath();
	}

	@Test
	public void testValidateSpecification_1() throws IOException {

		file = PathResolver.getFile(FrameworkUtil.getBundle(getClass()), TestPathHelper.VALIDATOR_TEST_MSP_1);
		file = SpecificationValidatorMSP.validateSpecification(file);
		assertEquals(spec, file.getAbsolutePath());
	}

	@Test
	public void testValidateSpecification_3() throws IOException {

		file = PathResolver.getFile(FrameworkUtil.getBundle(getClass()), TestPathHelper.VALIDATOR_TEST_MSP_2);
		file = SpecificationValidatorMSP.validateSpecification(file);
		assertEquals(spec, file.getAbsolutePath());
	}

	@Test
	public void testValidateSpecification_4() throws IOException {

		file = PathResolver.getFile(FrameworkUtil.getBundle(getClass()), TestPathHelper.VALIDATOR_TEST_MSP_3);
		file = SpecificationValidatorMSP.validateSpecification(file);
		assertEquals(spec, file.getAbsolutePath());
	}
}
