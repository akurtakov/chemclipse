/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Christoph Läubrich - initial API and implementation
 * Philip Wenig - refactorings
 *******************************************************************************/
package org.eclipse.chemclipse.processing.core;

import java.util.Collection;

/**
 * A {@link IMessageProvider} can provide Messages, this is the counterpart for {@link IMessageConsumer}
 *
 */
public interface IMessageProvider {

	Collection<? extends IProcessingMessage> getMessages();

	/**
	 * Returns whether the process info stores error message or not.
	 *
	 * @return boolean
	 */
	default boolean hasErrorMessages() {

		return hasMessages(MessageType.ERROR);
	}

	/**
	 * Returns whether the process info stores warn message or not.
	 *
	 * @return boolean
	 */
	default boolean hasWarnMessages() {

		return hasMessages(MessageType.WARN);
	}

	default boolean hasMessages(final MessageType type) {

		for(IProcessingMessage message : getMessages()) {
			if(message.getMessageType() == type) {
				return true;
			}
		}
		return false;
	}
}