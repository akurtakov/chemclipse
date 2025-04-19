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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InstrumentNameListUtil {

	public static final String SEPARATOR_TOKEN = ";";

	public String createList(String[] items) {

		List<String> instrumentList = getInstruments(items);
		String instruments = "";
		for(String instrument : instrumentList) {
			instruments = instruments.concat(instrument + SEPARATOR_TOKEN);
		}
		return instruments;
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

	public List<String> getInstruments(String preferenceEntry) {

		List<String> instruments = new ArrayList<String>();
		if(preferenceEntry != "") {
			String[] items = parseString(preferenceEntry);
			if(items.length > 0) {
				for(String item : items) {
					instruments.add(item);
				}
			}
		}
		Collections.sort(instruments);
		return instruments;
	}

	private List<String> getInstruments(String[] items) {

		List<String> instruments = new ArrayList<String>();
		if(items != null) {
			int size = items.length;
			for(int i = 0; i < size; i++) {
				instruments.add(items[i]);
			}
		}
		return instruments;
	}
}
