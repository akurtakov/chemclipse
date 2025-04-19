/*******************************************************************************
 * Copyright (c) 2012, 2025 Lablicate GmbH.
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

public class ArrayReaderTestImplementation extends AbstractArrayReader implements IArrayReader {

	public ArrayReaderTestImplementation(byte[] data) {

		super(data);
	}

	public ArrayReaderTestImplementation(File file) throws FileNotFoundException, IOException {

		super(file);
	}
}
