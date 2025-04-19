/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.ui.listener;

import java.io.File;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.FileTransfer;

public class DataExplorerDragListener implements DragSourceListener {

	private final TreeViewer treeViewer;

	public DataExplorerDragListener(TreeViewer treeViewer) {

		this.treeViewer = treeViewer;
	}

	@Override
	public void dragStart(DragSourceEvent event) {

		IStructuredSelection selection = (IStructuredSelection)treeViewer.getSelection();
		if(selection.isEmpty()) {
			event.doit = false;
		}
	}

	@Override
	public void dragSetData(DragSourceEvent event) {

		IStructuredSelection selection = (IStructuredSelection)treeViewer.getSelection();
		Object[] selectedElements = selection.toArray();
		String[] fileNames = new String[selectedElements.length];
		for(int i = 0; i < selectedElements.length; i++) {
			if(selectedElements[i] instanceof File file) {
				fileNames[i] = file.getPath();
			}
		}
		FileTransfer fileTransfer = FileTransfer.getInstance();
		if(fileTransfer.isSupportedType(event.dataType)) {
			event.data = fileNames;
		}
	}

	@Override
	public void dragFinished(DragSourceEvent event) {

	}
}