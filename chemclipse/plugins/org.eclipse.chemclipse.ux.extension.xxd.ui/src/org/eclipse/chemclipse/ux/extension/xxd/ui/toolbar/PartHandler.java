/*******************************************************************************
 * Copyright (c) 2020, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.xxd.ui.toolbar;

public class PartHandler extends AbstractPartHandler {

	private String name = "";
	private PartStackReference partStackReference;

	public PartHandler(String name, String partId, String stackPositionKey) {

		this.name = name;
		this.partStackReference = new PartStackReference(partId, stackPositionKey);
	}

	@Override
	public String getName() {

		return name;
	}

	@Override
	public PartStackReference getPartStackReference() {

		return partStackReference;
	}
}
