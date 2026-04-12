/*******************************************************************************
 * Copyright (c) 2014, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.msd.filter.supplier.ionremover.settings;

import org.eclipse.chemclipse.model.core.MarkedTraceModus;

public interface ITraceRemoverFilterSettings {

	String DESCRIPTION = "Ion Remover Filter";

	String getIonsToRemove();

	void setIonsToRemove(String ionsToRemove);

	MarkedTraceModus getMarkedTraceModus();

	void setMarkedTraceModus(MarkedTraceModus markedTraceModus);
}