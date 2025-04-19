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
package org.eclipse.chemclipse.converter.model.reports;

public interface IFileAttributes {

	String getFileName();

	void setFileName(String fileName);

	String getCanonicalPath();

	void setCanonicalPath(String canonicalPath);

	long getCreationTime();

	void setCreationTime(long creationTime);

	long getLastAccessTime();

	void setLastAccessTime(long lastAccessTime);

	long getLastModificationTime();

	void setLastModificationTime(long lastModificationTime);
}
