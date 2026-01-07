/*******************************************************************************
 * Copyright (c) 2023, 2026 Lablicate GmbH.
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

import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.model.RetentionIndexAssigner;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class RetentionIndexAssignerDeserializer extends JsonDeserializer<RetentionIndexAssigner> {

	@Override
	public RetentionIndexAssigner deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {

		RetentionIndexAssigner retentionIndexAssigner = new RetentionIndexAssigner();
		retentionIndexAssigner.load(jsonParser.getText());
		return retentionIndexAssigner;
	}
}
