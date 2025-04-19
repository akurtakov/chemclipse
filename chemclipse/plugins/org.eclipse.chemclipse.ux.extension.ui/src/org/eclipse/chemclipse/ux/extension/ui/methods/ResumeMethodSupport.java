/*******************************************************************************
 * Copyright (c) 2021, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.ui.methods;

import org.eclipse.chemclipse.processing.methods.IProcessMethod;
import org.eclipse.chemclipse.ux.extension.ui.preferences.PreferenceSupplierMethods;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;

public class ResumeMethodSupport {

	public static MethodParameters selectMethodParameters(Shell shell, IProcessMethod processMethod) throws MethodCancelException {

		MethodParameters methodParameters = new MethodParameters();
		if(processMethod != null) {
			/*
			 * Set the active profile as this is used to
			 * parameterize the process method even if
			 * no support resume was activated. The resume index
			 * is 0 by default, so that all items are processed.
			 */
			methodParameters.setProfile(processMethod.getActiveProfile());
			if(processMethod.isSupportResume()) {
				if(PreferenceSupplierMethods.isShowResumeMethodDialog()) {
					/*
					 * Show the dialog.
					 */
					ResumeMethodDialog resumeMethodDialog = new ResumeMethodDialog(shell);
					resumeMethodDialog.setInput(processMethod);
					resumeMethodDialog.create();
					//
					if(resumeMethodDialog.open() == Window.OK) {
						methodParameters.setProfile(resumeMethodDialog.getProfile());
						methodParameters.setResumeIndex(resumeMethodDialog.getResumeIndex());
					} else {
						throw new MethodCancelException();
					}
				}
			}
		}
		//
		return methodParameters;
	}
}