/*******************************************************************************
 * Copyright (c) 2017, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.xxd.ui.internal.runnables;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.chemclipse.chromatogram.wsd.identifier.wavespectrum.WaveSpectrumIdentifier;
import org.eclipse.chemclipse.ux.extension.xxd.ui.l10n.ExtensionMessages;
import org.eclipse.chemclipse.wsd.model.core.IScanWSD;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

public class WaveSpectrumIdentifierRunnable implements IRunnableWithProgress {

	private final List<IScanWSD> scans;
	private final String identifierId;

	public WaveSpectrumIdentifierRunnable(List<IScanWSD> scans, String identifierId) {

		this.scans = scans;
		this.identifierId = identifierId;
	}

	@Override
	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {

		try {
			monitor.beginTask(ExtensionMessages.scanIdentification, IProgressMonitor.UNKNOWN);
			WaveSpectrumIdentifier.identify(scans, identifierId, monitor);
		} finally {
			monitor.done();
		}
	}
}
