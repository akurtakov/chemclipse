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
package org.eclipse.chemclipse.chromatogram.xxd.integrator.core.settings;

import org.eclipse.chemclipse.chromatogram.xxd.integrator.core.settings.peaks.ISettingStatus;

import junit.framework.TestCase;

public class SettingStatus_1_Test extends TestCase {

	private ISettingStatus settingStatus;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void testStatus_1() {

		settingStatus = new SettingStatus(true, true);
		assertTrue("Report", settingStatus.report());
		assertTrue("SumOn", settingStatus.sumOn());
	}

	public void testStatus_2() {

		settingStatus = new SettingStatus(true, false);
		assertTrue("Report", settingStatus.report());
		assertFalse("SumOn", settingStatus.sumOn());
	}

	public void testStatus_3() {

		settingStatus = new SettingStatus(false, true);
		assertFalse("Report", settingStatus.report());
		assertTrue("SumOn", settingStatus.sumOn());
	}

	public void testStatus_4() {

		settingStatus = new SettingStatus(false, false);
		assertFalse("Report", settingStatus.report());
		assertFalse("SumOn", settingStatus.sumOn());
	}
}
