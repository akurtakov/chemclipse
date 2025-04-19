/*******************************************************************************
 * Copyright (c) 2015, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.converter.supplier.ocx.internal.support;

public class ScanProxy implements IScanProxy {

	private int offset;
	private int retentionTime;
	private int numberOfIons;
	private float totalSignal;
	private float retentionIndex;
	private int timeSegmentId;
	private int cycleNumber;

	public ScanProxy(int offset, int retentionTime, int numberOfIons, float totalSignal, float retentionIndex, int timeSegmentId, int cycleNumber) {
		this.offset = offset;
		this.retentionTime = retentionTime;
		this.numberOfIons = numberOfIons;
		this.totalSignal = totalSignal;
		this.retentionIndex = retentionIndex;
		this.timeSegmentId = timeSegmentId;
		this.cycleNumber = cycleNumber;
	}

	@Override
	public int getOffset() {

		return offset;
	}

	@Override
	public int getRetentionTime() {

		return retentionTime;
	}

	@Override
	public int getNumberOfIons() {

		return numberOfIons;
	}

	@Override
	public float getTotalSignal() {

		return totalSignal;
	}

	@Override
	public float getRetentionIndex() {

		return retentionIndex;
	}

	@Override
	public int getTimeSegmentId() {

		return timeSegmentId;
	}

	@Override
	public int getCycleNumber() {

		return cycleNumber;
	}
}
