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
 * Matthias Mailänder - initial API and implementation
 * Philip Wenig - renamed to make the purpose more clear
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.xxd.ui.operations;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.model.identifier.IIdentificationTarget;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.support.events.IChemClipseEvents;
import org.eclipse.chemclipse.swt.ui.notifier.UpdateNotifierUI;
import org.eclipse.chemclipse.ux.extension.xxd.ui.l10n.ExtensionMessages;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.widgets.Display;

public class DeleteScanTargetsOperation extends AbstractOperation {

	private IChromatogramSelection chromatogramSelection;
	private Display display;
	private List<IScan> scansToClear;
	private Map<Integer, Set<IIdentificationTarget>> backupTargets;

	public DeleteScanTargetsOperation(Display display, IChromatogramSelection chromatogramSelection, List<IScan> scansToClear) {

		super(ExtensionMessages.deleteScanTargets);
		this.display = display;
		this.chromatogramSelection = chromatogramSelection;
		this.scansToClear = scansToClear;
		backupTargets = new LinkedHashMap<>();
	}

	@Override
	public boolean canExecute() {

		return !scansToClear.isEmpty() && chromatogramSelection != null;
	}

	@Override
	public boolean canRedo() {

		return !scansToClear.isEmpty() && chromatogramSelection != null;
	}

	@Override
	public boolean canUndo() {

		return !scansToClear.isEmpty();
	}

	@Override
	public IStatus execute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		for(IScan scan : scansToClear) {
			Set<IIdentificationTarget> deepCopy = new HashSet<>(scan.getTargets());
			backupTargets.put(scan.getScanNumber(), deepCopy);
			scan.getTargets().clear();
		}
		chromatogramSelection.setSelectedIdentifiedScan(null);
		update();
		return Status.OK_STATUS;
	}

	private void update() {

		if(chromatogramSelection != null) {
			chromatogramSelection.setSelectedIdentifiedScan(null);
			chromatogramSelection.update(true);

			UpdateNotifierUI.update(display, chromatogramSelection);
		}
		UpdateNotifierUI.update(display, IChemClipseEvents.TOPIC_IDENTIFICATION_TARGETS_UPDATE_SELECTION, "Scan Targets were deleted.");
	}

	@Override
	public String getLabel() {

		return ExtensionMessages.deleteScanTargets;
	}

	@Override
	public IStatus redo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		return execute(monitor, info);
	}

	@Override
	public IStatus undo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		for(Entry<Integer, Set<IIdentificationTarget>> backup : backupTargets.entrySet()) {
			chromatogramSelection.getChromatogram().getScan(backup.getKey()).getTargets().addAll(backup.getValue());
		}
		update();
		return Status.OK_STATUS;
	}
}
