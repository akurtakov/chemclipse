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
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.wsd.identifier.supplier.blastn.core;

import java.io.IOException;

import org.eclipse.chemclipse.chromatogram.wsd.identifier.chromatogram.AbstractChromatogramIdentifier;
import org.eclipse.chemclipse.chromatogram.wsd.identifier.chromatogram.IChromatogramIdentifierSettings;
import org.eclipse.chemclipse.chromatogram.wsd.identifier.supplier.blastn.io.LocalNucleotideBLAST;
import org.eclipse.chemclipse.chromatogram.wsd.identifier.supplier.blastn.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.chromatogram.wsd.identifier.supplier.blastn.settings.LocalIdentifierSettings;
import org.eclipse.chemclipse.model.identifier.IChromatogramIdentificationResult;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.wsd.model.core.selection.IChromatogramSelectionWSD;
import org.eclipse.core.runtime.IProgressMonitor;

public class ChromatogramIdentifierLocal extends AbstractChromatogramIdentifier {

	private static final String DESCRIPTION = "Nucleotide BLAST";

	@Override
	public IProcessingInfo<IChromatogramIdentificationResult> identify(IChromatogramSelectionWSD chromatogramSelection, IChromatogramIdentifierSettings chromatogramIdentifierSettings, IProgressMonitor monitor) {

		IProcessingInfo<IChromatogramIdentificationResult> processingInfo = validate(chromatogramSelection, chromatogramIdentifierSettings);
		if(!processingInfo.hasErrorMessages()) {
			if(chromatogramIdentifierSettings instanceof LocalIdentifierSettings settings) {
				try {
					LocalNucleotideBLAST.run(chromatogramSelection.getChromatogram(), settings);
					processingInfo.addInfoMessage(DESCRIPTION, "The chromatogram has been identified.");
				} catch(IOException e) {
					processingInfo.addErrorMessage(DESCRIPTION, "Failed to identify chromatogram.", e);
				} catch(InterruptedException e) {
					processingInfo.addErrorMessage(DESCRIPTION, "Process interrupted.", e);
					Thread.currentThread().interrupt();
				}
			}
		}
		return processingInfo;
	}

	@Override
	public IProcessingInfo<IChromatogramIdentificationResult> identify(IChromatogramSelectionWSD chromatogramSelection, IProgressMonitor monitor) {

		IChromatogramIdentifierSettings identifierSettings = PreferenceSupplier.getIdentifierSettings();
		return identify(chromatogramSelection, identifierSettings, monitor);
	}
}