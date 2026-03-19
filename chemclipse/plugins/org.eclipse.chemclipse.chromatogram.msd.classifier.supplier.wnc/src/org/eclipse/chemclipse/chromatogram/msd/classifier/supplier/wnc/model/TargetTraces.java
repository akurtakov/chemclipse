/*******************************************************************************
 * Copyright (c) 2011, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.model;

import java.util.HashMap;
import java.util.StringTokenizer;

import org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.validators.TargetTraceValidator;
import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.core.runtime.IStatus;

public class TargetTraces extends HashMap<Integer, TargetTrace> {

	private static final long serialVersionUID = -5237292924832144080L;

	private static final Logger logger = Logger.getLogger(TargetTraces.class);

	public static final String ENTRY_DELIMITER = ";"; //$NON-NLS-1$
	public static final String VALUE_DELIMITER = ":"; //$NON-NLS-1$

	private TargetTraceValidator validator = new TargetTraceValidator();

	public static TargetTraces getDefault() {

		TargetTraces targetTraces = new TargetTraces();
		targetTraces.add(new TargetTrace(18, "Water"));
		targetTraces.add(new TargetTrace(28, "Nitrogen"));
		targetTraces.add(new TargetTrace(32, "Oxygen"));
		targetTraces.add(new TargetTrace(44, "Carbon Dioxide"));
		targetTraces.add(new TargetTrace(84, "Solvent Tailing"));
		targetTraces.add(new TargetTrace(207, "Column Bleed"));
		return targetTraces;
	}

	public void add(TargetTrace targetTrace) {

		if(targetTrace != null) {
			put(targetTrace.getIon(), targetTrace);
		}
	}

	public void remove(TargetTrace targetTrace) {

		if(targetTrace != null) {
			remove(targetTrace.getIon());
		}
	}

	public void load(String items) {

		loadSettings(items);
	}

	public String save() {

		return extract();
	}

	private void loadSettings(String content) {

		if(!content.isEmpty()) {
			String[] items = parseString(content);
			if(items.length > 0) {
				String name;
				Integer ion;
				String[] values;
				for(String item : items) {
					try {
						values = item.split(VALUE_DELIMITER);
						if(values.length > 1) {
							name = values[0];
							ion = Integer.parseInt(values[1]);
							add(new TargetTrace(ion, name));
						}
					} catch(NumberFormatException e) {
						logger.warn(e);
					}
				}
			}
		}
	}

	private String[] parseString(String stringList) {

		String[] decodedArray;
		if(stringList.contains(ENTRY_DELIMITER)) {
			StringTokenizer stringTokenizer = new StringTokenizer(stringList, ENTRY_DELIMITER);
			int arraySize = stringTokenizer.countTokens();
			decodedArray = new String[arraySize];
			for(int i = 0; i < arraySize; i++) {
				decodedArray[i] = stringTokenizer.nextToken(ENTRY_DELIMITER);
			}
		} else {
			decodedArray = new String[1];
			decodedArray[0] = stringList;
		}
		return decodedArray;
	}

	public TargetTrace extractSettingInstance(String item) {

		return extract(item);
	}

	public String extractSetting(TargetTrace setting) {

		TargetTraces targetTraces = new TargetTraces();
		targetTraces.add(setting);
		return targetTraces.save();
	}

	private TargetTrace extract(String text) {

		TargetTrace setting = null;

		IStatus status = validator.validate(text);
		if(status.isOK()) {
			setting = validator.getSetting();
		} else {
			logger.warn(status.getMessage());
		}

		return setting;
	}

	private String extract() {

		StringBuilder builder = new StringBuilder();
		for(TargetTrace targetTrace : values()) {
			if(targetTrace != null) {
				builder.append(targetTrace.getName());
				builder.append(VALUE_DELIMITER);
				builder.append(targetTrace.getIon());
				builder.append(ENTRY_DELIMITER);
			}
		}
		return builder.toString();
	}
}