/*******************************************************************************
 * Copyright (c) 2008, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.identifier.chromatogram;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.model.exceptions.ValueMustNotBeNullException;
import org.eclipse.chemclipse.model.identifier.IIdentifierSettings;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.ProcessingInfo;
import org.eclipse.chemclipse.support.literature.LiteratureReference;

public abstract class AbstractChromatogramIdentifier implements IChromatogramIdentifier {

	private static final String DESCRIPTION = "ChromatogramIdentifier";

	private List<LiteratureReference> literatureReferences = new ArrayList<>();

	public IProcessingInfo<?> validate(IChromatogramSelection chromatogramSelection, IIdentifierSettings identifierSettings) {

		IProcessingInfo<?> processingInfo = new ProcessingInfo<>();
		try {
			validateChromatogramSelection(chromatogramSelection);
			validateSettings(identifierSettings);
		} catch(ValueMustNotBeNullException e) {
			processingInfo.addErrorMessage(DESCRIPTION, e.getMessage());
		}
		return processingInfo;
	}

	/**
	 * Tests if the chromatogram selection is a valid instance.
	 * 
	 * @param chromatogramSelection
	 * @throws ValueMustNotBeNullException
	 */
	public void validateChromatogramSelection(IChromatogramSelection chromatogramSelection) throws ValueMustNotBeNullException {

		if(chromatogramSelection == null) {
			throw new ValueMustNotBeNullException("The chromatogram selection must not be null.");
		}
		if(chromatogramSelection.getChromatogram() == null) {
			throw new ValueMustNotBeNullException("The chromatogram must not be null.");
		}
	}

	/**
	 * Throws an exception if the settings are null.
	 * 
	 * @param identifierSettings
	 * @throws ValueMustNotBeNullException
	 */
	public void validateSettings(IIdentifierSettings identifierSettings) throws ValueMustNotBeNullException {

		if(identifierSettings == null) {
			throw new ValueMustNotBeNullException("The identifier settings must not be null.");
		}
	}

	@Override
	public List<LiteratureReference> getLiteratureReferences() {

		return literatureReferences;
	}
}
