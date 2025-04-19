/*******************************************************************************
 * Copyright (c) 2020, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.xxd.ui.parts;

import jakarta.inject.Inject;

import org.eclipse.chemclipse.ux.extension.xxd.ui.swt.ExtendedFlavorMarkerUI;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class FlavorMarkerPart extends AbstractLibraryInformationPart<ExtendedFlavorMarkerUI> {

	@Inject
	public FlavorMarkerPart(Composite parent) {

		super(parent);
	}

	@Override
	protected ExtendedFlavorMarkerUI createControl(Composite parent) {

		return new ExtendedFlavorMarkerUI(parent, SWT.NONE);
	}
}
