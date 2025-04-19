/*******************************************************************************
 * Copyright (c) 2011, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.peak.detector.supplier.manual.ui.handlers;

import java.util.ArrayList;
import java.util.List;

import jakarta.inject.Named;

import org.eclipse.chemclipse.rcp.app.ui.handlers.PerspectiveSwitchHandler;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;

public class DetectorHandlerMSD {

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_PART) MPart part) {

		/*
		 * Try to select and show the perspective and view.
		 */
		String perspectiveId = "org.eclipse.chemclipse.chromatogram.xxd.peak.detector.supplier.manual.ui.perspective";
		List<String> viewIds = new ArrayList<String>();
		viewIds.add("org.eclipse.chemclipse.chromatogram.xxd.peak.detector.supplier.manual.ui.views.manualDetectedPeakMSD");
		viewIds.add("org.eclipse.chemclipse.chromatogram.xxd.peak.detector.supplier.manual.ui.views.chromatogramSelectionView");
		PerspectiveSwitchHandler.focusPerspectiveAndView(perspectiveId, viewIds);
	}
}
