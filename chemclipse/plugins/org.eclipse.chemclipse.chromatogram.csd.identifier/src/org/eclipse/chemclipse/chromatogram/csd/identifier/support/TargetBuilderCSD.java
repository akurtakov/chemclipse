/*******************************************************************************
 * Copyright (c) 2016, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.csd.identifier.support;

import org.eclipse.chemclipse.csd.model.core.IPeakCSD;
import org.eclipse.chemclipse.csd.model.core.IScanCSD;
import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.model.exceptions.ReferenceMustNotBeNullException;
import org.eclipse.chemclipse.model.identifier.IComparisonResult;
import org.eclipse.chemclipse.model.identifier.IIdentificationTarget;
import org.eclipse.chemclipse.model.identifier.ILibraryInformation;
import org.eclipse.chemclipse.model.implementation.IdentificationTarget;
import org.eclipse.chemclipse.model.targets.TargetUnknownSettings;
import org.eclipse.chemclipse.model.targets.UnknownTargetBuilder;

public class TargetBuilderCSD {

	private static final Logger logger = Logger.getLogger(TargetBuilderCSD.class);

	public void setPeakTargetUnknown(IPeakCSD peakCSD, String identifier, TargetUnknownSettings targetUnknownSettings) {

		try {
			IScan scan = peakCSD.getPeakModel().getPeakMaximum();
			if(scan instanceof IScanCSD unknown) {
				ILibraryInformation libraryInformation = UnknownTargetBuilder.getLibraryInformationUnknown(unknown, targetUnknownSettings, "");
				IComparisonResult comparisonResult = UnknownTargetBuilder.getComparisonResultUnknown(targetUnknownSettings.getMatchQuality());
				IIdentificationTarget peakTarget = new IdentificationTarget(libraryInformation, comparisonResult);
				peakTarget.setIdentifier(identifier);
				peakCSD.getTargets().add(peakTarget);
			}
		} catch(ReferenceMustNotBeNullException e) {
			logger.warn(e);
		}
	}
}
