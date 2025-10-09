/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.converter.supplier.jcampdx.io;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.model.columns.ISeparationColumn;
import org.eclipse.chemclipse.model.columns.SeparationColumnFactory;
import org.eclipse.chemclipse.model.identifier.ColumnIndexMarker;
import org.eclipse.chemclipse.model.identifier.IIdentificationTarget;
import org.eclipse.chemclipse.model.identifier.ILibraryInformation;
import org.eclipse.chemclipse.msd.model.core.IRegularLibraryMassSpectrum;
import org.eclipse.chemclipse.support.model.SeparationColumnType;
import org.eclipse.chemclipse.xxd.converter.supplier.jcampdx.preferences.PreferenceSupplier;

public class RetentionIndexSupport {

	private static final Logger logger = Logger.getLogger(RetentionIndexSupport.class);
	/*
	 * Variations:
	 * ##RI=
	 * ##RI1=
	 * ##RI2=
	 * ...
	 */
	public static final String RETENTION_INDEX_MARKER = "##RI";
	public static final Pattern RETENTION_INDEX_PATTERN = Pattern.compile("(RI)([0-3]?)(=)(.*)");

	public void extract(IRegularLibraryMassSpectrum massSpectrum, String line) {

		Matcher matcher = RetentionIndexSupport.RETENTION_INDEX_PATTERN.matcher(line);
		if(matcher.find()) {
			/*
			 * RI, Type
			 */
			float retentionIndex = getRetentionIndex(matcher);
			SeparationColumnType separationColumnType = getSeparationColumnType(matcher);
			/*
			 * Set Retention Index
			 */
			if(SeparationColumnType.DEFAULT.equals(separationColumnType)) {
				massSpectrum.setRetentionIndex(retentionIndex);
			} else {
				ILibraryInformation libraryInformation = massSpectrum.getLibraryInformation();
				ISeparationColumn separationColumn = SeparationColumnFactory.getSeparationColumn(separationColumnType);
				libraryInformation.add(new ColumnIndexMarker(separationColumn, retentionIndex));
				massSpectrum.setRetentionIndex(separationColumnType, retentionIndex);
				if(massSpectrum.getRetentionIndex() == 0.0f) {
					massSpectrum.setRetentionIndex(retentionIndex);
				}
			}
		}
	}

	public void extract(IIdentificationTarget identificationTarget, String line) {

		if(identificationTarget != null) {
			Matcher matcher = RetentionIndexSupport.RETENTION_INDEX_PATTERN.matcher(line);
			if(matcher.find()) {
				/*
				 * RI, Type
				 */
				float retentionIndex = getRetentionIndex(matcher);
				SeparationColumnType separationColumnType = getSeparationColumnType(matcher);
				/*
				 * Set Retention Index
				 */
				ILibraryInformation libraryInformation = identificationTarget.getLibraryInformation();
				if(SeparationColumnType.DEFAULT.equals(separationColumnType)) {
					libraryInformation.setRetentionIndex(retentionIndex);
				} else {
					ISeparationColumn separationColumn = SeparationColumnFactory.getSeparationColumn(separationColumnType);
					libraryInformation.add(new ColumnIndexMarker(separationColumn, retentionIndex));
					if(libraryInformation.getRetentionIndex() == 0.0f) {
						libraryInformation.setRetentionIndex(retentionIndex);
					}
				}
			}
		}
	}

	private SeparationColumnType getSeparationColumnType(Matcher matcher) {

		String position = matcher.group(2);
		int index = position.isEmpty() ? 0 : Integer.parseInt(position);

		SeparationColumnType separationColumnType;
		switch(index) {
			case 1:
				separationColumnType = PreferenceSupplier.getSeparationColumnTypeRetentionIndex1();
				break;
			case 2:
				separationColumnType = PreferenceSupplier.getSeparationColumnTypeRetentionIndex2();
				break;
			case 3:
				separationColumnType = PreferenceSupplier.getSeparationColumnTypeRetentionIndex3();
				break;
			default:
				separationColumnType = SeparationColumnType.DEFAULT;
				break;
		}

		return separationColumnType;
	}

	private float getRetentionIndex(Matcher matcher) {

		String value = matcher.group(4);

		float retentionIndex = 0;
		try {
			retentionIndex = (float)(Double.parseDouble(value.trim()));
		} catch(NumberFormatException e) {
			logger.warn(e);
		}

		return retentionIndex;
	}
}