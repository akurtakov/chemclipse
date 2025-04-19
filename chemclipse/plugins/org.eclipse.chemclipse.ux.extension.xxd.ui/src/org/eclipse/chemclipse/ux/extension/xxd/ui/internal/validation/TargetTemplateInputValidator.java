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
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.xxd.ui.internal.validation;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.chemclipse.model.targets.TargetValidator;
import org.eclipse.chemclipse.ux.extension.xxd.ui.l10n.ExtensionMessages;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IInputValidator;

public class TargetTemplateInputValidator implements IInputValidator {

	private TargetValidator targetValidator = new TargetValidator();
	private Set<String> names = new HashSet<>();

	public TargetTemplateInputValidator(Set<String> names) {

		if(names != null) {
			this.names = names;
		}
	}

	@Override
	public String isValid(String target) {

		IStatus status = targetValidator.validate(target);
		if(status.isOK()) {
			String name = targetValidator.getName();
			if(names.contains(name)) {
				return ExtensionMessages.targetTemplateAlreadyExists;
			}
		} else {
			return status.getMessage();
		}
		return null;
	}
}
