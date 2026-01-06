/*******************************************************************************
 * Copyright (c) 2013, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.quantitation;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class QuantitationSignals extends TreeSet<IQuantitationSignal> implements IQuantitationSignals {

	private static final long serialVersionUID = 6123008658126987673L;

	@Override
	public List<Double> getSelectedSignals() {

		List<Double> signals = new ArrayList<>();
		for(IQuantitationSignal quantitationSignal : this) {
			/*
			 * Only selected signals shall be returned.
			 */
			if(quantitationSignal.isUse()) {
				signals.add(quantitationSignal.getSignal());
			}
		}
		return signals;
	}

	@Override
	public void deselectAllSignals() {

		setSignalsUse(false);
	}

	@Override
	public void selectAllSignals() {

		setSignalsUse(true);
	}

	@Override
	public void selectSignal(double signal) {

		/**
		 * The list isn't that big. But a hash map would be better.
		 * The action will be performed not very often, hence it's ok.
		 */
		for(IQuantitationSignal quantitationSignal : this) {
			if(quantitationSignal.getSignal() == signal) {
				quantitationSignal.setUse(true);
			}
		}
	}

	private void setSignalsUse(boolean use) {

		for(IQuantitationSignal quantitationSignal : this) {
			quantitationSignal.setUse(use);
		}
	}
}
