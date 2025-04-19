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
 * Christoph Läubrich - support for E4
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.xxd.ui.editors;

import java.util.function.Supplier;

import org.eclipse.chemclipse.model.types.DataType;
import org.eclipse.chemclipse.processing.converter.ISupplierFileIdentifier;
import org.eclipse.chemclipse.ux.extension.ui.provider.ISupplierEditorSupport;
import org.eclipse.chemclipse.ux.extension.xxd.ui.part.support.SupplierEditorSupport;
import org.eclipse.chemclipse.xxd.process.files.SupplierFileIdentifier;
import org.eclipse.e4.core.contexts.IEclipseContext;

public class EditorSupportFactory {

	private final ISupplierFileIdentifier supplierFileIdentifier;
	private final ISupplierEditorSupport supplierEditorSupport;

	public EditorSupportFactory(DataType dataType, Supplier<IEclipseContext> context) {

		supplierFileIdentifier = new SupplierFileIdentifier(dataType);
		supplierEditorSupport = new SupplierEditorSupport(dataType, context);
	}

	public ISupplierFileIdentifier getInstanceIdentifier() {

		return supplierFileIdentifier;
	}

	public ISupplierEditorSupport getInstanceEditorSupport() {

		return supplierEditorSupport;
	}
}
