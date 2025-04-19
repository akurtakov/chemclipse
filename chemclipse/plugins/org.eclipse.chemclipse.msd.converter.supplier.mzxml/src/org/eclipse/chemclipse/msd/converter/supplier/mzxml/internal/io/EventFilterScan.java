/*******************************************************************************
 * Copyright (c) 2015, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.converter.supplier.mzxml.internal.io;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.EventFilter;
import javax.xml.stream.events.XMLEvent;

public class EventFilterScan implements EventFilter {

	private List<String> acceptedElements;

	public EventFilterScan() {

		acceptedElements = new ArrayList<>();
		acceptedElements.add("scan");
	}

	@Override
	public boolean accept(XMLEvent xmlEvent) {

		boolean result = false;
		String element;
		if(xmlEvent.isStartElement()) {
			element = xmlEvent.asStartElement().getName().getLocalPart();
			exitloop:
			for(String acceptedElement : acceptedElements) {
				if(element.equals(acceptedElement)) {
					result = true;
					break exitloop;
				}
			}
		}
		return result;
	}
}
