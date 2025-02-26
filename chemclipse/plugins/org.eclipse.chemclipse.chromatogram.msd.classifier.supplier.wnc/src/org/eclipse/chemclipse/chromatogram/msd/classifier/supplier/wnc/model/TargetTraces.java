/*******************************************************************************
 * Copyright (c) 2011, 2025 Lablicate GmbH.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.model;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TargetTraces {

	private Map<Integer, TargetTrace> ions;

	public TargetTraces() {

		ions = new TreeMap<>();
	}

	public void add(TargetTrace targetTrace) {

		if(targetTrace != null) {
			ions.put(targetTrace.getIon(), targetTrace);
		}
	}

	public void remove(TargetTrace targetTrace) {

		if(targetTrace != null) {
			remove(targetTrace.getIon());
		}
	}

	public void remove(Integer ion) {

		ions.remove(ion);
	}

	public TargetTrace getTargetTrace(int ion) {

		return ions.get(ion);
	}

	public Object[] toArray() {

		return ions.values().toArray();
	}

	public void add(TargetTraces targetTraces) {

		Set<Integer> keys = targetTraces.getKeys();
		for(Integer key : keys) {
			ions.put(key, targetTraces.getTargetTrace(key));
		}
	}

	public Set<Integer> getKeys() {

		return ions.keySet();
	}
}