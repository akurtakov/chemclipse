/*******************************************************************************
 * Copyright (c) 2020, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.filter.peaks.settings;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class DeleteIntegrationsFilterSettings {

	@JsonProperty(value = "Delete Integrations", defaultValue = "false")
	@JsonPropertyDescription(value = "Confirm to delete the integrations.")
	private boolean deleteIntegrations;

	public boolean isDeleteIntegrations() {

		return deleteIntegrations;
	}

	public void setDeleteIntegrations(boolean deleteIntegrations) {

		this.deleteIntegrations = deleteIntegrations;
	}
}