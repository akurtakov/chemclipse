/*******************************************************************************
 * Copyright (c) 2022, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.ui.internal.provider;

import java.util.Collections;
import java.util.List;

import org.eclipse.chemclipse.model.identifier.ILibraryInformation;
import org.eclipse.jface.viewers.ILazyContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;

public class LibraryInformationContentProvider implements ILazyContentProvider {

	private TableViewer tableViewer;
	private List<ILibraryInformation> input;

	public LibraryInformationContentProvider(TableViewer tableViewer) {

		this.tableViewer = tableViewer;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

		if(newInput != null && newInput instanceof List list) {
			this.input = list;
		} else {
			this.input = Collections.emptyList();
		}
	}

	@Override
	public void updateElement(int index) {

		if(input != null && index < input.size()) {
			tableViewer.replace(input.get(index), index);
		}
	}
}