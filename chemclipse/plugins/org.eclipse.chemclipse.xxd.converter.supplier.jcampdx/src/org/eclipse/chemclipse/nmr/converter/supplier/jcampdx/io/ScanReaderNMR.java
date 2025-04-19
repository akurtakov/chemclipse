/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.nmr.converter.supplier.jcampdx.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.math3.util.Precision;
import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.model.core.IComplexSignalMeasurement;
import org.eclipse.chemclipse.nmr.converter.supplier.jcampdx.model.VendorSpectrumMeasurement;
import org.eclipse.chemclipse.nmr.converter.supplier.jcampdx.model.VendorSpectrumSignal;
import org.eclipse.core.runtime.IProgressMonitor;

import jakarta.activation.UnsupportedDataTypeException;

public class ScanReaderNMR {

	private static final Logger logger = Logger.getLogger(ScanReaderNMR.class);

	private static final String COMMENT_MARKER = "$$";
	private static final String HEADER_MARKER = "##";

	private static final String XUNITS = "##XUNITS=";
	private static final String YUNITS = "##YUNITS=";

	private static final String FIRSTX = "##FIRSTX=";
	private static final String LASTX = "##LASTX=";
	private static final String DELTAX = "##DELTAX=";
	private static final String XFACTOR = "##XFACTOR=";
	private static final String YFACTOR = "##YFACTOR=";
	private static final String NPOINTS = "##NPOINTS=";
	private static final String FIRSTY = "##FIRSTY=";
	private static final String XYDATA = "##XYDATA=";

	public IComplexSignalMeasurement<?> read(File file, IProgressMonitor monitor) throws IOException {

		VendorSpectrumMeasurement measurement = new VendorSpectrumMeasurement();

		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line;

		float firstX = 0;
		float firstY = 0;
		float lastX = 0;
		float deltaX = 0;
		double xFactor = 0;
		double yFactor = 0;
		float rawX = 0;
		int nPoints = 0;
		boolean firstValue = true;

		while((line = bufferedReader.readLine()) != null) {
			if(line.contains(COMMENT_MARKER)) {
				line = line.substring(0, line.indexOf(COMMENT_MARKER));
			}
			if(line.startsWith(NPOINTS)) {
				nPoints = Integer.parseInt(line.replace(NPOINTS, "").trim());
			}
			if(line.startsWith(XYDATA)) {
				if(!line.contains("(X++(Y..Y))")) {
					bufferedReader.close();
					fileReader.close();
					throw new UnsupportedDataTypeException("Unknown line compression type: " + line);
				}
			}
			if(line.startsWith(FIRSTX)) {
				firstX = Float.parseFloat(line.replace(FIRSTX, "").trim());
			}
			if(line.startsWith(FIRSTY)) {
				firstY = Float.parseFloat(line.replace(FIRSTY, "").trim());
			}
			if(line.startsWith(LASTX)) {
				lastX = Float.parseFloat(line.replace(LASTX, "").trim());
			}
			if(line.startsWith(DELTAX)) {
				deltaX = Float.parseFloat(line.replace(DELTAX, "").trim());
			}
			if(line.startsWith(XFACTOR)) {
				xFactor = Double.valueOf(line.replace(XFACTOR, "").trim());
			}
			if(line.startsWith(YFACTOR)) {
				yFactor = Double.valueOf(line.replace(YFACTOR, "").trim());
			}
			if(line.startsWith(XUNITS)) {
				String xUnit = line.replace(XUNITS, "").trim();
				if(!(xUnit.equals("HZ"))) {
					bufferedReader.close();
					fileReader.close();
					throw new UnsupportedDataTypeException("Unsupported X unit: " + xUnit);
				}
			}
			if(line.startsWith(YUNITS)) {
				String yUnit = line.replace(YUNITS, "").trim();
				if(!(yUnit.equals("ARBITRARY UNITS"))) {
					bufferedReader.close();
					fileReader.close();
					throw new UnsupportedDataTypeException("Unsupported X unit: " + yUnit);
				}
			}
			if(!line.startsWith(HEADER_MARKER)) {
				if(deltaX == 0) {
					if(firstX > lastX) {
						deltaX = -1;
					} else {
						deltaX = +1;
					}
				}
				try (Scanner scanner = new Scanner(line).useDelimiter("[^\\d]+")) {
					if(!scanner.hasNextInt()) {
						continue;
					}
					rawX = scanner.nextInt() - deltaX;
					while(scanner.hasNextInt()) {
						int rawY = scanner.nextInt();
						rawX += deltaX;
						double x = rawX * xFactor;
						double y = rawY * yFactor;
						measurement.addSignal(new VendorSpectrumSignal(x, y));
						if(firstValue) {
							if(!Precision.equalsWithRelativeTolerance(firstY, y, 0.1)) {
								logger.warn("Expected first Y to be " + firstY + " but calculated " + y);
							}
						}

						firstValue = false;
					}
				}
			}
		}
		if(nPoints > 0) {
			int signals = measurement.getSignals().size();
			if(signals != nPoints) {
				logger.warn("Expected " + nPoints + " but got " + signals + " signals instead.");
			}
		}
		if(!Precision.equalsWithRelativeTolerance(lastX, rawX * xFactor, 0.1)) {
			logger.warn("Expected last X to be " + lastX + " but calculated " + rawX * xFactor);
		}
		bufferedReader.close();
		fileReader.close();

		return measurement;
	}
}