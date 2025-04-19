/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Christoph Läubrich - Adjust to new API
 *******************************************************************************/
package org.eclipse.chemclipse.converter.scan;

import org.eclipse.chemclipse.converter.core.AbstractConverterSupport;
import org.eclipse.chemclipse.processing.DataCategory;

public class ScanConverterSupport extends AbstractConverterSupport implements IScanConverterSupport {

	private final DataCategory category;

	public ScanConverterSupport(DataCategory category) {

		this.category = category;
	}

	@Override
	public DataCategory getDataCategory() {

		return category;
	}
}