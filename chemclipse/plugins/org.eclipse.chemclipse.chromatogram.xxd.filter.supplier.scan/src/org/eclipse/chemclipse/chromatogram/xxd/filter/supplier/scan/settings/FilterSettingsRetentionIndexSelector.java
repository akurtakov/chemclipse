/*******************************************************************************
 * Copyright (c) 2022, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.settings;

import org.eclipse.chemclipse.chromatogram.filter.settings.AbstractChromatogramFilterSettings;
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.model.RetentionIndexOption;
import org.eclipse.chemclipse.model.support.ColumnIndexSupport;
import org.eclipse.chemclipse.support.model.SeparationColumnType;
import org.eclipse.chemclipse.support.settings.StringSettingsProperty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class FilterSettingsRetentionIndexSelector extends AbstractChromatogramFilterSettings {

	@JsonProperty(value = "Search Column", defaultValue = ColumnIndexSupport.COLUMN_TYPE_CHROMATOGRAM)
	@JsonPropertyDescription(value = ColumnIndexSupport.COLUMN_TYPE_DESCRIPTION)
	@StringSettingsProperty(allowEmpty = false)
	private String searchColumn = ColumnIndexSupport.COLUMN_TYPE_CHROMATOGRAM;
	@JsonProperty(value = "Case Sensitive", defaultValue = "false")
	@JsonPropertyDescription(value = "Search case sensitive")
	private boolean caseSensitive = false;
	@JsonProperty(value = "Remove White-Space", defaultValue = "false")
	@JsonPropertyDescription(value = "Remove white space when searching.")
	private boolean removeWhiteSpace = false;
	@JsonProperty(value = "Match Partly", defaultValue = "false")
	@JsonPropertyDescription(value = "If true, the search column must not match the column name or type completely.")
	private boolean matchPartly = false;
	@JsonProperty(value = "Separation Column (Fallback)", defaultValue = "DEFAULT")
	@JsonPropertyDescription(value = "Use the following separation column if the above column can't be matched.")
	private SeparationColumnType separationColumnTypeFallback = SeparationColumnType.DEFAULT;
	@JsonProperty(value = "Retention Index Option", defaultValue = "AUTO")
	@JsonPropertyDescription(value = "Use the following value when assigning the retention index value.")
	private RetentionIndexOption retentionIndexOption = RetentionIndexOption.AUTO;
	@JsonProperty(value = "Delete Unrelated Indices", defaultValue = "false")
	@JsonPropertyDescription(value = "Delete all indices, wich are not matched by the above settings.")
	private boolean deleteUnrelatedIndices = false;

	public String getSearchColumn() {

		return searchColumn;
	}

	public void setSearchColumn(String searchColumn) {

		this.searchColumn = searchColumn;
	}

	public boolean isCaseSensitive() {

		return caseSensitive;
	}

	public void setCaseSensitive(boolean caseSensitive) {

		this.caseSensitive = caseSensitive;
	}

	public boolean isRemoveWhiteSpace() {

		return removeWhiteSpace;
	}

	public void setRemoveWhiteSpace(boolean removeWhiteSpace) {

		this.removeWhiteSpace = removeWhiteSpace;
	}

	public boolean isMatchPartly() {

		return matchPartly;
	}

	public void setMatchPartly(boolean matchPartly) {

		this.matchPartly = matchPartly;
	}

	public SeparationColumnType getSeparationColumnTypeFallback() {

		return separationColumnTypeFallback;
	}

	public void setSeparationColumnTypeFallback(SeparationColumnType separationColumnTypeFallback) {

		this.separationColumnTypeFallback = separationColumnTypeFallback;
	}

	public RetentionIndexOption getRetentionIndexOption() {

		return retentionIndexOption;
	}

	public void setRetentionIndexOption(RetentionIndexOption retentionIndexOption) {

		this.retentionIndexOption = retentionIndexOption;
	}

	public boolean isDeleteUnrelatedIndices() {

		return deleteUnrelatedIndices;
	}

	public void setDeleteUnrelatedIndices(boolean deleteUnrelatedIndices) {

		this.deleteUnrelatedIndices = deleteUnrelatedIndices;
	}
}