/*******************************************************************************
 * Copyright (c) 2011, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.classifier.core;

import java.util.List;

import org.eclipse.chemclipse.chromatogram.xxd.classifier.exceptions.NoChromatogramClassifierSupplierAvailableException;

public interface IChromatogramClassifierSupport {

	String getClassifierId(int index) throws NoChromatogramClassifierSupplierAvailableException;

	IChromatogramClassifierSupplier getClassifierSupplier(String classifierId) throws NoChromatogramClassifierSupplierAvailableException;

	List<String> getAvailableClassifierIds() throws NoChromatogramClassifierSupplierAvailableException;

	String[] getClassifierNames() throws NoChromatogramClassifierSupplierAvailableException;
}
