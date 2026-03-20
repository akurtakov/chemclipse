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

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class TargetTracesSerializer extends JsonSerializer<TargetTraces> {

	@Override
	public void serialize(TargetTraces targetTraces, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

		if(targetTraces != null) {
			jsonGenerator.writeString(targetTraces.save());
		} else {
			jsonGenerator.writeString("");
		}
	}
}
