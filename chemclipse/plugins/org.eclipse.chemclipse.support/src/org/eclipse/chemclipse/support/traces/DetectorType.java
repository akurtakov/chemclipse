/*******************************************************************************
 * Copyright (c) 2024, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.support.traces;

import org.eclipse.chemclipse.support.text.ILabel;

public enum DetectorType implements ILabel {

	AUTO("AUTO"), //
	MSD("MSD"), //
	VSD("VSD"), //
	WSD("WSD"); //

	private String label = "";

	private DetectorType(String label) {

		this.label = label;
	}

	@Override
	public String label() {

		return label;
	}
}