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
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.xxd.ui.swt;

public interface PeakScanListUIConfig extends IToolbarConfig, TableConfig {

	/**
	 * Defines how the UI interacts with the Chromatogram selection
	 *
	 */
	enum InteractionMode {
		/**
		 * No interaction
		 */
		NONE,
		/**
		 * The UI is the source of selections
		 */
		SOURCE,
		/**
		 * The UI is the sink of selections
		 */
		SINK,
		/**
		 * the UI is the source and the sink of selections
		 */
		BIDIRECTIONAL;
	}

	/**
	 * Sets whether this list displays scans
	 * 
	 * @param inRange
	 *            if true only select in given range, ignored when show is false
	 */
	void setShowScans(boolean show, boolean inRange);

	/**
	 * Sets whether this list displays peaks
	 * 
	 * @param inRange
	 *            if true only select in given range, ignored when show is false
	 */
	void setShowPeaks(boolean show, boolean inRange);

	void setMoveRetentionTimeOnPeakSelection(boolean enabled);

	/**
	 * The interaction mode to use
	 */
	void setInteractionMode(InteractionMode interactionMode);
}
