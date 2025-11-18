/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.filter.internal.model;

import org.eclipse.chemclipse.model.core.IScan;

/**
 * Used when transferring scan targets to peaks.
 */
public class IdentifiedScan {

	private IScan scan = null;
	private boolean assigned = false;

	public IdentifiedScan(IScan scan) {

		this.scan = scan;
	}

	public boolean isAssigned() {

		return assigned;
	}

	public void setAssigned(boolean assigned) {

		this.assigned = assigned;
	}

	public IScan getScan() {

		return scan;
	}
}