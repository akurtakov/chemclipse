/*******************************************************************************
 * Copyright (c) 2024, 2025 Lablicate GmbH.
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

import org.eclipse.chemclipse.model.core.IChromatogramOverview;
import org.eclipse.chemclipse.rcp.ui.icons.core.ApplicationImageFactory;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImage;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImageProvider;
import org.eclipse.chemclipse.support.ui.provider.AbstractChemClipseLabelProvider;
import org.eclipse.chemclipse.tsd.model.core.TraceRange1D;
import org.eclipse.chemclipse.tsd.model.support.TraceRangeSupport;
import org.eclipse.swt.graphics.Image;

public class TraceRange1DLabelProvider extends AbstractChemClipseLabelProvider {

	public static final String RETENTION_TIME_COLUMN1_START = "Retention Time Start (Column1) [min]";
	public static final String RETENTION_TIME_COLUMN1_STOP = "Retention Time Stop (Column1) [min]";
	public static final String NAME = "Name";
	public static final String TRACES = "Traces";

	public static final String[] TITLES = { //
			RETENTION_TIME_COLUMN1_START, //
			RETENTION_TIME_COLUMN1_STOP, //
			NAME, //
			TRACES //
	};
	public static final int[] BOUNDS = { //
			80, //
			80, //
			100, //
			200 //
	};

	@Override
	public Image getColumnImage(Object element, int columnIndex) {

		if(columnIndex == 0) {
			return getImage(element);
		} else {
			return null;
		}
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {

		String text = "";
		if(element instanceof TraceRange1D traceRange) {
			switch(columnIndex) {
				case 0:
					text = TraceRangeSupport.DF_COLUMN_1_MINUTES.format(traceRange.getRetentionTimeColumn1Start() / IChromatogramOverview.MINUTE_CORRELATION_FACTOR);
					break;
				case 1:
					text = TraceRangeSupport.DF_COLUMN_1_MINUTES.format(traceRange.getRetentionTimeColumn1Stop() / IChromatogramOverview.MINUTE_CORRELATION_FACTOR);
					break;
				case 2:
					text = traceRange.getName();
					break;
				case 3:
					text = traceRange.getTraces();
					break;
				default:
					text = "n.a.";
			}
		}
		return text;
	}

	@Override
	public Image getImage(Object element) {

		return ApplicationImageFactory.getInstance().getImage(IApplicationImage.IMAGE_CHROMATOGRAM, IApplicationImageProvider.SIZE_16x16);
	}
}