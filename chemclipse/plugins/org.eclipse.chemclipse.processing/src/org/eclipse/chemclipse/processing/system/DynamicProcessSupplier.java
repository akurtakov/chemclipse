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
package org.eclipse.chemclipse.processing.system;

import org.eclipse.chemclipse.processing.DataCategory;
import org.eclipse.chemclipse.processing.supplier.AbstractProcessSupplier;

public class DynamicProcessSupplier extends AbstractProcessSupplier<DynamicProcessSettings> {

	public DynamicProcessSupplier(String id, String name, String description) {

		super(id, name, description, DynamicProcessSettings.class, null, DataCategory.chromatographyCategories());
	}

	@Override
	public String getCategory() {

		return "Dynamic Methods";
	}
}