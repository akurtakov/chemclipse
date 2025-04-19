/*******************************************************************************
 * Copyright (c) 2016, 2025 Lablicate GmbH.
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileListUtil {

	public static final String SEPARATOR_TOKEN = ";";

	public String createList(String[] items) {

		List<String> fileList = getFileList(items);
		String files = "";
		for(String file : fileList) {
			files = files.concat(file + SEPARATOR_TOKEN);
		}
		return files;
	}

	public String[] parseString(String stringList) {

		String[] decodedArray;
		if(stringList.contains(SEPARATOR_TOKEN)) {
			decodedArray = stringList.split(SEPARATOR_TOKEN);
		} else {
			decodedArray = new String[1];
			decodedArray[0] = stringList;
		}
		return decodedArray;
	}

	public List<String> getFiles(String preferenceEntry) {

		List<String> files = new ArrayList<>();
		if(!"".equals(preferenceEntry)) {
			String[] items = parseString(preferenceEntry);
			if(items.length > 0) {
				for(String item : items) {
					File file = new File(item);
					if(file.exists()) {
						files.add(item);
					}
				}
			}
		}
		Collections.sort(files);
		return files;
	}

	private List<String> getFileList(String[] items) {

		List<String> files = new ArrayList<>();
		if(items != null) {
			int size = items.length;
			for(int i = 0; i < size; i++) {
				File file = new File(items[i]);
				if(file.exists()) {
					files.add(items[i]);
				}
			}
		}
		return files;
	}
}
