/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.msd.comparison.supplier.entropy.comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.model.identifier.IComparisonResult;
import org.eclipse.chemclipse.model.identifier.MatchConstraints;
import org.eclipse.chemclipse.msd.model.core.IIon;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.chemclipse.msd.model.implementation.Ion;
import org.eclipse.chemclipse.msd.model.implementation.ScanMSD;
import org.eclipse.chemclipse.msd.model.xic.ExtractedIonSignal;
import org.eclipse.chemclipse.msd.model.xic.IExtractedIonSignal;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.junit.jupiter.api.Test;

public class EntropyComparator_1_Test {

	private EntropyComparator entropyComparator = new EntropyComparator();

	@Test
	public void test01() {

		List<IIon> ions = new ArrayList<>();
		ions.add(new Ion(18, 1));
		ions.add(new Ion(28, 100));
		ions.add(new Ion(32, 1));
		IExtractedIonSignal extractedIonSignal = new ExtractedIonSignal(ions);
		double spectralEntropy = entropyComparator.getSpectralEntropy(extractedIonSignal, false);
		assertEquals(0.11010002486896941, spectralEntropy, 0.0d);
	}

	@Test
	public void test02() {

		List<IIon> ions = new ArrayList<>();
		ions.add(new Ion(18, 1));
		ions.add(new Ion(28, 100));
		ions.add(new Ion(32, 10));
		IExtractedIonSignal extractedIonSignal = new ExtractedIonSignal(ions);
		double spectralEntropy = entropyComparator.getSpectralEntropy(extractedIonSignal, false);
		assertEquals(0.3532881430864223, spectralEntropy, 0.0d);
	}

	@Test
	public void test03() {

		List<IIon> ions = new ArrayList<>();
		ions.add(new Ion(18, 100));
		ions.add(new Ion(28, 100));
		ions.add(new Ion(32, 100));
		IExtractedIonSignal extractedIonSignal = new ExtractedIonSignal(ions);
		double spectralEntropy = entropyComparator.getSpectralEntropy(extractedIonSignal, false);
		assertEquals(1.0986122916069845, spectralEntropy, 0.0d);
	}

	@Test
	public void test04() {

		IExtractedIonSignal unknown = getUnknown().getExtractedIonSignal();
		double spectralEntropy = entropyComparator.getSpectralEntropy(unknown, false);
		assertEquals(3.3522551987564304, spectralEntropy, 0.0d);
	}

	@Test
	public void test05() {

		IExtractedIonSignal reference = getReference().getExtractedIonSignal();
		double spectralEntropy = entropyComparator.getSpectralEntropy(reference, false);
		assertEquals(3.231818372423294, spectralEntropy, 0.0d);
	}

	@Test
	public void test06() {

		IExtractedIonSignal unknown = getUnknown().getExtractedIonSignal();
		IExtractedIonSignal reference = getReference().getExtractedIonSignal();
		IExtractedIonSignal virtual = entropyComparator.getVirtualSignal(unknown, reference);
		/*
		 * Unit Vector
		 */
		unknown.normalizeVector(1.0f);
		reference.normalizeVector(1.0f);
		virtual.normalizeVector(1.0f);
		/*
		 * Spectral Entropy
		 */
		double spectralEntropyUnkown = entropyComparator.getSpectralEntropy(unknown, true);
		double spectralEntropyReference = entropyComparator.getSpectralEntropy(reference, true);
		double spectralEntropyVirtual = entropyComparator.getSpectralEntropy(virtual, true);
		/*
		 * Match
		 */
		float entropyDistance = entropyComparator.calculateEntropyDistance(spectralEntropyUnkown, spectralEntropyReference, spectralEntropyVirtual);
		assertEquals(0.050477546f, entropyDistance, 0);
	}

	@Test
	public void test07() {

		IExtractedIonSignal unknown = getUnknown().getExtractedIonSignal();
		IExtractedIonSignal reference = getReference().getExtractedIonSignal();
		IExtractedIonSignal virtual = entropyComparator.getVirtualSignal(unknown, reference);
		/*
		 * Unit Vector
		 */
		unknown.normalizeVector(1.0f);
		reference.normalizeVector(1.0f);
		virtual.normalizeVector(1.0f);
		/*
		 * Spectral Entropy
		 */
		double spectralEntropyUnkown = entropyComparator.getSpectralEntropy(unknown, true);
		double spectralEntropyReference = entropyComparator.getSpectralEntropy(reference, true);
		double spectralEntropyVirtual = entropyComparator.getSpectralEntropy(virtual, true);
		/*
		 * Match
		 */
		float matchFactor = entropyComparator.calculateMatchFactor(spectralEntropyUnkown, spectralEntropyReference, spectralEntropyVirtual);
		assertEquals(96.35881805419922f, matchFactor, 0);
	}

