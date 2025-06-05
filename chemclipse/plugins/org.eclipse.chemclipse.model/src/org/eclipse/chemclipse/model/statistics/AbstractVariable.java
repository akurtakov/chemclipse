/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Jan Holy - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.model.statistics;

public abstract class AbstractVariable implements IVariable {

	private String description;
	private boolean selected;
	private boolean visualSelected;
	private String type;
	private String value;
	private String classification;

	public AbstractVariable() {

	}

	@Override
	public String getDescription() {

		return description;
	}

	@Override
	public String getType() {

		return type;
	}

	@Override
	public String getValue() {

		return value;
	}

	@Override
	public boolean isSelected() {

		return selected;
	}

	@Override
	public boolean isVisualSelected() {

		return this.visualSelected;
	}

	@Override
	public void setDescription(String description) {

		this.description = description;
	}

	@Override
	public void setSelected(boolean selected) {

		this.selected = selected;
	}

	@Override
	public void setVisualSelected(boolean visualSelected) {

		this.visualSelected = visualSelected;
	}

	@Override
	public void setType(String type) {

		this.type = type;
	}

	@Override
	public void setValue(String value) {

		this.value = value;
	}

	@Override
	public String getClassification() {

		return classification;
	}

	@Override
	public void setClassification(String classification) {

		this.classification = classification;
	}
}
