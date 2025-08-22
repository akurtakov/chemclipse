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
 * Christoph Läubrich - initial API and implementation
 * Philip Wenig - refactoring Observable
 *******************************************************************************/
package org.eclipse.chemclipse.support.ui.swt.edit;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class BooleanEdit extends EditValue<Boolean> {

	private static final long serialVersionUID = 6116766646926264825L;

	private final Button button;
	private final boolean initialValue;
	private boolean currentValue;

	public BooleanEdit(Composite parent, String label, boolean initialValue) {

		this.initialValue = initialValue;
		currentValue = initialValue;
		button = new Button(parent, SWT.CHECK);
		if(label != null) {
			button.setText(label);
		}
		button.setSelection(initialValue);
		button.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				currentValue = button.getSelection();
				updateChange(this, "BooleanEdit", currentValue, currentValue);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});
	}

	@Override
	public boolean isEdited() {

		return currentValue != initialValue;
	}

	@Override
	public Boolean getValue() {

		return currentValue;
	}

	@Override
	public Control getControl() {

		return button;
	}
}