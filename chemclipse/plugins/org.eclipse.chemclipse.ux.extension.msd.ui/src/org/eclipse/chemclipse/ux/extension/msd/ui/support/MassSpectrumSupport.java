/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
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

public class MassSpectrumSupport {

	private static ISupplierFileIdentifier massSpectrumIdentifier;
	private static ISupplierFileEditorSupport massSpectrumEditorSupport;

	private MassSpectrumSupport() {
	}

	public static ISupplierFileIdentifier getInstanceIdentifier() {

		if(massSpectrumIdentifier == null) {
			massSpectrumIdentifier = new MassSpectrumIdentifier();
		}
		return massSpectrumIdentifier;
	}

	public static ISupplierFileEditorSupport getInstanceEditorSupport() {

		if(massSpectrumEditorSupport == null) {
			massSpectrumEditorSupport = new MassSpectrumEditorSupport();
		}
		return massSpectrumEditorSupport;
	}
}
