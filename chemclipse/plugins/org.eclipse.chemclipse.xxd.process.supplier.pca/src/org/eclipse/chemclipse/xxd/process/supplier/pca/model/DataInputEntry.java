/*******************************************************************************
 * Copyright (c) 2011, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.process.supplier.pca.model;

import java.io.File;
import java.util.Objects;

public class DataInputEntry implements IDataInputEntry {

	private String groupName = "";
	private String inputFile = "";

	/**
	 * Set the peak input file.
	 *
	 * @param inputFile
	 */
	public DataInputEntry(String inputFile) {

		if(inputFile != null) {
			this.inputFile = inputFile;
		}
	}

	@Override
	public String getFileName() {

		File file = new File(inputFile);
		return file.getName();
	}

	@Override
	public String getGroupName() {

		return groupName;
	}

	@Override
	public String getInputFile() {

		return inputFile;
	}

	@Override
	public String getSampleName() {

		String fileName = getFileName();
		int extPos = fileName.lastIndexOf(".");
		if(extPos < 1) {
			return fileName;
		} else {
			return fileName.substring(0, extPos);
		}
	}

	@Override
	public void setGroupName(String groupName) {

		this.groupName = groupName;
	}

	@Override
	public int hashCode() {

		return Objects.hash(getSampleName());
	}

	@Override
	public boolean equals(Object o) {

		if(o == null) {
			return false;
		}
		if(o == this) {
			return true;
		}
		if(!(o instanceof DataInputEntry)) {
			return false;
		}
		DataInputEntry dataInputEntry = (DataInputEntry)o;
		return dataInputEntry.getSampleName().equals(getSampleName());
	}
}