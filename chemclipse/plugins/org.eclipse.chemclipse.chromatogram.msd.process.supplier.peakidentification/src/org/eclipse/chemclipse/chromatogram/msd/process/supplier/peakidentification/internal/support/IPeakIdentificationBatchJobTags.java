/*******************************************************************************
 * Copyright (c) 2011, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.msd.process.supplier.peakidentification.internal.support;

/**
 * @author Dr. Philip Wenig
 * 
 */
public interface IPeakIdentificationBatchJobTags {

	String UTF8 = "UTF-8";
	/*
	 * Start and Stop Element /
	 */
	String PEAK_IDENTIFICATION_BATCH_JOB = "PeakIdentificationBatchJob";
	/*
	 * Header
	 */
	String HEADER = "Header";
	String REPORT_FOLDER = "ReportFolder";
	String OVERRIDE_REPORT = "OverrideReport";
	/*
	 * Peak File Input Entries
	 */
	String PEAK_INPUT_ENTRIES = "InputEntries";
	String PEAK_INPUT_ENTRY = "InputEntry";
	/*
	 * Peak File Output Entries
	 */
	String PEAK_OUTPUT_ENTRIES = "OutputEntries";
	String PEAK_OUTPUT_ENTRY = "OutputEntry";
	String PEAK_CONVERTER_ID = "converterId";
	/*
	 * PEAK INTEGRATOR
	 */
	String PEAK_INTEGRATOR = "INTEGRATOR";
	String PEAK_INTEGRATOR_ATTRIBUTE = "integrator";
	/*
	 * PEAK IDENTIFIER
	 */
	String PEAK_IDENTIFIER = "IDENTIFIER";
	String PEAK_IDENTIFIER_ATTRIBUTE = "identifier";
	/*
	 * Peak Integration/Identification Entry
	 */
	String PEAK_INTEGRATION_ENTRY = "IntegrationEntry";
	String PEAK_IDENTIFICATION_ENTRY = "IdentificationEntry";
	String PROCESSOR_ID = "processorId";
	String PROCESS_REPORT = "processReport";
}
