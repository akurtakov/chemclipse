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
package org.eclipse.chemclipse.tsd.model.services;

import org.eclipse.chemclipse.support.settings.serialization.ISerializationService;
import org.eclipse.chemclipse.tsd.model.core.TraceRanges1D;
import org.eclipse.chemclipse.tsd.model.serializer.TraceRangesDeserializer1D;
import org.eclipse.chemclipse.tsd.model.serializer.TraceRangesSerializer1D;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;

@Component(service = {ISerializationService.class}, configurationPolicy = ConfigurationPolicy.OPTIONAL)
public class TraceRangesSerializationService1D implements ISerializationService {

	@Override
	public Class<?> getSupportedClass() {

		return TraceRanges1D.class;
	}

	@Override
	public JsonSerializer<TraceRanges1D> getSerializer() {

		return new TraceRangesSerializer1D();
	}

	@Override
	public JsonDeserializer<TraceRanges1D> getDeserializer() {

		return new TraceRangesDeserializer1D();
	}
}