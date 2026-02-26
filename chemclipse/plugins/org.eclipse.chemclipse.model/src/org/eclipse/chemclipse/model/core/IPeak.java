/*******************************************************************************
 * Copyright (c) 2013, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Christoph Läubrich - add the PeakPostion interface, extract Classifiable interface, implement ISignal, add getName
 *******************************************************************************/
package org.eclipse.chemclipse.model.core;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.eclipse.chemclipse.model.quantitation.IInternalStandard;
import org.eclipse.chemclipse.model.quantitation.IQuantitationEntry;
import org.eclipse.chemclipse.model.support.IIntegrationConstraints;

public interface IPeak extends ITargetSupplier, IClassifier, ISignal {

	/**
	 * This comparator compares peaks based on the RT at the maximum of the intensity of the peak model
	 */
	public static final Comparator<IPeak> COMPARATOR_RT_MAX = (o1, o2) -> Integer.compare(o1.getPeakModel().getRetentionTimeAtPeakMaximum(), o2.getPeakModel().getRetentionTimeAtPeakMaximum());
	/**
	 * This comparator compares peaks based on the RT at the start of the intensity of the peak model
	 */
	public static final Comparator<IPeak> COMPARATOR_RT_START = (o1, o2) -> Integer.compare(o1.getPeakModel().getStartRetentionTime(), o2.getPeakModel().getStartRetentionTime());

	IPeakModel getPeakModel();

	/**
	 * Returns the modelDescription of the peak.<br/>
	 * The modelDescription is given as:<br/>
	 * TIC - if all ions are considered<br/>
	 * XIC - if some ions are subtracted<br/>
	 * <br/>
	 * E.g.:<br/>
	 * "TIC"<br/>
	 * "+199-70"<br/>
	 */
	String getModelDescription();

	/**
	 * Sets a description of the peak model.<br/>
	 * See also getModel();
	 */
	void setModelDescription(String modelDescription);

	/**
	 * Returns the peak type.<br/>
	 * It is a value which defines the type of the peak start and end point.<br/>
	 * BB - baseline baseline<br/>
	 * BV - baseline valley<br/>
	 * ... <br/>
	 */
	PeakType getPeakType();

	/**
	 * Sets the peak type.<br/>
	 */
	void setPeakType(PeakType peakType);

	/**
	 * Returns the number of assumed hidden peaks.
	 * If there's no hint, 0 will be returned.
	 */
	int getSuggestedNumberOfComponents();

	/**
	 * Sets the number of suggested hidden peaks.
	 */
	void setSuggestedNumberOfComponents(int suggestedNumberOfComponents);

	/**
	 * Returns the integrator description.
	 */
	String getIntegratorDescription();

	/**
	 * Sets the integrator description.
	 */
	void setIntegratorDescription(String integratorDescription);

	/**
	 * Returns the peak detector description.
	 */
	String getDetectorDescription();

	/**
	 * Sets the peak detector description.
	 */
	void setDetectorDescription(String detectorDescription);

	/**
	 * Returns the integration constraints object.<br/>
	 * Several constraints on integration mode can be stored in the object.<br/>
	 * Think of a peak where a shoulder has been detected. Now you don't want
	 * the integrator to use another baseline for the shoulder.<br/>
	 * What can you do? Tell the integrator to not set another baseline or
	 * correction. If the peak is marked with the IntegrationConstraint
	 * "LEAVE_PEAK_AS_IT_IS" it will be integrated as it is, if the integrator
	 * has implemented it.
	 */
	IIntegrationConstraints getIntegrationConstraints();

	/**
	 * Returns the integrated area of the actual peak.
	 */
	double getIntegratedArea();

	/**
	 * Sets the integration results.
	 */
	void setIntegratedArea(List<? extends IIntegrationEntry> integrationEntries, String integratorDescription);

	/**
	 * Returns the list of integration entries.
	 */
	List<IIntegrationEntry> getIntegrationEntries();

	void addAllIntegrationEntries(Collection<? extends IIntegrationEntry> integrationEntries);

	void addAllIntegrationEntries(IIntegrationEntry... integrationEntries);

	/**
	 * Returns the peak quantifier description.
	 */
	String getQuantifierDescription();

	/**
	 * Sets the peak quantifier description.
	 */
	void setQuantifierDescription(String quantifierDescription);

	/**
	 * Adds a quantitation entry to the list.
	 */
	void addQuantitationEntry(IQuantitationEntry quantitationEntry);

	void addAllQuantitationEntries(Collection<? extends IQuantitationEntry> quantitationEntries);

	void addAllQuantitationEntries(IQuantitationEntry... quantitationEntries);

	/**
	 * Removes the quantitation entry from the list.
	 */
	void removeQuantitationEntry(IQuantitationEntry quantitationEntry);

	/**
	 * Removes the quantitation entries from the list.
	 */
	void removeQuantitationEntries(List<IQuantitationEntry> quantitationEntriesToRemove);

	/**
	 * Get the quantitation entries.
	 */
	List<IQuantitationEntry> getQuantitationEntries();

	/**
	 * Removes all quantitation entries.
	 */
	void removeAllQuantitationEntries();

	/**
	 * Removes all integration entries.
	 */
	void removeAllIntegrationEntries();

	/**
	 * Returns if the peak is active for analysis.
	 */
	boolean isActiveForAnalysis();

	/**
	 * Sets the peak active/inactive.
	 */
	void setActiveForAnalysis(boolean activeForAnalysis);

	List<IInternalStandard> getInternalStandards();

	void addInternalStandard(IInternalStandard internalStandard);

	void addInternalStandards(List<IInternalStandard> internalStandards);

	void removeInternalStandards();

	void removeInternalStandard(IInternalStandard internalStandard);

	void removeQuantitationReferences();

	List<String> getQuantitationReferences();

	void addQuantitationReference(String quantitationReference);

	void addQuantitationReferences(List<String> quantitationReferences);

	void removeQuantitationReference(String quantitationReference);

	void removeClassifier();

	String getTemporaryData();

	/**
	 * The temporary data is not saved!
	 * It can be used to place volatile process information.
	 */
	void setTemporaryData(String temporaryData);

	boolean isMarkedAsDeleted();

	/**
	 * Mark this peak as deleted. The DELETED PeakType was used before,
	 * but that doesn't make sense.
	 */
	void setMarkedAsDeleted(boolean markedAsDeleted);

	/**
	 * Returns the retention time at peak maximum in milliseconds.
	 */
	@Override
	default double getX() {

		return getPeakModel().getRetentionTimeAtPeakMaximum();
	}

	/**
	 * Returns the abundance of the peak including background.
	 */
	@Override
	default double getY() {

		IPeakModel peakModel = getPeakModel();
		return peakModel.getPeakAbundance() + peakModel.getBackgroundAbundance();
	}
}