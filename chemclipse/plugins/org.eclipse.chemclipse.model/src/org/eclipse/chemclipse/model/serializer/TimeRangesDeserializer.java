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
package org.eclipse.chemclipse.model.serializer;

import java.io.IOException;

import org.eclipse.chemclipse.model.ranges.TimeRanges;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class TimeRangesDeserializer extends JsonDeserializer<TimeRanges> {

	@Override
	public TimeRanges deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {

		TimeRanges timeRanges = new TimeRanges();
		timeRanges.load(jsonParser.getText());
		//
		return timeRanges;
	}
}