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
package org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.service;

import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.model.RetentionIndexMarker;
import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.serializer.RetentionIndexMarkerDeserializer;
import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.serializer.RetentionIndexMarkerSerializer;
import org.eclipse.chemclipse.support.settings.serialization.ISerializationService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;

@Component(service = {ISerializationService.class}, configurationPolicy = ConfigurationPolicy.OPTIONAL)
public class RetentionIndexMarkerSerializationService implements ISerializationService {

	@Override
	public Class<?> getSupportedClass() {

		return RetentionIndexMarker.class;
	}

	@Override
	public JsonSerializer<RetentionIndexMarker> getSerializer() {

		return new RetentionIndexMarkerSerializer();
	}

	@Override
	public JsonDeserializer<RetentionIndexMarker> getDeserializer() {

		return new RetentionIndexMarkerDeserializer();
	}
}