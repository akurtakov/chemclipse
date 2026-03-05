/*******************************************************************************
 * Copyright (c) 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.process.supplier.batchprocess.ui.editors;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.chemclipse.support.ui.workbench.EditorSupport;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.e4.ui.model.application.ui.MDirtyable;
import org.eclipse.e4.ui.model.application.ui.basic.MBasicFactory;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IURIEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

/**
 * Legacy 3.x compatibility shim that allows the Eclipse Project Explorer to open
 * *.obj files using the pure E4 {@link BatchJobEditor}. Eclipse's Project Explorer
 * uses {@code IDE.openEditor()} which requires an {@link EditorPart}; this shim
 * manually creates the {@link MPart} and {@link MDirtyable} and delegates all
 * lifecycle calls to the E4 editor — following the same pattern as
 * {@code ChromatogramEditor3x}.
 */
public class BatchJobEditorLauncher extends EditorPart {

	private BatchJobEditor editor;
	private boolean dirty = false;
	private final MDirtyable dirtyable = new MDirtyable() {

		@Override
		public void setDirty(boolean value) {

			dirty = value;
		}

		@Override
		public boolean isDirty() {

			return dirty;
		}
	};

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {

		setSite(site);
		setInput(input);
		if(!(input instanceof IURIEditorInput uriEditorInput)) {
			throw new PartInitException("The file couldn't be loaded.");
		}
		File file = new File(uriEditorInput.getURI());
		String name = input.getName();
		setPartName(name.contains(".") ? name.substring(0, name.lastIndexOf('.')) : name);
		MPart part = MBasicFactory.INSTANCE.createPart();
		part.setElementId(BatchJobEditor.ID);
		Map<String, Object> map = new HashMap<>();
		map.put(EditorSupport.MAP_FILE, file.getAbsolutePath());
		part.setObject(map);
		editor = new BatchJobEditor();
		editor.part = part;
		editor.dirtyable = dirtyable;
	}

	@Override
	public void createPartControl(Composite parent) {

		editor.initialize(parent);
	}

	@Override
	public void doSave(IProgressMonitor monitor) {

		editor.save();
	}

	@Override
	public void doSaveAs() {

		editor.saveAs();
	}

	@Override
	public boolean isDirty() {

		return dirty;
	}

	@Override
	public boolean isSaveAsAllowed() {

		return true;
	}

	@Override
	public void setFocus() {

		editor.setFocus();
	}
}
