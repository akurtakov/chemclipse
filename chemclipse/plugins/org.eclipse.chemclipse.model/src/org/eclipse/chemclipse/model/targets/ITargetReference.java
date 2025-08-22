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
 * Philip Wenig - refactoring target label support
 *******************************************************************************/
package org.eclipse.chemclipse.model.targets;

import org.eclipse.chemclipse.model.core.ISignal;
import org.eclipse.chemclipse.model.core.ITargetSupplier;
import org.eclipse.chemclipse.model.identifier.IIdentificationTarget;

public interface ITargetReference extends ITargetSupplier {

	ISignal getSignal();

	String getRetentionTimeMinutes();

	float getRetentionIndex();

	/**
	 * Unique ID to persist the data.
	 * 
	 * @return {String}
	 */
	String getID();

	/**
	 * Type: Peak/Scan
	 * 
	 * @return {String}
	 */
	TargetReferenceType getType();

	/**
	 * Returns the best target or null if no target is available.
	 * 
	 * @return {IIdentificationTarget}
	 */
	default IIdentificationTarget getBestIdentificationTarget() {

		return IIdentificationTarget.getIdentificationTarget(getTargets(), getRetentionIndex());
	}

	default String getTargetLabel(LibraryField libraryField) {

		IIdentificationTarget identificationTarget = getBestIdentificationTarget();
		if(identificationTarget != null) {
			return libraryField.getTransformer().apply(identificationTarget);
		}

		return null;
	}
}