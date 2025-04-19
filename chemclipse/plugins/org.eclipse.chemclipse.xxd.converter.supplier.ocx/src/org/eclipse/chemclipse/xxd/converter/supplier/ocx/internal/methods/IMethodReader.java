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
 * Christoph Läubrich - stream support
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.converter.supplier.ocx.internal.methods;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.chemclipse.processing.core.IMessageConsumer;
import org.eclipse.chemclipse.processing.methods.IProcessMethod;
import org.eclipse.chemclipse.processing.methods.ProcessMethod;
import org.eclipse.core.runtime.IProgressMonitor;

public interface IMethodReader {

	/**
	 * try to convert the given file
	 * 
	 * @param file
	 * @param consumer
	 * @param monitor
	 * @return <code>null</code> if this reader is not valid for the given file
	 * @throws IOException
	 */
	default IProcessMethod convert(File file, IMessageConsumer consumer, IProgressMonitor monitor) throws IOException {

		try (InputStream stream = new BufferedInputStream(new FileInputStream(file))) {
			IProcessMethod method = convert(stream, file.getName(), consumer, monitor);
			if(method instanceof ProcessMethod processMethod) {
				processMethod.setSourceFile(file);
			}
			return method;
		}
	}

	IProcessMethod convert(InputStream stream, String nameHint, IMessageConsumer consumer, IProgressMonitor monitor) throws IOException;
}
