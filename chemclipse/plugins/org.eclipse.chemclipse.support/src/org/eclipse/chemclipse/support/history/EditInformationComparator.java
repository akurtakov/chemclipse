/*******************************************************************************
 * Copyright (c) 2008, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.support.history;

import java.util.Comparator;

public class EditInformationComparator implements Comparator<IEditInformation> {

	private EditHistorySortOrder editHistorySortOrder;

	public EditInformationComparator() {
		this.editHistorySortOrder = EditHistorySortOrder.DATE_ASC;
	}

	public EditInformationComparator(EditHistorySortOrder editHistorySortOrder) {
		this.editHistorySortOrder = editHistorySortOrder;
	}

	@Override
	public int compare(IEditInformation o1, IEditInformation o2) {

		int result;
		switch(editHistorySortOrder) {
			case DATE_ASC:
				result = Long.compare(o1.getDate().getTime(), o2.getDate().getTime());
				break;
			case DATE_DESC:
				result = Long.compare(o2.getDate().getTime(), o1.getDate().getTime());
				break;
			default:
				result = Long.compare(o1.getDate().getTime(), o2.getDate().getTime());
				break;
		}
		return result;
	}
}
