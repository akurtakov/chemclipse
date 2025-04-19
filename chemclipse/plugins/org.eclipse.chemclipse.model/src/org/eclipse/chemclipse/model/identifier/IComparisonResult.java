/*******************************************************************************
 * Copyright (c) 2010, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Alexander Kerner - implementation
 * Christoph Läubrich - add comparator static field
 *******************************************************************************/
package org.eclipse.chemclipse.model.identifier;

import java.io.Serializable;
import java.util.Comparator;

/**
 * 0 = no match
 * 100 = perfect match
 */
public interface IComparisonResult extends Serializable, Comparable<IComparisonResult> {

	static Comparator<IComparisonResult> MATCH_FACTOR_COMPARATOR = (o1, o2) -> Float.compare(o1.getMatchFactor(), o2.getMatchFactor());
	//
	float FACTOR_BEST_MATCH = 100.0f;
	float FACTOR_NO_MATCH = 0.0f;
	//
	float MAX_MATCH_FACTOR = FACTOR_BEST_MATCH;
	float MAX_REVERSE_MATCH_FACTOR = FACTOR_BEST_MATCH;
	//
	float DEF_MAX_PENALTY = IPenaltyCalculationSettings.DEF_PENALTY_MATCH_FACTOR;
	float MIN_ALLOWED_PENALTY = IPenaltyCalculationSettings.MIN_PENALTY_MATCH_FACTOR;
	float MAX_ALLOWED_PENALTY = IPenaltyCalculationSettings.MAX_PENALTY_MATCH_FACTOR;
	//
	float MIN_ALLOWED_PROBABILITY = 0.0f;
	float MAX_ALLOWED_PROBABILITY = 100.0f;

	boolean isMatch();

	IComparisonResult setMatch(boolean match);

	float getMatchFactor();

	float getMatchFactorNotAdjusted();

	float getMatchFactorDirect();

	float getMatchFactorDirectNotAdjusted();

	/**
	 * Sets a penalty. It's effectively the same as calling
	 * {@link #clearPenalty()} and {@link #addPenalty(float)}. {@code penalty}
	 * must be between MIN_ALLOWED_PENALTY and MAX_ALLOWED_PENALTY otherwise an
	 * exception is thrown.
	 * 
	 * @param penalty
	 *            the penalty to set
	 * @throws IllegalArgumentException
	 *             if {@code penalty} is smaller than
	 *             {@link #MIN_ALLOWED_PENALTY} or larger than
	 *             {@link #MAX_ALLOWED_PENALTY}
	 */
	void setPenalty(float penalty);

	/**
	 * Adds given penalty to this {@code IComparisonResult}'s penalty.
	 * 
	 * @param penalty
	 */
	void addPenalty(float penalty);

	void clearPenalty();

	float getPenalty();

	float getReverseMatchFactor();

	float getReverseMatchFactorNotAdjusted();

	float getReverseMatchFactorDirect();

	float getReverseMatchFactorDirectNotAdjusted();

	float getProbability();

	float getInLibFactor();

	void setInLibFactor(float inLibFactor);

	IRatingSupplier getRatingSupplier();
}
