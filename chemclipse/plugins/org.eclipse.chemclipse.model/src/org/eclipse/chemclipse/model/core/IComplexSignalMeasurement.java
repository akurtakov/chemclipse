/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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