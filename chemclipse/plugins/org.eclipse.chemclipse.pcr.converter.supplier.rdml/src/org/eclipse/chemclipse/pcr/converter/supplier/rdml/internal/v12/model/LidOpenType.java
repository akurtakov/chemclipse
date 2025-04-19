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
package org.eclipse.chemclipse.pcr.converter.supplier.rdml.internal.v12.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

/**
 * This step waits for the user to open the lid and continues afterwards. It
 * allows to stop the program and to wait for the user to add for example
 * enzymes and continue the program afterwards. The temperature of the previous
 * step is maintained.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lidOpenType")
public class LidOpenType {
}
