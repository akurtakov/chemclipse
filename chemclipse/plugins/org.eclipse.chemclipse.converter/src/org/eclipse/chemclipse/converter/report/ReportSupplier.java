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
package org.eclipse.chemclipse.converter.report;

import org.eclipse.chemclipse.processing.converter.ISupplier;

public class ReportSupplier implements IReportSupplierSetter {

	private String id = "";
	private String description = "";
	private String filterName = "";
	private String fileExtension = "";
	private String fileName = "";

	@Override
	public String getId() {

		return id;
	}

	@Override
	public void setId(final String id) {

		if(id != null) {
			this.id = id;
		}
	}

	@Override
	public String getDescription() {

		return description;
	}

	@Override
	public void setDescription(final String description) {

		if(description != null) {
			this.description = description;
		}
	}

	@Override
	public String getFilterName() {

		return filterName;
	}

	@Override
	public void setFilterName(final String filterName) {

		if(filterName != null) {
			this.filterName = filterName;
		}
	}

	@Override
	public String getFileExtension() {

		return fileExtension;
	}

	@Override
	public void setFileExtension(final String fileExtension) {

		String extension = fileExtension;
		if(fileExtension != null) {
			if(!"".equals(fileExtension)) {
				extension = fileExtension.startsWith(".") ? fileExtension : "." + fileExtension;
			}
			this.fileExtension = extension;
		}
	}

	@Override
	public String getFileName() {

		return fileName;
	}

	@Override
	public void setFileName(final String fileName) {

		if(fileName != null) {
			this.fileName = fileName;
		}
	}

	@Override
	public boolean equals(final Object otherObject) {

		if(this == otherObject) {
			return true;
		}
		if(otherObject == null) {
			return false;
		}
		if(getClass() != otherObject.getClass()) {
			return false;
		}
		ISupplier other = (ISupplier)otherObject;
		return id.equals(other.getId()) && //
				description.equals(other.getDescription()) && //
				filterName.equals(other.getFilterName()) && //
				fileExtension.equals(other.getFileExtension()) && //
				fileName.equals(other.getFileName());
	}

	@Override
	public int hashCode() {

		return id.hashCode() + //
				description.hashCode() + //
				filterName.hashCode() + //
				fileExtension.hashCode() + //
				fileName.hashCode();
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getName());
		builder.append("[");
		builder.append("id=" + this.id);
		builder.append(",description=" + this.description);
		builder.append(",filterName=" + this.filterName);
		builder.append(",fileExtension=" + this.fileExtension);
		builder.append(",fileName=" + this.fileName);
		builder.append("]");
		return builder.toString();
	}
}
