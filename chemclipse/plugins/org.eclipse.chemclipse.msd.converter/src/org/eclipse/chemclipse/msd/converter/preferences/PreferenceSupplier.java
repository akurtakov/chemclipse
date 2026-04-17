/*******************************************************************************
 * Copyright (c) 2016, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.converter.preferences;

import org.eclipse.chemclipse.support.preferences.AbstractPreferenceSupplier;
import org.eclipse.chemclipse.support.preferences.IPreferenceSupplier;
import org.osgi.framework.FrameworkUtil;

public class PreferenceSupplier extends AbstractPreferenceSupplier {

	public static final String P_REFERENCE_IDENTIFIER_MARKER = "referenceIdentifierMarker";
	public static final String DEF_REFERENCE_IDENTIFIER_MARKER = "";
	public static final String P_REFERENCE_IDENTIFIER_PREFIX = "referenceIdentifierPrefix";
	public static final String DEF_REFERENCE_IDENTIFIER_PREFIX = "";

	public static IPreferenceSupplier INSTANCE() {

		return INSTANCE(PreferenceSupplier.class);
	}

	@Override
	public String getPreferenceNode() {

		return FrameworkUtil.getBundle(PreferenceSupplier.class).getSymbolicName();
	}

	@Override
	public void initializeDefaults() {

		putDefault(P_REFERENCE_IDENTIFIER_MARKER, DEF_REFERENCE_IDENTIFIER_MARKER);
		putDefault(P_REFERENCE_IDENTIFIER_PREFIX, DEF_REFERENCE_IDENTIFIER_PREFIX);
	}

	public static String getReferenceIdentifierMarker() {

		return INSTANCE().get(P_REFERENCE_IDENTIFIER_MARKER, DEF_REFERENCE_IDENTIFIER_MARKER);
	}

	public static String getReferenceIdentifierPrefix() {

		return INSTANCE().get(P_REFERENCE_IDENTIFIER_PREFIX, DEF_REFERENCE_IDENTIFIER_PREFIX);
	}
}