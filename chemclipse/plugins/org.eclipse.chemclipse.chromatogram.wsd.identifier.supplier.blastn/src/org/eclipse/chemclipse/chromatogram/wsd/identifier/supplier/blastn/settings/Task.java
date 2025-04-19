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
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.wsd.identifier.supplier.blastn.settings;

import org.eclipse.chemclipse.support.text.ILabel;

public enum Task implements ILabel {

	BLASTN("blastn", "BLASTN"), //
	BLASTN_SHORT("blastn-short", "short sequence BLASTN"), //
	MEGABLAST("megablast", "MegaBLAST"), //
	DC_MEGABLAST("dc-megablast", "discontiguous MegaBLAST"); //

	private String label = "";
	private String value = "";

	private Task(String value, String label) {

		this.value = value;
		this.label = label;
	}

	@Override
	public String label() {

		return label;
	}

	public String value() {

		return value;
	}

	public static String[][] getOptions() {

		return ILabel.getOptions(values());
	}
}