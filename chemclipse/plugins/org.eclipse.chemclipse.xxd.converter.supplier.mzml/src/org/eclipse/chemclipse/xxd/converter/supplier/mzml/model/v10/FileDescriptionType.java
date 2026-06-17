/*******************************************************************************
 * Copyright (c) 2023, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.converter.supplier.mzml.model.v10;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Information pertaining to the entire mzML file (i.e. not specific to any part of the data set) is stored here.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FileDescriptionType", propOrder = {"fileContent", "sourceFileList", "contact"})
public class FileDescriptionType {

	@XmlElement(required = true)
	protected ParamGroupType fileContent;

	protected SourceFileListType sourceFileList;

	protected List<ParamGroupType> contact;

	public ParamGroupType getFileContent() {

		return fileContent;
	}

	public void setFileContent(ParamGroupType value) {

		this.fileContent = value;
	}

	public SourceFileListType getSourceFileList() {

		return sourceFileList;
	}

	public void setSourceFileList(SourceFileListType value) {

		this.sourceFileList = value;
	}

	public List<ParamGroupType> getContact() {

		if(contact == null) {
			contact = new ArrayList<>();
		}
		return this.contact;
	}
}
