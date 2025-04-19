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
 * CHristoph Läubrich - extend API
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.ui.editors;

import org.eclipse.chemclipse.nmr.model.selection.IDataNMRSelection;

public interface IScanEditorNMR extends IChemClipseEditor {

	IDataNMRSelection getScanSelection();

	String getName();
}
