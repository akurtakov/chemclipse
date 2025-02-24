/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Christoph Läubrich - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.nmr.processing.supplier.base.ui;

import org.eclipse.chemclipse.nmr.processing.supplier.base.settings.PhaseCorrectionSettings;
import org.eclipse.chemclipse.ux.extension.xxd.ui.editors.EditorExtension;
import org.eclipse.core.runtime.IAdapterFactory;

public class PhaseCorrectionSettingsAdapterFactory implements IAdapterFactory {

	@Override
	public <T> T getAdapter(Object adaptableObject, Class<T> adapterType) {

		if(EditorExtension.class.equals(adapterType)) {
			if(adaptableObject instanceof PhaseCorrectionSettings correctionSettings) {
				return adapterType.cast(new PhaseCorrectionSettingsEditorExtension(correctionSettings));
			}
		}
		return null;
	}

	@Override
	public Class<?>[] getAdapterList() {

		return new Class<?>[]{EditorExtension.class};
	}
}
