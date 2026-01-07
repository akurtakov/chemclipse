/*******************************************************************************
 * Copyright (c) 2025, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Lorenz Gerber - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.core;

import java.util.List;

import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IDataInputEntry;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.Samples;
import org.eclipse.core.runtime.IProgressMonitor;

public class PcaExtractionFileLongText implements IExtractionData {

	public static final String DESCRIPTION = "PCA Data Long Format";
	public static final String FILE_EXTENSION = ".pdl";
	public static final String FILE_NAME = DESCRIPTION.replaceAll("\\s", "") + FILE_EXTENSION;
	public static final String FILTER_EXTENSION = "*" + FILE_EXTENSION;
	public static final String FILTER_NAME = DESCRIPTION + " (*" + FILE_EXTENSION + ")";
	private final List<IDataInputEntry> dataInputEntries;
	private final List<IDataInputEntry> filterDataInputEntries;
	private int numberOfSamplesToFilter;

	public PcaExtractionFileLongText(List<IDataInputEntry> dataInputEntries, List<IDataInputEntry> filterDataInputEntries, int numberOfSamplesToFilter) {

		this.dataInputEntries = dataInputEntries;
		this.filterDataInputEntries = filterDataInputEntries;
		this.numberOfSamplesToFilter = numberOfSamplesToFilter;
	}

	@Override
	public Samples process(IProgressMonitor monitor) {

		return extract();
	}

	private Samples extract() {

		LongFileExtractor extractor = new LongFileExtractor(dataInputEntries, filterDataInputEntries, numberOfSamplesToFilter);
		return (extractor.extract());

	}
}