	@Test
	public void test08() {

		IScanMSD unknown = getUnknown();
		IScanMSD reference = getReference();
		IProcessingInfo<IComparisonResult> processingInfo = entropyComparator.compare(unknown, reference, new MatchConstraints());
		IComparisonResult comparisonResult = processingInfo.getProcessingResult();
		assertNotNull(comparisonResult);
		assertEquals(96.35881805419922f, comparisonResult.getMatchFactor(), 0);
	}

	private IScanMSD getUnknown() {

		IScanMSD scanMSD = new ScanMSD();
		scanMSD.addIon(new Ion(36, 0.098f));
		scanMSD.addIon(new Ion(37, 2.407f));
		scanMSD.addIon(new Ion(38, 5.703f));
		scanMSD.addIon(new Ion(39, 28.615f));
		scanMSD.addIon(new Ion(40, 4.527f));
		scanMSD.addIon(new Ion(41, 2.473f));
		scanMSD.addIon(new Ion(42, 2.581f));
		scanMSD.addIon(new Ion(43, 0.477f));
		scanMSD.addIon(new Ion(48, 0.016f));
		scanMSD.addIon(new Ion(49, 2.104f));
		scanMSD.addIon(new Ion(50, 9.369f));
		scanMSD.addIon(new Ion(51, 21.222f));
		scanMSD.addIon(new Ion(52, 13.217f));
		scanMSD.addIon(new Ion(53, 17.12f));
		scanMSD.addIon(new Ion(54, 2.777f));
		scanMSD.addIon(new Ion(55, 11.407f));
		scanMSD.addIon(new Ion(56, 0.162f));
		scanMSD.addIon(new Ion(61, 0.743f));
		scanMSD.addIon(new Ion(62, 3.396f));
		scanMSD.addIon(new Ion(63, 4.876f));
		scanMSD.addIon(new Ion(64, 1.478f));
		scanMSD.addIon(new Ion(65, 29.402f));
		scanMSD.addIon(new Ion(66, 5.108f));
		scanMSD.addIon(new Ion(67, 2.775f));
		scanMSD.addIon(new Ion(68, 19.997f));
		scanMSD.addIon(new Ion(69, 1.217f));
		scanMSD.addIon(new Ion(71, 1.57f));
		scanMSD.addIon(new Ion(74, 0.182f));
		scanMSD.addIon(new Ion(75, 0.585f));
		scanMSD.addIon(new Ion(76, 0.931f));
		scanMSD.addIon(new Ion(77, 4.089f));
		scanMSD.addIon(new Ion(78, 1.668f));
		scanMSD.addIon(new Ion(79, 13.527f));
		scanMSD.addIon(new Ion(80, 4.549f));
		scanMSD.addIon(new Ion(81, 12.156f));
		scanMSD.addIon(new Ion(82, 2.879f));
		scanMSD.addIon(new Ion(83, 2.15f));
		scanMSD.addIon(new Ion(85, 0.25f));
		scanMSD.addIon(new Ion(86, 0.116f));
		scanMSD.addIon(new Ion(88, 0.026f));
		scanMSD.addIon(new Ion(90, 0.026f));
		scanMSD.addIon(new Ion(91, 1.524f));
		scanMSD.addIon(new Ion(92, 1.58f));
		scanMSD.addIon(new Ion(93, 29.524f));
		scanMSD.addIon(new Ion(94, 3.72f));
		scanMSD.addIon(new Ion(95, 11.301f));
		scanMSD.addIon(new Ion(96, 40.833f));
		scanMSD.addIon(new Ion(97, 1.978f));
		scanMSD.addIon(new Ion(98, 0.2f));
		scanMSD.addIon(new Ion(99, 0.176f));
		scanMSD.addIon(new Ion(103, 0.348f));
		scanMSD.addIon(new Ion(105, 0.208f));
		scanMSD.addIon(new Ion(106, 0.2f));
		scanMSD.addIon(new Ion(107, 9.495f));
		scanMSD.addIon(new Ion(108, 7.913f));
		scanMSD.addIon(new Ion(109, 5.721f));
		scanMSD.addIon(new Ion(110, 5.492f));
		scanMSD.addIon(new Ion(111, 34.649f));
		scanMSD.addIon(new Ion(112, 1.426f));
		scanMSD.addIon(new Ion(114, 0.308f));
		scanMSD.addIon(new Ion(115, 0.048f));
		scanMSD.addIon(new Ion(116, 0.07f));
		scanMSD.addIon(new Ion(117, 0.252f));
		scanMSD.addIon(new Ion(118, 0.14f));
		scanMSD.addIon(new Ion(119, 0.138f));
		scanMSD.addIon(new Ion(120, 0.581f));
		scanMSD.addIon(new Ion(121, 0.525f));
		scanMSD.addIon(new Ion(123, 2.307f));
		scanMSD.addIon(new Ion(124, 1.74f));
		scanMSD.addIon(new Ion(125, 2.929f));
		scanMSD.addIon(new Ion(127, 0.164f));
		scanMSD.addIon(new Ion(128, 0.168f));
		scanMSD.addIon(new Ion(130, 0.11f));
		scanMSD.addIon(new Ion(133, 0.382f));
		scanMSD.addIon(new Ion(134, 0.356f));
		scanMSD.addIon(new Ion(135, 0.475f));
		scanMSD.addIon(new Ion(136, 0.22f));
		scanMSD.addIon(new Ion(137, 3.76f));
		scanMSD.addIon(new Ion(138, 3.188f));
		scanMSD.addIon(new Ion(139, 54.963f));
		scanMSD.addIon(new Ion(140, 4.337f));
		scanMSD.addIon(new Ion(141, 0.653f));
		scanMSD.addIon(new Ion(142, 0.262f));
		scanMSD.addIon(new Ion(146, 0.134f));
		scanMSD.addIon(new Ion(147, 0.226f));
		scanMSD.addIon(new Ion(152, 0.014f));
		scanMSD.addIon(new Ion(153, 2.116f));
		scanMSD.addIon(new Ion(154, 100f));
		scanMSD.addIon(new Ion(155, 8.988f));
		scanMSD.addIon(new Ion(156, 0.943f));
		scanMSD.addIon(new Ion(165, 0.044f));
		scanMSD.addIon(new Ion(167, 0.23f));
		scanMSD.addIon(new Ion(193, 0.116f));
		scanMSD.addIon(new Ion(221, 0.014f));

		return scanMSD;
	}

