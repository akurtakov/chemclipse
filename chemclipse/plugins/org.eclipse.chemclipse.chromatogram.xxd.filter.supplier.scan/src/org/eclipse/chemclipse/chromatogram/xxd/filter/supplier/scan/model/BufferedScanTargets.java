/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.model;

import java.util.Set;
import java.util.TreeMap;

import org.eclipse.chemclipse.model.identifier.IIdentificationTarget;

public class BufferedScanTargets {

	public static final String NAME = "Buffered Scan Targets";
	public static final String IDENTIFIER = BufferedScanTargets.class.getCanonicalName();
	public static final String DESCRIPTION = "Buffer of all identified scan targets.";

	private TreeMap<Integer, Set<IIdentificationTarget>> mappedTargets = new TreeMap<>();

	public TreeMap<Integer, Set<IIdentificationTarget>> getMappedTargets() {

		return mappedTargets;
	}
}