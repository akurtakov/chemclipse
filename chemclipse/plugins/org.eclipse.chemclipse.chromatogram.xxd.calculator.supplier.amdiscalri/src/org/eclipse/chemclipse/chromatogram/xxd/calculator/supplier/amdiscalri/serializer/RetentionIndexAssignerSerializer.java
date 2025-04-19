/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.serializer;

import java.io.IOException;

import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.model.RetentionIndexAssigner;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class RetentionIndexAssignerSerializer extends JsonSerializer<RetentionIndexAssigner> {

	@Override
	public void serialize(RetentionIndexAssigner retentionIndexAssigner, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

		if(retentionIndexAssigner != null) {
			jsonGenerator.writeString(retentionIndexAssigner.save());
		} else {
			jsonGenerator.writeString("");
		}
	}
}