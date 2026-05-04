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
 * Matthias Mailänder - fix status line not appearing
 *******************************************************************************/
package org.eclipse.chemclipse.progress.ui.internal.core;

import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.progress.core.IStatusLineMessageListener;
import org.eclipse.chemclipse.progress.core.InfoType;
import org.eclipse.chemclipse.support.ui.activator.ContextAddon;
import org.eclipse.chemclipse.support.ui.workbench.DisplayUtils;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.swt.widgets.Display;

/**
 * Prints messages to the status line.
 * 
 * @author Philip Wenig
 */
public class UIStatusLineLogger implements IStatusLineMessageListener {

	private static final Logger logger = Logger.getLogger(UIStatusLineLogger.class);

	@Override
	public void setInfo(final InfoType infoType, final String message) {

		Display display = DisplayUtils.getDisplay();
		display.asyncExec(() -> {

			IStatusLineManager statusLineManager = getStatusLineManager();
			if(statusLineManager != null) {
				switch(infoType) {
					case MESSAGE:
						statusLineManager.setMessage(message);
						break;
					case ERROR_MESSAGE:
						statusLineManager.setErrorMessage(message);
						break;
				}
			}
		});
	}

	private IStatusLineManager getStatusLineManager() {

		MApplication application = ContextAddon.getApplication();
		if(application != null && !application.getChildren().isEmpty()) {
			MWindow window = application.getChildren().get(0);
			IEclipseContext context = window.getContext();
			if(context != null) {
				return context.get(IStatusLineManager.class);
			}
		}
		logger.warn("IStatusLineManager is not available.");
		return null;
	}
}
