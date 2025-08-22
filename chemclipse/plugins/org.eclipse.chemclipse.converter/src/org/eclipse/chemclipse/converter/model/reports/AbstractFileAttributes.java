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

import java.util.ArrayList;

public abstract class AbstractFileAttributes<T extends ISequenceRecord> extends ArrayList<T> implements IFileAttributes {

	private static final long serialVersionUID = 7859362563177957105L;

	private String fileName = "";
	private String canonicalPath = "";
	private long creationTime = 0;
	private long lastAccessTime = 0;
	private long lastModificationTime = 0;

	@Override
	public String getFileName() {

		return fileName;
	}

	@Override
	public void setFileName(String fileName) {

		this.fileName = fileName;
	}

	@Override
	public String getCanonicalPath() {

		return canonicalPath;
	}

	@Override
	public void setCanonicalPath(String canonicalPath) {

		this.canonicalPath = canonicalPath;
	}

	@Override
	public long getCreationTime() {

		return creationTime;
	}

	@Override
	public void setCreationTime(long creationTime) {

		this.creationTime = creationTime;
	}

	@Override
	public long getLastAccessTime() {

		return lastAccessTime;
	}

	@Override
	public void setLastAccessTime(long lastAccessTime) {

		this.lastAccessTime = lastAccessTime;
	}

	@Override
	public long getLastModificationTime() {

		return lastModificationTime;
	}

	@Override
	public void setLastModificationTime(long lastModificationTime) {

		this.lastModificationTime = lastModificationTime;
	}
}
