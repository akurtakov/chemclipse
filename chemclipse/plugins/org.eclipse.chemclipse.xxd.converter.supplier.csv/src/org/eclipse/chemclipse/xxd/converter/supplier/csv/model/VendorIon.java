/*******************************************************************************
 * Copyright (c) 2011, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.converter.supplier.csv.model;

import org.eclipse.chemclipse.msd.model.core.AbstractIon;

public class VendorIon extends AbstractIon implements IVendorIon {

	public static final int BINARY_ION_LENGTH_IN_BYTES = 4;
	/**
	 * Renew the serialVersionUID any time you have changed some fields or
	 * methods.
	 */
	private static final long serialVersionUID = -8157753037973736404L;

	public VendorIon(double ion) {

		super(ion);
	}

	public VendorIon(double ion, float abundance) {

		super(ion, abundance);
	}
}