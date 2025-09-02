/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
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

public class TraceEmpty extends AbstractTrace {

	public int getTrace() {

		return TRACE_TIC;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		builder.append("TIC");
		builder.append(getScaleFactorAsString());

		return builder.toString();
	}
}