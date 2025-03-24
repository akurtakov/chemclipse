/*******************************************************************************
 * Copyright (c) 2017, 2025 Lablicate GmbH.
 * 
 * All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
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