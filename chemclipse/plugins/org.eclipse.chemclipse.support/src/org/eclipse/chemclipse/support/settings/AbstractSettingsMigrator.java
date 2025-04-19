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

import java.util.List;

public abstract class AbstractSettingsMigrator<T> implements ISettingsMigrator {

	public abstract List<ISettingsMigrationHandler<T>> getSettingsMigrationHandler();

	/**
	 * Use the supplied migration handler to automate the transfer.
	 * 
	 * @param settings
	 * @param content
	 */
	public void transferToLatestVersion(T settings, String content) {

		/*
		 * Enable 'fail on unknown properties' to prevent wrong settings to be mapped.
		 */
		if(content != null && !content.isBlank()) {
			List<ISettingsMigrationHandler<T>> migrationHandler = getSettingsMigrationHandler();
			for(ISettingsMigrationHandler<T> handler : migrationHandler) {
				if(handler.migrateSettings(settings, content)) {
					return;
				}
			}
		}
	}
}