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
package org.eclipse.chemclipse.ux.extension.xxd.ui.toolbar;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImage;
import org.eclipse.chemclipse.ux.extension.ui.support.PartSupport;
import org.eclipse.chemclipse.ux.extension.xxd.ui.preferences.PreferencePageTaskTargets;
import org.eclipse.chemclipse.ux.extension.xxd.ui.preferences.PreferenceSupplier;
import org.eclipse.jface.preference.IPreferencePage;

public class GroupHandlerTargets extends AbstractGroupHandler {

	public static final String NAME = "Targets";

	private static final String IMAGE_HIDE = IApplicationImage.IMAGE_TARGET_ACTIVE;
	private static final String IMAGE_SHOW = IApplicationImage.IMAGE_TARGET;

	@Override
	public List<IPreferencePage> getPreferencePages() {

		List<IPreferencePage> preferencePages = new ArrayList<>();
		preferencePages.add(new PreferencePageTaskTargets());
		return preferencePages;
	}

	@Override
	public List<IPartHandler> getPartHandlerMandatory() {

		List<IPartHandler> partHandler = new ArrayList<>();

		partHandler.add(new PartHandler(NAME, PartSupport.PARTDESCRIPTOR_TARGETS, PreferenceSupplier.P_STACK_POSITION_TARGETS));

		return partHandler;
	}

	@Override
	public List<IPartHandler> getPartHandlerAdditional() {

		List<IPartHandler> partHandler = new ArrayList<>();

		partHandler.add(new PartHandler("Molecule", PartSupport.PARTDESCRIPTOR_MOLECULE, PreferenceSupplier.P_STACK_POSITION_MOLECULE));
		partHandler.add(new PartHandler("Penalty Calculation", PartSupport.PARTDESCRIPTOR_PENALTY_CALCULATION, PreferenceSupplier.P_STACK_POSITION_PENALTY_CALCULATION));
		partHandler.add(new PartHandler("Synonyms", PartSupport.PARTDESCRIPTOR_SYNONYMS, PreferenceSupplier.P_STACK_POSITION_SYNONYMS));
		partHandler.add(new PartHandler("Column Indices", PartSupport.PARTDESCRIPTOR_COLUMN_INDICES, PreferenceSupplier.P_STACK_POSITION_COLUMN_INDICES));
		partHandler.add(new PartHandler("CAS Numbers", PartSupport.PARTDESCRIPTOR_CAS_NUMBERS, PreferenceSupplier.P_STACK_POSITION_CAS_NUMBERS));
		partHandler.add(new PartHandler("Flavor Marker", PartSupport.PARTDESCRIPTOR_FLAVOR_MARKER, PreferenceSupplier.P_STACK_POSITION_FLAVOR_MARKER));

		return partHandler;
	}

	@Override
	public String getName() {

		return NAME;
	}

	@Override
	public String getImageHide() {

		return IMAGE_HIDE;
	}

	@Override
	public String getImageShow() {

		return IMAGE_SHOW;
	}

	@Override
	public String getMainMenuSuffix() {

		return ".targets";
	}
}
