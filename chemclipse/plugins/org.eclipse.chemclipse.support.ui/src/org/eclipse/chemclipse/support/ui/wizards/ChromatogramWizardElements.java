/*******************************************************************************
 * Copyright (c) 2016, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.support.ui.wizards;

import java.util.ArrayList;
import java.util.List;

public class ChromatogramWizardElements extends WizardElements implements IChromatogramWizardElements {

	private List<String> selectedChromatograms;

	public ChromatogramWizardElements() {

		selectedChromatograms = new ArrayList<>();
	}

	@Override
	public void addElements(IChromatogramWizardElements chromatogramWizardElements) {

		if(chromatogramWizardElements != null) {
			selectedChromatograms.addAll(chromatogramWizardElements.getSelectedChromatograms());
		}
	}

	@Override
	public List<String> getSelectedChromatograms() {

		return selectedChromatograms;
	}

	@Override
	public void clearSelectedChromatograms() {

		selectedChromatograms.clear();
	}

	@Override
	public void addSelectedChromatogram(String selectedChromatogram) {

		selectedChromatograms.add(selectedChromatogram);
	}
}
