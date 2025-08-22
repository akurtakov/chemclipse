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
package org.eclipse.chemclipse.ux.extension.xxd.ui.toolbar;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.IParameter;
import org.eclipse.core.commands.IParameterValues;
import org.eclipse.core.commands.ParameterValuesException;

public class Parameter implements IParameter {

	private String id = "";
	private String name = "";

	private IParameterValues parameterValues = new IParameterValues() {

		private Map<?, ?> map = new HashMap<>();

		@Override
		public Map<?, ?> getParameterValues() {

			return map;
		}
	};

	public Parameter(String id, String name) {

		this.id = id;
		this.name = name;
	}

	@Override
	public String getId() {

		return id;
	}

	@Override
	public String getName() {

		return name;
	}

	@Override
	public IParameterValues getValues() throws ParameterValuesException {

		return parameterValues;
	}

	@Override
	public boolean isOptional() {

		return false;
	}
}
