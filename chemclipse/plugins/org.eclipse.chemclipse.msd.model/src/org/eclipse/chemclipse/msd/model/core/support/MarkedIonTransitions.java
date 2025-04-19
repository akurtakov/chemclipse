/*******************************************************************************
 * Copyright (c) 2013, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.model.core.support;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.chemclipse.msd.model.core.IIonTransition;

public class MarkedIonTransitions implements IMarkedIonTransitions {

	private Set<IMarkedIonTransition> markedIonTransitions;

	public MarkedIonTransitions() {
		markedIonTransitions = new HashSet<IMarkedIonTransition>();
	}

	public MarkedIonTransitions(Set<IIonTransition> ionTransitions) {
		this();
		for(IIonTransition ionTransition : ionTransitions) {
			IMarkedIonTransition markedIonTransition = new MarkedIonTransition(ionTransition);
			markedIonTransitions.add(markedIonTransition);
		}
	}

	@Override
	public Set<IIonTransition> getSelectedIonTransitions() {

		Set<IIonTransition> ionTransitions = new HashSet<IIonTransition>();
		for(IMarkedIonTransition markedIonTransition : markedIonTransitions) {
			if(markedIonTransition.isSelected()) {
				ionTransitions.add(markedIonTransition.getIonTransition());
			}
		}
		return ionTransitions;
	}

	@Override
	public Set<IMarkedIonTransition> getAll() {

		return markedIonTransitions;
	}
}
