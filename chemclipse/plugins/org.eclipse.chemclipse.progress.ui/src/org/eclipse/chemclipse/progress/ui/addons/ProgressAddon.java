/*******************************************************************************
 * Copyright (c) 2008, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.progress.ui.addons;

import org.eclipse.chemclipse.progress.core.StatusLineLogger;
import org.eclipse.chemclipse.progress.ui.internal.core.UIStatusLineLogger;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class ProgressAddon {

	private UIStatusLineLogger uiStatusLineLogger;

	@PostConstruct
	public void postConstruct() {

		uiStatusLineLogger = new UIStatusLineLogger();
		StatusLineLogger.add(uiStatusLineLogger);
	}

	@PreDestroy
	public void preDestroy() {

		if(uiStatusLineLogger != null) {
			StatusLineLogger.remove(uiStatusLineLogger);
		}
	}
}
