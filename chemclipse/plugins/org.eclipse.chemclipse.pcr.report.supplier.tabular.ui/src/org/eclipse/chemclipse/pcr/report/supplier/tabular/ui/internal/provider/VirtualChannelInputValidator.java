/*******************************************************************************
 * Copyright (c) 2022, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.pcr.report.supplier.tabular.ui.internal.provider;

import org.eclipse.chemclipse.pcr.report.supplier.tabular.model.VirtualChannel;
import org.eclipse.chemclipse.pcr.report.supplier.tabular.model.VirtualChannels;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IInputValidator;

public class VirtualChannelInputValidator implements IInputValidator {

	private VirtualChannelValidator validator = new VirtualChannelValidator();
	private VirtualChannels virtualChannels;

	public VirtualChannelInputValidator(VirtualChannels wellMappings) {

		this.virtualChannels = wellMappings;
	}

	@Override
	public String isValid(String target) {

		IStatus status = validator.validate(target);
		if(status.isOK()) {
			VirtualChannel channel = validator.getVirtualChannel();
			if(virtualChannels.contains(channel)) {
				return "The element already exists.";
			}
		} else {
			return status.getMessage();
		}
		return null;
	}
}
