/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.rcp.app.ui.console;

import org.eclipse.chemclipse.logging.support.Settings;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;

public class MessageConsoleSupport {

	public MessageConsoleSupport() {

		MessageConsole console = new MessageConsole("Messages", null);
		ConsolePlugin.getDefault().getConsoleManager().addConsoles(new IConsole[]{console});
	}

	public void printConfiguration() {

		MessageConsoleAppender.printLine("----------------------------------------------------------------------------------");
		MessageConsoleAppender.printLine("Product Initializiation:   " + Settings.class.getName());
		MessageConsoleAppender.printLine("Workspace Path:            " + Settings.getWorkspaceDirectory());
		MessageConsoleAppender.printLine("System Path:               " + Settings.getSystemDirectory());
		MessageConsoleAppender.printLine("System Method Path:        " + Settings.getSystemMethodDirectory());
		MessageConsoleAppender.printLine("System Configuration Path: " + Settings.getSystemConfigDirectory());
		MessageConsoleAppender.printLine("System Plugins Path:       " + Settings.getSystemPluginDirectory());
		MessageConsoleAppender.printLine("----------------------------------------------------------------------------------");
	}
}
