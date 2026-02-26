/*******************************************************************************
 * Copyright (c) 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.xxd.ui.support;

import java.io.IOException;

import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.model.settings.IProcessSettings;
import org.eclipse.chemclipse.processing.supplier.IProcessSupplier;
import org.eclipse.chemclipse.processing.supplier.IProcessSupplierContext;
import org.eclipse.chemclipse.processing.supplier.IProcessorPreferences;
import org.eclipse.chemclipse.processing.system.ProcessSettingsSupport;
import org.eclipse.chemclipse.ux.extension.ui.methods.SettingsWizard;
import org.eclipse.chemclipse.ux.extension.xxd.ui.Activator;
import org.eclipse.swt.widgets.Shell;

public class ProcessorSettingsSupport {

	private static final Logger logger = Logger.getLogger(ProcessorSettingsSupport.class);

	public static <S extends IProcessSettings> S getSettings(Shell shell, String identifier) {

		S settings = null;
		IProcessSupplierContext supplierContext = Activator.getProcessSupplierContext();
		IProcessSupplier<S> processSupplier = supplierContext.getSupplier(identifier);
		if(processSupplier != null) {
			try {
				IProcessorPreferences<S> processorPreferences = SettingsWizard.getSettings(shell, ProcessSettingsSupport.getWorkspacePreferences(processSupplier), true);
				if(processorPreferences != null) {
					settings = processorPreferences.getSettings();
				}
			} catch(IOException e) {
				logger.warn(e);
			}
		}

		return settings;
	}
}