/*******************************************************************************
 * Copyright (c) 2012, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.rcp.app.ui.handlers;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;

import org.eclipse.chemclipse.rcp.app.ui.dialogs.SelectViewDialog;

public class SelectViewHandler {

	@Execute
	public void execute(MWindow window) {

		SelectViewDialog selectViewDialog = ContextInjectionFactory.make(SelectViewDialog.class, window.getContext());
		selectViewDialog.open();
	}
}