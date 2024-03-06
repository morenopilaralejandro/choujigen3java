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
@Table(name = "tactic_side")
public class TacticSide {
	@Column(name = "tactic_side_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long tacticSideId;
	@Column(name = "tactic_side_name_ja")
	private String tacticSideNameJa;
	@Column(name = "tactic_side_name_en")
	private String tacticSideNameEn;
	@Column(name = "tactic_side_name_es")
	private String tacticSideNameEs;

	public TacticSide() {
	}

	public TacticSide(Long tacticSideId, String tacticSideNameJa, String tacticSideNameEn, String tacticSideNameEs) {
		super();
		this.tacticSideId = tacticSideId;
		this.tacticSideNameJa = tacticSideNameJa;
		this.tacticSideNameEn = tacticSideNameEn;
		this.tacticSideNameEs = tacticSideNameEs;
	}
	
	public String getNameByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			return this.getTacticSideNameJa();
		case "en":
			return this.getTacticSideNameEn();
		case "es":
			return this.getTacticSideNameEs();
		default:
			return this.getTacticSideNameEn();
		}
	}

	public Long getTacticSideId() {
		return tacticSideId;
	}

	public void setTacticSideId(Long tacticSideId) {
		this.tacticSideId = tacticSideId;
	}

	public String getTacticSideNameJa() {
		return tacticSideNameJa;
	}

	public void setTacticSideNameJa(String tacticSideNameJa) {
		this.tacticSideNameJa = tacticSideNameJa;
	}

	public String getTacticSideNameEn() {
		return tacticSideNameEn;
	}

	public void setTacticSideNameEn(String tacticSideNameEn) {
		this.tacticSideNameEn = tacticSideNameEn;
	}

	public String getTacticSideNameEs() {
		return tacticSideNameEs;
	}

	public void setTacticSideNameEs(String tacticSideNameEs) {
		this.tacticSideNameEs = tacticSideNameEs;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tacticSideId, tacticSideNameEn, tacticSideNameEs, tacticSideNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TacticSide other = (TacticSide) obj;
		return Objects.equals(tacticSideId, other.tacticSideId) && Objects.equals(tacticSideNameEn, other.tacticSideNameEn)
				&& Objects.equals(tacticSideNameEs, other.tacticSideNameEs)
				&& Objects.equals(tacticSideNameJa, other.tacticSideNameJa);
	}

	@Override
	public String toString() {
		return "TacticSide [tacticSideId=" + tacticSideId + ", tacticSideNameJa=" + tacticSideNameJa + ", tacticSideNameEn="
				+ tacticSideNameEn + ", tacticSideNameEs=" + tacticSideNameEs + "]";
	}
}
