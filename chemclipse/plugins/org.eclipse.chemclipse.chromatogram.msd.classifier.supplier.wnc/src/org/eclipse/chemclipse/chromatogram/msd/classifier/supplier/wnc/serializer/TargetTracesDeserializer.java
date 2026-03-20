/*******************************************************************************
 * Copyright (c) 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.serializer;

import java.io.IOException;

import org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.model.TargetTraces;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class TargetTracesDeserializer extends JsonDeserializer<TargetTraces> {

	@Override
	public TargetTraces deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {

		TargetTraces targetTraces = new TargetTraces();
		targetTraces.load(jsonParser.getText());
		return targetTraces;
	}
}
