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

public class ExcelFileXlsWizardPage extends OfficeFileWizardPage {

	public ExcelFileXlsWizardPage(ISelection selection) {
		super(selection, "Microsoft Office Excel File", "This wizard creates a new Microsoft Office Excel (*.xls) file.", "report.xls", "xls");
	}
}