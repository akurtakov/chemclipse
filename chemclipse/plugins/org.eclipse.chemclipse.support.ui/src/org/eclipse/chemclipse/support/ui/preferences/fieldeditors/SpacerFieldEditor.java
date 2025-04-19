/*******************************************************************************
 * Copyright (c) 2010, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.support.ui.preferences.fieldeditors;

import org.eclipse.swt.widgets.Composite;

/**
 * You can use this editor as a spacer in a preference page.
 * 
 * @author Dr. Philip Wenig
 */
public class SpacerFieldEditor extends LabelFieldEditor {

	public SpacerFieldEditor(Composite parent) {
		super("", parent);
	}
}
