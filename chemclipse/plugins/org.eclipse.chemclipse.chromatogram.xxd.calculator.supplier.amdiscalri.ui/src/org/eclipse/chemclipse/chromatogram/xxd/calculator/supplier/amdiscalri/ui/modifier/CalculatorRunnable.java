/*******************************************************************************
 * Copyright (c) 2014, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.ui.modifier;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.chemclipse.chromatogram.xxd.calculator.core.chromatogram.ChromatogramCalculator;
import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.settings.CalculatorSettings;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.ui.support.ProcessingInfoPartSupport;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Display;

public class CalculatorRunnable implements IRunnableWithProgress {

	private static final String CALCULATOR_ID = "org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri";
	private IChromatogramSelection chromatogramSelection;

	public CalculatorRunnable(IChromatogramSelection chromatogramSelection) {

		this.chromatogramSelection = chromatogramSelection;
	}

	@Override
	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {

		try {
			monitor.beginTask("Retention Index Calculator", IProgressMonitor.UNKNOWN);
			CalculatorSettings settings = PreferenceSupplier.getChromatogramCalculatorSettings();
			IProcessingInfo<?> processingInfo = ChromatogramCalculator.applyCalculator(chromatogramSelection, settings, CALCULATOR_ID, monitor);
			ProcessingInfoPartSupport.getInstance().update(processingInfo, false);
			updateSelection();
		} finally {
			monitor.done();
		}
	}

	/*
	 * Updates the selection using the GUI thread.
	 */
	private void updateSelection() {

		Display.getDefault().asyncExec(() -> chromatogramSelection.update(true));
	}
}
