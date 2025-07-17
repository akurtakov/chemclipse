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
 * Lorenz Gerber - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.model;

import org.eclipse.chemclipse.model.statistics.IVariable;

public interface IResults<R extends IResult, V extends IVariable> {

	double[] getCrossValidations();

	void setCrossValidations(double[] crossValidations);

	double[] getCumulativeCrossValidations();

	void setCumulativeCrossValidations(double[] cumulativeCrossValidations);
}
