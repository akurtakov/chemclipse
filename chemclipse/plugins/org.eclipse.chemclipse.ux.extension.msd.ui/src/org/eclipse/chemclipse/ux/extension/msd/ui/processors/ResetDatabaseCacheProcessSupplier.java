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
package org.eclipse.chemclipse.ux.extension.msd.ui.processors;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.chemclipse.msd.identifier.support.DatabasesCache;
import org.eclipse.chemclipse.processing.core.ICategories;
import org.eclipse.chemclipse.processing.supplier.IProcessSupplier;
import org.eclipse.chemclipse.processing.supplier.IProcessTypeSupplier;
import org.eclipse.chemclipse.processing.supplier.ProcessExecutionContext;
import org.eclipse.chemclipse.processing.system.AbstractSystemProcessSupplier;
import org.eclipse.chemclipse.processing.system.ISystemProcessSettings;
import org.eclipse.chemclipse.ux.extension.msd.ui.settings.ResetDatabaseCacheSettings;
import org.osgi.service.component.annotations.Component;

@Component(service = {IProcessTypeSupplier.class})
public class ResetDatabaseCacheProcessSupplier implements IProcessTypeSupplier {

	private static final String ID = "org.eclipse.chemclipse.ux.extension.msd.ui.system.resetDatabaseCacheMSD";
	public static final String NAME = "Reset Database Cache (MSD)";
	public static final String DESCRIPTION = "Reset the database cache. It will be reloaded on demand.";

	@Override
	public String getCategory() {

		return ICategories.PEAK_IDENTIFIER;
	}

	@Override
	public Collection<IProcessSupplier<?>> getProcessorSuppliers() {

		return Collections.singleton(new ProcessSupplier(this));
	}

	private static final class ProcessSupplier extends AbstractSystemProcessSupplier<ResetDatabaseCacheSettings> {

		public ProcessSupplier(IProcessTypeSupplier parent) {

			super(ID, NAME, DESCRIPTION, ResetDatabaseCacheSettings.class, parent);
		}

		@Override
		public void executeUserSettings(ISystemProcessSettings settings, ProcessExecutionContext context) throws IOException {

			DatabasesCache.resetCache();
		}
	}
}