package com.choujigen.ogre.domain;

import java.util.Locale;
import java.util.Objects;

import org.springframework.context.i18n.LocaleContextHolder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "region")
public class Region {
	@Column(name = "region_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long regionId;
	@Column(name = "region_name_ja")
	private String regionNameJa;
	@Column(name = "region_name_en")
	private String regionNameEn;
	@Column(name = "region_name_es")
	private String regionNameEs;

	public Region() {
	}

	public Region(Long regionId, String regionNameJa, String regionNameEn, String regionNameEs) {
		super();
		this.regionId = regionId;
		this.regionNameJa = regionNameJa;
		this.regionNameEn = regionNameEn;
		this.regionNameEs = regionNameEs;
	}
	
	public String getNameByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			return this.getRegionNameJa();
		case "en":
			return this.getRegionNameEn();
		case "es":
			return this.getRegionNameEs();
		default:
			return this.getRegionNameEn();
		}
	}

	public Long getRegionId() {
		return regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	public String getRegionNameJa() {
		return regionNameJa;
	}

	public void setRegionNameJa(String regionNameJa) {
		this.regionNameJa = regionNameJa;
	}

	public String getRegionNameEn() {
		return regionNameEn;
	}

	public void setRegionNameEn(String regionNameEn) {
		this.regionNameEn = regionNameEn;
	}

	public String getRegionNameEs() {
		return regionNameEs;
	}

	public void setRegionNameEs(String regionNameEs) {
		this.regionNameEs = regionNameEs;
	}

	@Override
	public int hashCode() {
		return Objects.hash(regionId, regionNameEn, regionNameEs, regionNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Region other = (Region) obj;
		return Objects.equals(regionId, other.regionId) && Objects.equals(regionNameEn, other.regionNameEn)
				&& Objects.equals(regionNameEs, other.regionNameEs)
				&& Objects.equals(regionNameJa, other.regionNameJa);
	}

	@Override
	public String toString() {
		return "Region [regionId=" + regionId + ", regionNameJa=" + regionNameJa + ", regionNameEn="
				+ regionNameEn + ", regionNameEs=" + regionNameEs + "]";
	}
}
