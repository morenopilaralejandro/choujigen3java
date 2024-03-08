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
@Table(name = "zone_outer")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "zone_outer_id")
public class ZoneOuter extends Zone {
	@ManyToOne
	@JoinColumn(name = "region_id", referencedColumnName = "region_id")
	private Region region;

	public ZoneOuter() {
	}

	public ZoneOuter(Long zoneId, String zoneNameJa, String zoneNameEn, String zoneNameEs, ZoneType zoneType,
			Region region) {
		super(zoneId, zoneNameJa, zoneNameEn, zoneNameEs, zoneType);
		this.region = region;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(region);
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
		ZoneOuter other = (ZoneOuter) obj;
		return Objects.equals(region, other.region);
	}

	@Override
	public String toString() {
		return "ZoneOuter [region=" + region + "]";
	}

}
