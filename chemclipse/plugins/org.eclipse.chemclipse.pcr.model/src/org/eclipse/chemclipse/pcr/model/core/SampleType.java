/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Matthias Mailänder - add color compensation
 *******************************************************************************/
package org.eclipse.chemclipse.pcr.model.core;

public enum SampleType {
	UNKNOWN, //
	NON_TEMPLATE_CONTROL, //
	NO_AMPLICATION_CONTROL, //
	STANDARD_SAMPLE, //
	NO_TARGET_PRESENT, //
	MINUS_RT, //
	POSITIVE_CONTROL, //
	OPTICAL_CALIBRATOR;
}
