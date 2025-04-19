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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FileSettingUtil implements IStringSerialization<File> {

	private ObjectMapper objectMapper;

	public FileSettingUtil() {

		objectMapper = new ObjectMapper();
	}

	@Override
	public String serialize(List<File> data) {

		String[] savaData = data.stream().map(File::getAbsolutePath).toArray(String[]::new);
		try {
			return objectMapper.writeValueAsString(savaData);
		} catch(JsonProcessingException e) {
		}
		return "";
	}

	@Override
	public List<File> deserialize(String data) {

		if(data != null && !data.isEmpty()) {
			try {
				return Arrays.stream(objectMapper.readValue(data, String[].class)).map(File::new).collect(Collectors.toList());
			} catch(IOException e) {
			}
		}
		return new ArrayList<>();
	}
}
