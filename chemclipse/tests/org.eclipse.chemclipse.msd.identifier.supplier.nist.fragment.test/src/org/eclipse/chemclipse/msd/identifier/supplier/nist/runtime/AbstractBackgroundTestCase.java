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
package org.eclipse.chemclipse.msd.identifier.supplier.nist.runtime;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@Disabled
@TestInstance(Lifecycle.PER_CLASS)
public abstract class AbstractBackgroundTestCase {

	List<String> parameterBackground = new ArrayList<>();

	@BeforeAll
	public void setUp() throws FileNotFoundException, IOException {

		parameterBackground.add(INistSupport.INSTRUMENT);
		parameterBackground.add(INistSupport.PAR2);
	}
}
