/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.model;

import java.util.Objects;

public class IndexNameMarker {

	private int retentionIndex = 0;
	private String name = "";

	public IndexNameMarker() {

		this(0, "");
	}

	public IndexNameMarker(int retentionIndex, String name) {

		this.retentionIndex = retentionIndex;
		this.name = name;
	}

	public void copyFrom(IndexNameMarker indexNameMarker) {

		this.retentionIndex = indexNameMarker.getRetentionIndex();
		this.name = indexNameMarker.getName();
	}

	public int getRetentionIndex() {

		return retentionIndex;
	}

	public void setRetentionIndex(int retentionIndex) {

		this.retentionIndex = retentionIndex;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	@Override
	public int hashCode() {

		return Objects.hash(name, retentionIndex);
	}

	@Override
	public boolean equals(Object obj) {

		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		IndexNameMarker other = (IndexNameMarker)obj;
		return Objects.equals(name, other.name) && retentionIndex == other.retentionIndex;
	}

	@Override
	public String toString() {

		return "IndexNameMarker [retentionIndex=" + retentionIndex + ", name=" + name + "]";
	}
}