/*******************************************************************************
 * Copyright (c) 2008, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.model.core.support;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.eclipse.chemclipse.model.support.IIntegrationConstraints;
import org.eclipse.chemclipse.model.support.IntegrationConstraint;
import org.eclipse.chemclipse.model.support.IntegrationConstraints;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class IntegrationConstraints_1_Test {

	private IIntegrationConstraints integrationConstraints;
	private IntegrationConstraint constraint;

	@BeforeAll
	public void setUp() {

		integrationConstraints = new IntegrationConstraints();
		constraint = IntegrationConstraint.LEAVE_PEAK_AS_IT_IS;
	}

	@Test
	public void testHasIntegrationConstraint_1() {

		assertFalse(integrationConstraints.hasIntegrationConstraint(constraint));
	}

	@Test
	public void testHasIntegrationConstraint_2() {

		integrationConstraints.add(constraint);
		assertTrue(integrationConstraints.hasIntegrationConstraint(constraint));
	}

	@Test
	public void testHasIntegrationConstraint_3() {

		integrationConstraints.add(constraint);
		integrationConstraints.add(constraint);
		assertTrue(integrationConstraints.hasIntegrationConstraint(constraint));
	}

	@Test
	public void testHasIntegrationConstraint_4() {

		integrationConstraints.add(constraint);
		integrationConstraints.remove(constraint);
		assertFalse(integrationConstraints.hasIntegrationConstraint(constraint));
	}

	@Test
	public void testHasIntegrationConstraint_5() {

		integrationConstraints.add(constraint);
		integrationConstraints.add(constraint);
		integrationConstraints.remove(constraint);
		assertFalse(integrationConstraints.hasIntegrationConstraint(constraint));
	}

	@Test
	public void testHasIntegrationConstraint_6() {

		integrationConstraints.add(constraint);
		integrationConstraints.add(constraint);
		integrationConstraints.removeAll();
		assertFalse(integrationConstraints.hasIntegrationConstraint(constraint));
	}
}
