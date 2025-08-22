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

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ClassificationDictionaryDeserializer extends JsonDeserializer<ClassificationDictionary> {

	@Override
	public ClassificationDictionary deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {

		ClassificationDictionary classificationDictionary = new ClassificationDictionary();
		classificationDictionary.load(jsonParser.getText());

		return classificationDictionary;
	}
}