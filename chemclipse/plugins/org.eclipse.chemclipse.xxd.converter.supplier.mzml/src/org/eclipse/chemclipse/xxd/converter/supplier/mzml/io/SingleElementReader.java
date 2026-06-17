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
package org.eclipse.chemclipse.xxd.converter.supplier.mzml.io;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.util.StreamReaderDelegate;

public class SingleElementReader extends StreamReaderDelegate {

	private int depth = 1; // constructed while sitting on the target START_ELEMENT
	private boolean finished;

	public SingleElementReader(XMLStreamReader parent) {

		super(parent);
	}

	@Override
	public boolean hasNext() throws XMLStreamException {

		return !finished && super.hasNext();
	}

	@Override
	public int next() throws XMLStreamException {

		if(finished) {
			return XMLStreamConstants.END_DOCUMENT;
		}
		int event = super.next();
		if(event == XMLStreamConstants.START_ELEMENT) {
			depth++;
		} else if(event == XMLStreamConstants.END_ELEMENT && --depth == 0) {
			finished = true;
		}
		return event;
	}
}