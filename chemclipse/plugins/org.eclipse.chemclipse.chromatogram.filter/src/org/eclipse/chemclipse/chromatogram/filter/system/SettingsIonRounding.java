/*******************************************************************************
 * Copyright (c) 2021, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.filter.system;

import org.eclipse.chemclipse.model.math.IonRoundMethod;
import org.eclipse.chemclipse.processing.system.ISystemProcessSettings;
import org.eclipse.chemclipse.support.settings.LabelProperty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SettingsIonRounding implements ISystemProcessSettings {

	@JsonProperty(value = "Ion Round Method", defaultValue = "DEFAULT")
	@LabelProperty(value = "%IonRoundMethod", tooltip = "%IonRoundMethodDescription")
	private IonRoundMethod ionRoundMethod = IonRoundMethod.DEFAULT;

	public IonRoundMethod getIonRoundMethod() {

		return ionRoundMethod;
	}

	public void setIonRoundMethod(IonRoundMethod ionRoundMethod) {

		this.ionRoundMethod = ionRoundMethod;
	}
}