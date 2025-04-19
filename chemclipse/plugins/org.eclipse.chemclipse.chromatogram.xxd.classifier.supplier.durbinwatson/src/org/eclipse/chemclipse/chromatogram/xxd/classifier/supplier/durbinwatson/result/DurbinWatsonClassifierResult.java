/*******************************************************************************
 * Copyright (c) 2015, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.classifier.supplier.durbinwatson.result;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.chromatogram.xxd.classifier.result.AbstractChromatogramClassifierResult;
import org.eclipse.chemclipse.chromatogram.xxd.classifier.result.ResultStatus;

public class DurbinWatsonClassifierResult extends AbstractChromatogramClassifierResult implements IDurbinWatsonClassifierResult {

	private List<ISavitzkyGolayFilterRating> savitzkyGolayFilterRatings = new ArrayList<>();

	public DurbinWatsonClassifierResult(ResultStatus resultStatus, String description) {

		super(resultStatus, description);
	}

	@Override
	public List<ISavitzkyGolayFilterRating> getSavitzkyGolayFilterRatings() {

		return savitzkyGolayFilterRatings;
	}
}