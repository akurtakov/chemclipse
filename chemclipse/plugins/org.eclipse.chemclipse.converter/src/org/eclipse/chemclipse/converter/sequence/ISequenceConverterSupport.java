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
package org.eclipse.chemclipse.converter.sequence;

import java.io.File;
import java.util.List;

import org.eclipse.chemclipse.converter.exceptions.NoConverterAvailableException;
import org.eclipse.chemclipse.processing.converter.ISupplier;

public interface ISequenceConverterSupport {

	void add(final ISupplier supplier);

	String[] getFilterExtensions() throws NoConverterAvailableException;

	String[] getFilterNames() throws NoConverterAvailableException;

	String getConverterId(int index) throws NoConverterAvailableException;

	String getConverterId(String name) throws NoConverterAvailableException;

	List<String> getAvailableConverterIds(File file) throws NoConverterAvailableException;

	List<ISupplier> getSupplier();

	ISupplier getSupplier(String id) throws NoConverterAvailableException;
}
