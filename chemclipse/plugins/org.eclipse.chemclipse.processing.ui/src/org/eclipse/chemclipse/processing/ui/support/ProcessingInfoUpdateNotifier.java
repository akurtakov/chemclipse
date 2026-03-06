/*******************************************************************************
 * Copyright (c) 2012, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Christoph Läubrich - use {@link IMessageProvider} interface, make a creatable singleton and store the current value
 *******************************************************************************/
package org.eclipse.chemclipse.processing.ui.support;

import org.eclipse.chemclipse.processing.core.IMessageProvider;
import org.eclipse.chemclipse.support.events.IChemClipseEvents;
import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.core.services.events.IEventBroker;

import jakarta.inject.Inject;

@Creatable
public class ProcessingInfoUpdateNotifier {

	@Inject
	private IEventBroker eventBroker;

	private IMessageProvider messageProvider;

	public void update(IMessageProvider messageProvider) {

		this.messageProvider = messageProvider;
		if(eventBroker != null) {
			eventBroker.post(IChemClipseEvents.TOPIC_PROCESSING_INFO_UPDATE, messageProvider);
		}
	}

	public IMessageProvider getProcessingInfo() {

		return messageProvider;
	}
}
