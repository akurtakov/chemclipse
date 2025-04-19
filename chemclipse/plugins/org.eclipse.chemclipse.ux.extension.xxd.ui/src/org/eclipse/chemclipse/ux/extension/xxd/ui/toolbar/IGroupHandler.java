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
package org.eclipse.chemclipse.ux.extension.xxd.ui.toolbar;

import java.util.List;

import org.eclipse.jface.preference.IPreferencePage;

public interface IGroupHandler {

	List<IPreferencePage> getPreferencePages();

	List<IPartHandler> getPartHandler();

	List<IPartHandler> getPartHandlerMandatory();

	List<IPartHandler> getPartHandlerAdditional();

	void setPartStatus(boolean visible);

	void updateMenu();

	String getPartElementId(IPartHandler partHandler);

	String getSettingsElementId();

	String getActionElementId(Action action);

	String getImageHide();

	String getImageShow();

	String getName();

	String getMainMenuSuffix();
}
