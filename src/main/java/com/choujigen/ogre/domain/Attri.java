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
@Table(name = "attri")
public class Attri {
	@Column(name = "attri_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long attriId;
	@Column(name = "attri_name_ja")
	private String attriNameJa;
	@Column(name = "attri_name_en")
	private String attriNameEn;
	@Column(name = "attri_name_es")
	private String attriNameEs;

	public Attri() {
	}

	public Attri(Long attriId, String attriNameJa, String attriNameEn, String attriNameEs) {
		super();
		this.attriId = attriId;
		this.attriNameJa = attriNameJa;
		this.attriNameEn = attriNameEn;
		this.attriNameEs = attriNameEs;
	}

	public String getNameByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			return this.getAttriNameJa();
		case "en":
			return this.getAttriNameEn();
		case "es":
			return this.getAttriNameEs();
		default:
			return this.getAttriNameEn();
		}
	}

	public Long getAttriId() {
		return attriId;
	}

	public void setAttriId(Long attriId) {
		this.attriId = attriId;
	}

	public String getAttriNameJa() {
		return attriNameJa;
	}

	public void setAttriNameJa(String attriNameJa) {
		this.attriNameJa = attriNameJa;
	}

	public String getAttriNameEn() {
		return attriNameEn;
	}

	public void setAttriNameEn(String attriNameEn) {
		this.attriNameEn = attriNameEn;
	}

	public String getAttriNameEs() {
		return attriNameEs;
	}

	public void setAttriNameEs(String attriNameEs) {
		this.attriNameEs = attriNameEs;
	}

	@Override
	public int hashCode() {
		return Objects.hash(attriId, attriNameEn, attriNameEs, attriNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attri other = (Attri) obj;
		return Objects.equals(attriId, other.attriId) && Objects.equals(attriNameEn, other.attriNameEn)
				&& Objects.equals(attriNameEs, other.attriNameEs) && Objects.equals(attriNameJa, other.attriNameJa);
	}

	@Override
	public String toString() {
		return "Attri [attriId=" + attriId + ", attriNameJa=" + attriNameJa + ", attriNameEn=" + attriNameEn
				+ ", attriNameEs=" + attriNameEs + "]";
	}

}
