/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.xxd.ui.swt;

import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.rcp.ui.icons.core.ApplicationImageFactory;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImage;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImageProvider;
import org.eclipse.chemclipse.ux.extension.xxd.ui.model.TracesExportOption;
import org.eclipse.chemclipse.ux.extension.xxd.ui.model.TracesSupport;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

public class TracesClipboardUI extends Composite {

	private AtomicReference<Button> buttonClipboard = new AtomicReference<>();
	private IScan scan = null;

	public TracesClipboardUI(Composite parent, int style) {

		super(parent, style);
		createControl();
	}

	public void setInput(IScan scan) {

		this.scan = scan;
	}

	public void updateOption() {

		TracesExportOption tracesExportOption = TracesSupport.getTracesExportOption();
		buttonClipboard.get().setToolTipText(tracesExportOption.label());
	}

	private void createControl() {

		setLayout(new FillLayout());
		//
		Composite composite = new Composite(this, SWT.NONE);
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginLeft = 0;
		gridLayout.marginRight = 0;
		gridLayout.marginWidth = 0;
		composite.setLayout(gridLayout);
		//
		createButtonClipboard(composite);
		//
		initialize();
	}

	private void initialize() {

		createMenuClipboard();
	}

	private void createButtonClipboard(Composite parent) {

		Button button = new Button(parent, SWT.PUSH);
		button.setText("");
		button.setToolTipText("Copy the traces to clipboard.");
		button.setImage(ApplicationImageFactory.getInstance().getImage(IApplicationImage.IMAGE_COPY_CLIPBOARD, IApplicationImageProvider.SIZE_16x16));
		button.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				copyToClipboard(e.display);
			}
		});
		//
		buttonClipboard.set(button);
	}

	private void createMenuClipboard() {

		Button button = buttonClipboard.get();
		Menu menu = new Menu(button);

		for(TracesExportOption tracesExportOption : TracesExportOption.values()) {
			MenuItem menuItem = new MenuItem(menu, SWT.NONE);
			menuItem.setText(tracesExportOption.label());
			menuItem.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {

					TracesSupport.setTracesExportOption(tracesExportOption);
					button.setToolTipText(tracesExportOption.label());
					copyToClipboard(e.display);
				}
			});
		}
		//
		button.setMenu(menu);
	}

	private void copyToClipboard(Display display) {

		if(scan != null) {
			TracesExportOption tracesExportOption = TracesSupport.getTracesExportOption();
			TracesSupport.copyTracesToClipboard(display, tracesExportOption, scan);
		}
	}
}