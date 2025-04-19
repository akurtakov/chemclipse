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
package org.eclipse.chemclipse.pcr.model.comparators;

import java.util.Comparator;

import org.eclipse.chemclipse.pcr.model.core.IDetectionFormat;

public class DetectionFormatComparator implements Comparator<IDetectionFormat> {

	@Override
	public int compare(IDetectionFormat detectionFormat1, IDetectionFormat detectionFormat2) {

		return detectionFormat1.getName().compareTo(detectionFormat2.getName());
	}
}
