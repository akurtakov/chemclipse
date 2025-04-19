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
package org.eclipse.chemclipse.converter.io.reports;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

import org.eclipse.chemclipse.converter.model.reports.IFileAttributes;

public abstract class AbstractFileAttributeReader {

	public void setFileAttributes(File file, IFileAttributes fileAttributes) throws IOException {

		Path path = Paths.get(file.toURI());
		BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
		fileAttributes.setFileName(file.getName());
		fileAttributes.setCanonicalPath(file.getCanonicalPath());
		fileAttributes.setCreationTime(basicFileAttributes.creationTime().toMillis());
		fileAttributes.setLastAccessTime(basicFileAttributes.lastAccessTime().toMillis());
		fileAttributes.setLastModificationTime(file.lastModified());
	}
}
