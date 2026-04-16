/*******************************************************************************
 * Copyright (c) 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.converter;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.converter.services.IChromatogramConverterAdditionService;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator {

	private static Activator plugin;
	private Bundle bundle;
	/*
	 * Services
	 */
	private ServiceTracker<IChromatogramConverterAdditionService, IChromatogramConverterAdditionService> chromatogramConverterAdditionServiceTracker = null;

	/**
	 * The constructor
	 */
	public Activator() {

	}

	@Override
	public void start(BundleContext context) throws Exception {

		plugin = this;
		this.bundle = context.getBundle();
		startServices(context);
	}

	@Override
	public void stop(BundleContext context) throws Exception {

		stopServices();
		plugin = null;
	}

	/**
	 * Returns the bundle associated with this plug-in.
	 *
	 * @return the associated bundle
	 */
	public final Bundle getBundle() {

		return bundle;
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {

		return plugin;
	}

	public List<IChromatogramConverterAdditionService> getChromatogramConverterAdditionService() {

		List<IChromatogramConverterAdditionService> services = new ArrayList<>();
		if(chromatogramConverterAdditionServiceTracker.getServices() == null) {
			return services;
		}

		for(Object object : chromatogramConverterAdditionServiceTracker.getServices()) {
			if(object instanceof IChromatogramConverterAdditionService service) {
				services.add(service);
			}
		}

		return services;
	}

	private void startServices(BundleContext context) {

		chromatogramConverterAdditionServiceTracker = new ServiceTracker<>(context, IChromatogramConverterAdditionService.class, null);
		chromatogramConverterAdditionServiceTracker.open();
	}

	private void stopServices() {

		chromatogramConverterAdditionServiceTracker.close();
	}
}
