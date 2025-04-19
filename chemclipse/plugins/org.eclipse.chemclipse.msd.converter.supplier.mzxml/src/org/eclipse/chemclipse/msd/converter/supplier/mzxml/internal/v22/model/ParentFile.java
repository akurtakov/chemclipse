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
package org.eclipse.chemclipse.msd.converter.supplier.mzxml.internal.v22.model;

import java.io.Serializable;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"value"})
public class ParentFile implements Serializable {

	private static final long serialVersionUID = 220L;
	@XmlValue
	@XmlSchemaType(name = "anySimpleType")
	private Object value;
	@XmlAttribute(name = "fileName", required = true)
	@XmlSchemaType(name = "anyURI")
	private String fileName;
	@XmlAttribute(name = "fileType", required = true)
	private String fileType;
	@XmlAttribute(name = "fileSha1", required = true)
	private String fileSha1;

	public Object getValue() {

		return value;
	}

	public void setValue(Object value) {

		this.value = value;
	}

	public String getFileName() {

		return fileName;
	}

	public void setFileName(String value) {

		this.fileName = value;
	}

	public String getFileType() {

		return fileType;
	}

	public void setFileType(String value) {

		this.fileType = value;
	}

	public String getFileSha1() {

		return fileSha1;
	}

	public void setFileSha1(String value) {

		this.fileSha1 = value;
	}
}
