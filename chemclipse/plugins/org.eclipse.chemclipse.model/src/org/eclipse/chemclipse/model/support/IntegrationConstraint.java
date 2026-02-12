/*******************************************************************************
 * Copyright (c) 2008, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.support;

/**
 * Defines constraints on integration mode.<br/>
 * If you would like to suppress an integration with another baseline and other
 * corrections, you can add a constraint to the peak.<br/>
 * But keep in mind, it depends on the integrator to follow such constraints.
 */
public enum IntegrationConstraint {
	LEAVE_PEAK_AS_IT_IS; // no baseline correction, no other correction
}
