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
 * Alexander Kerner - Generics
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.xxd.ui.support;

import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.MessageType;
import org.eclipse.chemclipse.processing.core.ProcessingInfo;
import org.eclipse.chemclipse.processing.core.ProcessingMessage;

public abstract class AbstractChromatogramEditorAction<T> implements IChromatogramEditorAction<T> {

	public IProcessingInfo<T> validate(IChromatogramSelection chromatogramSelection) {

		IProcessingInfo<T> processingInfo = new ProcessingInfo<>();
		if(chromatogramSelection == null) {
			processingInfo.addMessage(new ProcessingMessage(MessageType.ERROR, "Editor Action", "The chromatogram selection is null."));
		}
		return processingInfo;
	}
}
