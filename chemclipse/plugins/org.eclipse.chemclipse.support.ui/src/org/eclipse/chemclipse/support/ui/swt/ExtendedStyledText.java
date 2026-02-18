/*******************************************************************************
 * Copyright (c) 2023, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.support.ui.swt;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;

/**
 * This widget doesn't allow copy &amp; paste by default.
 * It can be enabled on demand.
 */
public class ExtendedStyledText extends StyledText {

	private boolean enableCopyPaste = false;

	public ExtendedStyledText(Composite parent, int style) {

		super(parent, style);
	}

	public boolean isEnableCopyPaste() {

		return enableCopyPaste;
	}

	public void setEnableCopyPaste(boolean enableCopyPaste) {

		this.enableCopyPaste = enableCopyPaste;
	}

	@Override
	public void paste() {

		if(enableCopyPaste) {
			super.paste();
		}
	}

	@Override
	public void cut() {

		if(enableCopyPaste) {
			super.paste();
		}
	}

	@Override
	public void copy() {

		if(enableCopyPaste) {
			super.copy();
		}
	}

	@Override
	public void copy(int clipboardType) {

		if(enableCopyPaste) {
			super.copy(clipboardType);
		}
	}
}