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
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.xxd.calculator.peak.resolution.ui.internal;

import org.eclipse.chemclipse.chromatogram.xxd.calculator.peak.resolution.ui.provider.MeasurementResultTitles;
import org.eclipse.chemclipse.chromatogram.xxd.calculator.peak.resolution.ui.provider.PeakResolutionResultsContentProvider;
import org.eclipse.chemclipse.chromatogram.xxd.calculator.peak.resolution.ui.provider.PeakResolutionResultsLabelProvider;
import org.eclipse.chemclipse.support.ui.swt.columns.ColumnDefinitionProvider;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;

public class PeakResolutionAdapterFactory implements IAdapterFactory {

	private static final MeasurementResultTitles TITLES = new MeasurementResultTitles();
	private static final PeakResolutionResultsLabelProvider LABEL_PROVIDER = new PeakResolutionResultsLabelProvider();
	private static final PeakResolutionResultsContentProvider CONTENT_PROVIDER = new PeakResolutionResultsContentProvider();

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
		return null;
	}

	@Override
	public Class<?>[] getAdapterList() {

		return new Class<?>[]{IStructuredContentProvider.class, ColumnDefinitionProvider.class, ITableLabelProvider.class};
	}
}
