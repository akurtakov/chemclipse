/*******************************************************************************
 * Copyright (c) 2017, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Dr. Alexander Kerner - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.processing.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultProcessingResult<T> implements IProcessingResult<T> {

	private List<IProcessingMessage> processingMessages;
	private T processingResult;

	public DefaultProcessingResult() {

		processingMessages = new ArrayList<>();
	}

	public DefaultProcessingResult(final IProcessingResult<T> processingInfo) {

		this();
		addMessages(processingInfo);
	}

	@Override
	public void addMessage(final IProcessingMessage processingMessage) {

		processingMessages.add(processingMessage);
	}

	@Override
	public List<IProcessingMessage> getMessages() {

		return processingMessages;
	}

	@Override
	public List<IProcessingMessage> getMessages(final MessageType type) {

		return getMessages().stream().filter(m -> m.getMessageType().equals(type)).collect(Collectors.toList());
	}

	@Override
	public T getProcessingResult() {

		return processingResult;
	}

	@Override
	public void setProcessingResult(final T processingResult) {

		this.processingResult = processingResult;
	}

	@Override
	public IProcessingInfo<T> toInfo() {

		final ProcessingInfo<T> result = new ProcessingInfo<>();
		for(final IProcessingMessage message : getMessages()) {
			result.addMessage(message);
		}
		result.setProcessingResult(getProcessingResult());
		return result;
	}
}
