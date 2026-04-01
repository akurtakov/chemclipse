/*******************************************************************************
 * Copyright (c) 2013, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.converter.supplier.jcampdx.io;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.eclipse.chemclipse.converter.exceptions.FileIsNotWriteableException;
import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.msd.converter.io.AbstractChromatogramMSDWriter;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.msd.model.core.IIon;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.core.runtime.IProgressMonitor;

public class ChromatogramWriter extends AbstractChromatogramMSDWriter {

	@Override
	public void writeChromatogram(File file, IChromatogramMSD chromatogram, IProgressMonitor monitor) throws FileIsNotWriteableException, IOException {

		PrintWriter printWriter = new PrintWriter(file);

		writeHeader(chromatogram, printWriter);
		writeScans(chromatogram, printWriter, monitor);

		printWriter.flush();
		printWriter.close();
	}

	private void writeHeader(IChromatogramMSD chromatogram, PrintWriter printWriter) {

		printWriter.println("##TITLE= ");
		printWriter.println("##JCAMP-DX= ");
		printWriter.println("##SAMPLE_DESCRIPTION= " + chromatogram.getMiscInfo());
		printWriter.println("##DATE= " + chromatogram.getDate().toString());
		printWriter.println("##TIME= " + chromatogram.getDate().toString());
		printWriter.println("##SPECTROMETER_SYSTEM= ");
		printWriter.println("##EXPERIMENT_NAME= ");
		printWriter.println("##INLET= ");
		printWriter.println("##IONIZATION_MODE= EI+");
		printWriter.println("##ELECTRON_ENERGY= 70.000000");
		printWriter.println("##RESOLUTION= ");
		printWriter.println("##ACCELERATING_VOLTAGE= 8000.000000");
		printWriter.println("##CALIBRATION_FILE= ");
		printWriter.println("##REFERENCE_FILE= ");
		printWriter.println("##MASS_RANGE= ");
		printWriter.println("##SCAN_LAW= Exponential");
		printWriter.println("##SCAN_RATE_UNITS= seconds/decade");
		printWriter.println("##SCAN_RATE= " + chromatogram.getScanInterval() / 1000.0d);
		printWriter.println("##SCAN_DELAY_UNITS= seconds");
		printWriter.println("##SCAN_DELAY= " + chromatogram.getScanDelay() / 1000.0d);
		printWriter.println("##XUNITS= Daltons");
		printWriter.println("##DATA_FORMAT= Centroid");
	}

	private void writeScans(IChromatogramMSD chromatogram, PrintWriter printWriter, IProgressMonitor monitor) {

		for(IScan scan : chromatogram.getScans()) {
			/*
			 * Export each scan.
			 */
			monitor.subTask("Export Scan " + scan.getScanNumber());
			printWriter.println("##SCAN_NUMBER= " + scan.getScanNumber());
			printWriter.println("##RETENTION_TIME= " + scan.getRetentionTime() / 1000.0d); // milliseconds -> seconds
			printWriter.println("##TIC= " + (int)scan.getTotalSignal());
			if(scan instanceof IScanMSD scanMSD) {
				printWriter.println("##NPOINTS= " + scanMSD.getNumberOfIons());
				printWriter.println("##XYDATA= (XY..XY)");
				for(IIon ion : scanMSD.getIons()) {
					printWriter.println(" " + ion.getIon() + ", " + (int)ion.getAbundance());
				}
			}
		}
	}
}
