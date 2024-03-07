package com.choujigen.ogre.domain;

import java.util.Locale;
import java.util.Objects;

import org.springframework.context.i18n.LocaleContextHolder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

	@ManyToOne
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
