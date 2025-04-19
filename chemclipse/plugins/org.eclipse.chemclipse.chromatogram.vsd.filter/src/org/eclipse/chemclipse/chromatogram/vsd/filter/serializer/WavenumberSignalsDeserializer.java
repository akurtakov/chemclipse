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

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class WavenumberSignalsDeserializer extends JsonDeserializer<WavenumberSignals> {

	@Override
	public WavenumberSignals deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

		WavenumberSignals settings = new WavenumberSignals();
		settings.load(jsonParser.getText());
		return settings;
	}
}