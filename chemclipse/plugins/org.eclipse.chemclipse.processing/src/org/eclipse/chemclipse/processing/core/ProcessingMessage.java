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
package org.eclipse.chemclipse.processing.core;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ProcessingMessage extends AbstractProcessingMessage implements IProcessingMessage {

	private Throwable exception;

	public ProcessingMessage(MessageType messageType, String description, String message) {

		super(messageType, description, message);
	}

	public ProcessingMessage(MessageType messageType, String description, String message, String solution) {

		super(messageType, description, message, solution);
	}

	@Override
	public Throwable getException() {

		return exception;
	}

	public void setException(Throwable exception) {

		this.exception = exception;
	}

	@Override
	public String getDetails() {

		String details = super.getDetails();
		if(details == null && exception != null) {
			try (StringWriter writer = new StringWriter();
					PrintWriter printWriter = new PrintWriter(writer)) {
				exception.printStackTrace(printWriter);
				printWriter.flush();
				return writer.getBuffer().toString();
			} catch(IOException e) {
				throw new AssertionError("Unexpected I/O error", e);
			}
		}
		return details;
	}
}
