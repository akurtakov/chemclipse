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
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.msd.filter.supplier.denoising.ui.internal.provider;

import org.eclipse.chemclipse.support.ui.swt.columns.ColumnDefinitionProvider;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;

public class DenoisingAdapterFactory implements IAdapterFactory {

	private static final SelectionHandler SELECTION_HANDLER = new SelectionHandler();
	private static final ResultTitles TITLES = new ResultTitles();
	private static final ResultsLabelProvider LABEL_PROVIDER = new ResultsLabelProvider();
	private static final ResultsContentProvider CONTENT_PROVIDER = new ResultsContentProvider();

	@Override
	public <T> T getAdapter(Object adaptableObject, Class<T> adapterType) {

		if(adapterType == IStructuredContentProvider.class) {
			return adapterType.cast(CONTENT_PROVIDER);
		}
		if(adapterType == ITableLabelProvider.class) {
			return adapterType.cast(LABEL_PROVIDER);
		}
		if(adapterType == ColumnDefinitionProvider.class) {
			return adapterType.cast(TITLES);
		}
		if(adapterType == ISelectionChangedListener.class) {
			return adapterType.cast(SELECTION_HANDLER);
		}
		return null;
	}

	@Override
	public Class<?>[] getAdapterList() {

		return new Class<?>[]{IStructuredContentProvider.class, ColumnDefinitionProvider.class, ITableLabelProvider.class, ISelectionChangedListener.class};
	}
}
