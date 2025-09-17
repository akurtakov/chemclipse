/*******************************************************************************
 * Copyright (c) 2020, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.swt.ui.components.massspectrum;

import org.eclipse.chemclipse.msd.model.core.IRegularMassSpectrum;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class ExtendedMassSpectrumPeakListUI extends Composite {

	private MassSpectrumPeakListUI massSpectrumPeaksListUI;

	public ExtendedMassSpectrumPeakListUI(Composite parent, int style) {

		super(parent, style);
		createControl();
	}

	public void update(IRegularMassSpectrum regularMassSpectrum) {

		massSpectrumPeaksListUI.update(regularMassSpectrum);
	}

	private void createControl() {

		setLayout(new FillLayout());
		massSpectrumPeaksListUI = new MassSpectrumPeakListUI(this, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.VIRTUAL);
	}
}
