/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Christoph Läubrich - initial API and implementation
 * Philip Wenig - filter statistics
 *******************************************************************************/
package org.eclipse.chemclipse.model.core;

import java.util.List;

public interface IComplexSignalMeasurement<T extends IComplexSignal> extends IMeasurement {

	List<? extends T> getSignals();

	String getFilterStatistics();
}