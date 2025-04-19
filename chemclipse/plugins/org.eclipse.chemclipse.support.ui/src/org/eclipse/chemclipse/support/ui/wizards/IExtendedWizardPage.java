/*******************************************************************************
 * Copyright (c) 2015, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.support.ui.wizards;

import java.text.DecimalFormat;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Text;

public interface IExtendedWizardPage extends IWizardPage {

	boolean canFinish();

	void setDefaultValues();

	String validateInput(Text textInput, String errorMessage);

	String validateDoubleInput(Text textInput, DecimalFormat decimalFormat, String errorMessage);

	String validateDoubleInput(Text textInput, DecimalFormat decimalFormat, double min, double max, String errorMessage);

	String validateInput(Combo comboInput, String errorMessage);

	String validateDateInput(DateTime dateTime, String errorMessage);
}
