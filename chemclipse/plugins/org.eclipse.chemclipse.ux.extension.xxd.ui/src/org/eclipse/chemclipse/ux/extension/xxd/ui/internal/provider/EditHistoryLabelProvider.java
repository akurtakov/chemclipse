/*******************************************************************************
 * Copyright (c) 2014, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.xxd.ui.internal.provider;

import org.eclipse.chemclipse.processing.supplier.IProcessSupplier;
import org.eclipse.chemclipse.processing.supplier.IProcessSupplierContext;
import org.eclipse.chemclipse.rcp.ui.icons.core.ApplicationImageFactory;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImage;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImageProvider;
import org.eclipse.chemclipse.support.history.IEditInformation;
import org.eclipse.chemclipse.support.l10n.SupportMessages;
import org.eclipse.chemclipse.ux.extension.xxd.ui.Activator;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

public class EditHistoryLabelProvider extends LabelProvider implements ITableLabelProvider {

	public static final String[] TITLES = {//
			SupportMessages.columnDescription, //
			SupportMessages.columnEditor, //
			SupportMessages.columnDate, //
	};

	public static final int[] BOUNDS = {//
			300, //
			100, //
			100, //
	};

	@Override
	public Image getColumnImage(Object element, int columnIndex) {

		if(columnIndex == 0) {
			if(element instanceof IEditInformation editInformation && editInformation.getProcessSupplierEntry() != null) {

				IProcessSupplierContext supplierContext = Activator.getProcessSupplierContext();
				IProcessSupplier<?> supplier = supplierContext.getSupplier(editInformation.getProcessSupplierEntry().getId());
				if(supplier == null) {
					return ApplicationImageFactory.getInstance().getImage(IApplicationImage.IMAGE_STATUS_ERROR, IApplicationImageProvider.SIZE_16x16);
				}

				if(supplier.getSettingsClass() == null) {
					return ApplicationImageFactory.getInstance().getImage(IApplicationImage.IMAGE_STATUS_WARN, IApplicationImageProvider.SIZE_16x16);
				}

				return ApplicationImageFactory.getInstance().getImage(IApplicationImage.IMAGE_STATUS_OK, IApplicationImageProvider.SIZE_16x16);

			} else {
				return ApplicationImageFactory.getInstance().getImage(IApplicationImage.IMAGE_STATUS_EMPTY, IApplicationImageProvider.SIZE_16x16);
			}
		}
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {

		String text = "";
		if(element instanceof IEditInformation editInformation) {
			switch(columnIndex) {
				case 0:
					text = editInformation.getDescription();
					break;
				case 1:
					text = editInformation.getEditor();
					break;
				case 2:
					text = editInformation.getDate().toString();
					break;
				default:
					text = SupportMessages.labelNotAvailable;
			}
		}
		return text;
	}
}
