/*******************************************************************************
 * Copyright (c) 2012, 2025 Lablicate GmbH.
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

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.log.Logger;

@SuppressWarnings("restriction")
public class AboutHandler {

	@Execute
	void execute(ECommandService commandService, EHandlerService handlerService, Logger logger) {

		ParameterizedCommand command = commandService.createCommand("org.eclipse.ui.help.aboutAction", null);
		if(handlerService.canExecute(command)) {
			handlerService.executeHandler(command);
		} else {
			logger.warn("Can't handle to open the about dialog.");
		}
	}
}
