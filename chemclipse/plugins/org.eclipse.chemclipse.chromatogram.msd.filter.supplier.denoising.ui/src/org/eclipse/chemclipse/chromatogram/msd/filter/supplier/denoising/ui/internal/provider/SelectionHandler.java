/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Christoph Läubrich - change to new API
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.msd.filter.supplier.denoising.ui.internal.provider;

import org.eclipse.chemclipse.msd.model.core.ICombinedMassSpectrum;
import org.eclipse.chemclipse.swt.ui.notifier.UpdateNotifierUI;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.widgets.Display;

public class SelectionHandler implements ISelectionChangedListener {

	@Override
	public void selectionChanged(SelectionChangedEvent event) {

		ISelection selection = event.getSelection();
		if(selection instanceof IStructuredSelection structuredSelection) {
			Object element = structuredSelection.getFirstElement();
			if(element instanceof ICombinedMassSpectrum combinedMassSpectrum) {
				UpdateNotifierUI.update(Display.getDefault(), combinedMassSpectrum);
			}
		}
	}
}
