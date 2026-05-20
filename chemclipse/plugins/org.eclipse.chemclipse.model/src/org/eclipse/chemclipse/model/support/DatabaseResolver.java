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
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.model.support;

import org.eclipse.chemclipse.model.Activator;
import org.eclipse.chemclipse.model.services.IDatabaseResolverService;

public class DatabaseResolver {

	public static String getDatabaseName(String uuid) {

		for(IDatabaseResolverService databaseResolverService : Activator.getDefault().getDatabaseResolverServices()) {
			String name = databaseResolverService.resolve(uuid);
			if(name != null && !name.isBlank()) {
				return name;
			}
		}

		return uuid;
	}
}