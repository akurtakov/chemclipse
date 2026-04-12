/*******************************************************************************
 * Copyright (c) 2008, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.msd.filter.supplier.ionremover.settings;

import org.eclipse.chemclipse.chromatogram.filter.settings.AbstractChromatogramFilterSettings;
import org.eclipse.chemclipse.model.core.MarkedTraceModus;
import org.eclipse.chemclipse.support.settings.StringSettingsProperty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class ChromatogramFilterSettings extends AbstractChromatogramFilterSettings implements ITraceRemoverFilterSettings {

	@JsonProperty(value = "Ions To Remove", defaultValue = "18 28 84 207")
	@JsonPropertyDescription(value = "List the ions to remove, separated by a white space.")
	@StringSettingsProperty(isMultiLine = false, allowEmpty = false)
	private String ionsToRemove = "18 28 84 207";
	@JsonProperty(value = "Mode", defaultValue = "INCLUDE")
	@JsonPropertyDescription(value = "Gives the mode to use (include = remove all ions given in the list, exclude = remove all ions not in the list)")
	private MarkedTraceModus markedTraceModus = MarkedTraceModus.INCLUDE;

	@Override
	public String getIonsToRemove() {

		return ionsToRemove;
	}

	@Override
	public void setIonsToRemove(String ionsToRemove) {

		this.ionsToRemove = ionsToRemove;
	}

	@Override
	public MarkedTraceModus getMarkedTraceModus() {

		return markedTraceModus;
	}

	@Override
	public void setMarkedTraceModus(MarkedTraceModus markedTraceModus) {

		this.markedTraceModus = markedTraceModus;
	}
}