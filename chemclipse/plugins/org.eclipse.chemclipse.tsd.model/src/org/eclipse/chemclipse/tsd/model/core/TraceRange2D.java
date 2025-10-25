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
package org.eclipse.chemclipse.tsd.model.core;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.chemclipse.support.traces.TraceFactory;
import org.eclipse.chemclipse.support.traces.TraceGeneric;

public class TraceRange2D extends TraceRange1D {

	private int retentionTimeColumn2Start = 0;
	private int retentionTimeColumn2Stop = 0;
	private String scanIndicesColumn2 = "";
	private SecondDimensionHint secondDimensionHint = SecondDimensionHint.NONE;
	/*
	 * Transient
	 */
	private Set<Integer> scanIndices = new HashSet<>();
	private Set<Integer> traceIndices = new HashSet<>();

	public int getRetentionTimeColumn2Start() {

		return retentionTimeColumn2Start;
	}

	public void setRetentionTimeColumn2Start(int retentionTimeColumn2Start) {

		this.retentionTimeColumn2Start = retentionTimeColumn2Start;
	}

	public int getRetentionTimeColumn2Stop() {

		return retentionTimeColumn2Stop;
	}

	public void setRetentionTimeColumn2Stop(int retentionTimeColumn2Stop) {

		this.retentionTimeColumn2Stop = retentionTimeColumn2Stop;
	}

	public String getScanIndicesColumn2() {

		return scanIndicesColumn2;
	}

	public void setScanIndicesColumn2(String scanIndicesColumn2) {

		this.scanIndicesColumn2 = scanIndicesColumn2 == null ? "" : scanIndicesColumn2;
		scanIndices.clear();

		List<TraceGeneric> genericTraces = TraceFactory.parseTraces(this.scanIndicesColumn2, TraceGeneric.class);
		for(TraceGeneric traceGeneric : genericTraces) {
			scanIndices.add(traceGeneric.getTrace());
		}
	}

	public SecondDimensionHint getSecondDimensionHint() {

		return secondDimensionHint;
	}

	public void setSecondDimensionHint(SecondDimensionHint secondDimensionHint) {

		this.secondDimensionHint = secondDimensionHint;
	}

	public boolean matchesColumn2(int retentionTime, int scanSecondDimension) {

		if(matchesColumn1(retentionTime)) {
			if(scanIndices.contains(scanSecondDimension)) {
				return true;
			}
		}

		return false;
	}

	public Set<Integer> getScanIndices() {

		return scanIndices;
	}

	public Set<Integer> getTraceIndices() {

		return traceIndices;
	}

	@Override
	public String toString() {

		return "TraceRange2D [retentionTimeColumn2Start=" + retentionTimeColumn2Start + ", retentionTimeColumn2Stop=" + retentionTimeColumn2Stop + ", scanIndicesColumn2=" + scanIndicesColumn2 + ", secondDimensionHint=" + secondDimensionHint + "]";
	}
}