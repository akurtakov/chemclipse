/*******************************************************************************
 * Copyright (c) 2016, 2026 Lablicate GmbH.
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
import org.eclipse.chemclipse.model.exceptions.ReferenceMustNotBeNullException;
import org.eclipse.chemclipse.model.identifier.IComparisonResult;
import org.eclipse.chemclipse.model.identifier.IIdentificationTarget;
import org.eclipse.chemclipse.model.identifier.ILibraryInformation;
import org.eclipse.chemclipse.model.implementation.IdentificationTarget;
import org.eclipse.chemclipse.model.targets.TargetUnknownSettings;
import org.eclipse.chemclipse.model.targets.UnknownTargetBuilder;

public class TargetBuilderCSD {

	private static final Logger logger = Logger.getLogger(TargetBuilderCSD.class);

	public IIdentificationTarget setPeakTargetUnknown(IPeakCSD peakCSD, String identifier, TargetUnknownSettings targetUnknownSettings) {

		IIdentificationTarget identificationTarget = null;
		try {
			IScanCSD scan = peakCSD.getPeakModel().getPeakMaximum();
			ILibraryInformation libraryInformation = UnknownTargetBuilder.getLibraryInformationUnknown(scan, targetUnknownSettings, "");
			IComparisonResult comparisonResult = UnknownTargetBuilder.getComparisonResultUnknown(targetUnknownSettings.getMatchQuality());
			identificationTarget = new IdentificationTarget(libraryInformation, comparisonResult);
			identificationTarget.setIdentifier(identifier);
			peakCSD.getTargets().add(identificationTarget);
		} catch(ReferenceMustNotBeNullException e) {
			logger.warn(e);
		}
		return identificationTarget;
	}
}
