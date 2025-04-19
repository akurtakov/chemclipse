/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.pcr.converter.supplier.rdml.model;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidParameterException;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.chemclipse.pcr.model.core.IPlate;
import org.xml.sax.SAXException;

import jakarta.xml.bind.JAXBException;

public interface IPCRReader {

	IPlate readData(InputStream inputStream) throws IOException, SAXException, JAXBException, ParserConfigurationException, InvalidParameterException;
}
