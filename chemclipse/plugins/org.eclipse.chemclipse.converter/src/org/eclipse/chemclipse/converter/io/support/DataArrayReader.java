/*******************************************************************************
 * Copyright (c) 2017, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.converter.io.support;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataArrayReader extends AbstractArrayReader implements IDataArrayReader {

	public DataArrayReader(File file) throws FileNotFoundException, IOException {

		super(file);
	}

	public DataArrayReader(byte[] data) {

		super(data);
	}
}
