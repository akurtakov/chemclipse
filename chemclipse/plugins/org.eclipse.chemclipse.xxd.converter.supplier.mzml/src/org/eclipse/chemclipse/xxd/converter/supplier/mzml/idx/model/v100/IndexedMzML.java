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
package org.eclipse.chemclipse.xxd.converter.supplier.mzml.idx.model.v100;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.xxd.converter.supplier.mzml.model.v10.MzMLType;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlIDREF;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"mzML", "indexList", "indexListOffset", "fileChecksum"})
@XmlRootElement(name = "indexedmzML")
public class IndexedMzML {

	@XmlElement(required = true)
	protected MzMLType mzML;

	@XmlElement(required = true)
	protected IndexedMzML.IndexList indexList;

	@XmlElement(required = true, type = Long.class, nillable = true)
	protected Long indexListOffset;

	@XmlElement(required = true)
	protected String fileChecksum;

	public MzMLType getMzML() {

		return mzML;
	}

	public void setMzML(MzMLType value) {

		this.mzML = value;
	}

	public IndexedMzML.IndexList getIndexList() {

		return indexList;
	}

	public void setIndexList(IndexedMzML.IndexList value) {

		this.indexList = value;
	}

	public Long getIndexListOffset() {

		return indexListOffset;
	}

	public void setIndexListOffset(Long value) {

		this.indexListOffset = value;
	}

	public String getFileChecksum() {

		return fileChecksum;
	}

	public void setFileChecksum(String value) {

		this.fileChecksum = value;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = {"index"})
	public static class IndexList {

		@XmlElement(required = true)
		protected List<IndexedMzML.IndexList.Index> index;

		@XmlAttribute(name = "count", required = true)
		@XmlSchemaType(name = "nonNegativeInteger")
		protected BigInteger count;

		public List<IndexedMzML.IndexList.Index> getIndex() {

			if(index == null) {
				index = new ArrayList<>();
			}
			return this.index;
		}

		public BigInteger getCount() {

			return count;
		}

		public void setCount(BigInteger value) {

			this.count = value;
		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = {"offset"})
		public static class Index {

			@XmlElement(required = true)
			protected List<IndexedMzML.IndexList.Index.Offset> offset;

			@XmlAttribute(name = "name", required = true)
			protected String name;

			public List<IndexedMzML.IndexList.Index.Offset> getOffset() {

				if(offset == null) {
					offset = new ArrayList<>();
				}
				return this.offset;
			}

			public String getName() {

				return name;
			}

			public void setName(String value) {

				this.name = value;
			}

			@XmlAccessorType(XmlAccessType.FIELD)
			@XmlType(name = "", propOrder = {"value"})
			public static class Offset {

				@XmlValue
				protected long value;

				@XmlAttribute(name = "idRef", required = true)
				@XmlIDREF
				@XmlSchemaType(name = "IDREF")
				protected Object idRef;

				@XmlAttribute(name = "nativeID", required = true)
				protected String nativeID;

				@XmlAttribute(name = "spotID")
				protected String spotID;

				public long getValue() {

					return value;
				}

				public void setValue(long value) {

					this.value = value;
				}

				public Object getIdRef() {

					return idRef;
				}

				public void setIdRef(Object value) {

					this.idRef = value;
				}

				public String getNativeID() {

					return nativeID;
				}

				public void setNativeID(String value) {

					this.nativeID = value;
				}

				public String getSpotID() {

					return spotID;
				}

				public void setSpotID(String value) {

					this.spotID = value;
				}
			}
		}
	}
}
