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
 * Philip Wenig - refactor menu categories
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.msd.peak.detector.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.chemclipse.chromatogram.msd.peak.detector.settings.IPeakDetectorSettingsMSD;
import org.eclipse.chemclipse.chromatogram.peak.detector.core.IPeakDetectorSupplier;
import org.eclipse.chemclipse.chromatogram.peak.detector.core.IPeakDetectorSupport;
import org.eclipse.chemclipse.chromatogram.peak.detector.exceptions.NoPeakDetectorAvailableException;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.model.supplier.ChromatogramSelectionProcessSupplier;
import org.eclipse.chemclipse.model.types.DataType;
import org.eclipse.chemclipse.msd.model.core.selection.IChromatogramSelectionMSD;
import org.eclipse.chemclipse.processing.core.ICategories;
import org.eclipse.chemclipse.processing.core.IMessageConsumer;
import org.eclipse.chemclipse.processing.supplier.IProcessSupplier;
import org.eclipse.chemclipse.processing.supplier.IProcessTypeSupplier;
import org.eclipse.core.runtime.IProgressMonitor;
import org.osgi.service.component.annotations.Component;

@Component(service = IProcessTypeSupplier.class)
public class PeakDetectorMSDProcessTypeSupplier implements IProcessTypeSupplier {

	@Override
	public String getCategory() {

		return ICategories.PEAK_DETECTOR;
	}

	@Override
	public Collection<IProcessSupplier<?>> getProcessorSuppliers() {

		try {
			IPeakDetectorSupport support = PeakDetectorMSD.getPeakDetectorSupport();
			List<IProcessSupplier<?>> list = new ArrayList<>();
			for(String processorId : support.getAvailablePeakDetectorIds()) {
				IPeakDetectorSupplier supplier = support.getPeakDetectorSupplier(processorId);
				list.add(new PeakDetectorProcessorSupplier(supplier, this));
			}
			return list;
		} catch(NoPeakDetectorAvailableException e) {
			return Collections.emptyList();
		}
	}

	private static final class PeakDetectorProcessorSupplier extends ChromatogramSelectionProcessSupplier<IPeakDetectorSettingsMSD> {

		private IPeakDetectorSupplier supplier;

		@SuppressWarnings("unchecked")
		public PeakDetectorProcessorSupplier(IPeakDetectorSupplier supplier, IProcessTypeSupplier parent) {

			super("PeakDetectorMSD." + supplier.getId(), supplier.getPeakDetectorName(), supplier.getDescription(), (Class<IPeakDetectorSettingsMSD>)supplier.getSettingsClass(), parent, DataType.MSD);
			getLiteratureReferences().addAll(supplier.getLiteratureReferences());
			this.supplier = supplier;
		}

		@Override
		public IChromatogramSelection apply(IChromatogramSelection chromatogramSelection, IPeakDetectorSettingsMSD processSettings, IMessageConsumer messageConsumer, IProgressMonitor monitor) {

			if(chromatogramSelection instanceof IChromatogramSelectionMSD chromatogramSelectionMSD) {
				if(processSettings instanceof IPeakDetectorSettingsMSD) {
					messageConsumer.addMessages(PeakDetectorMSD.detect(chromatogramSelectionMSD, processSettings, supplier.getId(), monitor));
				}
			} else {
				messageConsumer.addWarnMessage(getDescription(), "Only MSD Chromatogram supported, skip processing");
			}
			return chromatogramSelection;
		}

		@Override
		public boolean matchesId(String id) {

			return super.matchesId(id) || supplier.getId().equals(id);
		}
	}
}
