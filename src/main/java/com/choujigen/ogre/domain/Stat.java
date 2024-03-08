package com.choujigen.ogre.domain;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

import org.springframework.context.i18n.LocaleContextHolder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "stat")
public class Stat {
	@Column(name = "stat_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long statId;
	@Column(name = "stat_name_ja")
	private String statNameJa;
	@Column(name = "stat_name_en")
	private String statNameEn;
	@Column(name = "stat_name_es")
	private String statNameEs;

	@ManyToMany(mappedBy = "stats")
	private List<TrainingMethod> trainingMethods;

	public Stat() {
	}

	public Stat(Long statId, String statNameJa, String statNameEn, String statNameEs) {
		super();
		this.statId = statId;
		this.statNameJa = statNameJa;
		this.statNameEn = statNameEn;
		this.statNameEs = statNameEs;
	}

	public String getNameByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			return this.getStatNameJa();
		case "en":
			return this.getStatNameEn();
		case "es":
			return this.getStatNameEs();
		default:
			return this.getStatNameEn();
		}
	}

	public Long getStatId() {
		return statId;
	}

	public void setStatId(Long statId) {
		this.statId = statId;
	}

	public String getStatNameJa() {
		return statNameJa;
	}

	public void setStatNameJa(String statNameJa) {
		this.statNameJa = statNameJa;
	}

	public String getStatNameEn() {
		return statNameEn;
	}

	public void setStatNameEn(String statNameEn) {
		this.statNameEn = statNameEn;
	}

	public String getStatNameEs() {
		return statNameEs;
	}

	public void setStatNameEs(String statNameEs) {
		this.statNameEs = statNameEs;
	}

	public List<TrainingMethod> getTrainingMethods() {
		return trainingMethods;
	}

	public void setTrainingMethods(List<TrainingMethod> trainingMethods) {
		this.trainingMethods = trainingMethods;
	}

	@Override
	public int hashCode() {
		return Objects.hash(statId, statNameEn, statNameEs, statNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stat other = (Stat) obj;
		return Objects.equals(statId, other.statId) && Objects.equals(statNameEn, other.statNameEn)
				&& Objects.equals(statNameEs, other.statNameEs) && Objects.equals(statNameJa, other.statNameJa);
	}

	@Override
	public String toString() {
		return "Stat [statId=" + statId + ", statNameJa=" + statNameJa + ", statNameEn=" + statNameEn + ", statNameEs="
				+ statNameEs + "]";
	}
}
