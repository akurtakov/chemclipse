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

import org.eclipse.chemclipse.model.core.AbstractMeasurement;

public class ChannelSpecification extends AbstractMeasurement implements IChannelSpecification {

	private static final long serialVersionUID = 6179615149777166714L;

	public ChannelSpecification() {

		addProtectedKey(NAME);
	}

	@Override
	public String getName() {

		return getHeaderDataOrDefault(NAME, "");
	}
}
