/*******************************************************************************
 * Copyright (c) 2022, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.identifier;

import java.io.Serializable;
import java.util.Set;

public interface IFlavorMarker extends Serializable {

	void clear();

	boolean isManuallyVerified();

	void setManuallyVerified(boolean manuallyVerified);

	String getOdor();

	String getMatrix();

	String getSolvent();

	String getSamplePreparation();

	void setSamplePreparation(String samplePreparation);

	String getLiteratureReference();

	void setLiteratureReference(String literatureReference);

	/**
	 * Returns an unmodifiable set.
	 * 
	 * @return
	 */
	Set<IOdorThreshold> getOdorThresholds();

	void add(IOdorThreshold odorThreshold);

	void remove(IOdorThreshold odorThreshold);

	void clearOdorThresholds();
}