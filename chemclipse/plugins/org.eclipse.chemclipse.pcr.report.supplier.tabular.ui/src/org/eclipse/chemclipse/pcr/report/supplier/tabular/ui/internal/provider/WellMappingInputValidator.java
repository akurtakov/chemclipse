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

import org.eclipse.chemclipse.pcr.report.supplier.tabular.model.WellMapping;
import org.eclipse.chemclipse.pcr.report.supplier.tabular.model.WellMappings;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IInputValidator;

public class WellMappingInputValidator implements IInputValidator {

	private WellMappingValidator validator = new WellMappingValidator();
	private WellMappings wellMappings;

	public WellMappingInputValidator(WellMappings wellMappings) {

		this.wellMappings = wellMappings;
	}

	@Override
	public String isValid(String target) {

		IStatus status = validator.validate(target);
		if(status.isOK()) {
			WellMapping mapping = validator.getMapping();
			if(wellMappings.contains(mapping)) {
				return "The element already exists.";
			}
		} else {
			return status.getMessage();
		}
		return null;
	}
}
