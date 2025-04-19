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
package org.eclipse.chemclipse.chromatogram.vsd.filter.serializer;

import java.io.IOException;

import org.eclipse.chemclipse.chromatogram.vsd.filter.model.WavenumberSignals;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class WavenumberSignalsSerializer extends JsonSerializer<WavenumberSignals> {

	@Override
	public void serialize(WavenumberSignals settings, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

		if(settings != null) {
			jsonGenerator.writeString(settings.save());
		} else {
			jsonGenerator.writeString("");
		}
	}
}