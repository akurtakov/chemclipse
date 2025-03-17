/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.fsd.converter.chromatogram;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.chemclipse.converter.chromatogram.ChromatogramExportSettings;
import org.eclipse.chemclipse.converter.core.IConverterSupport;
import org.eclipse.chemclipse.fsd.model.core.IChromatogramFSD;
import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.model.supplier.ChromatogramSelectionProcessSupplier;
import org.eclipse.chemclipse.model.types.DataType;
import org.eclipse.chemclipse.processing.converter.ISupplier;
import org.eclipse.chemclipse.processing.core.ICategories;
import org.eclipse.chemclipse.processing.core.IMessageConsumer;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.supplier.IProcessSupplier;
import org.eclipse.chemclipse.processing.supplier.IProcessTypeSupplier;
import org.eclipse.core.runtime.IProgressMonitor;
import org.osgi.service.component.annotations.Component;

@Component(service = {IProcessTypeSupplier.class})
public class ChromatogramConverterFSDProcessTypeSupplier implements IProcessTypeSupplier {

	@Override
	public String getCategory() {

		return ICategories.CHROMATOGRAM_EXPORT;
	}

	@Override
	public Collection<IProcessSupplier<?>> getProcessorSuppliers() {

		List<IProcessSupplier<?>> list = new ArrayList<>();
		List<ISupplier> suppliers = new ArrayList<>(ChromatogramConverterFSD.getInstance().getChromatogramConverterSupport().getSupplier(IConverterSupport.EXPORT_SUPPLIER));
		for(ISupplier supplier : suppliers) {
			list.add(new ChromatogramConverterFSDProcessorSupplier(supplier, this));
		}
		return list;
	}

	private static final class ChromatogramConverterFSDProcessorSupplier extends ChromatogramSelectionProcessSupplier<ChromatogramExportSettings> {

		private ISupplier supplier;

		public ChromatogramConverterFSDProcessorSupplier(ISupplier supplier, IProcessTypeSupplier parent) {

			super("fsd.export." + supplier.getId(), supplier.getFilterName(), supplier.getDescription(), ChromatogramExportSettings.class, parent, DataType.FSD);
			this.supplier = supplier;
		}

		@Override
		public IChromatogramSelection apply(IChromatogramSelection chromatogramSelection, ChromatogramExportSettings processSettings, IMessageConsumer messageConsumer, IProgressMonitor monitor) {

			if(processSettings == null) {
				processSettings = new ChromatogramExportSettings();
			}
			File exportFolder = processSettings.getExportFolder();
			if(exportFolder == null) {
				messageConsumer.addErrorMessage(getName(), "No output folder specified and no default configured.");
				return chromatogramSelection;
			}
			if(exportFolder.exists() || exportFolder.mkdirs()) {
				IChromatogram chromatogram = chromatogramSelection.getChromatogram();
				if(chromatogram instanceof IChromatogramFSD chromatogramFSD) {
					File file = processSettings.getExportFile(supplier.getFileExtension(), chromatogram);
					IProcessingInfo<File> info = ChromatogramConverterFSD.getInstance().convert(file, chromatogramFSD, supplier.getId(), monitor);
					messageConsumer.addMessages(info);
					if(info != null && info.getProcessingResult() != null) {
						File result = info.getProcessingResult();
						messageConsumer.addInfoMessage(getName(), "Exported data to " + result.getAbsolutePath());
					}
				} else {
					messageConsumer.addWarnMessage(getName(), "Only FSD chromatograms supported, skip processing.");
				}
			} else {
				messageConsumer.addErrorMessage(getName(), "The specified output folder (" + exportFolder.getAbsolutePath() + ") does not exist and can't be created.");
			}
			return chromatogramSelection;
		}

		@Override
		public boolean matchesId(String id) {

			return super.matchesId(id) || supplier.getId().equals(id);
		}
	}
}
