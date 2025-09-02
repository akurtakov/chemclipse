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

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.chemclipse.support.text.ValueFormat;
import org.eclipse.chemclipse.support.traces.ITrace;
import org.eclipse.chemclipse.support.traces.TraceFactory;
import org.eclipse.chemclipse.support.traces.TraceGeneric;
import org.eclipse.chemclipse.support.util.NamedTraceListUtil;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

public class TraceValidator implements IValidator<Object> {

	private static final String ERROR = "Please enter valid traces, e.g.: 320.1 400";

	private String traces = "";

	@Override
	public IStatus validate(Object value) {

		traces = "";
		String message = null;
		if(value == null) {
			message = ERROR;
		} else {
			if(value instanceof String content) {
				/*
				 * The traces are parsed dynamically.
				 * Backward compatibility is ensured via the TraceFactory.
				 */
				String invalidInput = TraceFactory.validate(content);
				if(invalidInput != null) {
					message = "The following input is invalid: " + invalidInput;
				} else {
					traces = content;
				}
			} else {
				message = ERROR;
			}
		}

		if(message != null) {
			return ValidationStatus.error(message);
		} else {
			return ValidationStatus.ok();
		}
	}

	/**
	 * Legacy support - better use TraceFactory.parseTraces(...)
	 * 
	 * @return {@link List}
	 */
	public List<Double> getTracesAsDouble() {

		Set<Double> values = new HashSet<>();
		for(ITrace trace : TraceFactory.parseTraces(traces, TraceGeneric.class)) {
			values.add(trace.getValue());
		}

		List<Double> doubles = new ArrayList<>(values);
		Collections.sort(doubles);

		return doubles;
	}

	/**
	 * Legacy support - better use TraceFactory.parseTraces(...)
	 * 
	 * @return {@link List}
	 */
	public List<Integer> getTracesAsInteger() {

		Set<Integer> values = new HashSet<>();
		for(double trace : getTracesAsDouble()) {
			values.add(Math.round((float)trace));
		}

		return new ArrayList<>(values);
	}

	/**
	 * Legacy support - better use TraceFactory.parseTraces(...)
	 * 
	 * @return {@link List}
	 */
	public String getTracesAsString() {

		StringBuilder builder = new StringBuilder();
		if(traces.isBlank()) {
			DecimalFormat decimalFormat = ValueFormat.getDecimalFormatEnglish("0.#");
			Iterator<Double> iterator = getTracesAsDouble().iterator();
			while(iterator.hasNext()) {
				builder.append(decimalFormat.format(iterator.next()));
				if(iterator.hasNext()) {
					builder.append(NamedTraceListUtil.SEPARATOR_TRACE);
				}
			}
		} else {
			builder.append(traces);
		}

		return builder.toString();
	}
}