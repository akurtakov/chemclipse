/*******************************************************************************
 * Copyright (c) 2008, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.filter.result;

public abstract class AbstractChromatogramFilterResult implements IChromatogramFilterResult {

	private ResultStatus resultStatus = ResultStatus.UNDEFINED;
	private String description = "";

	/**
	 * Creates a new FilterResult instance.<br/>
	 * If a value of the parameters is null, the default value will be chosen.<br/>
	 * resultStatus (default) == ResultStatus.UNDEFINED<br/>
	 * description (default) == ""
	 * 
	 * @param resultStatus
	 * @param description
	 */
	public AbstractChromatogramFilterResult(ResultStatus resultStatus, String description) {

		if(resultStatus != null) {
			this.resultStatus = resultStatus;
		}
		if(description != null) {
			this.description = description;
		}
	}

	@Override
	public String getDescription() {

		return description;
	}

	@Override
	public ResultStatus getResultStatus() {

		return resultStatus;
	}
}
