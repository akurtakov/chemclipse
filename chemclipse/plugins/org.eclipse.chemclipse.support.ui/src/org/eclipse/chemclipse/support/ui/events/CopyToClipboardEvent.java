/*******************************************************************************
 * Copyright (c) 2017, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.support.ui.events;

import org.eclipse.chemclipse.support.ui.internal.provider.CopyToClipboardProvider;
import org.eclipse.chemclipse.support.ui.swt.ExtendedTableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Display;

public class CopyToClipboardEvent implements IKeyEventProcessor {

	private CopyToClipboardProvider copyToClipboardProvider = new CopyToClipboardProvider();

	@Override
	public void handleEvent(ExtendedTableViewer extendedTableViewer, KeyEvent e) {

		if(e.stateMask == SWT.MOD1 && e.keyCode == 'c') {
			Clipboard clipboard = new Clipboard(Display.getDefault());
			copyToClipboardProvider.copyToClipboard(clipboard, extendedTableViewer);
			clipboard.dispose();
		}
	}
}