/*******************************************************************************
 * Copyright (c) 2023, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.xxd.ui.operations;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.chemclipse.model.core.IPeak;
import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.model.core.ITargetSupplier;
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

public class DeleteTargetsOperation extends AbstractOperation {

	private ITargetSupplier targetSupplier;
	private Set<IIdentificationTarget> targetsToDelete;
	private Display display;
	private IChromatogramSelection chromatogramSelection;

	public DeleteTargetsOperation(Display display, IChromatogramSelection chromatogramSelection, ITargetSupplier targetSupplier, Collection<IIdentificationTarget> targetsToDelete) {

		super(ExtensionMessages.deleteTargets);
		this.display = display;
		this.chromatogramSelection = chromatogramSelection;
		this.targetSupplier = targetSupplier;
		clone(targetsToDelete);
	}

	private void clone(Collection<IIdentificationTarget> input) {

		targetsToDelete = new HashSet<>();
		for(IIdentificationTarget identificationTarget : input) {
			targetsToDelete.add(identificationTarget.makeDeepCopy());
		}
	}

	@Override
	public boolean canExecute() {

		return !targetsToDelete.isEmpty();
	}

	@Override
	public boolean canRedo() {

		return !targetsToDelete.isEmpty();
	}

	@Override
	public boolean canUndo() {

		return !targetsToDelete.isEmpty();
	}

	@Override
	public IStatus execute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		targetSupplier.getTargets().removeAll(targetsToDelete);

		return Status.OK_STATUS;
	}

	@Override
	public String getLabel() {

		return ExtensionMessages.deleteTargets;
	}

	@Override
	public IStatus redo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		return execute(monitor, info);
	}

	@Override
	public IStatus undo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		targetSupplier.getTargets().addAll(targetsToDelete);
		notifyTargetsRestored();
		return Status.OK_STATUS;
	}

	private void notifyTargetsRestored() {

		UpdateNotifierUI.update(display, IChemClipseEvents.TOPIC_IDENTIFICATION_TARGETS_UPDATE_SELECTION, ExtensionMessages.targetsRestored);
		chromatogramSelection.getChromatogram().setDirty(true);
		if(targetSupplier instanceof IPeak peak) {
			chromatogramSelection.setSelectedPeak(peak);
			UpdateNotifierUI.update(display, peak);
		} else if(targetSupplier instanceof IScan scan) {
			chromatogramSelection.getSelectedScan();
			UpdateNotifierUI.update(display, scan);
		}
	}
}
