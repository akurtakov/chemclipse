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
package org.eclipse.chemclipse.model.service;

import org.eclipse.chemclipse.model.ranges.TimeRanges;
import org.eclipse.chemclipse.model.serializer.TimeRangesDeserializer;
import org.eclipse.chemclipse.model.serializer.TimeRangesSerializer;
import org.eclipse.chemclipse.support.settings.serialization.ISerializationService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;

@Component(service = {ISerializationService.class}, configurationPolicy = ConfigurationPolicy.OPTIONAL)
public class TimeRangesSerializationService implements ISerializationService {

	@Override
	public Class<?> getSupportedClass() {

		return TimeRanges.class;
	}

	@Override
	public JsonSerializer<TimeRanges> getSerializer() {

		return new TimeRangesSerializer();
	}

	@Override
	public JsonDeserializer<TimeRanges> getDeserializer() {

		return new TimeRangesDeserializer();
	}
}