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
@Table(name = "catch_type")
public class CatchType {
	@Column(name = "catch_type_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long catchTypeId;
	@Column(name = "catch_type_name_ja")
	private String catchTypeNameJa;
	@Column(name = "catch_type_name_en")
	private String catchTypeNameEn;
	@Column(name = "catch_type_name_es")
	private String catchTypeNameEs;

	public CatchType() {
	}

	public CatchType(Long catchTypeId, String catchTypeNameJa, String catchTypeNameEn, String catchTypeNameEs) {
		super();
		this.catchTypeId = catchTypeId;
		this.catchTypeNameJa = catchTypeNameJa;
		this.catchTypeNameEn = catchTypeNameEn;
		this.catchTypeNameEs = catchTypeNameEs;
	}

	public Long getCatchTypeId() {
		return catchTypeId;
	}

	public void setCatchTypeId(Long catchTypeId) {
		this.catchTypeId = catchTypeId;
	}

	public String getCatchTypeNameJa() {
		return catchTypeNameJa;
	}

	public void setCatchTypeNameJa(String catchTypeNameJa) {
		this.catchTypeNameJa = catchTypeNameJa;
	}

	public String getCatchTypeNameEn() {
		return catchTypeNameEn;
	}

	public void setCatchTypeNameEn(String catchTypeNameEn) {
		this.catchTypeNameEn = catchTypeNameEn;
	}

	public String getCatchTypeNameEs() {
		return catchTypeNameEs;
	}

	public void setCatchTypeNameEs(String catchTypeNameEs) {
		this.catchTypeNameEs = catchTypeNameEs;
	}

	public String getNameByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			return this.getCatchTypeNameJa();
		case "en":
			return this.getCatchTypeNameEn();
		case "es":
			return this.getCatchTypeNameEs();
		default:
			return this.getCatchTypeNameEn();
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(catchTypeId, catchTypeNameEn, catchTypeNameEs, catchTypeNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CatchType other = (CatchType) obj;
		return Objects.equals(catchTypeId, other.catchTypeId) && Objects.equals(catchTypeNameEn, other.catchTypeNameEn)
				&& Objects.equals(catchTypeNameEs, other.catchTypeNameEs)
				&& Objects.equals(catchTypeNameJa, other.catchTypeNameJa);
	}

	@Override
	public String toString() {
		return "CatchType [catchTypeId=" + catchTypeId + ", catchTypeNameJa=" + catchTypeNameJa + ", catchTypeNameEn="
				+ catchTypeNameEn + ", catchTypeNameEs=" + catchTypeNameEs + "]";
	}
}
