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
package org.eclipse.chemclipse.ux.extension.xxd.ui.parts;

import jakarta.inject.Inject;

import org.eclipse.chemclipse.ux.extension.xxd.ui.swt.ExtendedSequenceExplorerUI;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class SequenceExplorerPart {

	private ExtendedSequenceExplorerUI extendedSequenceExplorerUI;

	@Inject
	public SequenceExplorerPart(Composite parent, MPart part) {

		extendedSequenceExplorerUI = new ExtendedSequenceExplorerUI(parent, SWT.NONE);
	}

	@Focus
	public void setFocus() {

		extendedSequenceExplorerUI.setFocus();
	}
}
