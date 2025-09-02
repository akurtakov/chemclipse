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
package org.eclipse.chemclipse.support.validators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.chemclipse.support.traces.ITrace;
import org.eclipse.chemclipse.support.traces.TraceFactory;
import org.eclipse.chemclipse.support.traces.TraceGeneric;
import org.eclipse.core.databinding.validation.IValidator;

/**
 * This class offers legacy support to get traces as List or String.
 * It shall be used as long as all parts of the application use
 * the newer TraceFactory support.
 * 
 */
public abstract class AbstractTraceValidatorLegacy implements IValidator<Object> {

	private String traces = "";

	public String getTraces() {

		return traces;
	}

	/**
	 * Legacy support - better use TraceFactory.parseTraces(...)
	 * 
	 * @return {@link List}
	 */
	public List<Integer> getTracesAsInteger() {

		List<Integer> values = new ArrayList<>(TraceFactory.parseTraces(traces, TraceGeneric.class).stream().map(t -> t.getTrace()).collect(Collectors.toSet()));
		Collections.sort(values);

		return values;
	}

	/**
	 * Export integer based traces separated via
	 * white space and with condensed ranges.
	 * 
	 * @return String
	 */
	public String getLegacyTracesCondensed() {

		Iterator<Integer> iterator = getTracesAsInteger().iterator();
		if(iterator.hasNext()) {
			List<String> traces = new ArrayList<>();
			int start = iterator.next();
			int stop = start;
			while(iterator.hasNext()) {
				int value = iterator.next();
				if(value == (stop + 1)) {
					stop = value;
				} else {
					addTraces(traces, start, stop);
					start = value;
					stop = value;
				}
			}
			/*
			 * Last Entry
			 */
			addTraces(traces, start, stop);
			return String.join(" ", traces);
		} else {
			return "";
		}
	}

	protected void setTraces(String traces) {

		this.traces = traces;
	}

	private void addTraces(List<String> traces, int start, int stop) {

		if(start == stop) {
			traces.add(Integer.toString(start));
		} else {
			StringBuilder builder = new StringBuilder();
			builder.append(start);
			builder.append(" ");
			builder.append(ITrace.SEPARATOR_TRACE_RANGE);
			builder.append(" ");
			builder.append(stop);
			traces.add(builder.toString());
		}
	}
}