/*******************************************************************************
 * Copyright (c) 2011, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.rcp.connector.supplier.microsoft.office.ui.wizards;

import org.eclipse.jface.viewers.ISelection;

public class WordFileDocxWizardPage extends OfficeFileWizardPage {

	public WordFileDocxWizardPage(ISelection selection) {
		super(selection, "Microsoft Office Word File", "This wizard creates a new Microsoft Office Word (*.docx) file.", "report.docx", "docx");
	}
}