/*******************************************************************************
 * Copyright (c) 2013, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Christoph Läubrich - adopt to new API, add caching/access of determined {@link ISupplierFileIdentifier}s
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.ui.provider;

import java.io.File;
import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

import org.eclipse.chemclipse.container.support.FileContainerSupport;
import org.eclipse.chemclipse.processing.converter.ISupplier;
import org.eclipse.chemclipse.processing.converter.ISupplierFileIdentifier;
import org.eclipse.chemclipse.ux.extension.ui.swt.IdentifierCacheSupport;

public class LazyDataExplorerContentProvider extends LazyFileExplorerContentProvider {

	private final Function<File, Map<ISupplierFileIdentifier, Collection<ISupplier>>> supplierFunction;

	public LazyDataExplorerContentProvider(Collection<? extends ISupplierFileIdentifier> supplierFileIdentifierList) {

		this(IdentifierCacheSupport.createIdentifierCache(supplierFileIdentifierList));
	}

	public LazyDataExplorerContentProvider(Function<File, Map<ISupplierFileIdentifier, Collection<ISupplier>>> identifier) {

		this.supplierFunction = identifier;
	}

	@Override
	public boolean accept(File file) {

		if(super.accept(file)) {
			if(file.isDirectory()) {
				return true;
			} else if(FileContainerSupport.getCache().getFileContentProvider(file) != null) {
				return true;
			}
			return !supplierFunction.apply(file).isEmpty();
		}
		return false;
	}
}
