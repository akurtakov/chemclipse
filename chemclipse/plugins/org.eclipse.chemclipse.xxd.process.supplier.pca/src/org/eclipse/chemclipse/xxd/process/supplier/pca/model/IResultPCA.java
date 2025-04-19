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

import org.eclipse.chemclipse.model.statistics.ISample;

public interface IResultPCA {

	ISample getSample();

	double[] getSampleData();

	boolean isDisplayed();

	void setDisplayed(boolean displayed);

	double[] getScoreVector();

	void setScoreVector(double[] eigenSpace);

	double getErrorMemberShip();

	void setErrorMemberShip(double errorMemberShip);

	void setSampleData(double[] sampleData);

	void toggleSelected();

	boolean isSelected();
}