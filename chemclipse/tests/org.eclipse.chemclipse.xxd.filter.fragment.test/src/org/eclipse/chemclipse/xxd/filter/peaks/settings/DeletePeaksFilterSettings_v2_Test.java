/*******************************************************************************
 * Copyright (c) 2024, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.filter.peaks.settings;

import org.eclipse.chemclipse.xxd.filter.support.DeletePeakOption;

import junit.framework.TestCase;

public class DeletePeaksFilterSettings_v2_Test extends TestCase {

	private DeletePeaksFilterSettings settings;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		settings = new DeletePeaksFilterSettings();
	}

	public void test0() {

		settings.transferToLatestVersion("{\"Delete Peaks\":true}");
		assertEquals(DeletePeakOption.ALL, settings.getDeletePeakOption());
	}

	public void test1() {

		settings.transferToLatestVersion("{\"Delete Peaks\":false,\"Unidentified Only\":false,\"Inactive Only\":false}");
		assertEquals(DeletePeakOption.NONE, settings.getDeletePeakOption());
	}

	public void test2() {

		settings.transferToLatestVersion("{\"Delete Peaks\":false,\"Unidentified Only\":true,\"Inactive Only\":false}");
		assertEquals(DeletePeakOption.NONE, settings.getDeletePeakOption());
	}

	public void test3() {

		settings.transferToLatestVersion("{\"Delete Peaks\":true,\"Unidentified Only\":false,\"Inactive Only\":false}");
		assertEquals(DeletePeakOption.ALL, settings.getDeletePeakOption());
	}

	public void test4() {

		settings.transferToLatestVersion("{\"Delete Peaks\":true,\"Unidentified Only\":true,\"Inactive Only\":false}");
		assertEquals(DeletePeakOption.UNIDENTIFIED, settings.getDeletePeakOption());
	}

	public void test5() {

		settings.transferToLatestVersion("{\"Delete Peaks\":true,\"Unidentified Only\":false,\"Inactive Only\":true}");
		assertEquals(DeletePeakOption.INACTIVE, settings.getDeletePeakOption());
	}
}