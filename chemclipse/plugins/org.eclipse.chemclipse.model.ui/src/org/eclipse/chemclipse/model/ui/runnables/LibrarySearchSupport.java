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
package org.eclipse.chemclipse.model.ui.runnables;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.model.services.IRetentionIndexLibraryService;
import org.eclipse.chemclipse.model.ui.Activator;

public class LibrarySearchSupport {

	public static List<IRetentionIndexLibraryService> getRetentionIndexLibraryServices() {

		List<IRetentionIndexLibraryService> retentionIndexLibraryServices = new ArrayList<>();
		//
		Object[] services = Activator.getDefault().getRetentionIndexLibraryServices();
		if(services != null) {
			for(Object service : services) {
				if(service instanceof IRetentionIndexLibraryService retentionIndexLibraryService) {
					retentionIndexLibraryServices.add(retentionIndexLibraryService);
				}
			}
		}
		//
		return retentionIndexLibraryServices;
	}
}