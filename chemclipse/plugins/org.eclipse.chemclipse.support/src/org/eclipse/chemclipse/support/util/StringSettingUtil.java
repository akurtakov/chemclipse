/*******************************************************************************
 * Copyright (c) 2013, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.support.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StringSettingUtil implements IStringSerialization<String[]> {

	private ObjectMapper objectMapper;

	public StringSettingUtil() {

		objectMapper = new ObjectMapper();
	}

	@Override
	public String serialize(List<String[]> data) {

		String[][] savaData = data.stream().toArray(String[][]::new);
		try {
			return objectMapper.writeValueAsString(savaData);
		} catch(JsonProcessingException e) {
		}
		return "";
	}

	@Override
	public List<String[]> deserialize(String data) {

		List<String[]> deserialize = new ArrayList<>();
		if(data != null && !data.isEmpty()) {
			try {
				Arrays.stream(objectMapper.readValue(data, String[][].class)).forEach(deserialize::add);
			} catch(IOException e) {
			}
		}
		return new ArrayList<>();
	}
}
