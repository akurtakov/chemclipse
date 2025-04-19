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
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.classification.serializer;

import java.io.IOException;

import org.eclipse.chemclipse.xxd.classification.model.ClassificationDictionary;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class ClassificationDictionarySerializer extends JsonSerializer<ClassificationDictionary> {

	@Override
	public void serialize(ClassificationDictionary classifcationDictionary, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

		if(classifcationDictionary != null) {
			jsonGenerator.writeString(classifcationDictionary.save());
		} else {
			jsonGenerator.writeString("");
		}
	}
}