/*******************************************************************************
 * Copyright (c) 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.ui.internal.provider;

import org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.model.TargetTrace;
import org.eclipse.chemclipse.support.ui.swt.AbstractRecordTableComparator;
import org.eclipse.jface.viewers.Viewer;

public class TargetTraceTableComparator extends AbstractRecordTableComparator {

	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {

		int sortOrder = 0;
		if(e1 instanceof TargetTrace targetTrace1 && e2 instanceof TargetTrace targetTrace2) {
			switch(getPropertyIndex()) {
				case 0:
					sortOrder = Integer.compare(targetTrace2.getIon(), targetTrace1.getIon());
					break;
				case 1:
					sortOrder = targetTrace2.getName().compareTo(targetTrace1.getName());
					break;
				default:
					sortOrder = 0;
			}
		}

		if(getDirection() == ASCENDING) {
			sortOrder = -sortOrder;
		}

		return sortOrder;
	}
}