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
 * Christoph Läubrich - add stream support
 *******************************************************************************/
package org.eclipse.chemclipse.converter.methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.chemclipse.converter.core.IImportConverter;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.methods.IProcessMethod;
import org.eclipse.chemclipse.processing.methods.ProcessMethod;
import org.eclipse.core.runtime.IProgressMonitor;

public interface IMethodImportConverter extends IImportConverter {

	default IProcessingInfo<IProcessMethod> convert(File file, IProgressMonitor monitor) throws IOException {

		try (FileInputStream stream = new FileInputStream(file)) {
			IProcessingInfo<IProcessMethod> info = readFrom(stream, file.getName(), monitor);
			if(info != null) {
				IProcessMethod result = info.getProcessingResult();
				if(result instanceof ProcessMethod processMethod) {
					processMethod.setSourceFile(file);
				}
			}
			return info;
		}
	}

	IProcessingInfo<IProcessMethod> readFrom(InputStream stream, String nameHint, IProgressMonitor monitor) throws IOException;
}
