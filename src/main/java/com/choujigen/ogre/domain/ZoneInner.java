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
@Table(name = "zone_inner")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "zone_inner_id")
public class ZoneInner extends Zone {
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "zone_outer_id", referencedColumnName = "zone_outer_id")
	private ZoneOuter zoneOuter;
	
	@OneToMany(mappedBy = "zoneInner", fetch = FetchType.EAGER)
	private List<ZoneLevel> ZoneLevels;

	public ZoneInner() {
	}

	public ZoneInner(Long zoneId, String zoneNameJa, String zoneNameEn, String zoneNameEs, ZoneType zoneType,
			ZoneOuter zoneOuter) {
		super(zoneId, zoneNameJa, zoneNameEn, zoneNameEs, zoneType);
		this.zoneOuter = zoneOuter;
	}
	
	@Override
	public String getDisplayName() {
		String res = "";
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			res += this.getZoneNameJa();
			res += ", ";
			res += this.getZoneOuter().getZoneNameJa();
			break;
		case "en":
			res += this.getZoneNameEn();
			res += ", ";
			res += this.getZoneOuter().getZoneNameEn();
			break;
		case "es":
			res += this.getZoneNameEs();
			res += ", ";
			res += this.getZoneOuter().getZoneNameEs();
			break;
		default:
			res += this.getZoneNameEn();
			res += ", ";
			res += this.getZoneOuter().getZoneNameEn();
			break;
		}
		return res;
	}
	
	@Override
	public Long getOuterId() {
		return this.getZoneOuter().getZoneId();
	}

	public ZoneOuter getZoneOuter() {
		return zoneOuter;
	}

	public void setZoneOuter(ZoneOuter zoneOuter) {
		this.zoneOuter = zoneOuter;
	}

	public List<ZoneLevel> getZoneLevels() {
		return ZoneLevels;
	}

	public void setZoneLevels(List<ZoneLevel> zoneLevels) {
		ZoneLevels = zoneLevels;
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
