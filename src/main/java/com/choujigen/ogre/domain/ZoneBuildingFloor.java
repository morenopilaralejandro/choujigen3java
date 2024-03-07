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
@Table(name = "zone_building_floor")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "zone_building_floor_id")
public class ZoneBuildingFloor extends Zone {
	@ManyToOne
	@JoinColumn(name = "zone_building_id", referencedColumnName = "zone_building_id")
	private ZoneBuilding zoneBuilding;

	public ZoneBuildingFloor() {
	}

	public ZoneBuildingFloor(ZoneBuilding zoneBuilding) {
		super();
		this.zoneBuilding = zoneBuilding;
	}

	public ZoneBuilding getZoneBuilding() {
		return zoneBuilding;
	}

	public void setZoneBuilding(ZoneBuilding zoneBuilding) {
		this.zoneBuilding = zoneBuilding;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(zoneBuilding);
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
		ZoneBuildingFloor other = (ZoneBuildingFloor) obj;
		return Objects.equals(zoneBuilding, other.zoneBuilding);
	}

	@Override
	public String toString() {
		return "ZoneBuildingFloor [zoneBuilding=" + zoneBuilding + "]";
	}

}
