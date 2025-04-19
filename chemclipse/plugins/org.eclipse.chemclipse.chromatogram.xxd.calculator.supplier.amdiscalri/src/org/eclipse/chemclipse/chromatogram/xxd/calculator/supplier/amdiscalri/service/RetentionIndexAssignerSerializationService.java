/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
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

import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.model.RetentionIndexAssigner;
import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.serializer.RetentionIndexAssignerDeserializer;
import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.serializer.RetentionIndexAssignerSerializer;
import org.eclipse.chemclipse.support.settings.serialization.ISerializationService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;

@Component(service = {ISerializationService.class}, configurationPolicy = ConfigurationPolicy.OPTIONAL)
public class RetentionIndexAssignerSerializationService implements ISerializationService {

	@Override
	public Class<?> getSupportedClass() {

		return RetentionIndexAssigner.class;
	}

	@Override
	public JsonSerializer<RetentionIndexAssigner> getSerializer() {

		return new RetentionIndexAssignerSerializer();
	}

	@Override
	public JsonDeserializer<RetentionIndexAssigner> getDeserializer() {

		return new RetentionIndexAssignerDeserializer();
	}
}