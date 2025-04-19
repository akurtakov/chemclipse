/*******************************************************************************
 * Copyright (c) 2024, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.ui.methods;

import org.eclipse.chemclipse.processing.methods.ProcessEntryContainer;

public class MethodParameters {

	private String profile = ProcessEntryContainer.DEFAULT_PROFILE;
	private int resumeIndex = ProcessEntryContainer.DEFAULT_RESUME_INDEX;

	public String getProfile() {

		return profile;
	}

	public void setProfile(String profile) {

		if(profile == null || profile.isEmpty()) {
			this.profile = ProcessEntryContainer.DEFAULT_PROFILE;
		} else {
			this.profile = profile;
		}
	}

	public int getResumeIndex() {

		return resumeIndex;
	}

	public void setResumeIndex(int resumeIndex) {

		this.resumeIndex = resumeIndex;
	}
}
