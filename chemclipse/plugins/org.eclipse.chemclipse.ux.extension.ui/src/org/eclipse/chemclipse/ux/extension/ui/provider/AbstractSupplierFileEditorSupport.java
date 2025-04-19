/*******************************************************************************
 * Copyright (c) 2013, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.ui.provider;

import java.io.File;
import java.util.Collections;
import java.util.List;

import org.eclipse.chemclipse.processing.converter.AbstractSupplierFileIdentifier;
import org.eclipse.chemclipse.processing.converter.ISupplier;

public abstract class AbstractSupplierFileEditorSupport extends AbstractSupplierFileIdentifier implements ISupplierFileEditorSupport {

	protected AbstractSupplierFileEditorSupport(List<ISupplier> suppliers) {

		super(suppliers);
	}

	@Override
	public boolean openEditor(File file, boolean batch) {

		return openEditor(file, Collections.emptyMap(), batch);
	}

	@Override
	public boolean openEditor(File file, ISupplier supplier) {

		return openEditor(file, Collections.emptyMap(), supplier);
	}
}