/*******************************************************************************
 * Copyright (c) 2021, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.tsd.converter.core;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.chemclipse.converter.chromatogram.IChromatogramImportConverter;
import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.model.core.IChromatogramOverview;
import org.eclipse.chemclipse.tsd.converter.core.matcher.TraceRangeMatcher;
import org.eclipse.chemclipse.tsd.model.core.IChromatogramTSD;
import org.eclipse.core.runtime.IProgressMonitor;

public interface IImportConverterTSD extends IChromatogramImportConverter<IChromatogramTSD> {

	IChromatogramTSD convert(InputStream inputStream, IProgressMonitor monitor) throws IOException;

	IChromatogramOverview convertOverview(InputStream inputStream, IProgressMonitor monitor) throws IOException;

	IChromatogram extract(IChromatogramTSD chromatogramTSD, TraceRangeMatcher traceRangeMatcher, IProgressMonitor monitor) throws IOException;
}
