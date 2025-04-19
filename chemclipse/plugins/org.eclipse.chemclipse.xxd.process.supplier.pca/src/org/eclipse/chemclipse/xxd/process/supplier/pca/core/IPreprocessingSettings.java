/*******************************************************************************
 * Copyright (c) 2020, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.process.supplier.pca.core;

import org.eclipse.chemclipse.xxd.process.supplier.pca.core.preprocessing.ICentering;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.preprocessing.INormalization;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.preprocessing.IReplacer;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.preprocessing.ITransformation;

public interface IPreprocessingSettings extends IDataModification {

	ICentering getCentering();

	void setCentering(ICentering centering);

	INormalization getNormalization();

	void setNormalization(INormalization normalization);

	ITransformation getTransformation();

	void setTransformation(ITransformation transformation);

	IReplacer getReplacer();

	void setReplacer(IReplacer replacer);
}