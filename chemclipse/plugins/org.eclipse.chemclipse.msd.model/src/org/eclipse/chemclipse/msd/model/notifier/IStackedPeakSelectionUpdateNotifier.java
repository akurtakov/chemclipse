/*******************************************************************************
 * Copyright (c) 2013, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.model.notifier;

import java.util.List;

import org.eclipse.chemclipse.msd.model.core.IPeakMSD;

public interface IStackedPeakSelectionUpdateNotifier {

	void update(List<IPeakMSD> peakListMSD, boolean forceReload);
}
