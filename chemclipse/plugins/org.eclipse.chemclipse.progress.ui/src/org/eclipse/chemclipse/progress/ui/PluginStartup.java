/*******************************************************************************
 * Copyright (c) 2008, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.progress.ui;

import org.eclipse.chemclipse.progress.core.StatusLineLogger;
import org.eclipse.chemclipse.progress.ui.internal.core.UIStatusLineLogger;

import org.eclipse.ui.IStartup;

/**
 * @author eselmeister
 */
public class PluginStartup implements IStartup {

	private static UIStatusLineLogger uiStatusLineLogger;

	@Override
	public void earlyStartup() {

		/*
		 * Create a new ui status line logger instance and add it as a listener
		 * to StatusLineLogger.
		 */
		uiStatusLineLogger = new UIStatusLineLogger();
		StatusLineLogger.add(uiStatusLineLogger);
	}

	/**
	 * Returns the instance of ui status line logger or null if not exists.
	 * 
	 * @return
	 */
	public static UIStatusLineLogger getUIStatusLineLogger() {

		return uiStatusLineLogger;
	}
}
