/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Christoph Läubrich - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.xxd.ui.swt;

/**
 * UIs can implement this interface to indicate that they are configurable,
 * there is no restriction on this config object, but it is recommended that each UI defines a config interface
 * that extends "well-known" interfaces like {@link IToolbarConfig} so it is possible to configure UIs in a generic way for example with a generic toolbar handler.
 * 
 * Besides that, of course the interface can define as many special settings that can only be used from special handlers
 * 
 * @author Christoph Läubrich
 *
 * @param <T>
 */
public interface ConfigurableUI<T> {

	T getConfig();
}
