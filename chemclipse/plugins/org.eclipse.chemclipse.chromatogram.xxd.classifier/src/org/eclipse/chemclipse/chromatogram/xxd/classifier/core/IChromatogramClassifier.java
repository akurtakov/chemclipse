/*******************************************************************************
 * Copyright (c) 2011, 2025 Lablicate GmbH.
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
 * Christoph Läubrich - simplyfy API
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.xxd.classifier.core;

import org.eclipse.chemclipse.chromatogram.xxd.classifier.result.IChromatogramClassifierResult;
import org.eclipse.chemclipse.chromatogram.xxd.classifier.settings.IChromatogramClassifierSettings;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.model.types.DataType;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * A chromatogram classifier is used to extract key values of a chromatogram. This could
 * be for example to check the water, nitrogen and oxygene concentration in the chromatogram.
 * The classification data is stored in the chromatogram, but the data is transient and only
 * intended to be used for live inspection of the chromatogram.
 */
public interface IChromatogramClassifier {

	IProcessingInfo<IChromatogramClassifierResult> applyClassifier(IChromatogramSelection chromatogramSelection, IChromatogramClassifierSettings chromatogramClassifierSettings, IProgressMonitor monitor);

	DataType[] getDataTypes();
}
