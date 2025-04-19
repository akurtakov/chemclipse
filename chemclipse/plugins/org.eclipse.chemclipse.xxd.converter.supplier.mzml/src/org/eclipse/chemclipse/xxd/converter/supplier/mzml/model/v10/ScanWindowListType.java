/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.converter.supplier.mzml.model.v10;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ScanWindowListType", propOrder = {"scanWindow"})
public class ScanWindowListType {

	@XmlElement(required = true)
	protected List<ScanWindowType> scanWindow;
	@XmlAttribute(name = "count", required = true)
	protected int count;

	public List<ScanWindowType> getScanWindow() {

		if(scanWindow == null) {
			scanWindow = new ArrayList<>();
		}
		return this.scanWindow;
	}

	public int getCount() {

		return count;
	}

	public void setCount(int value) {

		this.count = value;
	}
}
