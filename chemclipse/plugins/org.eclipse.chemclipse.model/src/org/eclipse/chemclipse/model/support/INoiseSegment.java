/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Christoph Läubrich - initial API and implementation
 * Philip Wenig - corrected the name scheme
 *******************************************************************************/
package org.eclipse.chemclipse.model.support;

import java.io.Serializable;

public interface INoiseSegment extends IAnalysisSegment, Serializable {

	double getNoiseFactor();

	void setNoiseFactor(double noiseFactor);

	String getTraces();

	boolean isUse();

	void setUse(boolean use);

	boolean isUserSelection();

	void setUserSelection(boolean userSelection);
}