/*******************************************************************************
 * Copyright (c) 2020, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.assets.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;

import org.junit.jupiter.api.Test;

public class AssetItem_1_Test {

	@Test
	public void test1() {

		AssetItem assetItem = new AssetItem(new File(""), AssetType.CONFIGURATION);
		assertNotNull(assetItem);
		assertNotNull(assetItem.getFile());
		assertEquals(AssetType.CONFIGURATION, assetItem.getAssetType());
	}
}