/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Christoph Läubrich - initial API and implementation
 * Philip Wenig - refactoring to ChemClipse style
 *******************************************************************************/
package org.eclipse.chemclipse.model.core;

import java.util.Collection;

public interface IClassifier {

	Collection<String> getClassifier();

	void addClassifier(String classifier);

	void removeClassifier(String classifier);

	static String asString(IClassifier classifiable) {

		return asString(classifiable.getClassifier());
	}

	static String asString(Iterable<? extends CharSequence> classifier) {

		if(classifier != null) {
			return String.join(", ", classifier);
		}
		return "";
	}
}