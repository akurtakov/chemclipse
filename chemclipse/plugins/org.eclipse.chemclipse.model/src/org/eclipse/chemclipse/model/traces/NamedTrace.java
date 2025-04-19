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
package org.eclipse.chemclipse.model.traces;

import java.util.Objects;

public class NamedTrace {

	private String identifier = "";
	private String traces = "";

	public NamedTrace(String identifier, String traces) {

		this.identifier = identifier;
		this.traces = traces;
	}

	public String getIdentifier() {

		return identifier;
	}

	public void setIdentifier(String identifier) {

		this.identifier = identifier;
	}

	public String getTraces() {

		return traces;
	}

	public void setTraces(String traces) {

		this.traces = traces;
	}

	@Override
	public int hashCode() {

		return Objects.hash(identifier);
	}

	@Override
	public boolean equals(Object obj) {

		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		NamedTrace other = (NamedTrace)obj;
		return Objects.equals(identifier, other.identifier);
	}

	@Override
	public String toString() {

		return "NamedTrace [identifier=" + identifier + ", traces=" + traces + "]";
	}
}