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
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.xxd.identifier.scan;

import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

public class ScanIdentifier {

	private static final Logger logger = Logger.getLogger(ScanIdentifier.class);
	//
	private static final String EXTENSION_POINT = "org.eclipse.chemclipse.chromatogram.xxd.identifier.scanIdentifier";

	private ScanIdentifier() {

	}

	public static IScanIdentifierSupport getScanIdentifierSupport() {

		ScanIdentifierSupport identifierSupport = new ScanIdentifierSupport();
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = registry.getConfigurationElementsFor(EXTENSION_POINT);
		try {
			for(IConfigurationElement element : extensions) {
				Object object = element.createExecutableExtension("targetURL");
				if(object instanceof IScanIdentifierSupplier identifier) {
					identifierSupport.add(identifier);
				}
			}
		} catch(CoreException e) {
			logger.warn(e);
		}
		return identifierSupport;
	}
}
