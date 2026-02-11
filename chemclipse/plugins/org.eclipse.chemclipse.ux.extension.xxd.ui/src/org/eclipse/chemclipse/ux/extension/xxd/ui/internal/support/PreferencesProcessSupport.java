/*******************************************************************************
 * Copyright (c) 2021, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.xxd.ui.internal.support;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import org.eclipse.chemclipse.processing.DataCategory;
import org.eclipse.chemclipse.processing.supplier.IProcessSupplier;
import org.eclipse.chemclipse.processing.supplier.IProcessSupplierContext;
import org.eclipse.chemclipse.ux.extension.xxd.ui.Activator;
import org.eclipse.chemclipse.ux.extension.xxd.ui.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.xxd.process.support.ProcessTypeSupport;
import org.eclipse.chemclipse.xxd.process.ui.support.ProcessorSupport;
import org.eclipse.chemclipse.xxd.process.ui.toolbar.Processor;
import org.eclipse.jface.preference.IPreferenceStore;

public class PreferencesProcessSupport {

	private IPreferenceStore preferenceStore = Activator.getDefault().getPreferenceStore();
	private IProcessSupplierContext processSupplierContext = new ProcessTypeSupport();
	private Set<IProcessSupplier<?>> processSuppliers = new HashSet<>();

	private Predicate<IProcessSupplier<?>> predicateProcessSupplier;
	private DataCategory dataCategory = DataCategory.AUTO_DETECT;

	public PreferencesProcessSupport(DataCategory dataCategory) {

		this.dataCategory = dataCategory;
		this.predicateProcessSupplier = new Predicate<IProcessSupplier<?>>() {

			@Override
			public boolean test(IProcessSupplier<?> processSupplier) {

				if(processSupplier.getSupportedDataTypes().contains(DataCategory.AUTO_DETECT)) {
					return true;
				}
				return processSupplier.getSupportedDataTypes().contains(getDataCategory());
			}
		};

		updateProcessSuppliers();
	}

	public DataCategory getDataCategory() {

		return dataCategory;
	}

	public void setDataCategory(DataCategory dataCategory) {

		this.dataCategory = dataCategory;
	}

	public String persist(List<Processor> processors) {

		updateProcessSuppliers();
		return ProcessorSupport.getActiveProcessors(processors);
	}

	public List<Processor> getActiveProcessors() {

		updateProcessSuppliers();
		String settings = preferenceStore.getString(PreferenceSupplier.P_QUICK_ACCESS_PROCESSORS + dataCategory.name());
		return ProcessorSupport.getActiveProcessors(processSuppliers, settings);
	}

	private void updateProcessSuppliers() {

		processSuppliers.clear();
		processSuppliers.addAll(processSupplierContext.getSupplier(predicateProcessSupplier));
	}
}
