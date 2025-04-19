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
package org.eclipse.chemclipse.support.settings.serialization;

import java.io.IOException;

import org.eclipse.chemclipse.support.model.WindowSize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;

public class WindowSizeDeserializer extends StdScalarDeserializer<Object> {

	private static final long serialVersionUID = 1L;

	protected WindowSizeDeserializer() {

		super(Object.class);
	}

	@Override
	public Integer deserialize(JsonParser parser, DeserializationContext context) throws IOException {

		String text = parser.getText();
		int windowSize = WindowSize.getAdjustedSetting(text);
		return windowSize;
	}
}
