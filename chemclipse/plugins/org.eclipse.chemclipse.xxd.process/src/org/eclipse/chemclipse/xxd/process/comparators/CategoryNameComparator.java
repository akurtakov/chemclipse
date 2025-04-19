/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Christoph Läubrich - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.comparators;

import java.util.Comparator;

import org.eclipse.chemclipse.processing.supplier.IProcessSupplier;

public class CategoryNameComparator implements Comparator<IProcessSupplier<?>> {

	private static final NameComparator NAME = new NameComparator();
	private static final CategoryComparator CATEGORY = new CategoryComparator();

	@Override
	public int compare(IProcessSupplier<?> o1, IProcessSupplier<?> o2) {

		int cmp = CATEGORY.compare(o1, o2);
		if(cmp == 0) {
			cmp = NAME.compare(o1, o2);
		}
		return cmp;
	}
}
