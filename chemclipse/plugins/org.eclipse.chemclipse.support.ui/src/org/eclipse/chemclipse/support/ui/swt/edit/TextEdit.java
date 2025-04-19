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

import static org.eclipse.chemclipse.support.ui.swt.ControlBuilder.fill;

import java.beans.PropertyChangeEvent;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

public class TextEdit extends EditValue<String> {

	private static final long serialVersionUID = 2670106061643118051L;
	//
	private final Text text;
	private final String initialText;
	private String editedValue = "";

	public TextEdit(Composite parent, String initialText) {

		if(initialText == null) {
			initialText = "";
		}
		this.initialText = initialText;
		this.editedValue = initialText;
		text = fill(new Text(parent, SWT.NONE));
		text.setText(initialText);
		text.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {

				editedValue = text.getText();
				firePropertyChange(new PropertyChangeEvent(this, "TextEdit", editedValue, editedValue));
			}
		});
	}

	@Override
	public boolean isEdited() {

		return !editedValue.equals(initialText);
	}

	@Override
	public String getValue() {

		return editedValue;
	}

	@Override
	public Control getControl() {

		return text;
	}
}