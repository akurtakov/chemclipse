/*******************************************************************************
 * Copyright (c) 2021, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.processing.methods;

public abstract class AbstractProcessEntryContainer implements IProcessEntryContainer {

	/*
	 * The flag supportResume shall be persisted. By default, it is false, due to the following reasons:
	 * - Allow backward compatibility
	 * - Some meta methods must be executed at a whole
	 * So, the user explicitly has to define that a method may support the resume action.
	 * The selected resume index shall be not persisted as the user shall be asked each time
	 * to select the entry point if needed.
	 */
	private boolean supportResume = false;
	private int resumeIndex = IProcessEntryContainer.DEFAULT_RESUME_INDEX; // transient

	@Override
	public boolean isSupportResume() {

		return supportResume;
	}

	@Override
	public void setSupportResume(boolean supportResume) {

		this.supportResume = supportResume;
	}

	@Override
	public int getResumeIndex() {

		return resumeIndex;
	}

	@Override
	public void setResumeIndex(int resumeIndex) {

		this.resumeIndex = resumeIndex;
	}
}
