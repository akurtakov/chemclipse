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
 *******************************************************************************/
package org.eclipse.chemclipse.processing.core;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractProcessingInfo<T> implements IProcessingInfo<T> {

	private List<IProcessingMessage> processingMessages = new ArrayList<>();
	private T processingResult;

	protected AbstractProcessingInfo() {

	}

	protected AbstractProcessingInfo(IProcessingInfo<T> processingInfo) {

		this();
		addMessages(processingInfo);
	}

	@Override
	public void addMessages(IProcessingInfo<?> processingInfo) {

		if(processingInfo != null && processingInfo != this) {
			/*
			 * Add each message to this message queue.
			 */
			for(IProcessingMessage message : processingInfo.getMessages()) {
				addMessage(message);
			}
		}
	}

	@Override
	public void addMessage(IProcessingMessage processingMessage) {

		processingMessages.add(processingMessage);
	}

	@Override
	public void addInfoMessage(String description, String message) {

		IProcessingMessage processingMessage = new ProcessingMessage(MessageType.INFO, description, message);
		addMessage(processingMessage);
	}

	@Override
	public void addWarnMessage(String description, String message) {

		addWarnMessage(description, message, "");
	}

	@Override
	public void addWarnMessage(String description, String message, String proposedSolution) {

		IProcessingMessage processingMessage = new ProcessingMessage(MessageType.WARN, description, message, proposedSolution);
		addMessage(processingMessage);
	}

	@Override
	public void addErrorMessage(String description, String message) {

		addErrorMessage(description, message, "");
	}

	@Override
	public void addErrorMessage(String description, String message, String proposedSolution) {

		IProcessingMessage processingMessage = new ProcessingMessage(MessageType.ERROR, description, message, proposedSolution);
		addMessage(processingMessage);
	}

	@Override
	public List<IProcessingMessage> getMessages() {

		return processingMessages;
	}

	@Override
	public void setProcessingResult(T processingResult) {

		this.processingResult = processingResult;
	}

	@Override
	public T getProcessingResult() {

		return processingResult;
	}

	@Override
	public boolean hasErrorMessages() {

		for(IProcessingMessage processingMessage : processingMessages) {
			if(processingMessage.getMessageType().equals(MessageType.ERROR)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean hasWarnMessages() {

		for(IProcessingMessage processingMessage : processingMessages) {
			if(processingMessage.getMessageType().equals(MessageType.WARN)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isEmpty() {

		return processingMessages.isEmpty();
	}

	@Override
	public void clear() {

		processingMessages.clear();
	}
}
