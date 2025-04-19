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
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.support.ui.swt;

import java.util.Set;

import org.eclipse.chemclipse.support.ui.events.IKeyEventProcessor;
import org.eclipse.chemclipse.support.ui.menu.ITableMenuEntry;

public interface ITableSettings {

	boolean isCreateMenu();

	void setCreateMenu(boolean createMenu);

	void addMenuEntry(ITableMenuEntry menuEntry);

	void removeMenuEntry(ITableMenuEntry menuEntry);

	Set<ITableMenuEntry> getMenuEntries();

	void clearMenuEntries();

	void addKeyEventProcessor(IKeyEventProcessor keyEventProcessor);

	void removeKeyEventProcessor(IKeyEventProcessor keyEventProcessor);

	Set<IKeyEventProcessor> getKeyEventProcessors();

	void clearKeyEventProcessors();
}
