/*******************************************************************************
 * Copyright (c) 2017, 2025 Lablicate GmbH.
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

public interface IVariable extends Comparable<IVariable> {

	String getDescription();

	String getType();

	String getValue();

	boolean isSelected();

	void setDescription(String description);

	void setSelected(boolean selected);

	void setType(String type);

	void setValue(String value);

	void setClassification(String classification);

	String getClassification();
}