	private IScanMSD getReference() {

		IScanMSD scanMSD = new ScanMSD();
		scanMSD.addIon(new Ion(14, 0.2f));
		scanMSD.addIon(new Ion(15, 1.802f));
		scanMSD.addIon(new Ion(25, 0.1f));
		scanMSD.addIon(new Ion(26, 0.601f));
		scanMSD.addIon(new Ion(27, 1.001f));
		scanMSD.addIon(new Ion(28, 0.3f));
		scanMSD.addIon(new Ion(29, 2.402f));
		scanMSD.addIon(new Ion(30, 0.2f));
		scanMSD.addIon(new Ion(31, 0.4f));
		scanMSD.addIon(new Ion(34, 0.1f));
		scanMSD.addIon(new Ion(36, 0.1f));
		scanMSD.addIon(new Ion(37, 1.201f));
		scanMSD.addIon(new Ion(38, 3.003f));
		scanMSD.addIon(new Ion(39, 13.614f));
		scanMSD.addIon(new Ion(40, 2.202f));
		scanMSD.addIon(new Ion(41, 1.401f));
		scanMSD.addIon(new Ion(42, 1.602f));
		scanMSD.addIon(new Ion(43, 1.201f));
		scanMSD.addIon(new Ion(45, 0.1f));
		scanMSD.addIon(new Ion(48, 0.1f));
		scanMSD.addIon(new Ion(49, 0.901f));
		scanMSD.addIon(new Ion(50, 6.006f));
		scanMSD.addIon(new Ion(51, 12.713f));
		scanMSD.addIon(new Ion(52, 8.308f));
		scanMSD.addIon(new Ion(53, 11.011f));
		scanMSD.addIon(new Ion(54, 1.802f));
		scanMSD.addIon(new Ion(55, 8.909f));
		scanMSD.addIon(new Ion(56, 0.501f));
		scanMSD.addIon(new Ion(57, 0.1f));
		scanMSD.addIon(new Ion(59, 0.1f));
		scanMSD.addIon(new Ion(60, 0.1f));
		scanMSD.addIon(new Ion(61, 0.801f));
		scanMSD.addIon(new Ion(62, 1.702f));
		scanMSD.addIon(new Ion(63, 3.203f));
		scanMSD.addIon(new Ion(64, 1.101f));
		scanMSD.addIon(new Ion(65, 20.521f));
		scanMSD.addIon(new Ion(66, 3.003f));
		scanMSD.addIon(new Ion(67, 2.503f));
		scanMSD.addIon(new Ion(68, 13.313f));
		scanMSD.addIon(new Ion(69, 1.802f));
		scanMSD.addIon(new Ion(70, 0.3f));
		scanMSD.addIon(new Ion(71, 1.301f));
		scanMSD.addIon(new Ion(72, 0.1f));
		scanMSD.addIon(new Ion(73, 0.1f));
		scanMSD.addIon(new Ion(74, 0.4f));
		scanMSD.addIon(new Ion(75, 0.2f));
		scanMSD.addIon(new Ion(76, 0.601f));
		scanMSD.addIon(new Ion(77, 2.803f));
		scanMSD.addIon(new Ion(78, 1.001f));
		scanMSD.addIon(new Ion(79, 10.11f));
		scanMSD.addIon(new Ion(80, 3.303f));
		scanMSD.addIon(new Ion(81, 9.109f));
		scanMSD.addIon(new Ion(82, 1.401f));
		scanMSD.addIon(new Ion(83, 1.301f));
		scanMSD.addIon(new Ion(84, 0.1f));
		scanMSD.addIon(new Ion(85, 0.1f));
		scanMSD.addIon(new Ion(90, 0.1f));
		scanMSD.addIon(new Ion(91, 0.701f));
		scanMSD.addIon(new Ion(92, 1.101f));
		scanMSD.addIon(new Ion(93, 29.029f));
		scanMSD.addIon(new Ion(94, 2.603f));
		scanMSD.addIon(new Ion(95, 8.509f));
		scanMSD.addIon(new Ion(96, 33.433f));
		scanMSD.addIon(new Ion(97, 2.202f));
		scanMSD.addIon(new Ion(98, 0.2f));
		scanMSD.addIon(new Ion(105, 0.2f));
		scanMSD.addIon(new Ion(106, 0.501f));
		scanMSD.addIon(new Ion(107, 7.808f));
		scanMSD.addIon(new Ion(108, 6.707f));
		scanMSD.addIon(new Ion(109, 5.506f));
		scanMSD.addIon(new Ion(110, 4.705f));
		scanMSD.addIon(new Ion(111, 34.134f));
		scanMSD.addIon(new Ion(112, 2.302f));
		scanMSD.addIon(new Ion(113, 0.2f));
		scanMSD.addIon(new Ion(120, 0.4f));
		scanMSD.addIon(new Ion(121, 0.3f));
		scanMSD.addIon(new Ion(122, 0.2f));
		scanMSD.addIon(new Ion(123, 0.901f));
		scanMSD.addIon(new Ion(124, 2.002f));
		scanMSD.addIon(new Ion(125, 3.003f));
		scanMSD.addIon(new Ion(126, 0.2f));
		scanMSD.addIon(new Ion(135, 0.2f));
		scanMSD.addIon(new Ion(136, 0.1f));
		scanMSD.addIon(new Ion(137, 2.002f));
		scanMSD.addIon(new Ion(139, 54.054f));
		scanMSD.addIon(new Ion(140, 4.404f));
		scanMSD.addIon(new Ion(141, 0.501f));
		scanMSD.addIon(new Ion(151, 0.2f));
		scanMSD.addIon(new Ion(154, 100f));
		scanMSD.addIon(new Ion(155, 9.409f));
		scanMSD.addIon(new Ion(156, 1.001f));
		scanMSD.addIon(new Ion(157, 0.1f));

		return scanMSD;
	}
}