/*******************************************************************************
 * Copyright (c) 2008, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.identifier.supplier.nist.internal.results;

import java.util.ArrayList;
import java.util.List;

public class Compounds {

	private List<Compound> compounds;

	public Compounds() {
		compounds = new ArrayList<Compound>();
	}

	public void add(Compound compound) {

		compounds.add(compound);
	}

	public void remove(Compound compound) {

		compounds.remove(compound);
	}

	public List<Compound> getCompounds() {

		return compounds;
	}

	/**
	 * Returns the compound at the given index. The index starts at 1. If no
	 * compound is available, null will be returned.
	 * 
	 * @param index
	 * @return Compound
	 */
	public Compound getCompound(int index) {

		/*
		 * The user index starts with 1.
		 */
		index--;
		if(index >= 0 && index < compounds.size()) {
			return compounds.get(index);
		} else {
			return null;
		}
	}

	public int size() {

		return compounds.size();
	}
}
