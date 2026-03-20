/*******************************************************************************
 * Copyright (c) 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.service;

import org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.model.TargetTraces;
import org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.serializer.TargetTracesSerializer;
import org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.serializer.TargetTracesDeserializer;
import org.eclipse.chemclipse.support.settings.serialization.ISerializationService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;

@Component(service = {ISerializationService.class}, configurationPolicy = ConfigurationPolicy.OPTIONAL)
public class TargetTracesSerializationService implements ISerializationService {

	@Override
	public Class<?> getSupportedClass() {

		return TargetTraces.class;
	}

	@Override
	public JsonSerializer<TargetTraces> getSerializer() {

		return new TargetTracesSerializer();
	}

	@Override
	public JsonDeserializer<TargetTraces> getDeserializer() {

		return new TargetTracesDeserializer();
	}
}
