/*******************************************************************************
 * Copyright (c) 2015, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Dr. Janos Binder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.numeric.statistics.model;

import java.util.List;

public interface IStatisticsElement<T> {

	Object getIdentifier();

	void setIdentifier(Object identifier);

	List<IStatisticsSourceObject<T>> getSourceElements();

	List<T> getIncludedSourceElements();

	void setSourceElements(List<IStatisticsSourceObject<T>> sourceElements);

	boolean isContentStatistics();

	IStatistics getStatisticsContent();

	void setStatisticsContent(IStatistics content);

	<S> List<IStatisticsElement<S>> getStatisticsElements();

	<S> void setStatisticsElements(List<IStatisticsElement<S>> content);
}