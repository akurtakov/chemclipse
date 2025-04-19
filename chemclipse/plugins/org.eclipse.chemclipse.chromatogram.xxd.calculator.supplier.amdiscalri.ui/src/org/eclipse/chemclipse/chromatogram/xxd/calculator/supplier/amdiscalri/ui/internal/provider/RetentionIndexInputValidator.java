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
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.ui.internal.provider;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.validators.RetentionIndexEntryValidator;
import org.eclipse.chemclipse.model.columns.IRetentionIndexEntry;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IInputValidator;

public class RetentionIndexInputValidator implements IInputValidator {

	private RetentionIndexEntryValidator validator = new RetentionIndexEntryValidator();
	private Set<String> names = new HashSet<>();

	public RetentionIndexInputValidator(Set<String> names) {

		if(names != null) {
			this.names = names;
		}
	}

	@Override
	public String isValid(String target) {

		IStatus status = validator.validate(target);
		if(status.isOK()) {
			IRetentionIndexEntry setting = validator.getSetting();
			String name = setting.getName();
			if(names.contains(name)) {
				return "The element already exists.";
			}
		} else {
			return status.getMessage();
		}
		return null;
	}
}