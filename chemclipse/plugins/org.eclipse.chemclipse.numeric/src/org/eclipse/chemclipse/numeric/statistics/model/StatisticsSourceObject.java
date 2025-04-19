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

public class StatisticsSourceObject<T> implements IStatisticsSourceObject<T> {

	private boolean included;
	private final T sourceObject;

	public StatisticsSourceObject(T sourceObject, boolean included) {
		this(sourceObject);
		this.included = included;
	}

	public StatisticsSourceObject(T sourceObject) {
		this.sourceObject = sourceObject;
		this.included = true;
	}

	@Override
	public void setIncluded(boolean included) {

		this.included = included;
	}

	@Override
	public boolean isIncluded() {

		return included;
	}

	@Override
	public T getSourceObject() {

		return sourceObject;
	}
}
