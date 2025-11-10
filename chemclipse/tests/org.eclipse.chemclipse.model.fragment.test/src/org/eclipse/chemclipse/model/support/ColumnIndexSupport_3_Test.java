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
package org.eclipse.chemclipse.model.support;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.model.columns.ISeparationColumn;
import org.eclipse.chemclipse.model.columns.SeparationColumn;
import org.eclipse.chemclipse.model.identifier.ColumnIndexMarker;
import org.eclipse.chemclipse.model.identifier.IColumnIndexMarker;
import org.eclipse.chemclipse.support.model.SeparationColumnType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class ColumnIndexSupport_3_Test {

	private static final ISeparationColumn DB1_NON_POLAR = new SeparationColumn("DB1", SeparationColumnType.NON_POLAR);
	private static final ISeparationColumn DB5_NON_POLAR = new SeparationColumn("DB5", SeparationColumnType.NON_POLAR);
	private static final ISeparationColumn HP5_NON_POLAR = new SeparationColumn("HP5", SeparationColumnType.NON_POLAR);
	private static final ISeparationColumn DB1701_SEMI_POLAR = new SeparationColumn("DB1701", SeparationColumnType.SEMI_POLAR);
	private static final ISeparationColumn FFAP_POLAR = new SeparationColumn("FFAP", SeparationColumnType.POLAR);
	private static final ISeparationColumn CARBOWAX_POLAR = new SeparationColumn("CARBOWAX", SeparationColumnType.POLAR);

	private List<IColumnIndexMarker> columnIndexMarkers = new ArrayList<>();

	@BeforeAll
	public void setUp() {

		columnIndexMarkers.add(new ColumnIndexMarker(DB1_NON_POLAR, 1720));
		columnIndexMarkers.add(new ColumnIndexMarker(DB5_NON_POLAR, 1725));
		columnIndexMarkers.add(new ColumnIndexMarker(HP5_NON_POLAR, 1726));
		columnIndexMarkers.add(new ColumnIndexMarker(DB1701_SEMI_POLAR, 921));
		columnIndexMarkers.add(new ColumnIndexMarker(FFAP_POLAR, 1378));
		columnIndexMarkers.add(new ColumnIndexMarker(CARBOWAX_POLAR, 1389));
	}

	@Test
	public void test1() {

		boolean caseSensitive = true;
		boolean removeWhiteSpace = false;
		boolean matchPartly = false;
		SeparationColumnType fallbackType = SeparationColumnType.NON_POLAR;

		List<IColumnIndexMarker> columnIndexMarkerFiltered = ColumnIndexSupport.getColumnIndexMarker(columnIndexMarkers, "DB1", caseSensitive, removeWhiteSpace, matchPartly, fallbackType);
		assertEquals(1, columnIndexMarkerFiltered.size());
		assertEquals("DB1", columnIndexMarkerFiltered.get(0).getSeparationColumn().getName());
	}

	@Test
	public void test2() {

		boolean caseSensitive = true;
		boolean removeWhiteSpace = false;
		boolean matchPartly = true;
		SeparationColumnType fallbackType = SeparationColumnType.NON_POLAR;

		List<IColumnIndexMarker> columnIndexMarkerFiltered = ColumnIndexSupport.getColumnIndexMarker(columnIndexMarkers, "DB1", caseSensitive, removeWhiteSpace, matchPartly, fallbackType);
		assertEquals(2, columnIndexMarkerFiltered.size());
		assertEquals("DB1", columnIndexMarkerFiltered.get(0).getSeparationColumn().getName());
		assertEquals("DB1701", columnIndexMarkerFiltered.get(1).getSeparationColumn().getName());
	}

	@Test
	public void test3() {

		boolean caseSensitive = true;
		boolean removeWhiteSpace = false;
		boolean matchPartly = true;
		SeparationColumnType fallbackType = SeparationColumnType.DEFAULT;

		List<IColumnIndexMarker> columnIndexMarkerFiltered = ColumnIndexSupport.getColumnIndexMarker(columnIndexMarkers, "DBX", caseSensitive, removeWhiteSpace, matchPartly, fallbackType);
		assertEquals(0, columnIndexMarkerFiltered.size());
	}

	@Test
	public void test4() {

		boolean caseSensitive = true;
		boolean removeWhiteSpace = false;
		boolean matchPartly = true;
		SeparationColumnType fallbackType = SeparationColumnType.NON_POLAR;

		List<IColumnIndexMarker> columnIndexMarkerFiltered = ColumnIndexSupport.getColumnIndexMarker(columnIndexMarkers, "DBX", caseSensitive, removeWhiteSpace, matchPartly, fallbackType);
		assertEquals(3, columnIndexMarkerFiltered.size());
		assertEquals("DB1", columnIndexMarkerFiltered.get(0).getSeparationColumn().getName());
		assertEquals("DB5", columnIndexMarkerFiltered.get(1).getSeparationColumn().getName());
		assertEquals("HP5", columnIndexMarkerFiltered.get(2).getSeparationColumn().getName());
	}

	@Test
	public void test5() {

		boolean caseSensitive = true;
		boolean removeWhiteSpace = false;
		boolean matchPartly = true;
		SeparationColumnType fallbackType = SeparationColumnType.DEFAULT;

		List<IColumnIndexMarker> columnIndexMarkerFiltered = ColumnIndexSupport.getColumnIndexMarker(columnIndexMarkers, "1701", caseSensitive, removeWhiteSpace, matchPartly, fallbackType);
		assertEquals(1, columnIndexMarkerFiltered.size());
		assertEquals("DB1701", columnIndexMarkerFiltered.get(0).getSeparationColumn().getName());
	}

	@Test
	public void test6() {

		boolean caseSensitive = true;
		boolean removeWhiteSpace = false;
		boolean matchPartly = false;
		SeparationColumnType fallbackType = SeparationColumnType.SEMI_POLAR;

		List<IColumnIndexMarker> columnIndexMarkerFiltered = ColumnIndexSupport.getColumnIndexMarker(columnIndexMarkers, "1701", caseSensitive, removeWhiteSpace, matchPartly, fallbackType);
		assertEquals(1, columnIndexMarkerFiltered.size());
		assertEquals("DB1701", columnIndexMarkerFiltered.get(0).getSeparationColumn().getName());
	}

	@Test
	public void test7() {

		boolean caseSensitive = true;
		boolean removeWhiteSpace = false;
		boolean matchPartly = false;
		SeparationColumnType fallbackType = SeparationColumnType.DEFAULT;

		List<IColumnIndexMarker> columnIndexMarkerFiltered = ColumnIndexSupport.getColumnIndexMarker(columnIndexMarkers, "", caseSensitive, removeWhiteSpace, matchPartly, fallbackType);
		assertEquals(0, columnIndexMarkerFiltered.size());
	}

	@Test
	public void test8() {

		boolean caseSensitive = true;
		boolean removeWhiteSpace = false;
		boolean matchPartly = false;
		SeparationColumnType fallbackType = SeparationColumnType.POLAR;

		List<IColumnIndexMarker> columnIndexMarkerFiltered = ColumnIndexSupport.getColumnIndexMarker(columnIndexMarkers, "", caseSensitive, removeWhiteSpace, matchPartly, fallbackType);
		assertEquals(2, columnIndexMarkerFiltered.size());
		assertEquals("FFAP", columnIndexMarkerFiltered.get(0).getSeparationColumn().getName());
		assertEquals("CARBOWAX", columnIndexMarkerFiltered.get(1).getSeparationColumn().getName());
	}

	@Test
	public void test9() {

		boolean caseSensitive = true;
		boolean removeWhiteSpace = false;
		boolean matchPartly = false;
		SeparationColumnType fallbackType = SeparationColumnType.POLAR;

		List<IColumnIndexMarker> columnIndexMarkerFiltered = ColumnIndexSupport.getColumnIndexMarker(columnIndexMarkers, "FFAP", caseSensitive, removeWhiteSpace, matchPartly, fallbackType);
		assertEquals(1, columnIndexMarkerFiltered.size());
		assertEquals("FFAP", columnIndexMarkerFiltered.get(0).getSeparationColumn().getName());
	}
}