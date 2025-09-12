/*******************************************************************************
 * Copyright (c) 2024, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.converter.supplier.mmass.internal.io;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.msd.converter.io.AbstractMassSpectraReader;
import org.eclipse.chemclipse.msd.converter.io.IMassSpectraReader;
import org.eclipse.chemclipse.msd.model.core.IStandaloneMassSpectrum;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class AbstractMassSpectrumReader extends AbstractMassSpectraReader implements IMassSpectraReader {

	private static final Logger logger = Logger.getLogger(AbstractMassSpectrumReader.class);

	public void readDescription(Element element, IStandaloneMassSpectrum massSpectrum) {

		NodeList descriptionList = element.getElementsByTagName("description");
		for(int i = 0; i < descriptionList.getLength(); i++) {
			Node node = descriptionList.item(i);
			Element description = (Element)node;
			massSpectrum.setSampleName(description.getElementsByTagName("title").item(0).getTextContent());
			try {
				String date = description.getElementsByTagName("date").item(0).getAttributes().getNamedItem("value").getTextContent();
				if(!date.isEmpty()) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy", Locale.ENGLISH);
					massSpectrum.setDate(dateFormat.parse(date));
				}
			} catch(ParseException e) {
				logger.warn(e);
			}
			String operator = getAttributeValue(description, "operator");
			String contact = getAttributeValue(description, "contact");
			String institution = getAttributeValue(description, "institution");
			massSpectrum.setOperator(operator + " " + contact + " " + institution);
			massSpectrum.setInstrument(getAttributeValue(description, "instrument"));
			massSpectrum.setDescription(getTagTextContent(description, "notes"));
		}
	}

	public String getAttributeValue(Element parent, String tag) {

		NodeList nodes = parent.getElementsByTagName(tag);
		if(nodes != null && nodes.getLength() > 0) {
			Node node = nodes.item(0);
			if(node != null && node.hasAttributes()) {
				Node value = node.getAttributes().getNamedItem("value");
				if(value != null) {
					return value.getTextContent();
				}
			}
		}
		return null;
	}

	public String getTagTextContent(Element parent, String tag) {

		NodeList nodes = parent.getElementsByTagName(tag);
		if(nodes != null && nodes.getLength() > 0) {
			Node node = nodes.item(0);
			if(node != null) {
				return node.getTextContent();
			}
		}
		return null;
	}

	public void checkArray(NamedNodeMap attributes) {

		if(!attributes.getNamedItem("compression").getTextContent().equals("zlib")) {
			throw new UnsupportedOperationException("Only zlib compression is supported.");
		}
		if(!attributes.getNamedItem("endian").getTextContent().equals("little")) {
			throw new UnsupportedOperationException("Only Little Endian is supported.");
		}
		if(!attributes.getNamedItem("precision").getTextContent().equals("32")) {
			throw new UnsupportedOperationException("Only 32-bit precision is supported.");
		}
	}

	public ByteBuffer decompress(byte[] binary) throws DataFormatException {

		ByteBuffer byteBuffer = ByteBuffer.wrap(binary);
		Inflater inflater = new Inflater();
		inflater.setInput(byteBuffer.array());
		byte[] byteArray = new byte[byteBuffer.capacity() * 10];
		int decodedLength = inflater.inflate(byteArray);
		byteBuffer = ByteBuffer.wrap(byteArray, 0, decodedLength);
		byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
		return byteBuffer;
	}

	public float[] decodeFloatArray(ByteBuffer byteBuffer) {

		FloatBuffer floatBuffer = byteBuffer.asFloatBuffer();
		float[] values = new float[floatBuffer.capacity()];
		for(int index = 0; index < floatBuffer.capacity(); index++) {
			values[index] = floatBuffer.get(index);
		}
		return values;
	}
}
