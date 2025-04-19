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
package org.eclipse.chemclipse.support.settings;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface ISettingsMigrationHandler<T> {

	default ObjectMapper getObjectMapper() {

		/*
		 * Enable 'fail on unknown properties' to prevent wrong settings to be mapped.
		 */
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		//
		return objectMapper;
	}

	/**
	 * Migrate the JSON settings provided in content to
	 * the supplied settings instance of type T.
	 * If the settings are of wrong version or if it fails return false.
	 * 
	 * @param settings
	 * @param content
	 * @return {@link Boolean}
	 */
	boolean migrateSettings(T settings, String content);
}