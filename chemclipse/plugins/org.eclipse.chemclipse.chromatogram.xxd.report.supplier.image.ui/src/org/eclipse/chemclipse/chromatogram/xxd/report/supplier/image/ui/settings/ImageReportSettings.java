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
package org.eclipse.chemclipse.chromatogram.xxd.report.supplier.image.ui.settings;

import org.eclipse.chemclipse.chromatogram.xxd.report.settings.DefaultChromatogramReportSettings;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageReportSettings extends DefaultChromatogramReportSettings implements IChromatogramImageReportSettings {

	@JsonProperty(value = "Width", defaultValue = "1920")
	private int width = 1920;

	@JsonProperty(value = "Height", defaultValue = "1080")
	private int height = 1080;

	@JsonProperty(value = "Add Peaks", defaultValue = "false")
	private boolean peaks = false;

	@JsonProperty(value = "Add Labelled Scans", defaultValue = "false")
	private boolean scans = false;
	///
	@JsonProperty(value = "Image Format", defaultValue = "PNG")
	private ImageFormat imageFormat = ImageFormat.PNG;

	@Override
	public ImageFormat getFormat() {

		return imageFormat;
	}

	public void setFormat(ImageFormat imageFormat) {

		this.imageFormat = imageFormat;
	}

	@Override
	public boolean isPeaks() {

		return peaks;
	}

	public void setPeaks(boolean peaks) {

		this.peaks = peaks;
	}

	@Override
	public boolean isScans() {

		return scans;
	}

	public void setScans(boolean scans) {

		this.scans = scans;
	}

	@Override
	public int getWidth() {

		return width;
	}

	public void setWidth(int width) {

		this.width = width;
	}

	@Override
	public int getHeight() {

		return height;
	}

	public void setHeight(int height) {

		this.height = height;
	}
}
