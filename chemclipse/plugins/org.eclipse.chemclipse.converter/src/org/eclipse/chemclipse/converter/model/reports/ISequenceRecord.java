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
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.converter.model.reports;

import java.util.Map;

public interface ISequenceRecord {

	String getSubstance();

	void setSubstance(String substance);

	String getProcessMethod();

	void setProcessMethod(String processMethod);

	String getReportMethod();

	void setReportMethod(String reportMethod);

	int getVial();

	void setVial(int vial);

	double getInjectionVolume();

	void setInjectionVolume(double injectionVolume);

	String getSampleName();

	void setSampleName(String sampleName);

	double getMultiplier();

	void setMultiplier(double multiplier);

	String getDataPath();

	void setDataPath(String dataPath);

	String getDataFile();

	void setDataFile(String dataFile);

	String getDescription();

	void setDescription(String description);

	SequenceRecordAdvice getAdvice();

	Map<String, String> getMetadata();
}