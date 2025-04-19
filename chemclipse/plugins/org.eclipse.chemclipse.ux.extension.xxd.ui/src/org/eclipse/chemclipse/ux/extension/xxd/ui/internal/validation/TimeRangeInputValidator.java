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
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.xxd.ui.internal.validation;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.chemclipse.ux.extension.xxd.ui.ranges.TimeRangeLabels;
import org.eclipse.chemclipse.ux.extension.xxd.ui.ranges.TimeRangeValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IInputValidator;

public class TimeRangeInputValidator implements IInputValidator {

	private TimeRangeValidator validator = new TimeRangeValidator();
	private Set<String> identifier = new HashSet<>();
	private TimeRangeLabels timeRangeLabels = new TimeRangeLabels();

	public TimeRangeInputValidator(Set<String> identifier, TimeRangeLabels timeRangeLabels) {

		if(identifier != null) {
			this.identifier = identifier;
		}
		//
		if(timeRangeLabels != null) {
			this.timeRangeLabels = timeRangeLabels;
		}
	}

	@Override
	public String isValid(String target) {

		IStatus status = validator.validate(target);
		if(status.isOK()) {
			String name = validator.getIdentifier();
			if(identifier.contains(name)) {
				return timeRangeLabels.getAddExists();
			}
		} else {
			return status.getMessage();
		}
		//
		return null;
	}
}