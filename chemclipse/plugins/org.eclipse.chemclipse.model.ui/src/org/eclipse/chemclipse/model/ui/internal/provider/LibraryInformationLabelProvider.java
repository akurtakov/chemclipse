/*******************************************************************************
 * Copyright (c) 2021, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.ui.internal.provider;

import org.eclipse.chemclipse.model.core.IChromatogramOverview;
import org.eclipse.chemclipse.model.identifier.ILibraryInformation;
import org.eclipse.chemclipse.rcp.ui.icons.core.ApplicationImageFactory;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImage;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImageProvider;
import org.eclipse.chemclipse.support.text.ValueFormat;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

public class LibraryInformationLabelProvider extends LabelProvider implements ITableLabelProvider {

	public static final String NAME = "Name";
	public static final String SYNONYMS = "Synonyms";
	public static final String RETENTION_TIME = "Retention Time [min]";
	public static final String CONTRIBUTOR = "Contributor";
	public static final String CAS_NUMBER = "CAS#";
	public static final String FORMULA = "Formula";
	public static final String SMILES = "SMILES";
	public static final String INCHI = "InChI";
	public static final String DATABASE = "Database";
	public static final String DATABASE_INDEX = "Database Index";
	public static final String COMMENTS = "Comments";

	public static final String[] TITLES = { //
			NAME, //
			SYNONYMS, //
			RETENTION_TIME, //
			CONTRIBUTOR, //
			CAS_NUMBER, //
			FORMULA, //
			SMILES, //
			INCHI, //
			DATABASE, //
			DATABASE_INDEX, //
			COMMENTS //
	};

	public static final int[] BOUNDS = { //
			100, //
			100, //
			100, //
			100, //
			100, //
			100, //
			100, //
			100, //
			100, //
			100, //
			100 //
	};

	@Override
	public Image getColumnImage(Object element, int columnIndex) {

		if(columnIndex == 0) {
			return getImage(element);
		}
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {

		String text = "";
		if(element instanceof ILibraryInformation libraryInformation) {
			switch(columnIndex) {
				case 0:
					text = libraryInformation.getName();
					break;
				case 1:
					text = Integer.toString(libraryInformation.getSynonyms().size());
					break;
				case 2:
					text = ValueFormat.getDecimalFormatEnglish("0.000").format(libraryInformation.getRetentionTime() / IChromatogramOverview.MINUTE_CORRELATION_FACTOR);
					break;
				case 3:
					text = libraryInformation.getContributor();
					break;
				case 4:
					text = libraryInformation.getCasNumber();
					break;
				case 5:
					text = libraryInformation.getFormula();
					break;
				case 6:
					text = libraryInformation.getSmiles();
					break;
				case 7:
					text = libraryInformation.getInChI();
					break;
				case 8:
					text = libraryInformation.getDatabase();
					break;
				case 9:
					text = Integer.toString(libraryInformation.getDatabaseIndex());
					break;
				case 10:
					text = libraryInformation.getComments();
					break;
				default:
					text = "n.v.";
			}
		}
		return text;
	}

	@Override
	public Image getImage(Object element) {

		return ApplicationImageFactory.getInstance().getImage(IApplicationImage.IMAGE_SAMPLE, IApplicationImageProvider.SIZE_16x16);
	}
}