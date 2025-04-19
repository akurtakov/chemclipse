/*******************************************************************************
 * Copyright (c) 2020, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Christoph Läubrich - initial API and implementation
 * Matthias Mailänder - add MALDI support
 * Philip Wenig - generalized data categories
 *******************************************************************************/
package org.eclipse.chemclipse.processing;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public final class DataCategoryGroup {

	private final String name;
	private final Set<DataCategory> dataCategories;
	private static final DataCategoryGroup[] DEFAULT_GROUPS = new DataCategoryGroup[]{ //
			new DataCategoryGroup("Chromatography", DataCategory.chromatographyCategories()), //
			new DataCategoryGroup("Spectroscopy", DataCategory.spectroscopyCategories()), //
			new DataCategoryGroup("Spectrometry", DataCategory.spectrometryCategories())};

	public DataCategoryGroup(String name, DataCategory... dataCategories) {

		this(name, Arrays.asList(dataCategories));
	}

	public DataCategoryGroup(String name, Collection<DataCategory> dataCategories) {

		this.name = name;
		this.dataCategories = Collections.unmodifiableSet(new LinkedHashSet<>(dataCategories));
	}

	public String getName() {

		return name;
	}

	public Set<DataCategory> getDataCategories() {

		return dataCategories;
	}

	public static DataCategoryGroup[] defaultGroups() {

		return DEFAULT_GROUPS.clone();
	}
}