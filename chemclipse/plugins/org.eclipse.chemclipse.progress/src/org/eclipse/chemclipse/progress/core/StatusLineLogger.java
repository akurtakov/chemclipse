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
package org.eclipse.chemclipse.progress.core;

import java.util.ArrayList;
import java.util.List;

public class StatusLineLogger {

	private static List<IStatusLineMessageListener> listeners = new ArrayList<>();

	/**
	 * Use only static methods.
	 */
	private StatusLineLogger() {

	}

	/**
	 * Adds a {@link IStatusLineMessageListener} to listen to messages.<br/>
	 * DO NOT ATTEND IF NOT ABSOLUTELY NECCESSARY.
	 * 
	 * @param listener
	 */
	public static void add(IStatusLineMessageListener listener) {

		listeners.add(listener);
	}

	/**
	 * Removes a {@link IStatusLineMessageListener}.
	 * 
	 * @param listener
	 */
	public static void remove(IStatusLineMessageListener listener) {

		listeners.remove(listener);
	}

	/**
	 * Set a message given by {@link InfoType} to the status line.
	 * 
	 * @param infoType
	 * @param message
	 */
	public static void setInfo(InfoType infoType, String message) {

		/*
		 * Normally you should encapsulate the calls if one of the listeners is
		 * not working correctly.<br/> But, we skip it here.
		 */
		for(IStatusLineMessageListener listener : listeners) {
			if(listener != null) {
				listener.setInfo(infoType, message);
			}
		}
	}
}
