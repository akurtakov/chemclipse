/*******************************************************************************
 * Copyright (c) 2018, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.ui.support;

import org.eclipse.chemclipse.processing.core.IMessageProvider;
import org.eclipse.chemclipse.processing.methods.IProcessMethod;
import org.eclipse.chemclipse.processing.supplier.IProcessSupplier;
import org.eclipse.chemclipse.processing.supplier.IProcessSupplierContext;
import org.eclipse.chemclipse.processing.supplier.IProcessorPreferences;
import org.eclipse.chemclipse.processing.system.ProcessSettingsSupport;
import org.eclipse.chemclipse.support.history.EditInformation;
import org.eclipse.chemclipse.support.history.IEditHistory;
import org.eclipse.chemclipse.support.history.IEditInformation;
import org.eclipse.chemclipse.support.history.ISupplierEditHistory;
import org.eclipse.chemclipse.support.history.ProcessSupplierEntry;
import org.eclipse.chemclipse.support.settings.UserManagement;

public class AuditTrailSupport {

	public static void updateAuditTrail(ISupplierEditHistory editHistorySupplier, IMessageProvider processingInfo, IProcessMethod processMethod, IProcessSupplierContext processTypeSupport) {

		if(!processingInfo.hasErrorMessages()) {
			processMethod.forEach(p -> updateAuditTrail(editHistorySupplier, p.getName(), processTypeSupport.getSupplier(p.getProcessorId())));
		}
	}

	public static void updateAuditTrail(ISupplierEditHistory editHistorySupplier, IMessageProvider processingInfo, IProcessSupplier<?> processSupplier) {

		if(!processingInfo.hasErrorMessages()) {
			updateAuditTrail(editHistorySupplier, processSupplier.getCategory() + ": " + processSupplier.getName(), processSupplier);
		}
	}

	private static void updateAuditTrail(ISupplierEditHistory editHistorySupplier, String description, IProcessSupplier<?> processSupplier) {

		if(editHistorySupplier != null) {
			/*
			 * Normal description
			 */
			IEditInformation editInformation = new EditInformation(description, UserManagement.getCurrentUser());

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
				editInformation.setProcessSupplierEntry(processSupplierEntry);
			}

			IEditHistory editHistory = editHistorySupplier.getEditHistory();
			editHistory.add(editInformation);
		}
	}
}