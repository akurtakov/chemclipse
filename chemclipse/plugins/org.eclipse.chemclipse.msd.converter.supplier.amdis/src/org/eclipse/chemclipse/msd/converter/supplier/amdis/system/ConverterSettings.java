/*******************************************************************************
 * Copyright (c) 2021, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.converter.supplier.amdis.system;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.eclipse.chemclipse.processing.system.ISystemProcessSettings;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class ConverterSettings implements ISystemProcessSettings {

	@JsonProperty(value = "Charset Import MSL", defaultValue = "US_ASCII")
	@JsonPropertyDescription(value = "The following charset is used to import the *.msl files.")
	private Charset charsetImportMSL = StandardCharsets.US_ASCII;
	@JsonProperty(value = "Charset Import MSP", defaultValue = "US_ASCII")
	@JsonPropertyDescription(value = "The following charset is used to import the *.msp files.")
	private Charset charsetImportMSP = StandardCharsets.US_ASCII;
	@JsonProperty(value = "Charset Import FIN", defaultValue = "US_ASCII")
	@JsonPropertyDescription(value = "The following charset is used to import the *.fin files.")
	private Charset charsetImportFIN = StandardCharsets.US_ASCII;
	@JsonProperty(value = "Charset Import ELU", defaultValue = "US_ASCII")
	@JsonPropertyDescription(value = "The following charset is used to import the *.elu files.")
	private Charset charsetImportELU = StandardCharsets.US_ASCII;

	public Charset getCharsetImportMSL() {

		return charsetImportMSL;
	}

	public void setCharsetImportMSL(Charset charsetImportMSL) {

		this.charsetImportMSL = charsetImportMSL;
	}

	public Charset getCharsetImportMSP() {

		return charsetImportMSP;
	}

	public void setCharsetImportMSP(Charset charsetImportMSP) {

		this.charsetImportMSP = charsetImportMSP;
	}

	public Charset getCharsetImportFIN() {

		return charsetImportFIN;
	}

	public void setCharsetImportFIN(Charset charsetImportFIN) {

		this.charsetImportFIN = charsetImportFIN;
	}

	public Charset getCharsetImportELU() {

		return charsetImportELU;
	}

	public void setCharsetImportELU(Charset charsetImportELU) {

		this.charsetImportELU = charsetImportELU;
	}
}