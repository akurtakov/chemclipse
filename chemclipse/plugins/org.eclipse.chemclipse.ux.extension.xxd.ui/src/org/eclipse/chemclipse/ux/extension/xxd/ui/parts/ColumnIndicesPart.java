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

import org.eclipse.chemclipse.ux.extension.xxd.ui.swt.ExtendedColumnIndicesUI;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import jakarta.inject.Inject;

public class ColumnIndicesPart extends AbstractLibraryInformationPart<ExtendedColumnIndicesUI> {

	@Inject
	public ColumnIndicesPart(Composite parent) {

		super(parent);
	}

	@Override
	protected ExtendedColumnIndicesUI createControl(Composite parent) {

		return new ExtendedColumnIndicesUI(parent, SWT.NONE);
	}
}