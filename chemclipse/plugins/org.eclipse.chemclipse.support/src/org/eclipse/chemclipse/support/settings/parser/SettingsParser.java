/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Christoph Läubrich - initial API and implementation
 * Philip Wenig - get rid of system settings
 *******************************************************************************/
package org.eclipse.chemclipse.support.settings.parser;

import java.util.List;

public interface SettingsParser<T> {

	List<InputValue> getInputValues();

	T createDefaultInstance();
}