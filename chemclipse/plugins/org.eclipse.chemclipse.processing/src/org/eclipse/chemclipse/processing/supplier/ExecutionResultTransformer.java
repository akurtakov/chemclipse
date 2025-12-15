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
package org.eclipse.chemclipse.processing.supplier;

import java.io.IOException;

import org.eclipse.chemclipse.processing.methods.IProcessEntryContainer;

/**
 * 
 * A {@link ExecutionResultTransformer} can transform the consumer of a {@link IProcessEntryContainer} child invocation
 */
public interface ExecutionResultTransformer<SettingType> extends IProcessSupplier<SettingType> {

	<T> IProcessExecutionConsumer<T> transform(IProcessExecutionConsumer<T> consumer, IProcessorPreferences<SettingType> processorPreferences, ProcessExecutionContext context) throws IOException;
}
