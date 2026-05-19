/*******************************************************************************
 * Copyright (c) 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Lorenz Gerber - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.io;

import java.io.File;
import java.io.IOException;

import org.eclipse.chemclipse.model.statistics.ISample;
import org.eclipse.chemclipse.model.statistics.IVariable;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.EvaluationPCA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IEvaluation;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IResult;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class WorkspaceIO {

	public static final String DESCRIPTION = "PCA Workspace";
	public static final String FILE_EXTENSION = ".pws";
	public static final int CURRENT_VERSION = 1;
	public static final String FILE_NAME = "PCAWorkspace";
	public static final String[] FILTER_EXTENSION = {"*" + FILE_EXTENSION};
	public static final String[] FILTER_NAME = {DESCRIPTION + " (*" + FILE_EXTENSION + ")"};

	private WorkspaceIO() {

	}

	public static void write(File file, IEvaluation<IVariable, ISample, IResult> workspace) throws IOException {

		if(!(workspace instanceof EvaluationPCA evaluation)) {
			throw new IOException("Unsupported evaluation type: " + workspace.getClass().getName());
		}
		EvaluationPCADTO dto = EvaluationPCAMapper.toDTO(evaluation);
		createMapper().writeValue(file, dto);
	}

	public static IEvaluation<IVariable, ISample, IResult> read(File file) throws IOException {

		ObjectMapper mapper = createMapper();
		JsonNode node = mapper.readTree(file);
		int fileVersion = node.path("version").asInt(0);
		if(fileVersion < CURRENT_VERSION) {
			node = migrate(node, fileVersion);
		}
		EvaluationPCADTO dto = mapper.treeToValue(node, EvaluationPCADTO.class);
		return EvaluationPCAMapper.toDomain(dto);
	}

	/**
	 * Applies sequential migrations from {@code fromVersion} up to
	 * {@link #CURRENT_VERSION}. Add a new {@code if (version < N)} block here
	 * whenever the DTO format changes in version N.
	 * Example for a future version 2 that renames a field:
	 * <pre>
	 * if (version < 2) {
	 *     ObjectNode settings = (ObjectNode) node.path("samples").path("analysisSettings");
	 *     settings.set("newFieldName", settings.remove("oldFieldName"));
	 *     version = 2;
	 * }
	 * </pre>
	 */
	private static JsonNode migrate(JsonNode node, int fromVersion) {

		// int version = fromVersion;
		// if (version < 2) { ... version = 2; }
		return node;
	}

	private static ObjectMapper createMapper() {

		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		return mapper;
	}
}
