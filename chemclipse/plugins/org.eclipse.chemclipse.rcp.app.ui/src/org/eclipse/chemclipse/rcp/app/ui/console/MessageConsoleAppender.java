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

import java.io.IOException;

import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.swt.ui.support.Colors;
import org.eclipse.swt.graphics.Color;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

public final class MessageConsoleAppender {

	private static final Logger logger = Logger.getLogger(MessageConsoleAppender.class);

	private MessageConsoleAppender() {

		// static only
	}

	public static void printLine(String text) {

		printLine(text, null);
	}

	public static void printError(String text) {

		printLine(text, Colors.RED);
	}

	public static void printWarn(String text) {

		printLine(text, Colors.DARK_YELLOW);
	}

	public static void printDone(String text) {

		printLine(text, Colors.GREEN);
	}

	public static void printLine(String text, Color color) {

		IConsole[] consoles = ConsolePlugin.getDefault().getConsoleManager().getConsoles();
		if(consoles.length == 0) {
			return;
		}
		if(consoles[0] instanceof MessageConsole messageConsole) {
			try (MessageConsoleStream consoleStream = messageConsole.newMessageStream()) {
				consoleStream.setColor(color);
				consoleStream.println(text);
			} catch(IOException e) {
				logger.warn(e);
			}
		}
	}
}
