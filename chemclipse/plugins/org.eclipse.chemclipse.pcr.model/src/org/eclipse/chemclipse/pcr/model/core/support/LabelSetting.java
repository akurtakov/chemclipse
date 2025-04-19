/*******************************************************************************
 * Copyright (c) 2021, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.pcr.model.core.support;

import org.eclipse.chemclipse.pcr.model.l10n.Messages;
import org.eclipse.chemclipse.support.text.ILabel;

public enum LabelSetting implements ILabel {
	SAMPLENAME(Messages.sampleID), //
	COORDINATE(Messages.coordinate), //
	COORDINATE_SAMPLENAME(Messages.sampleCoordinate); //

	private String label = ""; //$NON-NLS-1$

	private LabelSetting(String label) {

		this.label = label;
	}

	@Override
	public String label() {

		return label;
	}

	public static String[][] getOptions() {

		return ILabel.getOptions(values());
	}
}
