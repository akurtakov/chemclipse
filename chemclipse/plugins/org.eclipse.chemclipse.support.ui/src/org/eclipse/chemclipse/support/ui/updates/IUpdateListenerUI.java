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
 *******************************************************************************/
package org.eclipse.chemclipse.support.ui.updates;

import org.eclipse.chemclipse.support.updates.IUpdateListener;
import org.eclipse.swt.widgets.Display;

/**
 * If an update listener without Display is needed, have a look at:
 * org.eclipse.chemclipse.support.updates.IUpdateListener
 * {@link IUpdateListener}
 */
public interface IUpdateListenerUI {

	void update(Display display);
}