/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.xxd.ui.internal.editors;

import org.eclipse.chemclipse.model.types.DataType;
import org.eclipse.chemclipse.processing.converter.ISupplierFileIdentifier;
import org.eclipse.chemclipse.ux.extension.ui.provider.ISupplierEditorSupport;

public class ProjectExplorerSupportFactory {

	private ISupplierFileIdentifier supplierFileIdentifier;
	private ISupplierEditorSupport supplierEditorSupport;

	public ProjectExplorerSupportFactory(DataType dataType) {
		supplierFileIdentifier = new ProjectExplorerFileIdentifier(dataType);
		supplierEditorSupport = new ProjectExplorerEditorSupport(dataType);
	}

	public ISupplierFileIdentifier getInstanceIdentifier() {

		return supplierFileIdentifier;
	}

	public ISupplierEditorSupport getInstanceEditorSupport() {

		return supplierEditorSupport;
	}
}
