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
 * Lorenz Gerber - add select
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.model;

public interface IResultMVA extends IResult {

	double[] getScoreVector();

	void setScoreVector(double[] eigenSpace);

	double getErrorMetric();

	void setErrorMetric(double errorMetric);

	void setCrossValidations(double[] crossValidation);

	void setCumulativeCrossValidations(double[] cumulativeCrossValidation);
}