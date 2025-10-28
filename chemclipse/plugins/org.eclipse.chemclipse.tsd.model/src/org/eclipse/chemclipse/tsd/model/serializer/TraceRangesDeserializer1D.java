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
package org.eclipse.chemclipse.tsd.model.serializer;

import java.io.IOException;

import org.eclipse.chemclipse.tsd.model.core.TraceRanges1D;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class TraceRangesDeserializer1D extends JsonDeserializer<TraceRanges1D> {

	@Override
	public TraceRanges1D deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {

		TraceRanges1D traceRanges = new TraceRanges1D();
		traceRanges.load(jsonParser.getText());

		return traceRanges;
	}
}