/*******************************************************************************
 * Copyright (c) 2016, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Matthias Mailänder - add magic code
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.converter.supplier.zip.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import org.eclipse.chemclipse.converter.core.AbstractMagicNumberMatcher;

public class MagicNumberMatcher extends AbstractMagicNumberMatcher {

	private static final byte[] MAGIC_CODE = new byte[]{(byte)0x50, (byte)0x4B, (byte)0x03, (byte)0x04};
	private static final int LOCAL_HEADER_SIZE = 8;
	private static final int GENERAL_PURPOSE_FLAG_OFFSET = 6;
	private static final int ENCRYPTION_BIT = 0x01;

	@Override
	public boolean checkFileFormat(File file) {

		return checkFileExtension(file, ".zip") && checkMagicCode(file, MAGIC_CODE) && !isEncrypted(file);
	}

	private boolean isEncrypted(File file) {

		try (InputStream inputStream = Files.newInputStream(file.toPath())) {
			byte[] header = new byte[LOCAL_HEADER_SIZE];
			if(inputStream.read(header) < LOCAL_HEADER_SIZE) {
				return false;
			}
			/*
			 * Bit 0 of the general purpose bit flag (offset 6 in the local file header) indicates an encrypted entry.
			 */
			return (header[GENERAL_PURPOSE_FLAG_OFFSET] & ENCRYPTION_BIT) != 0;
		} catch(IOException e) {
			return false;
		}
	}
}
