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
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.pcr.converter.support;

import org.eclipse.chemclipse.converter.core.AbstractConverterSupport;
import org.eclipse.chemclipse.processing.DataCategory;

public class PlateConverterSupport extends AbstractConverterSupport implements IPlateConverterSupport {

	private final DataCategory dataCategory;

	public PlateConverterSupport(DataCategory dataCategory) {

		this.dataCategory = dataCategory;
	}

	@Override
	public DataCategory getDataCategory() {

		return dataCategory;
	}
}
