/*******************************************************************************
 * Copyright (c) 2022, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.xxd.ui.services;

import org.eclipse.chemclipse.processing.converter.ISupplierFileIdentifier;
import org.eclipse.chemclipse.ux.extension.xxd.ui.editors.ChromatogramEditorTSD;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

@Component(service = {IEditorService.class}, configurationPolicy = ConfigurationPolicy.OPTIONAL)
public class EditorServiceTSD implements IEditorService {

	@Override
	public String getLabel() {

		return "ChemClipse Editor (TSD)";
	}

	@Override
	public String getType() {

		return ISupplierFileIdentifier.TYPE_TSD;
	}

	@Override
	public String getElementId() {

		return ChromatogramEditorTSD.ID;
	}

	@Override
	public String getContributionURI() {

		return ChromatogramEditorTSD.CONTRIBUTION_URI;
	}

	@Override
	public String getIconURI() {

		return ChromatogramEditorTSD.ICON_URI;
	}

	@Override
	public String getTooltip() {

		return ChromatogramEditorTSD.TOOLTIP;
	}
}