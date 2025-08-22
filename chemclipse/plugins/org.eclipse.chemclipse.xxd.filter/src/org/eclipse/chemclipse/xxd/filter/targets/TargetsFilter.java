/*******************************************************************************
 * Copyright (c) 2020, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.filter.targets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.model.comparator.IdentificationTargetComparator;
import org.eclipse.chemclipse.model.core.IPeak;
import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.model.core.ITargetSupplier;
import org.eclipse.chemclipse.model.identifier.IIdentificationTarget;
import org.eclipse.chemclipse.xxd.filter.peaks.settings.DeleteTargetsFilterSettings;

public class TargetsFilter {

	private static final Logger logger = Logger.getLogger(TargetsFilter.class);

	public static void filter(ITargetSupplier targetSupplier, DeleteTargetsFilterSettings settings) {

		if(targetSupplier != null && settings != null) {
			/*
			 * Targets and option if used.
			 */
			Set<IIdentificationTarget> targets = targetSupplier.getTargets();
			String property = settings.getProperty() == null ? "" : settings.getProperty().trim();

			switch(settings.getTargetDeleteOption()) {
				case ALL_TARGETS:
					targets.clear();
					break;
				case UNVERIFIED_TARGETS:
					removeUnverifiedTargets(targets);
					break;
				case EMPTY_SMILES:
					removeEmptySmilesTargets(targets);
					break;
				case PROPERTY_IDENTIFIER:
					removeTargetsByIdentifier(targets, property);
					break;
				case PROPERTY_LEVEL:
					float retentionIndex = getRetentionIndex(targetSupplier);
					removeTargetsByLevel(targets, property, retentionIndex);
					break;
			}
		}
	}

	private static float getRetentionIndex(ITargetSupplier targetSupplier) {

		float retentionIndex = 0;
		if(targetSupplier instanceof IPeak peak) {
			retentionIndex = peak.getPeakModel().getPeakMaximum().getRetentionIndex();
		} else if(targetSupplier instanceof IScan scan) {
			retentionIndex = scan.getRetentionIndex();
		}

		return retentionIndex;
	}

	private static void removeUnverifiedTargets(Set<IIdentificationTarget> targets) {

		Set<IIdentificationTarget> delete = new HashSet<>();
		for(IIdentificationTarget target : targets) {
			if(!target.isVerified()) {
				delete.add(target);
			}
		}

		removeTargets(targets, delete);
	}

	private static void removeEmptySmilesTargets(Set<IIdentificationTarget> targets) {

		Set<IIdentificationTarget> delete = new HashSet<>();
		for(IIdentificationTarget target : targets) {
			String smiles = target.getLibraryInformation().getSmiles();
			if("".equals(smiles)) {
				delete.add(target);
			}
		}

		removeTargets(targets, delete);
	}

	private static void removeTargetsByIdentifier(Set<IIdentificationTarget> targets, String identifier) {

		if(!identifier.isEmpty()) {
			Set<IIdentificationTarget> delete = new HashSet<>();
			for(IIdentificationTarget target : targets) {
				if(target.getIdentifier().equals(identifier)) {
					delete.add(target);
				}
			}

			removeTargets(targets, delete);
		}
	}

	private static void removeTargetsByLevel(Set<IIdentificationTarget> targets, String level, float retentionIndex) {

		if(!level.isEmpty()) {
			try {
				/*
				 * ----------------------------------------
				 * Level is 1 based, but the targets list is 0 based.
				 * ----------------------------------------
				 * 1 (First Target)
				 * 2 (Second Target)
				 * 5
				 * > 1
				 * =< 5
				 */
				int size = targets.size();
				int fromIndex = -1;
				int toIndex = -1;
				Pattern pattern = Pattern.compile("(<|<=|>|>=)?(\\s+)?([0-9]+)");
				Matcher matcher = pattern.matcher(level.trim());
				if(matcher.matches()) {
					String hint = matcher.group(1) == null ? "" : matcher.group(1);
					String index = matcher.group(3);
					switch(hint) {
						case "<":
							fromIndex = 0;
							toIndex = Integer.parseInt(index) - 1;
							break;
						case "<=":
							fromIndex = 0;
							toIndex = Integer.parseInt(index);
							break;
						case ">":
							fromIndex = Integer.parseInt(index);
							toIndex = size;
							break;
						case ">=":
							fromIndex = Integer.parseInt(index) - 1;
							toIndex = size;
							break;
						default:
							/*
							 * Specific Level
							 */
							int position = Integer.parseInt(index) - 1;
							fromIndex = position;
							toIndex = position + 1;
							break;
					}

				}
				/*
				 * Validation
				 */
				if(fromIndex >= 0 && fromIndex <= toIndex && toIndex <= size) {
					List<IIdentificationTarget> sortedTargets = new ArrayList<>(targets);
					Collections.sort(sortedTargets, new IdentificationTargetComparator(retentionIndex));
					Set<IIdentificationTarget> deleteTargets = new HashSet<>(sortedTargets.subList(fromIndex, toIndex));
					removeTargets(targets, deleteTargets);
				}
			} catch(NumberFormatException e) {
				logger.warn(e);
			}
		}
	}

	private static void removeTargets(Set<IIdentificationTarget> targets, Set<IIdentificationTarget> delete) {

		targets.removeAll(delete);
	}
}