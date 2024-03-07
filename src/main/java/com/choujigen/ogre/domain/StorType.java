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
@Table(name = "stor_type")
public class StorType {
	@Column(name = "stor_type_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long storTypeId;
	@Column(name = "stor_type_name_ja")
	private String storTypeNameJa;
	@Column(name = "stor_type_name_en")
	private String storTypeNameEn;
	@Column(name = "stor_type_name_es")
	private String storTypeNameEs;

	public StorType() {
	}

	public StorType(Long storTypeId, String storTypeNameJa, String storTypeNameEn, String storTypeNameEs) {
		super();
		this.storTypeId = storTypeId;
		this.storTypeNameJa = storTypeNameJa;
		this.storTypeNameEn = storTypeNameEn;
		this.storTypeNameEs = storTypeNameEs;
	}
	
	public String getNameByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			return this.getStorTypeNameJa();
		case "en":
			return this.getStorTypeNameEn();
		case "es":
			return this.getStorTypeNameEs();
		default:
			return this.getStorTypeNameEn();
		}
	}

	public Long getStorTypeId() {
		return storTypeId;
	}

	public void setStorTypeId(Long storTypeId) {
		this.storTypeId = storTypeId;
	}

	public String getStorTypeNameJa() {
		return storTypeNameJa;
	}

	public void setStorTypeNameJa(String storTypeNameJa) {
		this.storTypeNameJa = storTypeNameJa;
	}

	public String getStorTypeNameEn() {
		return storTypeNameEn;
	}

	public void setStorTypeNameEn(String storTypeNameEn) {
		this.storTypeNameEn = storTypeNameEn;
	}

	public String getStorTypeNameEs() {
		return storTypeNameEs;
	}

	public void setStorTypeNameEs(String storTypeNameEs) {
		this.storTypeNameEs = storTypeNameEs;
	}

	@Override
	public int hashCode() {
		return Objects.hash(storTypeId, storTypeNameEn, storTypeNameEs, storTypeNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StorType other = (StorType) obj;
		return Objects.equals(storTypeId, other.storTypeId) && Objects.equals(storTypeNameEn, other.storTypeNameEn)
				&& Objects.equals(storTypeNameEs, other.storTypeNameEs)
				&& Objects.equals(storTypeNameJa, other.storTypeNameJa);
	}

	@Override
	public String toString() {
		return "StorType [storTypeId=" + storTypeId + ", storTypeNameJa=" + storTypeNameJa + ", storTypeNameEn="
				+ storTypeNameEn + ", storTypeNameEs=" + storTypeNameEs + "]";
	}
}
