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
package org.eclipse.chemclipse.model.processor;

import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

public interface IChromatogramProcessor {

	/**
	 * Returns a description of the executed action.
	 * 
	 * @return String
	 */
	String getDescription();

	/**
	 * Returns the chromatogram selection.
	 * 
	 * @return {@link IChromatogramSelection}
	 */

	IChromatogramSelection getChromatogramSelection();

	/**
	 * Executes an implemented chromatogram modifier action.<br/>
	 * If not using a graphical user interface, chose a {@link NullProgressMonitor}.
	 */
	void execute(IProgressMonitor monitor);
}
