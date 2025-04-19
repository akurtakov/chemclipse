/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Alexander Stark - initial API and implementation
 * Christoph Läubrich - changes for ne processor api and process optimizations
 * Philip Wenig - refactoring
 *******************************************************************************/
package org.eclipse.chemclipse.nmr.processing.ft;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.transform.DftNormalization;
import org.apache.commons.math3.transform.FastFourierTransformer;
import org.apache.commons.math3.transform.TransformType;
import org.eclipse.chemclipse.model.core.FilteredMeasurement;
import org.eclipse.chemclipse.model.core.IMeasurement;
import org.eclipse.chemclipse.model.filter.IMeasurementFilter;
import org.eclipse.chemclipse.nmr.model.core.AcquisitionParameter;
import org.eclipse.chemclipse.nmr.model.core.IMeasurementFID;
import org.eclipse.chemclipse.nmr.model.core.ISignalFID;
import org.eclipse.chemclipse.nmr.model.core.ISpectrumMeasurement;
import org.eclipse.chemclipse.nmr.model.core.ISpectrumSignal;
import org.eclipse.chemclipse.nmr.processing.supplier.base.core.AbstractFIDSignalFilter;
import org.eclipse.chemclipse.nmr.processing.supplier.base.core.UtilityFunctions;
import org.eclipse.chemclipse.nmr.processing.supplier.base.core.UtilityFunctions.ComplexFIDData;
import org.eclipse.chemclipse.nmr.processing.supplier.base.core.ZeroFillingProcessor;
import org.eclipse.chemclipse.nmr.processing.supplier.base.settings.FourierTransformationSettings;
import org.eclipse.chemclipse.nmr.processing.supplier.base.settings.support.ZeroFillingFactor;
import org.eclipse.chemclipse.processing.core.IMessageConsumer;
import org.eclipse.chemclipse.processing.filter.Filter;
import org.eclipse.chemclipse.processing.filter.FilterContext;
import org.eclipse.core.runtime.IProgressMonitor;
import org.osgi.service.component.annotations.Component;

@Component(service = {Filter.class, IMeasurementFilter.class})
public class FourierTransformationProcessor extends AbstractFIDSignalFilter<FourierTransformationSettings> {

	private static final long serialVersionUID = 4689862977089790920L;
	private static final String NAME = "Fourier Transformation";

	public FourierTransformationProcessor() {

		super(FourierTransformationSettings.class);
	}

	@Override
	protected IMeasurement doFiltering(FilterContext<IMeasurementFID, FourierTransformationSettings> context, IMessageConsumer messageConsumer, IProgressMonitor monitor) {

		IMeasurementFID measurement = context.getFilteredObject();
		List<? extends ISignalFID> signals = measurement.getSignals();
		// check if length of data is OK; warn if zero filling has to be applied
		if(!UtilityFunctions.lengthIsPowerOfTwo(signals)) {
			int fillLength = ZeroFillingProcessor.getZeroFillLength(signals.size(), ZeroFillingFactor.AUTO);
			messageConsumer.addErrorMessage(getName(), "Your data must be Zerofilled first (minimum fill length = " + fillLength + ")");
			return null;
		}
		ComplexFIDData fidData = UtilityFunctions.toComplexFIDData(signals);
		Complex[] nmrSpectrumProcessed = fourierTransformNmrData(fidData.signals);
		BigDecimal offset = measurement.getAcquisitionParameter().getSpectralOffset();
		BigDecimal width = measurement.getAcquisitionParameter().getSpectralWidth();
		BigDecimal step = width.divide(BigDecimal.valueOf(nmrSpectrumProcessed.length - 1).setScale(10), RoundingMode.HALF_UP);
		// center the data around the spectral frequency
		UtilityFunctions.leftShiftNMRComplexData(nmrSpectrumProcessed, nmrSpectrumProcessed.length / 2);
		List<FFTSpectrumSignal> newSignals = new ArrayList<>();
		for(int i = 0; i < nmrSpectrumProcessed.length; i++) {
			// api requires from high to low, so start with highest order
			int reversed_index = nmrSpectrumProcessed.length - 1 - i;
			BigDecimal shift = step.multiply(BigDecimal.valueOf(reversed_index)).add(offset);
			newSignals.add(new FFTSpectrumSignal(shift, nmrSpectrumProcessed[reversed_index]));
		}
		return new FFTFilteredMeasurement(context, newSignals);
	}

	@Override
	public String getName() {

		return NAME;
	}

	private static Complex[] fourierTransformNmrData(Complex[] fid) {

		FastFourierTransformer fFourierTransformer = new FastFourierTransformer(DftNormalization.STANDARD);
		Complex[] nmrSpectrum = fFourierTransformer.transform(fid, TransformType.FORWARD);
		return nmrSpectrum;
	}

	private static final class FFTFilteredMeasurement extends FilteredMeasurement<IMeasurementFID, FourierTransformationSettings> implements ISpectrumMeasurement {

		private static final long serialVersionUID = -3570180428815391262L;
		private List<? extends ISpectrumSignal> signals;

		public FFTFilteredMeasurement(FilterContext<IMeasurementFID, FourierTransformationSettings> filterContext, List<FFTSpectrumSignal> signals) {

			super(filterContext);
			this.signals = Collections.unmodifiableList(signals);
		}

		@Override
		public List<? extends ISpectrumSignal> getSignals() {

			return signals;
		}

		@Override
		public AcquisitionParameter getAcquisitionParameter() {

			return getFilteredObject().getAcquisitionParameter();
		}
	}

	private static final class FFTSpectrumSignal implements ISpectrumSignal, Serializable {

		private static final long serialVersionUID = 343539516695828431L;
		private BigDecimal shift;
		private Complex complex;

		public FFTSpectrumSignal(BigDecimal shift, Complex complex) {

			this.shift = shift;
			this.complex = complex;
		}

		@Override
		public BigDecimal getFrequency() {

			return shift;
		}

		@Override
		public Number getAbsorptiveIntensity() {

			return complex.getReal();
		}

		@Override
		public Number getDispersiveIntensity() {

			return complex.getImaginary();
		}
	}
}
