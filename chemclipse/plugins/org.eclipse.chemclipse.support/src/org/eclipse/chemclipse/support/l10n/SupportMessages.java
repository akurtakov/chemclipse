/*******************************************************************************
 * Copyright (c) 2015, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Matthias Mailänder - new API and re-implementation
 *******************************************************************************/
package org.eclipse.chemclipse.support.l10n;

import org.eclipse.osgi.util.NLS;

public class SupportMessages extends NLS {

	public static String taskPrepareProject;
	public static String taskOpenEditor;
	//
	public static String processingError;
	public static String processingProcessInterrupted;
	public static String processingSomethingWrong;
	public static String processingSelectProject;
	public static String processingProjectNotExists;
	public static String processingSelectValidFolder;
	public static String processingSelectValidProject;
	public static String processingNoProject;
	public static String processingTypeProjectName;
	public static String processingProjectAlreadyExists;
	public static String processingSelectFileName;
	public static String processingFileExists;
	public static String processingSelectValidFolderFile;
	//
	public static String labelSelectCreateProject;
	public static String labelSelectCreateProjectInfo;
	public static String labelSelectExistingProject;
	public static String labelCreateNewProject;
	public static String labelFileName;
	public static String labelFileNameInfo;
	public static String labelFileCreationProjectPath;
	public static String labelSelectFileName;
	public static String labelSelectProject;
	//
	public static String labelInstrumentName;
	public static String labelAddInstrument;
	public static String labelDeleteInstrument;
	public static String labelClearInstruments;
	public static String labelQuestionDeleteInstruments;
	public static String labelTypeInInstrument;
	public static String labelInstrumentExists;
	//
	public static String labelDilution;
	public static String labelAddDilution;
	public static String labelDeleteDilution;
	public static String labelClearDilutions;
	public static String labelQuestionDeleteDilutions;
	public static String labelTypeInDilution;
	public static String labelDilutionExists;
	//
	public static String labelCopyLinesInfo;
	public static String labelCopySelectionClipboard;
	//
	public static String columnDate;
	public static String columnDescription;
	public static String columnEditor;
	//
	public static String labelNoDescription;
	public static String labelNotAvailable;
	public static String labelSelectEntries;
	public static String labelSupplierAndExtensions;
	//
	static {
		NLS.initializeMessages("org.eclipse.chemclipse.support.l10n.messages", SupportMessages.class); //$NON-NLS-1$
	}

	private SupportMessages() {

	}
}
