/*******************************************************************************
 * Copyright (c) 2014, 2025 Lablicate GmbH.
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

import org.eclipse.core.resources.IContainer;

public class WizardElements implements IWizardElements {

	private IContainer container;
	private String fileName = "";

	@Override
	public IContainer getContainer() {

		return container;
	}

	@Override
	public void setContainer(IContainer container) {

		this.container = container;
	}

	@Override
	public String getFileName() {

		return fileName;
	}

	@Override
	public void setFileName(String fileName) {

		if(fileName == null) {
			this.fileName = "";
		} else {
			this.fileName = fileName;
		}
	}
}
