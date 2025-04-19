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
package org.eclipse.chemclipse.rcp.connector.supplier.microsoft.office.ui.editors;

public class WordEditorDocx extends OLEEditor {

	public WordEditorDocx() {
		super(IOLEApplication.PROG_ID_WORD, "docx", "Microsoft Word 2007 (*.docx)");
	}
}
