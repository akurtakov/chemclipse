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
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.pcr.model.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Position implements Comparable<Position> {

	private int id = 0;
	private String row = "";
	private int column = 0;
	private Pattern pattern = Pattern.compile("([a-zA-Z]*)(\\d*)");

	public Position() {

		this("", 0);
	}

	public Position(String row, int column) {

		this.row = row;
		this.column = column;
	}

	/*
	 * A1, H12
	 */
	public void setRowAndColumn(String positionAsString) {

		if(positionAsString != null) {
			Matcher matcher = pattern.matcher(positionAsString);
			if(matcher.matches()) {
				row = matcher.group(1).trim();
				column = Integer.parseInt(matcher.group(2).trim());
			}
		}
	}

	public int getId() {

		return id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public String getRow() {

		return row;
	}

	public void setRow(String row) {

		this.row = row;
	}

	public int getColumn() {

		return column;
	}

	public void setColumn(int column) {

		this.column = column;
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + ((row == null) ? 0 : row.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Position other = (Position)obj;
		if(column != other.column)
			return false;
		if(row == null) {
			if(other.row != null)
				return false;
		} else if(!row.equals(other.row))
			return false;
		return true;
	}

	@Override
	public String toString() {

		return row + column;
	}

	@Override
	public int compareTo(Position position) {

		int result = 0;
		if(position != null) {
			result = row.compareTo(position.getRow());
			if(result == 0) {
				result = Integer.compare(column, position.getColumn());
			}
		}
		return result;
	}
}
