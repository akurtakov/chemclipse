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
package org.eclipse.chemclipse.support.ui.menu;

public abstract class AbstractTableMenuEntry implements ITableMenuEntry {

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ((getCategory() == null) ? 0 : getCategory().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		AbstractTableMenuEntry other = (AbstractTableMenuEntry)obj;
		if(getCategory() == null) {
			if(other.getCategory() != null)
				return false;
		} else if(!getCategory().equals(other.getCategory()))
			return false;
		if(getName() == null) {
			if(other.getName() != null)
				return false;
		} else if(!getName().equals(other.getName()))
			return false;
		return true;
	}

	@Override
	public String toString() {

		return "TableMenuEntry [category=" + getCategory() + ", name=" + getName() + "]";
	}
}
