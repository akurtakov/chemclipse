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
 * Alexander Kerner - API
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.converter.supplier.ocx.internal.methods;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.chemclipse.processing.core.IMessageConsumer;
import org.eclipse.chemclipse.processing.methods.IProcessMethod;
import org.eclipse.core.runtime.IProgressMonitor;

public interface IMethodWriter {

	default void convert(File file, IProcessMethod processMethod, IMessageConsumer messages, IProgressMonitor monitor) throws IOException {

		try (FileOutputStream stream = new FileOutputStream(file)) {
			convert(stream, file.getName(), processMethod, messages, monitor);
			stream.flush();
		}
	}

	void convert(OutputStream stream, String nameHint, IProcessMethod processMethod, IMessageConsumer messages, IProgressMonitor monitor) throws IOException;
}
