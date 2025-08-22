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

import org.eclipse.chemclipse.model.core.IChromatogramOverview;
import org.eclipse.chemclipse.model.quantitation.IQuantitationCompound;
import org.eclipse.chemclipse.support.util.ValueParserSupport;
import org.eclipse.chemclipse.ux.extension.xxd.ui.l10n.ExtensionMessages;
import org.eclipse.chemclipse.xxd.model.quantitation.QuantitationCompound;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

public class QuantitationCompoundValidator extends ValueParserSupport implements IValidator<Object> {

	public static final String DEMO = "Styrene | mg/kg | 5.68";

	private static final String DELIMITER = "|";
	private static final String ERROR_TARGET = ExtensionMessages.enterCompoundExample + ": " + DEMO;

	private String name;
	private String concentrationUnit;
	private int retentionTime;

	@Override
	public IStatus validate(Object value) {

		String message = null;
		if(value == null) {
			message = ERROR_TARGET;
		} else {
			if(value instanceof String text) {
				text = text.trim();
				if("".equals(text.trim())) {
					message = ERROR_TARGET;
				} else {
					String[] values = text.trim().split("\\" + DELIMITER);

					name = parseString(values, 0);
					concentrationUnit = parseString(values, 1);
					retentionTime = (int)(parseDouble(values, 2, 0.0d) * IChromatogramOverview.MINUTE_CORRELATION_FACTOR);
				}
			} else {
				message = ERROR_TARGET;
			}
		}

		if(message != null) {
			return ValidationStatus.error(message);
		} else {
			return ValidationStatus.ok();
		}
	}

	public IQuantitationCompound getQuantitationCompound(boolean createDefaultSignal) {

		IQuantitationCompound quantitationCompound = new QuantitationCompound(name, concentrationUnit, retentionTime);
		if(createDefaultSignal) {
			quantitationCompound.setQuantitationSignalTIC();
		}
		return quantitationCompound;
	}
}
