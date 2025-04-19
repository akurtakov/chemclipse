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
 * Christoph Läubrich - initial API and implementation
 * Philip Wenig - refactoring Observable
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.xxd.ui.editors;

import java.beans.PropertyChangeSupport;

import org.eclipse.swt.widgets.Composite;

/**
 * An editor extension allows the dynamic creation of a component that might be embedded inside another editor or component
 * 
 * @author Christoph Läubrich
 *
 */
public interface EditorExtension {

	/**
	 * Creates a new extension
	 * 
	 * @param parent
	 * @return an Observable that can be used to monitor for changes in this extension
	 */
	public PropertyChangeSupport createExtension(Composite parent);
}