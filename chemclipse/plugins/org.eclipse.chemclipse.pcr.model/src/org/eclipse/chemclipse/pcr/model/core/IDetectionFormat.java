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
package org.eclipse.chemclipse.pcr.model.core;

import java.util.List;

import org.eclipse.chemclipse.model.core.IMeasurementInfo;

public interface IDetectionFormat extends IMeasurementInfo {

	String NAME = "name";

	String getName();

	List<IChannelSpecification> getChannelSpecifications();

	List<Integer> getEmissionWavlengths();

	List<Integer> getExcitationWavlengths();
}
