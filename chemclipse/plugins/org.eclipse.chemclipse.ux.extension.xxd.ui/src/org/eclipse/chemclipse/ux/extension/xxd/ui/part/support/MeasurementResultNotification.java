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
 * Philip Wenig - comments
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.xxd.ui.part.support;

import org.eclipse.chemclipse.model.core.IMeasurementResult;
import org.eclipse.chemclipse.ux.extension.ui.support.AbstractNotifications;
import org.eclipse.e4.core.di.annotations.Creatable;

import jakarta.inject.Singleton;

/*
 * This class is used in the MeasurementResultsPart to retrieve the ICustomPaintListener, e.g. to draw the analysis segments in the chromatogram.
 */
@Creatable
@Singleton
public class MeasurementResultNotification extends AbstractNotifications<IMeasurementResult<?>> {
}