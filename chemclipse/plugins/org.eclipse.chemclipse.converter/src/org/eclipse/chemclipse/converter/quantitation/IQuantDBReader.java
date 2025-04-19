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
package org.eclipse.chemclipse.converter.quantitation;

import java.io.File;

import org.eclipse.chemclipse.model.quantitation.IQuantitationDatabase;
import org.eclipse.core.runtime.IProgressMonitor;

public interface IQuantDBReader {

	IQuantitationDatabase read(File file, IProgressMonitor monitor);
}
