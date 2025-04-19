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
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.comparators;

import java.util.Comparator;

import org.eclipse.chemclipse.processing.supplier.IProcessTypeSupplier;

public class TypeCategoryComparator implements Comparator<IProcessTypeSupplier> {

	@Override
	public int compare(IProcessTypeSupplier supplier1, IProcessTypeSupplier supplier2) {

		return supplier1.getCategory().compareTo(supplier2.getCategory());
	}
}
