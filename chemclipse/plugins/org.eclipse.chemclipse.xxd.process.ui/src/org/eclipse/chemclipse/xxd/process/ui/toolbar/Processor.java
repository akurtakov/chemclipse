/*******************************************************************************
 * Copyright (c) 2021, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Matthias Mailänder - add default icons
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.ui.toolbar;

import org.eclipse.chemclipse.processing.supplier.IProcessSupplier;
import org.eclipse.chemclipse.rcp.ui.icons.core.ApplicationImageFactory;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImageProvider;
import org.eclipse.chemclipse.xxd.process.ui.support.ProcessorSupport;
import org.eclipse.swt.graphics.Image;

public class Processor {

	/*
	 * Backward compatibility with -1.
	 * Set selected processors at the end of the list (MAX_VALUE).
	 */
	public static final int INDEX_NONE = -1;
	public static final int INDEX_MAX = Integer.MAX_VALUE;

	private IProcessSupplier<?> processSupplier;
	private boolean active = false;
	private int index = INDEX_NONE; // position in list
	private String imageFileName;

	public Processor(IProcessSupplier<?> processSupplier) {

		this.processSupplier = processSupplier;
	}

	public IProcessSupplier<?> getProcessSupplier() {

		return processSupplier;
	}

	public boolean isActive() {

		return active;
	}

	public void setActive(boolean active) {

		this.active = active;
	}

	public int getIndex() {

		return index;
	}

	public void setIndex(int index) {

		this.index = index;
	}

	public String getImageFileName() {

		if(imageFileName == null) {
			return null;
		}
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {

		this.imageFileName = imageFileName;
	}

	public Image getMenuIcon() {

		// user override from common image pool for custom symbol
		if(imageFileName != null && !imageFileName.isBlank()) {
			return ApplicationImageFactory.getInstance().getImage(imageFileName, IApplicationImageProvider.SIZE_16x16);
		}

		Image menuIcon = ProcessorSupport.getMenuIcon(processSupplier);
		if(menuIcon == null) {
			menuIcon = ProcessorSupport.getDefaultIcon(processSupplier);
		}
		return menuIcon;
	}
}