/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.xxd.ui.dialogs;

import org.eclipse.chemclipse.model.core.IPeak;
import org.eclipse.chemclipse.ux.extension.xxd.ui.swt.ExtendedInternalStandardsUI;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class InternalStandardDialog extends Dialog {

	private IPeak peak;

	public InternalStandardDialog(Shell shell, IPeak peak) {

		super(shell);
		this.peak = peak;
	}

	@Override
	protected void configureShell(Shell shell) {

		super.configureShell(shell);
		shell.setText("Internal Standard (ISTD)");
	}

	@Override
	protected Point getInitialSize() {

		return new Point(600, 600);
	}

	@Override
	protected Control createDialogArea(Composite parent) {

		Composite composite = (Composite)super.createDialogArea(parent);
		composite.setLayout(new GridLayout(1, true));

		ExtendedInternalStandardsUI extendedInternalStandardsUI = createExtendedInternalStandardsUI(composite);
		extendedInternalStandardsUI.update(peak);

		return composite;
	}

	private ExtendedInternalStandardsUI createExtendedInternalStandardsUI(Composite parent) {

		ExtendedInternalStandardsUI extendedInternalStandardsUI = new ExtendedInternalStandardsUI(parent, SWT.NONE);
		extendedInternalStandardsUI.setLayoutData(new GridData(GridData.FILL_BOTH));

		return extendedInternalStandardsUI;
	}
}
