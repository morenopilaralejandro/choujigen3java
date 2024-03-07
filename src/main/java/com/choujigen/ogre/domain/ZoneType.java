package com.choujigen.ogre.domain;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "zone_type")
public class ZoneType {
	@Column(name = "zone_type_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long zoneTypeId;
	@Column(name = "zone_type_name")
	private String zoneTypeName;

	public ZoneType() {
	}

	public ZoneType(Long zoneTypeId, String zoneTypeName) {
		super();
		this.zoneTypeId = zoneTypeId;
		this.zoneTypeName = zoneTypeName;
	}

	public Long getZoneTypeId() {
		return zoneTypeId;
	}

	public void setZoneTypeId(Long zoneTypeId) {
		this.zoneTypeId = zoneTypeId;
	}

	public String getZoneTypeName() {
		return zoneTypeName;
	}

	public void setZoneTypeName(String zoneTypeName) {
		this.zoneTypeName = zoneTypeName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(zoneTypeId, zoneTypeName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ZoneType other = (ZoneType) obj;
		return Objects.equals(zoneTypeId, other.zoneTypeId) && Objects.equals(zoneTypeName, other.zoneTypeName);
	}

	@Override
	public String toString() {
		return "ZoneType [zoneTypeId=" + zoneTypeId + ", zoneTypeName=" + zoneTypeName + "]";
	}

}
