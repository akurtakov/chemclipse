/*******************************************************************************
 * Copyright (c) 2022, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.identifier;

import org.eclipse.chemclipse.model.columns.ISeparationColumn;

public abstract class AbstractColumnMarker implements IColumnMarker {

	private static final long serialVersionUID = 8169933704424369728L;

	private ISeparationColumn separationColumn;

	public AbstractColumnMarker(ISeparationColumn separationColumn) {

		this.separationColumn = separationColumn;
	}

	@Override
	public ISeparationColumn getSeparationColumn() {

		return separationColumn;
	}
}