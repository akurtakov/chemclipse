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
package org.eclipse.chemclipse.chromatogram.msd.filter.supplier.coda.ui.preferences;

import org.eclipse.swt.widgets.Composite;

import org.eclipse.chemclipse.support.ui.preferences.fieldeditors.FloatFieldEditor;

public class CodaFloatFieldEditor extends FloatFieldEditor {

	public CodaFloatFieldEditor(String name, String labelText, float minValue, float maxValue, Composite parent) {
		super(name, labelText, minValue, maxValue, parent);
	}
}
