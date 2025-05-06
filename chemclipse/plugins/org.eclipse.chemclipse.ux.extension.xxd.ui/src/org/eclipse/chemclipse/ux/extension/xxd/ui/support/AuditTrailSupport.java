/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Alexander Kerner - Generics
 * Christoph Läubrich - propagate result of methods to the user, add label selection support
 * Matthias Mailänder - display selected wavelengths, audit trail
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.xxd.ui.support;

import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.processing.core.IMessageProvider;
import org.eclipse.chemclipse.processing.methods.IProcessMethod;
import org.eclipse.chemclipse.processing.supplier.IProcessSupplier;
import org.eclipse.chemclipse.processing.supplier.IProcessSupplierContext;
import org.eclipse.chemclipse.processing.supplier.IProcessorPreferences;
import org.eclipse.chemclipse.processing.system.ProcessSettingsSupport;
import org.eclipse.chemclipse.support.history.EditInformation;
import org.eclipse.chemclipse.support.history.IEditHistory;
import org.eclipse.chemclipse.support.history.ProcessSupplierEntry;
import org.eclipse.chemclipse.support.history.ProcessSupplierSupport;
import org.eclipse.chemclipse.support.settings.UserManagement;

public class AuditTrailSupport {

	public static void updateAuditTrail(IChromatogram chromatogram, IMessageProvider processingInfo, IProcessMethod processMethod, IProcessSupplierContext processTypeSupport) {

		if(!processingInfo.hasErrorMessages()) {
			processMethod.forEach(p -> updateAuditTrail(chromatogram, p.getName(), processTypeSupport.getSupplier(p.getProcessorId())));
		}
	}

	public static void updateAuditTrail(IChromatogram chromatogram, IMessageProvider processingInfo, IProcessSupplier<?> processSupplier) {

		if(!processingInfo.hasErrorMessages()) {
			updateAuditTrail(chromatogram, processSupplier.getCategory() + ": " + processSupplier.getName(), processSupplier);
		}
	}

	private static void updateAuditTrail(IChromatogram chromatogram, String description, IProcessSupplier<?> processSupplier) {

		if(chromatogram != null) {
			IEditHistory editHistory = chromatogram.getEditHistory();
			/*
			 * Normal description
			 */
			editHistory.add(new EditInformation(description, UserManagement.getCurrentUser()));
			/*
			 * Detailed step to recover process method
			 */
			if(processSupplier != null) {
				IProcessorPreferences<?> processorPreferences = ProcessSettingsSupport.getWorkspacePreferences(processSupplier);
				ProcessSupplierEntry processSupplierEntry = new ProcessSupplierEntry();
				processSupplierEntry.setId(processSupplier.getId());
				processSupplierEntry.setName(processSupplier.getName());
				processSupplierEntry.setDescription(processSupplier.getDescription());
				processSupplierEntry.setUserSettings(processorPreferences.getUserSettingsAsString());
				editHistory.add(ProcessSupplierSupport.createEditInformation(processSupplierEntry));
			}
		}
	}
}