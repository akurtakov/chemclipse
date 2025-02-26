/*******************************************************************************
 * Copyright (c) 2011, 2025 Lablicate GmbH.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.result;

import org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.model.TargetTraces;
import org.eclipse.chemclipse.chromatogram.xxd.classifier.result.AbstractChromatogramClassifierResult;
import org.eclipse.chemclipse.chromatogram.xxd.classifier.result.IChromatogramClassifierResult;
import org.eclipse.chemclipse.chromatogram.xxd.classifier.result.ResultStatus;

public class WncClassifierResult extends AbstractChromatogramClassifierResult implements IChromatogramClassifierResult {

	private TargetTraces targetTraces;

	public WncClassifierResult(ResultStatus resultStatus, String description) {

		super(resultStatus, description);
	}

	public WncClassifierResult(ResultStatus resultStatus, String description, TargetTraces targetTraces) {

		super(resultStatus, description);
		this.targetTraces = targetTraces;
	}

	public TargetTraces getTargetTraces() {

		return targetTraces;
	}
}