/*******************************************************************************
 * Copyright (c) 2012, 2026 Lablicate GmbH.
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
 * Christoph Läubrich - Result must actually be an {@link IChromatogram}, add default implementation
 *******************************************************************************/
package org.eclipse.chemclipse.converter.chromatogram;

import java.io.File;

import org.eclipse.chemclipse.converter.core.IImportConverter;
import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.model.core.IChromatogramOverview;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.ProcessingInfo;
import org.eclipse.core.runtime.IProgressMonitor;

public interface IChromatogramImportConverter<R extends IChromatogram> extends IImportConverter {

	/**
	 * All implementing classes must return an IChromatogramOverview instance.<br/>
	 * If no suitable converter is available, null will be returned.<br/>
	 * <br/>
	 * AbstractChromatogramImportConverter implements
	 * IChromatogramImportConverter. When extending from
	 * AbstractChromatogramImportConverter => super.validate(chromatogram) can
	 * be used.
	 */
	default IProcessingInfo<IChromatogramOverview> convertOverview(File file, IProgressMonitor monitor) {

		IProcessingInfo<R> chromatogramInfo = convert(file, monitor);
		ProcessingInfo<IChromatogramOverview> info = new ProcessingInfo<>();
		info.addMessages(chromatogramInfo);
		info.setProcessingResult(chromatogramInfo.getProcessingResult());
		return info;
	}

	/**
	 * All implementing classes must return an IChromatogram instance.<br/>
	 * If no suitable converter is available, null will be returned.<br/>
	 * <br/>
	 * AbstractChromatogramImportConverter implements
	 * IChromatogramImportConverter. When extending from
	 * AbstractChromatogramImportConverter => super.validate(chromatogram) can
	 * be used.
	 */
	IProcessingInfo<R> convert(File file, IProgressMonitor monitor);
}
