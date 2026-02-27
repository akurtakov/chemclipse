/*******************************************************************************
 * Copyright (c) 2012, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.rcp.app.ui.handlers;

import org.eclipse.chemclipse.rcp.app.ui.dialogs.PerspectiveChooserDialog;
import org.eclipse.chemclipse.rcp.app.ui.dialogs.PerspectiveSwitcherDialog;
import org.eclipse.chemclipse.rcp.app.ui.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.support.ui.workbench.PartSupport;
import org.eclipse.chemclipse.support.ui.workbench.PerspectiveSupport;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import jakarta.inject.Inject;

public class PerspectiveSwitchHandler {

	@Inject
	private static MApplication application;
	@Inject
	private static PartSupport partSupport;
	@Inject
	private static PerspectiveSupport perspectiveSupport;

	@Execute
	public void execute(MWindow window) {

		PerspectiveSwitcherDialog perspectiveSwitcherDialog = ContextInjectionFactory.make(PerspectiveSwitcherDialog.class, window.getContext());
		perspectiveSwitcherDialog.open();
	}

	public static void focusPerspectiveAndView(String perspectiveId, String... viewIds) {

		/*
		 * Try to change the perspective and activate the requested view
		 */
		boolean changePerspectiveAutomatically = PreferenceSupplier.getChangePerspectiveAutomatically();
		if(!changePerspectiveAutomatically) {
			if(showPerspectiveDialog() != Window.OK) {
				return;
			}
		}
		if(changePerspectiveAutomatically) {
			/*
			 * Create the switcher if null.
			 */
			if(perspectiveSupport == null) {
				/*
				 * The application should definitively exists.
				 * But this is checked to avoid a NPE.
				 */
				if(application != null) {
					MWindow window = application.getChildren().get(0);
					if(window != null) {
						IEclipseContext context = window.getContext();
						perspectiveSupport = ContextInjectionFactory.make(PerspectiveSupport.class, context);
					}
				}
			}
			/*
			 * Change perspective and view.
			 */
			if(perspectiveId != null) {
				perspectiveSupport.changePerspective(perspectiveId);
			}

			for(String viewId : viewIds) {
				partSupport.focusPart(viewId);
			}
		}
	}

	/*
	 * Show a dialog if requested. The boolean values: P_SHOW_PERSPECTIVE_DIALOG
	 * P_CHANGE_PERSPECTIVE_AUTOMATICALLY can be edited by the user.
	 */
	private static int showPerspectiveDialog() {

		Shell shell = Display.getCurrent().getActiveShell();
		String title = "Change Perspective";
		String message = "The program changes the perspectives and views automatically on certain tasks. You can select whether you would like to change perspectives automatically. If not, you are responsible by your own to select the needed perspective and views.";
		PerspectiveChooserDialog dialog = new PerspectiveChooserDialog(shell, title, message);
		return dialog.open();
	}
}
