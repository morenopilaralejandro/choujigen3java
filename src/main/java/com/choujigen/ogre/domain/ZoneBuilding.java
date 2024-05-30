package com.choujigen.ogre.domain;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

import org.springframework.context.i18n.LocaleContextHolder;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "zone_building")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "zone_building_id")
public class ZoneBuilding extends Zone {
	@ManyToOne
	@JoinColumn(name = "zone_level_id", referencedColumnName = "zone_level_id")
	private ZoneLevel zoneLevel;
	
	@OneToMany(mappedBy = "zoneBuilding", fetch = FetchType.EAGER)
	private List<ZoneBuildingFloor> ZoneBuildingFloors;

	public ZoneBuilding() {
	}

	public ZoneBuilding(Long zoneId, String zoneNameJa, String zoneNameEn, String zoneNameEs, ZoneType zoneType,
			ZoneLevel zoneLevel) {
		super(zoneId, zoneNameJa, zoneNameEn, zoneNameEs, zoneType);
		this.zoneLevel = zoneLevel;
	}
	
	@Override
	public String getDisplayName() {
		String res = "";
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			res += this.getZoneNameJa();
			res += ", ";
			res += this.getZoneLevel().getZoneInner().getZoneOuter().getZoneNameJa();
			break;
		case "en":
			res += this.getZoneNameEn();
			res += ", ";
			res += this.getZoneLevel().getZoneInner().getZoneOuter().getZoneNameEn();	
			break;
		case "es":
			res += this.getZoneNameEs();
			res += ", ";
			res += this.getZoneLevel().getZoneInner().getZoneOuter().getZoneNameEs();
			break;
		default:
			res += this.getZoneNameEn();
			res += ", ";
			res += this.getZoneLevel().getZoneInner().getZoneOuter().getZoneNameEn();
			break;
		}
		return res;
	}
	
	public Long getOuterId() {
		return this.getZoneLevel().getZoneInner().getZoneOuter().getZoneId();
	}

	public ZoneLevel getZoneLevel() {
		return zoneLevel;
	}

	public void setZoneLevel(ZoneLevel zoneLevel) {
		this.zoneLevel = zoneLevel;
	}

	public List<ZoneBuildingFloor> getZoneBuildingFloors() {
		return ZoneBuildingFloors;
	}

	public void setZoneBuildingFloors(List<ZoneBuildingFloor> zoneBuildingFloors) {
		ZoneBuildingFloors = zoneBuildingFloors;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(zoneLevel);
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
		ZoneBuilding other = (ZoneBuilding) obj;
		return Objects.equals(zoneLevel, other.zoneLevel);
	}

	@Override
	public String toString() {
		return "ZoneBuilding [zoneLevel=" + zoneLevel + "]";
	}

}
