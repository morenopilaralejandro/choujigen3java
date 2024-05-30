package com.choujigen.ogre.domain;

import java.util.Locale;
import java.util.Objects;

import org.springframework.context.i18n.LocaleContextHolder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "zone")
@Inheritance(strategy = InheritanceType.JOINED)
public class Zone {
	@Column(name = "zone_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long zoneId;

	@Column(name = "zone_name_ja")
	private String zoneNameJa;

	@Column(name = "zone_name_en")
	private String zoneNameEn;

	@Column(name = "zone_name_es")
	private String zoneNameEs;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "zone_type_id", referencedColumnName = "zone_type_id")
	private ZoneType zoneType;

	public Zone() {
	}

	public Zone(Long zoneId, String zoneNameJa, String zoneNameEn, String zoneNameEs, ZoneType zoneType) {
		super();
		this.zoneId = zoneId;
		this.zoneNameJa = zoneNameJa;
		this.zoneNameEn = zoneNameEn;
		this.zoneNameEs = zoneNameEs;
		this.zoneType = zoneType;
	}
	
	/*Override*/
	public String getDisplayName() {
		String res = "";
		ZoneOuter auxOuter;
		ZoneInner auxInner;
		ZoneLevel auxLevel;
		ZoneBuilding auxBuilding;
		ZoneBuildingFloor auxBuildingFloor;
		
		switch (this.zoneType.getZoneTypeId().intValue()) {
		case 1:
			auxOuter = (ZoneOuter) this;
			res = auxOuter.getDisplayName();
			break;
		case 2:
			auxInner = (ZoneInner) this;
			res = auxInner.getDisplayName();
			break;
		case 3:
			auxLevel = (ZoneLevel) this;
			res = auxLevel.getDisplayName();
			break;
		case 4:
			auxBuilding = (ZoneBuilding) this;
			res = auxBuilding.getDisplayName();
			break;
		case 5:
			auxBuildingFloor = (ZoneBuildingFloor) this;
			res = auxBuildingFloor.getDisplayName();
			break;
		}
		return res;
	}
	
	public String getHref() {
		String res = "/map/";
		ZoneOuter auxOuter;
		ZoneInner auxInner;
		ZoneLevel auxLevel;
		ZoneBuilding auxBuilding;
		ZoneBuildingFloor auxBuildingFloor;
		
		switch (this.zoneType.getZoneTypeId().intValue()) {
		case 1:
			auxOuter = (ZoneOuter) this;
			res += auxOuter.getOuterId();
			res += "#zone";
			res += auxOuter.getZoneId();
			break;
		case 2:
			auxInner = (ZoneInner) this;
			res += auxInner.getOuterId();
			res += "#zone";
			res += auxInner.getZoneId();
			break;
		case 3:
			auxLevel = (ZoneLevel) this;
			res += auxLevel.getOuterId();
			res += "#zone";
			res += auxLevel.getZoneId();
			break;
		case 4:
			auxBuilding = (ZoneBuilding) this;
			res += auxBuilding.getOuterId();
			res += "#zone";
			res += auxBuilding.getZoneId();
			break;
		case 5:
			auxBuildingFloor = (ZoneBuildingFloor) this;
			res += auxBuildingFloor.getOuterId();
			res += "#zone";
			res += auxBuildingFloor.getZoneId();
			break;
		}
		return res;
	}

	public String getNameByLang() {
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

	public Long getZoneId() {
		return zoneId;
	}

	public void setZoneId(Long zoneId) {
		this.zoneId = zoneId;
	}

	public String getZoneNameJa() {
		return zoneNameJa;
	}

	public void setZoneNameJa(String zoneNameJa) {
		this.zoneNameJa = zoneNameJa;
	}

	public String getZoneNameEn() {
		return zoneNameEn;
	}

	public void setZoneNameEn(String zoneNameEn) {
		this.zoneNameEn = zoneNameEn;
	}

	public String getZoneNameEs() {
		return zoneNameEs;
	}

	public void setZoneNameEs(String zoneNameEs) {
		this.zoneNameEs = zoneNameEs;
	}

	public ZoneType getZoneType() {
		return zoneType;
	}

	public void setZoneType(ZoneType zoneType) {
		this.zoneType = zoneType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(zoneId, zoneNameEn, zoneNameEs, zoneNameJa, zoneType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Zone other = (Zone) obj;
		return Objects.equals(zoneId, other.zoneId) && Objects.equals(zoneNameEn, other.zoneNameEn)
				&& Objects.equals(zoneNameEs, other.zoneNameEs) && Objects.equals(zoneNameJa, other.zoneNameJa)
				&& Objects.equals(zoneType, other.zoneType);
	}

	@Override
	public String toString() {
		return "Zone [zoneId=" + zoneId + ", zoneNameJa=" + zoneNameJa + ", zoneNameEn=" + zoneNameEn + ", zoneNameEs="
				+ zoneNameEs + ", zoneType=" + zoneType + "]";
	}

}
