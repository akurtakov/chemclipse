/*******************************************************************************
 * Copyright (c) 2012, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Alexander Kerner - Generics
 * Christoph Läubrich - fix generic
 *******************************************************************************/
package org.eclipse.chemclipse.converter.chromatogram;

import org.eclipse.chemclipse.converter.core.AbstractImportConverter;
import org.eclipse.chemclipse.model.core.IChromatogram;

public abstract class AbstractChromatogramImportConverter<R extends IChromatogram> extends AbstractImportConverter implements IChromatogramImportConverter<R> {
}
