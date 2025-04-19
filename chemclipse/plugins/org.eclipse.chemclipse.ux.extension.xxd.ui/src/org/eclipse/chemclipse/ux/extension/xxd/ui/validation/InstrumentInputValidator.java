/*******************************************************************************
 * Copyright (c) 2020, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.xxd.ui.validation;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.chemclipse.ux.extension.xxd.ui.instruments.InstrumentValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IInputValidator;

public class InstrumentInputValidator implements IInputValidator {

	private InstrumentValidator validator = new InstrumentValidator();
	private Set<String> identifier = new HashSet<>();

	public InstrumentInputValidator(Set<String> identifier) {

		if(identifier != null) {
			this.identifier = identifier;
		}
	}

	@Override
	public String isValid(String target) {

		IStatus status = validator.validate(target);
		if(status.isOK()) {
			String name = validator.getIdentifier();
			if(identifier.contains(name)) {
				return "The instrument already exists.";
			}
		} else {
			return status.getMessage();
		}
		return null;
	}
}