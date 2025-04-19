/*******************************************************************************
 * Copyright (c) 2014, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.support.ui.listener;

public interface IFlowController {

	void addNextListener(INextListener nextListener);

	void removeNextListener(INextListener nextListener);

	void addNextSectionListener(INextListener nextListener);

	void removeNextSectionListener(INextListener nextListener);

	void addPreviousListener(IPreviousListener previousListener);

	void removePreviousListener(IPreviousListener previousListener);

	void addProcessListener(IProcessListener processListener);

	void removeProcessListener(IProcessListener processListener);
}
