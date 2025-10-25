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
import org.eclipse.chemclipse.tsd.model.core.TraceRanges2D;
import org.eclipse.chemclipse.tsd.model.serializer.TraceRangesDeserializer;
import org.eclipse.chemclipse.tsd.model.serializer.TraceRangesSerializer;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;

@Component(service = {ISerializationService.class}, configurationPolicy = ConfigurationPolicy.OPTIONAL)
public class TraceRangesSerializationService implements ISerializationService {

	@Override
	public Class<?> getSupportedClass() {

		return TraceRanges2D.class;
	}

	@Override
	public JsonSerializer<TraceRanges2D> getSerializer() {

		return new TraceRangesSerializer();
	}

	@Override
	public JsonDeserializer<TraceRanges2D> getDeserializer() {

		return new TraceRangesDeserializer();
	}
}