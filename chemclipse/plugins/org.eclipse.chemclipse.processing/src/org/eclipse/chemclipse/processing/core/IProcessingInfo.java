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
 * Alexander Kerner - implementation, Generics
 * Lorenz Gerber - add additional message field
 *******************************************************************************/
package org.eclipse.chemclipse.processing.core;

import java.util.List;

public interface IProcessingInfo<T> extends IMessageConsumer, IMessageProvider {

	/**
	 * Adds all message from {@link IProcessingInfo} to this processing info
	 * instance.
	 *
	 * @param processingInfo
	 */
	void addMessages(IProcessingInfo<?> processingInfo);

	/**
	 * Adds a message to the processing info.
	 *
	 * @param processingMessage
	 */
	void addMessage(IProcessingMessage processingMessage);

	@Override
	default void addMessage(String description, String message, String detail, String solution, Throwable t, MessageType type) {

		ProcessingMessage msg = new ProcessingMessage(type, description, message, solution);
		msg.setException(t);
		msg.setDetails(detail);
		msg.setProposedSolution(solution);
		addMessage(msg);
	}

	/**
	 * Adds a warn message to the processing info.
	 *
	 * @param description
	 * @param message
	 */
	@Override
	void addWarnMessage(String description, String message);

	/**
	 * Adds a warn message to the processing info.
	 *
	 * @param description
	 * @param message
	 * @param proposedSolution
	 */
	void addWarnMessage(String description, String message, String proposedSolution);

	/**
	 * Adds an error message to the processing info.
	 *
	 * @param description
	 * @param message
	 * @param proposedSolution
	 */
	void addErrorMessage(String description, String message, String proposedSolution);

	/**
	 * Returns the list of messages.
	 *
	 * @return the list of messages
	 */
	@Override
	List<IProcessingMessage> getMessages();

	/**
	 * Sets the processing result. Each plug-in knows which instance it expects
	 * as the return.
	 *
	 * @param processingResult
	 */
	void setProcessingResult(T processingResult);

	/**
	 * Returns the processing result.
	 * May return null.
	 *
	 * @return Object
	 */
	T getProcessingResult();

	boolean isEmpty();

	void clear();
}