/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Matthias Mailänder - initial API
 *******************************************************************************/
package org.eclipse.chemclipse.fsd.model.core;

import org.eclipse.chemclipse.model.core.IPeak;

public interface IPeakFSD extends IPeak {

	@Override
	IPeakModelFSD getPeakModel();
}
