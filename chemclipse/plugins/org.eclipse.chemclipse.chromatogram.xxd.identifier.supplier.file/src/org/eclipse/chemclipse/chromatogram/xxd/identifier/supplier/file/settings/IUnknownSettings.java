/*******************************************************************************
 * Copyright (c) 2021, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.identifier.supplier.file.settings;

import org.eclipse.chemclipse.model.identifier.IIdentifierSettings;

public interface IUnknownSettings extends IIdentifierSettings {

	String getTargetName();

	void setTargetName(String targetName);

	float getMatchQuality();

	void setMatchQuality(float matchQuality);

	String getMarkerStart();

	void setMarkerStart(String markerStart);

	String getMarkerStop();

	void setMarkerStop(String markerStop);

	boolean isIncludeRetentionTime();

	void setIncludeRetentionTime(boolean includeRetentionTime);

	boolean isIncludeRetentionIndex();

	void setIncludeRetentionIndex(boolean includeRetentionIndex);
}
