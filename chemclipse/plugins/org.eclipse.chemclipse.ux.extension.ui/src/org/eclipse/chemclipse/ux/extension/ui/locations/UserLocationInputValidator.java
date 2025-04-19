/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.ui.locations;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IInputValidator;

public class UserLocationInputValidator implements IInputValidator {

	private UserLocationValidator validator = new UserLocationValidator();
	private Set<String> names = new HashSet<>();

	public UserLocationInputValidator(Set<String> identifier) {

		if(identifier != null) {
			this.names = identifier;
		}
	}

	@Override
	public String isValid(String target) {

		IStatus status = validator.validate(target);
		if(status.isOK()) {
			String name = validator.getName();
			if(names.contains(name)) {
				return "The name exists already.";
			}
		} else {
			return status.getMessage();
		}
		return null;
	}
}