/*******************************************************************************
 * Copyright (c) 2022, 2025 Lablicate GmbH.
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

import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.model.RetentionIndexMarker;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class RetentionIndexMarkerSerializer extends JsonSerializer<RetentionIndexMarker> {

	@Override
	public void serialize(RetentionIndexMarker retentionIndexMarker, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

		if(retentionIndexMarker != null) {
			jsonGenerator.writeString(retentionIndexMarker.save());
		} else {
			jsonGenerator.writeString("");
		}
	}
}