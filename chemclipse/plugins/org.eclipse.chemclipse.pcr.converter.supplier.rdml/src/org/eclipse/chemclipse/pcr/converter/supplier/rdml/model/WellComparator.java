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
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.pcr.converter.supplier.rdml.model;

import java.util.Comparator;

import org.eclipse.chemclipse.pcr.model.core.IWell;

public class WellComparator implements Comparator<IWell> {

	@Override
	public int compare(IWell firstWell, IWell secondWell) {

		int columnComparison = Integer.compare(firstWell.getPosition().getColumn(), secondWell.getPosition().getColumn());
		if(columnComparison != 0) {
			return columnComparison;
		} else {
			return firstWell.getPosition().getRow().compareTo(secondWell.getPosition().getRow());
		}
	}
}
