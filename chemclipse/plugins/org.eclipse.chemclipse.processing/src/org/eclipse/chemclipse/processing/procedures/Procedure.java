/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Christoph Läubrich - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.processing.procedures;

import org.eclipse.chemclipse.processing.Processor;
import org.eclipse.chemclipse.processing.ProcessorCategory;
import org.eclipse.chemclipse.processing.supplier.IProcessExecutionConsumer;
import org.eclipse.chemclipse.processing.supplier.ProcessExecutionContext;

public interface Procedure<SettingType> extends Processor<SettingType> {

	<ResultType> IProcessExecutionConsumer<ResultType> createConsumer(SettingType settings, IProcessExecutionConsumer<ResultType> currentConsumer, ProcessExecutionContext context);

	@Override
	default ProcessorCategory[] getProcessorCategories() {

		return new ProcessorCategory[]{};
	}
}
