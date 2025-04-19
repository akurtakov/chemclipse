/*******************************************************************************
 * Copyright (c) 2015, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.processor;

import org.eclipse.chemclipse.model.selection.IChromatogramSelection;

public abstract class AbstractChromatogramProcessor implements IChromatogramProcessor {

	private IChromatogramSelection chromatogramSelection;

	public AbstractChromatogramProcessor(IChromatogramSelection chromatogramSelection) {

		this.chromatogramSelection = chromatogramSelection;
	}

	@Override
	public IChromatogramSelection getChromatogramSelection() {

		return chromatogramSelection;
	}
}
