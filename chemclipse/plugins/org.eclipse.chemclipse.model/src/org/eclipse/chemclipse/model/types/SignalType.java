/*******************************************************************************
 * Copyright (c) 2017, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.types;

import org.eclipse.chemclipse.support.text.ILabel;

public enum SignalType implements ILabel {

	AUTO_DETECT("Auto-Detect"), //
	CENTROID("Centroid"), //
	PROFILE("Profile");

	private String label = "";

	private SignalType(String label) {

		this.label = label;
	}

	@Override
	public String label() {

		return label;
	}
}
