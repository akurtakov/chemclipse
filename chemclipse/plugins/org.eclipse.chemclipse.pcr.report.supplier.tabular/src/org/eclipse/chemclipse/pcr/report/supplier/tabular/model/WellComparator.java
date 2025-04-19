/*******************************************************************************
 * Copyright (c) 2021, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.pcr.report.supplier.tabular.model;

import java.util.Comparator;

import org.eclipse.chemclipse.pcr.model.core.IWell;

public class WellComparator implements Comparator<IWell> {

	@Override
	public int compare(IWell firstWell, IWell secondWell) {

		if(firstWell.getSampleName().equals(secondWell.getSampleName())) {
			return firstWell.getPosition().compareTo(secondWell.getPosition());
		}
		return firstWell.getSampleName().compareTo(secondWell.getSampleName());
	}
}
