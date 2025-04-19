/*******************************************************************************
 * Copyright (c) 2020, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.xxd.ui.custom;

public class SelectionCoordinates {

	private int startRetentionTime = 0;
	private int stopRetentionTime = 0;
	private float startIntensity = 0.0f;
	private float stopIntensity = 0.0f;

	public int getStartRetentionTime() {

		return startRetentionTime;
	}

	public void setStartRetentionTime(int startRetentionTime) {

		this.startRetentionTime = startRetentionTime;
	}

	public int getStopRetentionTime() {

		return stopRetentionTime;
	}

	public void setStopRetentionTime(int stopRetentionTime) {

		this.stopRetentionTime = stopRetentionTime;
	}

	public float getStartIntensity() {

		return startIntensity;
	}

	public void setStartIntensity(float startIntensity) {

		this.startIntensity = startIntensity;
	}

	public float getStopIntensity() {

		return stopIntensity;
	}

	public void setStopIntensity(float stopIntensity) {

		this.stopIntensity = stopIntensity;
	}
}
