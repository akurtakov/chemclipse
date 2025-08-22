/*******************************************************************************
 * Copyright (c) 2024, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.support.traces;

public class TraceGeneric extends AbstractTrace {

	public int getTrace() {

		return getValueAsInt();
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		builder.append(getTrace());
		builder.append(getScaleFactorAsString());

		return builder.toString();
	}
}