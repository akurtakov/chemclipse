/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.support.literature;

public class LiteratureReference {

	private String content = "";
	private String title = "";
	private String url = "";

	public LiteratureReference(String content) {

		this.content = content;
		this.title = LiteratureSupport.getTitle(content);
		this.url = LiteratureSupport.getContainedLink(content);
	}

	public String getContent() {

		return content;
	}

	public String getTitle() {

		return title;
	}

	public String getUrl() {

		return url;
	}
}