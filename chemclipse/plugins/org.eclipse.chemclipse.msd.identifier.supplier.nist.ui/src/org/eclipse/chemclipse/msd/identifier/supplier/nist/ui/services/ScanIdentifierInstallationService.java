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
package org.eclipse.chemclipse.msd.identifier.supplier.nist.ui.services;

import org.eclipse.chemclipse.model.types.DataType;
import org.eclipse.chemclipse.msd.identifier.supplier.nist.ui.preferences.PreferencePageInstallation;
import org.eclipse.chemclipse.swt.ui.services.IScanIdentifierService;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

@Component(service = {IScanIdentifierService.class}, configurationPolicy = ConfigurationPolicy.OPTIONAL)
public class ScanIdentifierInstallationService implements IScanIdentifierService {

	@Override
	public DataType getDataType() {

		return DataType.MSD;
	}

	@Override
	public Class<? extends IWorkbenchPreferencePage> getPreferencePage() {

		return PreferencePageInstallation.class;
	}
}