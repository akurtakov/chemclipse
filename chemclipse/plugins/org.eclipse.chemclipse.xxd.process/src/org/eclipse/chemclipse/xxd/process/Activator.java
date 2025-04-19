/*******************************************************************************
 * Copyright (c) 2012, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Christoph Läubrich - dynmic supplier support
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process;

import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.chemclipse.processing.supplier.IProcessTypeSupplier;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private static final AtomicReference<ServiceTracker<IProcessTypeSupplier, IProcessTypeSupplier>> processTypeSupplierTracker = new AtomicReference<>();

	public static BundleContext getContext() {

		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext bundleContext) throws Exception {

		ServiceTracker<IProcessTypeSupplier, IProcessTypeSupplier> serviceTracker = new ServiceTracker<>(bundleContext, IProcessTypeSupplier.class, null);
		serviceTracker.open();
		ServiceTracker<IProcessTypeSupplier, IProcessTypeSupplier> tracker = processTypeSupplierTracker.getAndSet(serviceTracker);
		if(tracker != null) {
			tracker.close();
		}
		Activator.context = bundleContext;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext bundleContext) throws Exception {

		ServiceTracker<IProcessTypeSupplier, IProcessTypeSupplier> tracker = processTypeSupplierTracker.getAndSet(null);
		if(tracker != null) {
			tracker.close();
		}
		Activator.context = null;
	}

	/**
	 * 
	 * @return an array holding all currently active {@link IProcessTypeSupplier}
	 */
	public static IProcessTypeSupplier[] getProcessTypeSuppliers() {

		ServiceTracker<IProcessTypeSupplier, IProcessTypeSupplier> tracker = processTypeSupplierTracker.get();
		if(tracker != null) {
			return tracker.getServices(new IProcessTypeSupplier[0]);
		}
		return new IProcessTypeSupplier[0];
	}
}
