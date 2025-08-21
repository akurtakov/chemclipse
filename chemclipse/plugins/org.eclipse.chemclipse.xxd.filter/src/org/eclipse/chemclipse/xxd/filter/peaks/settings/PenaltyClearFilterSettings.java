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
package org.eclipse.chemclipse.xxd.filter.peaks.settings;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.model.settings.IProcessSettings;
import org.eclipse.chemclipse.support.literature.LiteratureReference;

public class PenaltyClearFilterSettings implements IProcessSettings {

	private static final Logger logger = Logger.getLogger(PenaltyClearFilterSettings.class);

	@Override
	public List<LiteratureReference> getLiteratureReferences() {

		List<LiteratureReference> literatureReferences = new ArrayList<>();
		literatureReferences.add(createLiteratureReference("S1044030599000471.ris", "10.1016/S1044-0305(99)00047-1"));

		return literatureReferences;
	}

	private static LiteratureReference createLiteratureReference(String file, String doi) {

		try {
			return new LiteratureReference(new String(PenaltyClearFilterSettings.class.getResourceAsStream(file).readAllBytes()));
		} catch(Exception e) {
			logger.warn(e);
			return new LiteratureReference(doi);
		}
	}
}