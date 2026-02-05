/*******************************************************************************
 * Copyright (c) 2019, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Christoph Läubrich - initial API and implementation
 * Lorenz Gerber - additional message field
 *******************************************************************************/
package org.eclipse.chemclipse.processing.core;

/**
 * A {@link IMessageConsumer} consumes messages from a processing or computation method to give feedback to the caller in a very detailed way
 * 
 * @author Christoph Läubrich
 *
 */
public interface IMessageConsumer {

	default void addErrorMessage(final String description, final String message) {

		addMessage(description, message, MessageType.ERROR);
	}

	default void addInfoMessage(final String description, final String message) {

		addMessage(description, message, MessageType.INFO);
	}

	default void addWarnMessage(final String description, final String message) {

		addMessage(description, message, MessageType.WARN);
	}

	default void addMessage(final String description, final String message, final MessageType type) {

		addMessage(description, message, null, type);
	}

	default void addMessage(final String description, final String message, final String proposedSolution, final MessageType type) {

		addMessage(description, message, null, proposedSolution, type);
	}

	void addMessage(final String description, final String message, final String details, final String proposedSolution, final MessageType type);

	default void addMessages(IMessageProvider messageProvider) {

		if(messageProvider != null) {
			for(IProcessingMessage message : messageProvider.getMessages()) {
				addMessage(message.getDescription(), message.getMessage(), message.getDetails(), message.getProposedSolution(), message.getMessageType());
			}
		}
	}
}
