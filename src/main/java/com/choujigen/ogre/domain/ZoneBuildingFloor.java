package com.choujigen.ogre.domain;

import java.util.Locale;
import java.util.Objects;

import org.springframework.context.i18n.LocaleContextHolder;

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

	public ZoneBuildingFloor(Long zoneId, String zoneNameJa, String zoneNameEn, String zoneNameEs, ZoneType zoneType,
			ZoneBuilding zoneBuilding) {
		super(zoneId, zoneNameJa, zoneNameEn, zoneNameEs, zoneType);
		this.zoneBuilding = zoneBuilding;
	}
	
	@Override
	public String getDisplayName() {
		String res = "";
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			res += this.getZoneBuilding().getZoneNameJa();
			if(!this.getZoneNameJa().equals(this.getZoneBuilding().getZoneNameJa())) {
				res += " ";
				res += this.getZoneNameJa();	
			}
			res += ", ";
			res += this.getZoneBuilding().getZoneLevel().getZoneInner().getZoneOuter().getZoneNameJa();
			break;
		case "en":
			res += this.getZoneBuilding().getZoneNameEn();
			if(!this.getZoneNameEn().equals(this.getZoneBuilding().getZoneNameEn())) {
				res += " ";
				res += this.getZoneNameEn();
			}
			res += ", ";
			res += this.getZoneBuilding().getZoneLevel().getZoneInner().getZoneOuter().getZoneNameEn();
			break;
		case "es":
			res += this.getZoneBuilding().getZoneNameEs();
			if(!this.getZoneNameEs().equals(this.getZoneBuilding().getZoneNameEs())) {
				res += " ";
				res += this.getZoneNameEs();
			}
			res += ", ";
			res += this.getZoneBuilding().getZoneLevel().getZoneInner().getZoneOuter().getZoneNameEs();
			break;
		default:
			res += this.getZoneBuilding().getZoneNameEn();
			if(!this.getZoneNameEn().equals(this.getZoneBuilding().getZoneNameEn())) {
				res += " ";
				res += this.getZoneNameEn();
			}
			res += ", ";
			res += this.getZoneBuilding().getZoneLevel().getZoneInner().getZoneOuter().getZoneNameEn();
			break;
		}
		return res;
	}
	
	public Long getOuterId() {
		return this.getZoneBuilding().getZoneLevel().getZoneInner().getZoneOuter().getZoneId();
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
