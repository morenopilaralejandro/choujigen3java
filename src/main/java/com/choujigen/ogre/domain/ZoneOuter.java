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
@Table(name = "zone_outer")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "zone_outer_id")
public class ZoneOuter extends Zone {
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "region_id", referencedColumnName = "region_id")
	private Region region;
	
	@OneToMany(mappedBy = "zoneOuter", fetch = FetchType.EAGER)
	private List<ZoneInner> zoneInners;

	public ZoneOuter() {
	}

	public ZoneOuter(Long zoneId, String zoneNameJa, String zoneNameEn, String zoneNameEs, ZoneType zoneType,
			Region region) {
		super(zoneId, zoneNameJa, zoneNameEn, zoneNameEs, zoneType);
		this.region = region;
	}
	
	@Override
	public String getDisplayName() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			return this.getZoneNameJa();
		case "en":
			return this.getZoneNameEn();
		case "es":
			return this.getZoneNameEs();
		default:
			return this.getZoneNameEn();
		}
	}
	
	@Override
	public Long getOuterId() {
		return this.getZoneId();
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
	
	public List<ZoneInner> getZoneInners() {
		return zoneInners;
	}

	public void setZoneInners(List<ZoneInner> zoneInners) {
		this.zoneInners = zoneInners;
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
