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
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.xxd.ui.custom;

import org.eclipse.swtchart.Range;

public interface IRangeSupport {

	void clearSelectedRange();

	void assignCurrentRangeSelection();

	Range getCurrentRangeX();

	void updateRangeX(Range selectedRangeX);

	Range getCurrentRangeY();

	void updateRangeY(Range selectedRangeY);

	void updateRange(Range selectedRangeX, Range selectedRangeY);

	void adjustChartRange();
}