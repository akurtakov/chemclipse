/*******************************************************************************
 * Copyright (c) 2008, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.integrator.core.settings.peaks;

import org.eclipse.chemclipse.chromatogram.xxd.integrator.core.settings.IIntegrationSettings;
import org.eclipse.chemclipse.model.core.IPeak;

/**
 * All implementing classes have to decide if a peak should be reported or not.<br/>
 * You could think of a report decider who wants peaks with an area less than
 * 1000 not to be reported.<br/>
 * A new class could implement IReportDecider, implements
 * "boolean report(IPeak peak)" and returns false, if the peak area is less then
 * 1000.<br/>
 * To take effect in the {@link ISettingStatus}, the class has to register
 * itself at a class, which implements {@link IIntegrationSettings}.
 */
public interface IReportDecider {

	/**
	 * It the given peak is null, false will be returned.<br/>
	 * Otherwise, it will be checked, if the peak should be reported.
	 * 
	 * @param peak
	 * @return boolean
	 */
	boolean report(IPeak peak);
}
