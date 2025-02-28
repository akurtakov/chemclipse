/*******************************************************************************
 * Copyright (c) 2014, 2025 Lablicate GmbH.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Dr. Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.msd.filter.core.massspectrum;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.chromatogram.msd.filter.settings.IMassSpectrumFilterSettings;
import org.eclipse.chemclipse.support.literature.LiteratureReference;

public class MassSpectrumFilterSupplier implements IMassSpectrumFilterSupplier {

	private String id = "";
	private String description = "";
	private String filterName = "";
	private Class<? extends IMassSpectrumFilterSettings> settingsClass;
	private List<LiteratureReference> literatureReference = new ArrayList<>();

	@Override
	public String getDescription() {

		return description;
	}

	/**
	 * Sets the description of the mass spectrum filter supplier.
	 * 
	 * @param description
	 */
	protected void setDescription(String description) {

		if(description != null) {
			this.description = description;
		}
	}

	@Override
	public String getFilterName() {

		return filterName;
	}

	/**
	 * Sets the name of the mass spectrum filter supplier.
	 * 
	 * @param filterName
	 */
	protected void setFilterName(String filterName) {

		if(filterName != null) {
			this.filterName = filterName;
		}
	}

	@Override
	public String getId() {

		return id;
	}

	/**
	 * Sets the mass spectrum filter supplier id like
	 * "org.eclipse.chemclipse.chromatogram.msd.filter.supplier.backgroundRemover".
	 * 
	 * @param id
	 */
	protected void setId(String id) {

		if(id != null) {
			this.id = id;
		}
	}

	@Override
	public List<LiteratureReference> getLiteratureReferences() {

		return literatureReference;
	}

	// ------------------------------------hashCode, equals, toString
	@Override
	public boolean equals(Object other) {

		if(other == null) {
			return false;
		}
		if(this == other) {
			return true;
		}
		if(this.getClass() != other.getClass()) {
			return false;
		}
		IMassSpectrumFilterSupplier otherSupplier = (IMassSpectrumFilterSupplier)other;
		return id.equals(otherSupplier.getId()) && description.equals(otherSupplier.getDescription()) && filterName.equals(otherSupplier.getFilterName());
	}

	@Override
	public int hashCode() {

		return 7 * id.hashCode() + 11 * description.hashCode() + 13 * filterName.hashCode();
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getName());
		builder.append("[");
		builder.append("id=" + id);
		builder.append(",");
		builder.append("description=" + description);
		builder.append(",");
		builder.append("filterName=" + filterName);
		builder.append("]");
		return builder.toString();
	}
	// ------------------------------------hashCode, equals, toString

	@Override
	public Class<? extends IMassSpectrumFilterSettings> getSettingsClass() {

		return settingsClass;
	}

	public void setConfigClass(Class<? extends IMassSpectrumFilterSettings> settingsClass) {

		this.settingsClass = settingsClass;
	}
}
