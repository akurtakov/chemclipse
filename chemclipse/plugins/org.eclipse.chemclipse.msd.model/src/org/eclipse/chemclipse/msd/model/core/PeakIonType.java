/*******************************************************************************
 * Copyright (c) 2008, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.model.core;

/**
 * You can mark a peak ion.<br/>
 * AMDIS, for example, uses this feature to flag uncertain peaks.<br/>
 * <br/>
 * AMDIS Examples (you can find those values in the *.ELU and *.FIN files):<br/>
 * (22,1 L0.7)<br/>
 * (19,1 B0.2)<br/>
 * (41,1 N0.2)<br/>
 * <br/>
 * There maybe some more types to be added here.
 */
public enum PeakIonType {

	NO_TYPE("no type stored"), B("B"), L("L"), N("N");

	private String description;

	private PeakIonType(String description) {

		this.description = description;
	}

	/**
	 * Returns the description of the peak ion type.
	 * 
	 * @return String
	 */
	public String getDescription() {

		return this.description;
	}
}
