/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.identifier.supplier.file.model;

import java.io.File;

import org.eclipse.chemclipse.model.columns.ISeparationColumn;

public class IdentifierFile {

	/*
	 * Both members are initialized in the constructor.
	 */
	private File file;
	private ISeparationColumn separationColumn;

	public IdentifierFile(File file) {

		this.file = file;
		IdentifierFileReader calibrationFileReader = new IdentifierFileReader();
		this.separationColumn = calibrationFileReader.parse(file);
	}

	public File getFile() {

		return file;
	}

	public ISeparationColumn getSeparationColumn() {

		return separationColumn;
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ((file == null) ? 0 : file.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		IdentifierFile other = (IdentifierFile)obj;
		if(file == null) {
			if(other.file != null)
				return false;
		} else if(!file.equals(other.file)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {

		return "CalibrationFile [file=" + file + ", separationColumns=" + separationColumn + "]";
	}
}
