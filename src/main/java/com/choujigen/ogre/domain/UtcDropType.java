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
@Table(name = "utc_drop_type")
public class UtcDropType {
	@Column(name = "utc_drop_type_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long utcDropTypeId;
	@Column(name = "utc_drop_type_name_ja")
	private String utcDropTypeNameJa;
	@Column(name = "utc_drop_type_name_en")
	private String utcDropTypeNameEn;
	@Column(name = "utc_drop_type_name_es")
	private String utcDropTypeNameEs;

	public UtcDropType() {
	}

	public UtcDropType(Long utcDropTypeId, String utcDropTypeNameJa, String utcDropTypeNameEn,
			String utcDropTypeNameEs) {
		super();
		this.utcDropTypeId = utcDropTypeId;
		this.utcDropTypeNameJa = utcDropTypeNameJa;
		this.utcDropTypeNameEn = utcDropTypeNameEn;
		this.utcDropTypeNameEs = utcDropTypeNameEs;
	}
	
	public String getNameByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			return this.utcDropTypeNameJa;
		case "en":
			return this.utcDropTypeNameEn;
		case "es":
			return this.utcDropTypeNameEs;
		default:
			return this.utcDropTypeNameEn;
		}
	}

	public Long getUtcDropTypeId() {
		return utcDropTypeId;
	}

	public void setUtcDropTypeId(Long utcDropTypeId) {
		this.utcDropTypeId = utcDropTypeId;
	}

	public String getUtcDropTypeNameJa() {
		return utcDropTypeNameJa;
	}

	public void setUtcDropTypeNameJa(String utcDropTypeNameJa) {
		this.utcDropTypeNameJa = utcDropTypeNameJa;
	}

	public String getUtcDropTypeNameEn() {
		return utcDropTypeNameEn;
	}

	public void setUtcDropTypeNameEn(String utcDropTypeNameEn) {
		this.utcDropTypeNameEn = utcDropTypeNameEn;
	}

	public String getUtcDropTypeNameEs() {
		return utcDropTypeNameEs;
	}

	public void setUtcDropTypeNameEs(String utcDropTypeNameEs) {
		this.utcDropTypeNameEs = utcDropTypeNameEs;
	}

	@Override
	public int hashCode() {
		return Objects.hash(utcDropTypeId, utcDropTypeNameEn, utcDropTypeNameEs, utcDropTypeNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UtcDropType other = (UtcDropType) obj;
		return Objects.equals(utcDropTypeId, other.utcDropTypeId)
				&& Objects.equals(utcDropTypeNameEn, other.utcDropTypeNameEn)
				&& Objects.equals(utcDropTypeNameEs, other.utcDropTypeNameEs)
				&& Objects.equals(utcDropTypeNameJa, other.utcDropTypeNameJa);
	}

	@Override
	public String toString() {
		return "UtcDropType [utcDropTypeId=" + utcDropTypeId + ", utcDropTypeNameJa=" + utcDropTypeNameJa
				+ ", utcDropTypeNameEn=" + utcDropTypeNameEn + ", utcDropTypeNameEs=" + utcDropTypeNameEs + "]";
	}
}
