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
package org.eclipse.chemclipse.msd.converter.supplier.mzdata.internal.v105.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sourceFileType", propOrder = {"nameOfFile", "pathToFile", "fileType"})
public class SourceFileType {

	@XmlElement(required = true)
	private String nameOfFile;
	@XmlElement(required = true)
	@XmlSchemaType(name = "anyURI")
	private String pathToFile;
	private String fileType;

	public String getNameOfFile() {

		return nameOfFile;
	}

	public void setNameOfFile(String value) {

		this.nameOfFile = value;
	}

	public String getPathToFile() {

		return pathToFile;
	}

	public void setPathToFile(String value) {

		this.pathToFile = value;
	}

	public String getFileType() {

		return fileType;
	}

	public void setFileType(String value) {

		this.fileType = value;
	}
}
