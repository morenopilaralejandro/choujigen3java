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
@Table(name = "zone_inner")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "zone_inner_id")
public class ZoneInner extends Zone {
	@ManyToOne
	@JoinColumn(name = "zone_outer_id", referencedColumnName = "zone_outer_id")
	private ZoneOuter zoneOuter;

	public ZoneInner() {
	}

	public ZoneInner(Long zoneId, String zoneNameJa, String zoneNameEn, String zoneNameEs, ZoneType zoneType,
			ZoneOuter zoneOuter) {
		super(zoneId, zoneNameJa, zoneNameEn, zoneNameEs, zoneType);
		this.zoneOuter = zoneOuter;
	}

	public ZoneOuter getZoneOuter() {
		return zoneOuter;
	}

	public void setZoneOuter(ZoneOuter zoneOuter) {
		this.zoneOuter = zoneOuter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(zoneOuter);
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
		ZoneInner other = (ZoneInner) obj;
		return Objects.equals(zoneOuter, other.zoneOuter);
	}

	@Override
	public String toString() {
		return "ZoneInner [zoneOuter=" + zoneOuter + "]";
	}

}
