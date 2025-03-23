/*******************************************************************************
 * Copyright (c) 2020, 2025 Lablicate GmbH.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.xxd.ui.toolbar;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImage;
import org.eclipse.chemclipse.ux.extension.ui.support.PartSupport;
import org.eclipse.chemclipse.ux.extension.xxd.ui.preferences.PreferencePageTaskMiscellaneous;
import org.eclipse.chemclipse.ux.extension.xxd.ui.preferences.PreferenceSupplier;
import org.eclipse.jface.preference.IPreferencePage;

public class GroupHandlerMiscellaneous extends AbstractGroupHandler {

	public static final String NAME = "Miscellaneous";

	private static final String IMAGE_HIDE = IApplicationImage.IMAGE_MEASUREMENT_RESULTS_ACTIVE;
	private static final String IMAGE_SHOW = IApplicationImage.IMAGE_MEASUREMENT_RESULTS_DEFAULT;

	@Override
	public List<IPreferencePage> getPreferencePages() {

		List<IPreferencePage> preferencePages = new ArrayList<>();
		preferencePages.add(new PreferencePageTaskMiscellaneous());
		return preferencePages;
	}

	@Override
	public List<IPartHandler> getPartHandlerMandatory() {

		List<IPartHandler> partHandler = new ArrayList<>();

		partHandler.add(new PartHandler("Measurement Results", PartSupport.PARTDESCRIPTOR_MEASUREMENT_RESULTS, PreferenceSupplier.P_STACK_POSITION_MEASUREMENT_RESULTS));

		return partHandler;
	}

	@Override
	public List<IPartHandler> getPartHandlerAdditional() {

		List<IPartHandler> partHandler = new ArrayList<>();

		partHandler.add(new PartHandler("Penalty Calculation", PartSupport.PARTDESCRIPTOR_PENALTY_CALCULATION, PreferenceSupplier.P_STACK_POSITION_PENALTY_CALCULATION));
		partHandler.add(new PartHandler("Synonyms", PartSupport.PARTDESCRIPTOR_SYNONYMS, PreferenceSupplier.P_STACK_POSITION_SYNONYMS));
		partHandler.add(new PartHandler("Column Indices", PartSupport.PARTDESCRIPTOR_COLUMN_INDICES, PreferenceSupplier.P_STACK_POSITION_COLUMN_INDICES));
		partHandler.add(new PartHandler("Flavor Marker", PartSupport.PARTDESCRIPTOR_FLAVOR_MARKER, PreferenceSupplier.P_STACK_POSITION_FLAVOR_MARKER));
		partHandler.add(new PartHandler("Literature", PartSupport.PARTDESCRIPTOR_LITERATURE, PreferenceSupplier.P_STACK_POSITION_LITERATURE));
		partHandler.add(new PartHandler("CAS Numbers", PartSupport.PARTDESCRIPTOR_CAS_NUMBERS, PreferenceSupplier.P_STACK_POSITION_CAS_NUMBERS));

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

		return ".misc";
	}
}
