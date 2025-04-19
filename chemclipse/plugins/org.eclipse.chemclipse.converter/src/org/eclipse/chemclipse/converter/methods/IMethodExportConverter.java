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
 * Alexander Kerner - Generics
 * Christoph Läubrich - Stream support
 *******************************************************************************/
package org.eclipse.chemclipse.converter.methods;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.chemclipse.converter.core.IExportConverter;
import org.eclipse.chemclipse.processing.core.IMessageConsumer;
import org.eclipse.chemclipse.processing.methods.IProcessMethod;
import org.eclipse.core.runtime.IProgressMonitor;

public interface IMethodExportConverter extends IExportConverter {

	default void convert(File file, IProcessMethod processMethod, IMessageConsumer messages, IProgressMonitor monitor) throws IOException {

		try (FileOutputStream stream = new FileOutputStream(file)) {
			convert(stream, file.getName(), processMethod, messages, monitor);
		}
	}

	/**
	 * writes the given method to the {@link OutputStream}
	 *
	 * @param stream
	 * @param nameHint
	 * @param monitor
	 * @throws IOException
	 *             in case of an IOError while reading streams
	 */
	void convert(OutputStream stream, String nameHint, IProcessMethod processMethod, IMessageConsumer messages, IProgressMonitor monitor) throws IOException;
}
