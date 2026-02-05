/*******************************************************************************
 * Copyright (c) 2019, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Christoph Läubrich - initial API and implementation
 * Philip Wenig - support process method resume option
 *******************************************************************************/
package org.eclipse.chemclipse.processing.supplier;

import java.util.List;
import java.util.Set;

import org.eclipse.chemclipse.processing.DataCategory;
import org.eclipse.chemclipse.support.literature.LiteratureReference;
import org.eclipse.chemclipse.support.settings.parser.SettingsParser;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public interface IProcessSupplier<SettingType> {

	enum SupplierType {
		/**
		 * The default type specifies no special behavior
		 */
		DEFAULT,
		/**
		 * A supplier might be interactive, that means that it requires some kind of user interaction to take place
		 */
		INTERACTIVE,
		/**
		 * A supplier that is structural contributes to the flow of execution but normally does not offer any mean in the context of execute a single step
		 */
		STRUCTURAL;
	}

	/**
	 * 
	 * @return the ID of this processor
	 */
	String getId();

	/**
	 * 
	 * @return the name of this processor
	 */
	String getName();

	default String getCategory() {

		return getTypeSupplier().getCategory();
	}

	/**
	 * 
	 * @return a brief description of this processor
	 */
	String getDescription();

	/**
	 * Returns the list of literature references.
	 * 
	 * @return {@link List}
	 */
	List<LiteratureReference> getLiteratureReferences();

	/**
	 * 
	 * @return the settings class
	 */
	Class<SettingType> getSettingsClass();

	/**
	 * 
	 * @return a set of supported data types
	 */
	Set<DataCategory> getSupportedDataTypes();

	/**
	 * 
	 * @return the settings parser for this supplier
	 */
	SettingsParser<SettingType> getSettingsParser();

	/**
	 * 
	 * @return the {@link IProcessTypeSupplier} this {@link IProcessSupplier} belongs to
	 */
	IProcessTypeSupplier getTypeSupplier();

	/**
	 * This method should be used when trying to find a processor that matches a stored id in favor of comparing the id directly because a processor might want to support old id names for backward compatibility
	 * 
	 * @param id
	 * @return <code>true</code> if the id matches this processor false otherwise
	 */
	default boolean matchesId(String id) {

		return getId().equals(id);
	}

	/**
	 * 
	 * @return the context that belongs to this supplier, this could either be the supplier itself or the corresponding {@link IProcessTypeSupplier}
	 */
	default IProcessSupplierContext getContext() {

		if(this instanceof IProcessSupplierContext processSupplierContext) {
			return processSupplierContext;
		} else {
			return getTypeSupplier();
		}
	}

	default SupplierType getType() {

		return SupplierType.DEFAULT;
	}

	/**
	 * Check if this {@link IProcessSupplier} can currently be used. A supplier might be incapable of being executed (e.g. improper system configuration) or temporary unavailable (e.g. disconnected from underlying device)
	 * 
	 * @return a {@link IStatus} describing the current state, the default implementation always returns {@link Status#OK_STATUS}
	 */
	default IStatus validate() {

		return Status.OK_STATUS;
	}

	/**
	 * Check if the given settings are valid for this {@link IProcessTypeSupplier}
	 * 
	 * @param settings
	 *            the settings to check
	 * @return a {@link IStatus} describing the outcome of the settings check, the default implementation always returns the result of {@link #validate()}
	 */
	default IStatus validate(SettingType settings) {

		return validate();
	}
}