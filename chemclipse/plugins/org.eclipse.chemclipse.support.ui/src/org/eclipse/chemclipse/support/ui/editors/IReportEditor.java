/*******************************************************************************
 * Copyright (c) 2016, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.support.ui.editors;

public interface IReportEditor {

	String getCurrentUser();

	void setDirty(boolean isDirty);

	/**
	 * Returns the file name.
	 * 
	 * @return String
	 */
	String getFileName();

	/**
	 * Returns the file extension.
	 * 
	 * @return String
	 */
	String getFileExtension();

	/**
	 * Adds the page to the internal list and sets the
	 * page index and text.
	 * 
	 * @param page
	 */
	void addEditorPage(IMultiEditorPage page);

	/**
	 * Sets the active page.
	 * USE IT ONLY IF NECESSARY.
	 * 
	 * @param editorId
	 */
	void setActivePage(String editorId);
}
