package com.choujigen.ogre.domain;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "zone_level")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "zone_level_id")
public class ZoneLevel extends Zone {
	@ManyToOne
	@JoinColumn(name = "zone_inner_id", referencedColumnName = "zone_inner_id")
	private ZoneInner zoneInner;

	public ZoneLevel() {
	}

	public ZoneLevel(Long zoneId, String zoneNameJa, String zoneNameEn, String zoneNameEs, ZoneType zoneType,
			ZoneInner zoneInner) {
		super(zoneId, zoneNameJa, zoneNameEn, zoneNameEs, zoneType);
		this.zoneInner = zoneInner;
	}

	public ZoneInner getZoneInner() {
		return zoneInner;
	}

	public void setZoneInner(ZoneInner zoneInner) {
		this.zoneInner = zoneInner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(zoneInner);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ZoneLevel other = (ZoneLevel) obj;
		return Objects.equals(zoneInner, other.zoneInner);
	}

	@Override
	public String toString() {
		return "ZoneLevel [zoneInner=" + zoneInner + "]";
	}

}
