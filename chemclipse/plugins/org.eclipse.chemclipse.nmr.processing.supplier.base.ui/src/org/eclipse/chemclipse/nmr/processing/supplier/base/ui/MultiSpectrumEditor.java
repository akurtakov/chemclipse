/*******************************************************************************
 * Copyright (c) 2019, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Christoph Läubrich - initial API and implementation
 * Philip Wenig - adjustments
 *******************************************************************************/
package org.eclipse.chemclipse.nmr.processing.supplier.base.ui;

import org.eclipse.chemclipse.processing.ProcessorFactory;
import org.eclipse.chemclipse.ux.extension.xxd.ui.swt.ExtendedNMROverlayUI;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;

public class MultiSpectrumEditor {

	private ExtendedNMROverlayUI extendedNMROverlayUI;
	private NMRSpectrumSelection measurementsUI;
	@Inject
	private ProcessorFactory filterFactory;

	@Inject
	public MultiSpectrumEditor() {

	}

	@PostConstruct
	public void postConstruct(Composite parent) {

		SashForm sashForm = new SashForm(parent, SWT.HORIZONTAL);
		Composite left = new Composite(sashForm, SWT.NONE);
		left.setLayout(new FillLayout());
		Composite right = new Composite(sashForm, SWT.NONE);
		right.setLayout(new FillLayout());
		sashForm.setWeights(800, 200);
		extendedNMROverlayUI = new ExtendedNMROverlayUI(left, SWT.NONE);
		measurementsUI = new NMRSpectrumSelection(right, filterFactory);
	}

	@PreDestroy
	public void preDestroy() {

	}

	@Persist
	public void save() {

	}

	@Focus
	public void onFocus() {

		extendedNMROverlayUI.update();
		measurementsUI.update(extendedNMROverlayUI.getSelections());
	}
}
