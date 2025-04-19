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
 * Philip Wenig - code cleanup
 *******************************************************************************/
package org.eclipse.chemclipse.support.ui.swt.columns;

import java.util.Collection;

/**
 * Interface for column definitions providing items
 */
public interface ColumnDefinitionProvider {

	Collection<? extends ColumnDefinition<?, ?>> getColumnDefinitions();
}