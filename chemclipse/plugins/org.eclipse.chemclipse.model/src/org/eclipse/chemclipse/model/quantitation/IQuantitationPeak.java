/*******************************************************************************
 * Copyright (c) 2013, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.quantitation;

import java.io.Serializable;

import org.eclipse.chemclipse.model.core.IPeak;

public interface IQuantitationPeak extends Serializable {

	double getConcentration();

	void setConcentration(double concentration);

	String getConcentrationUnit();

	void setConcentrationUnit(String concentrationUnit);

	IPeak getReferencePeak();
}
