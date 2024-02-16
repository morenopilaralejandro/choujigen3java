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
@Table(name = "hissatsu_type")
public class HissatsuType {
	@Column(name = "hissatsu_type_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long hissatsuTypeId;
	@Column(name = "hissatsu_type_name_ja")
	private String hissatsuTypeNameJa;
	@Column(name = "hissatsu_type_name_en")
	private String hissatsuTypeNameEn;
	@Column(name = "hissatsu_type_name_es")
	private String hissatsuTypeNameEs;

	public HissatsuType() {
	}

	public HissatsuType(Long hissatsuTypeId, String hissatsuTypeNameJa, String hissatsuTypeNameEn,
			String hissatsuTypeNameEs) {
		super();
		this.hissatsuTypeId = hissatsuTypeId;
		this.hissatsuTypeNameJa = hissatsuTypeNameJa;
		this.hissatsuTypeNameEn = hissatsuTypeNameEn;
		this.hissatsuTypeNameEs = hissatsuTypeNameEs;
	}

	public Long getHissatsuTypeId() {
		return hissatsuTypeId;
	}

	public void setHissatsuTypeId(Long hissatsuTypeId) {
		this.hissatsuTypeId = hissatsuTypeId;
	}

	public String getHissatsuTypeNameJa() {
		return hissatsuTypeNameJa;
	}

	public void setHissatsuTypeNameJa(String hissatsuTypeNameJa) {
		this.hissatsuTypeNameJa = hissatsuTypeNameJa;
	}

	public String getHissatsuTypeNameEn() {
		return hissatsuTypeNameEn;
	}

	public void setHissatsuTypeNameEn(String hissatsuTypeNameEn) {
		this.hissatsuTypeNameEn = hissatsuTypeNameEn;
	}

	public String getHissatsuTypeNameEs() {
		return hissatsuTypeNameEs;
	}

	public void setHissatsuTypeNameEs(String hissatsuTypeNameEs) {
		this.hissatsuTypeNameEs = hissatsuTypeNameEs;
	}

	public String getNameByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			return this.getHissatsuTypeNameJa();
		case "en":
			return this.getHissatsuTypeNameEn();
		case "es":
			return this.getHissatsuTypeNameEs();
		default:
			return this.getHissatsuTypeNameEn();
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(hissatsuTypeId, hissatsuTypeNameEn, hissatsuTypeNameEs, hissatsuTypeNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HissatsuType other = (HissatsuType) obj;
		return Objects.equals(hissatsuTypeId, other.hissatsuTypeId)
				&& Objects.equals(hissatsuTypeNameEn, other.hissatsuTypeNameEn)
				&& Objects.equals(hissatsuTypeNameEs, other.hissatsuTypeNameEs)
				&& Objects.equals(hissatsuTypeNameJa, other.hissatsuTypeNameJa);
	}

	@Override
	public String toString() {
		return "HissatsuType [hissatsuTypeId=" + hissatsuTypeId + ", hissatsuTypeNameJa=" + hissatsuTypeNameJa
				+ ", hissatsuTypeNameEn=" + hissatsuTypeNameEn + ", hissatsuTypeNameEs=" + hissatsuTypeNameEs + "]";
	}
}
