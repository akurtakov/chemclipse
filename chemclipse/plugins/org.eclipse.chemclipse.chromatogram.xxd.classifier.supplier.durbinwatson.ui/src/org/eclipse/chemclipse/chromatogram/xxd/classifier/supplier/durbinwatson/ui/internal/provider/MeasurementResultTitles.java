/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Christoph Läubrich - adjust to new API
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.xxd.classifier.supplier.durbinwatson.ui.internal.provider;

import static org.eclipse.chemclipse.support.ui.swt.columns.ColumnBuilder.defaultSortableColumn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

import org.eclipse.chemclipse.chromatogram.xxd.classifier.supplier.durbinwatson.result.ISavitzkyGolayFilterRating;
import org.eclipse.chemclipse.support.ui.swt.columns.ColumnDefinition;
import org.eclipse.chemclipse.support.ui.swt.columns.ColumnDefinitionProvider;

public class MeasurementResultTitles implements ColumnDefinitionProvider {

	@Override
	public Collection<? extends ColumnDefinition<?, ?>> getColumnDefinitions() {

		List<ColumnDefinition<?, ?>> list = new ArrayList<>();
		list.add(defaultSortableColumn("Rating", 150, new Function<ISavitzkyGolayFilterRating, Double>() {

			@Override
			public Double apply(ISavitzkyGolayFilterRating rating) {

				return rating.getRating();
			}
		}).create());
		list.add(defaultSortableColumn("Derivative", 150, new Function<ISavitzkyGolayFilterRating, Integer>() {

			@Override
			public Integer apply(ISavitzkyGolayFilterRating rating) {

				return rating.getFilterSettings().getDerivative();
			}
		}).create());
		list.add(defaultSortableColumn("Order", 150, new Function<ISavitzkyGolayFilterRating, Integer>() {

			@Override
			public Integer apply(ISavitzkyGolayFilterRating rating) {

				return rating.getFilterSettings().getOrder();
			}
		}).create());
		list.add(defaultSortableColumn("Width", 150, new Function<ISavitzkyGolayFilterRating, Integer>() {

			@Override
			public Integer apply(ISavitzkyGolayFilterRating rating) {

				return rating.getFilterSettings().getWidth();
			}
		}).create());
		return list;
	}
}
