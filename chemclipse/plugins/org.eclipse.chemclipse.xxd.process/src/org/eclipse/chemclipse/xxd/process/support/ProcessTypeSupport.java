/*******************************************************************************
 * Copyright (c) 2011, 2025 Lablicate GmbH.
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
 * Christoph Läubrich - improve logging output, propagate processor messages, enhance for usage in editors, preference support for processors
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.support;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.eclipse.chemclipse.processing.supplier.IProcessSupplier;
import org.eclipse.chemclipse.processing.supplier.IProcessSupplierContext;
import org.eclipse.chemclipse.processing.supplier.IProcessTypeSupplier;
import org.eclipse.chemclipse.xxd.process.Activator;

/**
 * You could also use the {@link IProcessSupplierContext} OSGI-Service or the E4ProcessSupplierContext if context injection is desired
 */
public class ProcessTypeSupport implements IProcessSupplierContext {

	private final List<IProcessTypeSupplier> localProcessSupplier = new ArrayList<>();

	@Override
	@SuppressWarnings("unchecked")
	public <SettingType> IProcessSupplier<SettingType> getSupplier(String processorId) {

		for(IProcessTypeSupplier typeSupplier : localProcessSupplier) {
			for(IProcessSupplier<?> supplier : typeSupplier.getProcessorSuppliers()) {
				if(supplier.matchesId(processorId)) {
					return (IProcessSupplier<SettingType>)supplier;
				}
			}
		}

		IProcessTypeSupplier[] dynamic = Activator.getProcessTypeSuppliers();
		for(IProcessTypeSupplier typeSupplier : dynamic) {
			for(IProcessSupplier<?> supplier : typeSupplier.getProcessorSuppliers()) {
				if(supplier.matchesId(processorId)) {
					return (IProcessSupplier<SettingType>)supplier;
				}
			}
		}

		return null;
	}

	@Override
	public void visitSupplier(Consumer<? super IProcessSupplier<?>> consumer) {

		for(IProcessTypeSupplier typeSupplier : localProcessSupplier) {
			typeSupplier.getProcessorSuppliers().forEach(consumer);
		}

		for(IProcessTypeSupplier typeSupplier : Activator.getProcessTypeSuppliers()) {
			typeSupplier.getProcessorSuppliers().forEach(consumer);
		}
	}

	/**
	 * Adds the given {@link IProcessTypeSupplier} to this
	 * 
	 * @param processTypeSupplier
	 */
	public void addProcessSupplier(IProcessTypeSupplier processTypeSupplier) {

		localProcessSupplier.add(processTypeSupplier);
	}
}
