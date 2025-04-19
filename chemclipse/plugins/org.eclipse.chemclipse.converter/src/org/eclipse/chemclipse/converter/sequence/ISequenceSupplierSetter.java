/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.converter.sequence;

import org.eclipse.chemclipse.converter.core.IFileContentMatcher;
import org.eclipse.chemclipse.converter.core.IMagicNumberMatcher;

public interface ISequenceSupplierSetter extends ISequenceSupplier {

	void setId(final String id);

	void setDescription(final String description);

	void setFilterName(final String filterName);

	void setFileExtension(final String fileExtension);

	void setFileName(final String fileName);

	void setMagicNumberMatcher(final IMagicNumberMatcher magicNumberMatcher);

	void setFileContentMatcher(IFileContentMatcher fileContentMatcher);
}
