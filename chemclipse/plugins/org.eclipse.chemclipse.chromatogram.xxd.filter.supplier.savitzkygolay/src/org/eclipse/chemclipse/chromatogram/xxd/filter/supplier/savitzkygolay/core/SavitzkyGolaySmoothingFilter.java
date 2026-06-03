/*******************************************************************************
 * Copyright (c) 2019, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Christoph Läubrich - initial API and implementation
 * Philip Wenig - refactorings
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.savitzkygolay.core;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.chromatogram.filter.result.IChromatogramFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.ResultStatus;
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.calculator.FilterSupplier;
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.savitzkygolay.processor.SavitzkyGolayProcessor;
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.savitzkygolay.settings.ChromatogramFilterSettings;
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.savitzkygolay.settings.MassSpectrumFilterSettings;
import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.model.filter.IScanFilter;
import org.eclipse.chemclipse.model.filter.ITotalScanSignalsFilter;
import org.eclipse.chemclipse.model.signals.ITotalScanSignals;
import org.eclipse.chemclipse.msd.model.core.IIonProvider;
import org.eclipse.chemclipse.processing.core.DefaultProcessingResult;
import org.eclipse.chemclipse.processing.core.IProcessingResult;
import org.eclipse.chemclipse.processing.filter.Filter;
import org.eclipse.chemclipse.processing.filter.FilterList;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.core.runtime.IProgressMonitor;
import org.osgi.service.component.annotations.Component;

@Component(service = {Filter.class, IScanFilter.class, ITotalScanSignalsFilter.class})
public class SavitzkyGolaySmoothingFilter implements IScanFilter<MassSpectrumFilterSettings>, ITotalScanSignalsFilter<MassSpectrumFilterSettings> {

	@Override
	public String getName() {

		return "Savitzky-Golay Smoothing";
	}

	@Override
	public MassSpectrumFilterSettings createNewConfiguration() {

		return new MassSpectrumFilterSettings();
	}

	@Override
	public IProcessingResult<Boolean> filterScans(FilterList<IScan> filterItems, MassSpectrumFilterSettings configuration, IProgressMonitor monitor) throws IllegalArgumentException {

		if(configuration == null) {
			configuration = createNewConfiguration();
		}
		DefaultProcessingResult<Boolean> result = new DefaultProcessingResult<>();
		List<IIonProvider> massSpectra = new ArrayList<>();
		for(IScan scan : filterItems) {
			IIonProvider ionProvider = Adapters.adapt(scan, IIonProvider.class);
			if(ionProvider != null) {
				massSpectra.add(ionProvider);
			} else {
				throw new IllegalArgumentException("Input contains invalid scan, use IScanFilter#acceptsIScan(IScan) to check for compatible types");
			}
		}
		int derivative = configuration.getDerivative();
		int order = configuration.getOrder();
		int width = configuration.getWidth();
		IProcessingResult<Integer> golayFilter = new FilterSupplier().applySavitzkyGolayFilter(massSpectra, derivative, order, width);
		result.setProcessingResult(golayFilter.getProcessingResult() > 0);
		result.addMessages(golayFilter);
		result.addInfoMessage(getName(), filterItems.size() + " scans were smoothed with derivative=" + derivative + ", order=" + order + ", width=" + width);
		return result;
	}

	@Override
	public boolean acceptsIScan(IScan item) {

		return Adapters.adapt(item, IIonProvider.class) != null;
	}

	@Override
	public IProcessingResult<Boolean> filterTotalScanSignals(FilterList<ITotalScanSignals> filterItems, MassSpectrumFilterSettings configuration, IProgressMonitor monitor) throws IllegalArgumentException {

		if(configuration == null) {
			configuration = createNewConfiguration();
		}
		ChromatogramFilterSettings chromatogramFilterSettings = new ChromatogramFilterSettings();
		chromatogramFilterSettings.setDerivative(configuration.getDerivative());
		chromatogramFilterSettings.setOrder(configuration.getOrder());
		chromatogramFilterSettings.setWidth(configuration.getWidth());

		DefaultProcessingResult<Boolean> result = new DefaultProcessingResult<>();
		for(ITotalScanSignals signals : filterItems) {
			IChromatogramFilterResult filterResult = SavitzkyGolayProcessor.apply(signals, chromatogramFilterSettings);
			if(filterResult.getResultStatus() != ResultStatus.OK) {
				result.addErrorMessage(getName(), filterResult.getDescription());
				break;
			} else {
				result.addInfoMessage(getName(), filterResult.getDescription());
				result.setProcessingResult(Boolean.TRUE);
			}
		}
		return result;
	}

	@Override
	public Class<MassSpectrumFilterSettings> getConfigClass() {

		return null;
	}

	@Override
	public boolean acceptsTotalScanSignals(ITotalScanSignals item) {

		return true;
	}
}
