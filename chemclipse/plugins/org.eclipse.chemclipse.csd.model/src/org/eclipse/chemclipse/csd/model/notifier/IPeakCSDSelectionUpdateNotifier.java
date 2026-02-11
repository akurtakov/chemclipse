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
package org.eclipse.chemclipse.csd.model.notifier;

import org.eclipse.chemclipse.csd.model.core.IPeakCSD;

public interface IPeakCSDSelectionUpdateNotifier {

	/**
	 * If some changes have been occurred, this method will inform about the
	 * changed peak selection instance.<br/>
	 * Each implementing class has to decide, which information of the selection
	 * should be used (draw the chromatogram?, draw the scan? ...).<br/>
	 * Use forceUpdate to inform the listeners that substantial information has
	 * been changed.<br/>
	 * Why and when use it? Think of GUI elements which store representations of
	 * the chromatogram model.<br/>
	 * In a normal retention time selection change, the model do not need to be
	 * reloaded.<br/>
	 * But if the chromatogram itself has been modified (background remove), the
	 * GUI model needs to be reloaded to show correct values.
	 */
	void update(IPeakCSD peakFID, boolean forceReload);
}
