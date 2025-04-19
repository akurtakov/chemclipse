/*******************************************************************************
 * Copyright (c) 2017, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Dr. Alexander Kerner - initial API and implementation
 * Lorenz Gerber - add additional message field
 *******************************************************************************/
package org.eclipse.chemclipse.processing.core;

import java.util.List;

public interface IProcessingResult<T> extends IMessageConsumer, IMessageProvider {

	void addMessage(IProcessingMessage processingMessage);

	default void addMessages(final IProcessingResult<?> processingInfo) {

		for(final IProcessingMessage message : processingInfo.getMessages()) {
			addMessage(message);
		}
	}

	@Override
	default void addMessage(String description, String message, String detail, String solution, Throwable t, MessageType type) {

		ProcessingMessage msg = new ProcessingMessage(type, description, message, solution);
		if(detail != null) {
			msg.setDetails(detail);
		}
		msg.setException(t);
		addMessage(msg);
	}

	@Override
	List<IProcessingMessage> getMessages();

	List<IProcessingMessage> getMessages(MessageType type);

	T getProcessingResult();

	void setProcessingResult(T processingResult);

	IProcessingInfo<T> toInfo();
}
