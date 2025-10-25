/*******************************************************************************
 * Copyright (c) 2024, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.tsd.model.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.model.core.IChromatogramOverview;
import org.eclipse.chemclipse.support.settings.OperatingSystemUtils;
import org.eclipse.chemclipse.tsd.model.support.TraceRangeSupport;
import org.eclipse.chemclipse.tsd.model.validators.TraceRange2DValidator;
import org.eclipse.core.runtime.IStatus;

public class TraceRanges2D extends ArrayList<TraceRange2D> {

	private static final long serialVersionUID = 8589998690167624026L;

	/*
	 * Before splitting into 2d and 1d
	 * the extension was *.trd
	 */
	public static final String DESCRIPTION = "Trace Range Definitions 2D";
	public static final String FILE_EXTENSION = ".t2d";
	public static final String FILE_NAME = DESCRIPTION.replaceAll("\\s", "") + FILE_EXTENSION;
	public static final String FILTER_EXTENSION = "*" + FILE_EXTENSION;
	public static final String FILTER_NAME = DESCRIPTION + " (*" + FILE_EXTENSION + ")";

	private static final String WHITE_SPACE = " ";
	private static final String SEPARATOR_TOKEN = ";";
	private static final String SEPARATOR_ENTRY = "|";

	private static final Logger logger = Logger.getLogger(TraceRanges2D.class);

	public void load(String items) {

		loadRules(items);
	}

	public String save() {

		return extractRanges(SEPARATOR_TOKEN);
	}

	public TraceRange2D extractTraceRange(String item) {

		return extract(item);
	}

	public String extractTraceRange(TraceRange2D traceRange) {

		return getTraceRangeAsString(traceRange);
	}

	public void importRules(File file) {

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			String line;
			while((line = bufferedReader.readLine()) != null) {
				TraceRange2D traceRange = extract(line);
				if(traceRange != null) {
					add(traceRange);
				}
			}
		} catch(FileNotFoundException e) {
			logger.warn(e);
		} catch(IOException e) {
			logger.warn(e);
		}
	}

	public boolean exportRules(File file) {

		boolean success = false;
		try (PrintWriter printWriter = new PrintWriter(file)) {
			String content = extractRanges(OperatingSystemUtils.getLineDelimiter());
			printWriter.println(content);
			printWriter.flush();
			success = true;
		} catch(FileNotFoundException e) {
			logger.warn(e);
		}

		return success;
	}

	private String extractRanges(String rangeSeparator) {

		StringBuilder builder = new StringBuilder();
		Iterator<TraceRange2D> iterator = iterator();

		while(iterator.hasNext()) {
			TraceRange2D traceRange = iterator.next();
			builder.append(getTraceRangeAsString(traceRange));
			if(iterator.hasNext()) {
				builder.append(rangeSeparator);
			}
		}

		return builder.toString().trim();
	}

	private String getTraceRangeAsString(TraceRange2D traceRange) {

		StringBuilder builder = new StringBuilder();

		if(traceRange != null) {
			builder.append(TraceRangeSupport.DF_COLUMN_1_MINUTES.format(traceRange.getRetentionTimeColumn1Start() / IChromatogramOverview.MINUTE_CORRELATION_FACTOR));
			addSeparator(builder);
			builder.append(TraceRangeSupport.DF_COLUMN_1_MINUTES.format(traceRange.getRetentionTimeColumn1Stop() / IChromatogramOverview.MINUTE_CORRELATION_FACTOR));
			addSeparator(builder);
			builder.append(TraceRangeSupport.DF_COLUMN_2_SECONDS.format(traceRange.getRetentionTimeColumn2Start() / IChromatogramOverview.SECOND_CORRELATION_FACTOR));
			addSeparator(builder);
			builder.append(TraceRangeSupport.DF_COLUMN_2_SECONDS.format(traceRange.getRetentionTimeColumn2Stop() / IChromatogramOverview.SECOND_CORRELATION_FACTOR));
			addSeparator(builder);
			builder.append(traceRange.getScanIndicesColumn2());
			addSeparator(builder);
			builder.append(traceRange.getName());
			addSeparator(builder);
			builder.append(traceRange.getTraces());
			addSeparator(builder);
			builder.append(traceRange.getSecondDimensionHint().name());
		}

		return builder.toString();
	}

	private TraceRange2D extract(String text) {

		TraceRange2D traceRange = null;
		TraceRange2DValidator validator = new TraceRange2DValidator();

		IStatus status = validator.validate(text);
		if(status.isOK()) {
			traceRange = validator.getSetting();
		} else {
			logger.warn(status.getMessage());
		}

		return traceRange;
	}

	private void loadRules(String input) {

		String[] lines;
		if(input.contains(SEPARATOR_TOKEN)) {
			lines = input.split(SEPARATOR_TOKEN);
		} else {
			lines = new String[1];
			lines[0] = input;
		}

		for(String line : lines) {
			TraceRange2D traceRange = extract(line);
			if(traceRange != null && !contains(traceRange)) {
				add(traceRange);
			}
		}
	}

	private void addSeparator(StringBuilder builder) {

		builder.append(WHITE_SPACE);
		builder.append(SEPARATOR_ENTRY);
		builder.append(WHITE_SPACE);
	}
}