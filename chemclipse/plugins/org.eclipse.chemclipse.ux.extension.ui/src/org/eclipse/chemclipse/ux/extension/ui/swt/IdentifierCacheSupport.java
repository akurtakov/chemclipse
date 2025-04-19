/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Christoph Läubrich - initial API and implementation
 * Philip Wenig - refactored into support class
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.ui.swt;

import java.util.Collection;

import org.eclipse.chemclipse.processing.converter.ISupplierFileIdentifier;
import org.eclipse.chemclipse.ux.extension.ui.provider.LazyFileExplorerContentProvider;
import org.eclipse.chemclipse.xxd.process.files.SupplierFileIdentifierCache;

public class IdentifierCacheSupport {

	public static SupplierFileIdentifierCache createIdentifierCache(Collection<? extends ISupplierFileIdentifier> supplierFileIdentifierList) {

		SupplierFileIdentifierCache cache = new SupplierFileIdentifierCache(LazyFileExplorerContentProvider.MAX_CACHE_SIZE);
		cache.setIdentifier(supplierFileIdentifierList);
		return cache;
	}
}
