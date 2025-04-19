/*******************************************************************************
 * Copyright (c) 2017, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.msd.ui.support;

import org.eclipse.chemclipse.processing.converter.ISupplierFileIdentifier;
import org.eclipse.chemclipse.ux.extension.ui.provider.ISupplierFileEditorSupport;

public class DatabaseSupport {

	private static ISupplierFileIdentifier databaseIdentifier;
	private static ISupplierFileEditorSupport databaseEditorSupport;

	private DatabaseSupport() {
	}

	public static ISupplierFileIdentifier getInstanceIdentifier() {

		if(databaseIdentifier == null) {
			databaseIdentifier = new DatabaseIdentifier();
		}
		return databaseIdentifier;
	}

	public static ISupplierFileEditorSupport getInstanceEditorSupport() {

		if(databaseEditorSupport == null) {
			databaseEditorSupport = new DatabaseEditorSupport();
		}
		return databaseEditorSupport;
	}
}
