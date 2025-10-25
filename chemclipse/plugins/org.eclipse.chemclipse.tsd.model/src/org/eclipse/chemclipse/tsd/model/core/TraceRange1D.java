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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.eclipse.chemclipse.support.traces.TraceGenericDelta;

public class TraceRange1D {

	private int retentionTimeColumn1Start = 0;
	private int retentionTimeColumn1Stop = 0;
	private String name = "";
	private String traces = "";
	/*
	 * Transient
	 */
	private List<TraceGenericDelta> genericTraces = new ArrayList<>();

	public int getRetentionTimeColumn1Start() {

		return retentionTimeColumn1Start;
	}

	public void setRetentionTimeColumn1Start(int retentionTimeColumn1Start) {

		this.retentionTimeColumn1Start = retentionTimeColumn1Start;
	}

	public int getRetentionTimeColumn1Stop() {

		return retentionTimeColumn1Stop;
	}

	public void setRetentionTimeColumn1Stop(int retentionTimeColumn1Stop) {

		this.retentionTimeColumn1Stop = retentionTimeColumn1Stop;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public String getTraces() {

		return traces;
	}

	public void setTraces(String traces) {

		this.traces = traces;
	}

	public List<TraceGenericDelta> getGenericTraces() {

		return genericTraces;
	}

	public boolean matchesColumn1(int retentionTimeColumn1) {

		if(retentionTimeColumn1Start == 0 && retentionTimeColumn1Stop == 0) {
			return true;
		} else if(retentionTimeColumn1 >= retentionTimeColumn1Start && retentionTimeColumn1 <= retentionTimeColumn1Stop) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {

		return Objects.hash(name, retentionTimeColumn1Start, retentionTimeColumn1Stop);
	}

	@Override
	public boolean equals(Object obj) {

		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		TraceRange1D other = (TraceRange1D)obj;
		return Objects.equals(name, other.name) && retentionTimeColumn1Start == other.retentionTimeColumn1Start && retentionTimeColumn1Stop == other.retentionTimeColumn1Stop;
	}

	@Override
	public String toString() {

		return "TraceRange1D [retentionTimeColumn1Start=" + retentionTimeColumn1Start + ", retentionTimeColumn1Stop=" + retentionTimeColumn1Stop + ", name=" + name + ", traces=" + traces + ", genericTraces=" + genericTraces + "]";
	}
}