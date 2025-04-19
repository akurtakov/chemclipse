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

public class CategoryComparator implements Comparator<IProcessSupplier<?>> {

	@Override
	public int compare(IProcessSupplier<?> supplier1, IProcessSupplier<?> supplier2) {

		return supplier1.getCategory().compareTo(supplier2.getCategory());
	}
}
