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
@Table(name = "formation_type")
public class FormationType {
	@Column(name = "formation_type_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long formationTypeId;
	@Column(name = "formation_type_name_ja")
	private String formationTypeNameJa;
	@Column(name = "formation_type_name_en")
	private String formationTypeNameEn;
	@Column(name = "formation_type_name_es")
	private String formationTypeNameEs;

	public FormationType() {
	}

	public FormationType(Long formationTypeId, String formationTypeNameJa, String formationTypeNameEn, String formationTypeNameEs) {
		super();
		this.formationTypeId = formationTypeId;
		this.formationTypeNameJa = formationTypeNameJa;
		this.formationTypeNameEn = formationTypeNameEn;
		this.formationTypeNameEs = formationTypeNameEs;
	}
	
	public String getNameByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			return this.getFormationTypeNameJa();
		case "en":
			return this.getFormationTypeNameEn();
		case "es":
			return this.getFormationTypeNameEs();
		default:
			return this.getFormationTypeNameEn();
		}
	}

	public Long getFormationTypeId() {
		return formationTypeId;
	}

	public void setFormationTypeId(Long formationTypeId) {
		this.formationTypeId = formationTypeId;
	}

	public String getFormationTypeNameJa() {
		return formationTypeNameJa;
	}

	public void setFormationTypeNameJa(String formationTypeNameJa) {
		this.formationTypeNameJa = formationTypeNameJa;
	}

	public String getFormationTypeNameEn() {
		return formationTypeNameEn;
	}

	public void setFormationTypeNameEn(String formationTypeNameEn) {
		this.formationTypeNameEn = formationTypeNameEn;
	}

	public String getFormationTypeNameEs() {
		return formationTypeNameEs;
	}

	public void setFormationTypeNameEs(String formationTypeNameEs) {
		this.formationTypeNameEs = formationTypeNameEs;
	}

	@Override
	public int hashCode() {
		return Objects.hash(formationTypeId, formationTypeNameEn, formationTypeNameEs, formationTypeNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FormationType other = (FormationType) obj;
		return Objects.equals(formationTypeId, other.formationTypeId) && Objects.equals(formationTypeNameEn, other.formationTypeNameEn)
				&& Objects.equals(formationTypeNameEs, other.formationTypeNameEs)
				&& Objects.equals(formationTypeNameJa, other.formationTypeNameJa);
	}

	@Override
	public String toString() {
		return "FormationType [formationTypeId=" + formationTypeId + ", formationTypeNameJa=" + formationTypeNameJa + ", formationTypeNameEn="
				+ formationTypeNameEn + ", formationTypeNameEs=" + formationTypeNameEs + "]";
	}
}
