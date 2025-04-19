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
package org.eclipse.chemclipse.model.supplier;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.model.types.DataType;
import org.eclipse.chemclipse.processing.DataCategory;
import org.eclipse.chemclipse.processing.core.IMessageConsumer;
import org.eclipse.chemclipse.processing.supplier.AbstractProcessSupplier;
import org.eclipse.chemclipse.processing.supplier.IProcessTypeSupplier;
import org.eclipse.chemclipse.processing.supplier.ProcessExecutionContext;
import org.eclipse.core.runtime.IProgressMonitor;

public abstract class ScanProcessSupplier<SettingsClass> extends AbstractProcessSupplier<SettingsClass> implements IScanProcessSupplier<SettingsClass> {

	protected ScanProcessSupplier(String id, String name, String description, Class<SettingsClass> settingsClass, IProcessTypeSupplier parent, DataType... dataTypes) {

		super(id, name, description, settingsClass, parent, convert(dataTypes));
	}

	protected ScanProcessSupplier(String id, String name, String description, Class<SettingsClass> settingsClass, IProcessTypeSupplier parent, int b, DataCategory... dataTypes) {

		super(id, name, description, settingsClass, parent, dataTypes);
	}

	@Override
	public IScan apply(IScan scan, SettingsClass processSettings, ProcessExecutionContext context) {

		return apply(scan, processSettings, context, context.getProgressMonitor());
	}

	protected abstract IScan apply(IScan scan, SettingsClass processSettings, IMessageConsumer messageConsumer, IProgressMonitor monitor);

	private static DataCategory[] convert(DataType[] dataTypes) {

		Set<DataCategory> converted = new HashSet<>();
		for(DataType dataType : dataTypes) {
			converted.add(dataType.toDataCategory());
		}
		return converted.toArray(new DataCategory[0]);
	}
}
