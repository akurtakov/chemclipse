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
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.filter.ui.preferences;

import org.eclipse.chemclipse.chromatogram.filter.impl.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.chromatogram.filter.ui.Activator;
import org.eclipse.chemclipse.chromatogram.filter.ui.l10n.Messages;
import org.eclipse.chemclipse.model.math.IonRoundMethod;
import org.eclipse.chemclipse.support.ui.preferences.fieldeditors.DoubleFieldEditor;
import org.eclipse.chemclipse.support.ui.preferences.fieldeditors.ExtendedIntegerFieldEditor;
import org.eclipse.chemclipse.support.ui.preferences.fieldeditors.FloatFieldEditor;
import org.eclipse.chemclipse.support.ui.preferences.fieldeditors.LabelFieldEditor;
import org.eclipse.chemclipse.support.ui.preferences.fieldeditors.SpacerFieldEditor;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class FilterPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public FilterPreferencePage() {

		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setTitle(Messages.filter);
		setDescription(""); //$NON-NLS-1$
	}

	public void createFieldEditors() {

		addField(new SpacerFieldEditor(getFieldEditorParent()));
		addField(new LabelFieldEditor(Messages.chromotogramSelectionFilter, getFieldEditorParent()));
		addField(new DoubleFieldEditor(PreferenceSupplier.P_START_RETENTION_TIME_MINUTES, Messages.startRetentionTimeMinutes, PreferenceSupplier.MIN_RETENTION_TIME_MINUTES, PreferenceSupplier.MAX_RETENTION_TIME_MINUTES, getFieldEditorParent()));
		addField(new DoubleFieldEditor(PreferenceSupplier.P_STOP_RETENTION_TIME_MINUTES, Messages.stopRetentionTimeMinutes, PreferenceSupplier.MIN_RETENTION_TIME_MINUTES, PreferenceSupplier.MAX_RETENTION_TIME_MINUTES, getFieldEditorParent()));

		addField(new SpacerFieldEditor(getFieldEditorParent()));
		addField(new LabelFieldEditor(Messages.peakTargetsReferenceChromatogram, getFieldEditorParent()));
		addField(new BooleanFieldEditor(PreferenceSupplier.P_PTTR_USE_BEST_TARGET_ONLY, Messages.useBestTargetOnly, getFieldEditorParent()));
		addField(new DoubleFieldEditor(PreferenceSupplier.P_DELTA_RETENTION_TIME_MINUTES, Messages.deltaRetentionTimeMinutes, PreferenceSupplier.MIN_RETENTION_TIME_MINUTES, PreferenceSupplier.MAX_RETENTION_TIME_MINUTES, getFieldEditorParent()));

		addField(new SpacerFieldEditor(getFieldEditorParent()));
		addField(new LabelFieldEditor(Messages.scanTargetsToReferenceChromatogramsTransfer, getFieldEditorParent()));
		addField(new BooleanFieldEditor(PreferenceSupplier.P_STTR_USE_BEST_TARGET_ONLY, Messages.useBestTargetOnly, getFieldEditorParent()));

		addField(new SpacerFieldEditor(getFieldEditorParent()));
		addField(new BooleanFieldEditor(PreferenceSupplier.P_USE_RETENTION_INDEX_QC, Messages.qcUseRententionIndexProcessor, getFieldEditorParent()));
		addField(new ComboFieldEditor(PreferenceSupplier.P_ION_ROUND_METHOD, Messages.ionRoundMethod, IonRoundMethod.getOptions(), getFieldEditorParent()));

		addField(new SpacerFieldEditor(getFieldEditorParent()));
		addField(new LabelFieldEditor(Messages.scanMaximaDetectorUI, getFieldEditorParent()));
		addField(new StringFieldEditor(PreferenceSupplier.P_MAX_DETECTOR_TARGET_NAME, Messages.targetName, getFieldEditorParent()));
		addField(new FloatFieldEditor(PreferenceSupplier.P_MAX_DETECTOR_MATCH_FACTOR, Messages.matchFactor, PreferenceSupplier.MIN_FACTOR, PreferenceSupplier.MAX_FACTOR, getFieldEditorParent()));
		addField(new BooleanFieldEditor(PreferenceSupplier.P_MAX_DETECTOR_MINIMA, Messages.detectMinima, getFieldEditorParent()));
		addField(new ExtendedIntegerFieldEditor(PreferenceSupplier.P_MAX_DETECTOR_COUNT, Messages.countIncludingZero, PreferenceSupplier.MIN_COUNT_MARKER, PreferenceSupplier.MAX_COUNT_MARKER, getFieldEditorParent()));

		addField(new SpacerFieldEditor(getFieldEditorParent()));
		addField(new ExtendedIntegerFieldEditor(PreferenceSupplier.P_TRANSFORM_MZ, Messages.transformMZ, PreferenceSupplier.MIN_MZ, PreferenceSupplier.MAX_MZ, getFieldEditorParent()));
	}

	public void init(IWorkbench workbench) {

	}
}