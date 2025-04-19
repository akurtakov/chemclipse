/*******************************************************************************
 * Copyright (c) 2024, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.vsd.filter.service;

import org.eclipse.chemclipse.chromatogram.vsd.filter.model.WavenumberSignals;
import org.eclipse.chemclipse.chromatogram.vsd.filter.serializer.WavenumberSignalsDeserializer;
import org.eclipse.chemclipse.chromatogram.vsd.filter.serializer.WavenumberSignalsSerializer;
import org.eclipse.chemclipse.support.settings.serialization.ISerializationService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;

@Component(service = {ISerializationService.class}, configurationPolicy = ConfigurationPolicy.OPTIONAL)
public class WavenumberSignalsSerializationService implements ISerializationService {

	@Override
	public Class<?> getSupportedClass() {

		return WavenumberSignals.class;
	}

	@Override
	public JsonSerializer<WavenumberSignals> getSerializer() {

		return new WavenumberSignalsSerializer();
	}

	@Override
	public JsonDeserializer<WavenumberSignals> getDeserializer() {

		return new WavenumberSignalsDeserializer();
	}
}