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
package org.eclipse.chemclipse.converter.model.reports;

public enum SequenceRecordAdvice {
	NONE("No advice available yet."), //
	DATA_IS_VALID("The data is valid."), //
	FILE_NOT_AVAILABLE("The file is not available.");

	private String decsription;

	private SequenceRecordAdvice(String description) {
		this.decsription = description;
	}

	public String getDecsription() {

		return decsription;
	}
}
