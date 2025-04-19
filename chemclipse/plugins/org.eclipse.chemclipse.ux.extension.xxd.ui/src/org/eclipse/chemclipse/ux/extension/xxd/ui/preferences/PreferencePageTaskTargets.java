/*******************************************************************************
 * Copyright (c) 2017, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.xxd.ui.preferences;

import org.eclipse.chemclipse.ux.extension.xxd.ui.toolbar.GroupHandler;
import org.eclipse.chemclipse.ux.extension.xxd.ui.toolbar.GroupHandlerTargets;

public class PreferencePageTaskTargets extends AbstractPreferencePageTask {

	public PreferencePageTaskTargets() {

		super(GroupHandler.getGroupHandler(GroupHandlerTargets.NAME));
	}
}