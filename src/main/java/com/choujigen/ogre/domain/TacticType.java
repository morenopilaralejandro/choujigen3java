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
@Table(name = "tactic_type")
public class TacticType {
	@Column(name = "tactic_type_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long tacticTypeId;
	@Column(name = "tactic_type_name_ja")
	private String tacticTypeNameJa;
	@Column(name = "tactic_type_name_en")
	private String tacticTypeNameEn;
	@Column(name = "tactic_type_name_es")
	private String tacticTypeNameEs;

	public TacticType() {
	}

	public TacticType(Long tacticTypeId, String tacticTypeNameJa, String tacticTypeNameEn, String tacticTypeNameEs) {
		super();
		this.tacticTypeId = tacticTypeId;
		this.tacticTypeNameJa = tacticTypeNameJa;
		this.tacticTypeNameEn = tacticTypeNameEn;
		this.tacticTypeNameEs = tacticTypeNameEs;
	}
	
	public String getNameByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			return this.getTacticTypeNameJa();
		case "en":
			return this.getTacticTypeNameEn();
		case "es":
			return this.getTacticTypeNameEs();
		default:
			return this.getTacticTypeNameEn();
		}
	}
	
	public String getCssClass() {
		switch(this.tacticTypeId.intValue()) {
		case 1:
			return "att";
		case 2:
			return "def";
		case 3:
			return "attdef";
		case 4:
			return "kick";
		default:
			return "";
		}
	}

	public Long getTacticTypeId() {
		return tacticTypeId;
	}

	public void setTacticTypeId(Long tacticTypeId) {
		this.tacticTypeId = tacticTypeId;
	}

	public String getTacticTypeNameJa() {
		return tacticTypeNameJa;
	}

	public void setTacticTypeNameJa(String tacticTypeNameJa) {
		this.tacticTypeNameJa = tacticTypeNameJa;
	}

	public String getTacticTypeNameEn() {
		return tacticTypeNameEn;
	}

	public void setTacticTypeNameEn(String tacticTypeNameEn) {
		this.tacticTypeNameEn = tacticTypeNameEn;
	}

	public String getTacticTypeNameEs() {
		return tacticTypeNameEs;
	}

	public void setTacticTypeNameEs(String tacticTypeNameEs) {
		this.tacticTypeNameEs = tacticTypeNameEs;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tacticTypeId, tacticTypeNameEn, tacticTypeNameEs, tacticTypeNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TacticType other = (TacticType) obj;
		return Objects.equals(tacticTypeId, other.tacticTypeId) && Objects.equals(tacticTypeNameEn, other.tacticTypeNameEn)
				&& Objects.equals(tacticTypeNameEs, other.tacticTypeNameEs)
				&& Objects.equals(tacticTypeNameJa, other.tacticTypeNameJa);
	}

	@Override
	public String toString() {
		return "TacticType [tacticTypeId=" + tacticTypeId + ", tacticTypeNameJa=" + tacticTypeNameJa + ", tacticTypeNameEn="
				+ tacticTypeNameEn + ", tacticTypeNameEs=" + tacticTypeNameEs + "]";
	}
}
