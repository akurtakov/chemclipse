/*******************************************************************************
 * Copyright (c) 2019, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.processing.methods;

import org.eclipse.chemclipse.processing.supplier.IProcessExecutionConsumer;
import org.eclipse.chemclipse.processing.supplier.IProcessorPreferences;
import org.eclipse.chemclipse.processing.supplier.ProcessExecutionContext;

public final class SubProcessExecutionConsumer<T> implements IProcessExecutionConsumer<T> {

	private final IProcessExecutionConsumer<T> intercepted;
	private final SubProcess<T> subprocess;

	public SubProcessExecutionConsumer(IProcessExecutionConsumer<T> parent, SubProcess<T> subprocess) {

		this.intercepted = parent;
		this.subprocess = subprocess;
	}

	@Override
	public <X> void execute(IProcessorPreferences<X> preferences, ProcessExecutionContext context) throws Exception {

		ProcessExecutionContext ctx2;
		if(intercepted.canExecute(preferences)) {
			ProcessExecutionContext ctx1 = context.split();
			ctx1.setContextObject(IProcessExecutionConsumer.class, intercepted);
			intercepted.execute(preferences, ctx1);
			ctx2 = context.split();
		} else {
			ctx2 = context;
		}
		subprocess.execute(preferences, intercepted, ctx2);
	}

	@Override
	public T getResult() {

		return intercepted.getResult();
	}

	@Override
	public IProcessExecutionConsumer<T> withResult(Object initialResult) {

		IProcessExecutionConsumer<T> withResult = intercepted.withResult(initialResult);
		if(withResult == null) {
			return null;
		}
		return new SubProcessExecutionConsumer<>(withResult, subprocess);
	}

	@FunctionalInterface
	public static interface SubProcess<SubType> {

		<SubX> void execute(IProcessorPreferences<SubX> preferences, IProcessExecutionConsumer<SubType> parent, ProcessExecutionContext subcontext);
	}
}
