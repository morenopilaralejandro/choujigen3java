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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "training_method")
public class TrainingMethod {
	@Column(name = "training_method_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long trainingMethodId;
	@Column(name = "training_method_name_ja")
	private String trainingMethodNameJa;
	@Column(name = "training_method_name_en")
	private String trainingMethodNameEn;
	@Column(name = "training_method_name_es")
	private String trainingMethodNameEs;
	@Column(name = "training_method_desc_ja")
	private String trainingMethodDescJa;
	@Column(name = "training_method_desc_en")
	private String trainingMethodDescEn;
	@Column(name = "training_method_desc_es")
	private String trainingMethodDescEs;
	
	@ManyToMany
	@JoinTable(name = "training_method_focuses_on_stat", joinColumns = @JoinColumn(name = "training_method_id"), inverseJoinColumns = @JoinColumn(name = "stat_id"))
	private List<Stat> stats;

	public TrainingMethod() {
	}
	
	public TrainingMethod(Long trainingMethodId, String trainingMethodNameJa, String trainingMethodNameEn,
			String trainingMethodNameEs, String trainingMethodDescJa, String trainingMethodDescEn,
			String trainingMethodDescEs) {
		super();
		this.trainingMethodId = trainingMethodId;
		this.trainingMethodNameJa = trainingMethodNameJa;
		this.trainingMethodNameEn = trainingMethodNameEn;
		this.trainingMethodNameEs = trainingMethodNameEs;
		this.trainingMethodDescJa = trainingMethodDescJa;
		this.trainingMethodDescEn = trainingMethodDescEn;
		this.trainingMethodDescEs = trainingMethodDescEs;
	}

	public String getNameByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			return this.getTrainingMethodNameJa();
		case "en":
			return this.getTrainingMethodNameEn();
		case "es":
			return this.getTrainingMethodNameEs();
		default:
			return this.getTrainingMethodNameEn();
		}
	}
	
	public String getDescByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			return this.getTrainingMethodDescJa();
		case "en":
			return this.getTrainingMethodDescEn();
		case "es":
			return this.getTrainingMethodDescEs();
		default:
			return this.getTrainingMethodDescEn();
		}
	}

	public Long getTrainingMethodId() {
		return trainingMethodId;
	}

	public void setTrainingMethodId(Long trainingMethodId) {
		this.trainingMethodId = trainingMethodId;
	}

	public String getTrainingMethodNameJa() {
		return trainingMethodNameJa;
	}

	public void setTrainingMethodNameJa(String trainingMethodNameJa) {
		this.trainingMethodNameJa = trainingMethodNameJa;
	}

	public String getTrainingMethodNameEn() {
		return trainingMethodNameEn;
	}

	public void setTrainingMethodNameEn(String trainingMethodNameEn) {
		this.trainingMethodNameEn = trainingMethodNameEn;
	}

	public String getTrainingMethodNameEs() {
		return trainingMethodNameEs;
	}

	public void setTrainingMethodNameEs(String trainingMethodNameEs) {
		this.trainingMethodNameEs = trainingMethodNameEs;
	}

	public String getTrainingMethodDescJa() {
		return trainingMethodDescJa;
	}

	public void setTrainingMethodDescJa(String trainingMethodDescJa) {
		this.trainingMethodDescJa = trainingMethodDescJa;
	}

	public String getTrainingMethodDescEn() {
		return trainingMethodDescEn;
	}

	public void setTrainingMethodDescEn(String trainingMethodDescEn) {
		this.trainingMethodDescEn = trainingMethodDescEn;
	}

	public String getTrainingMethodDescEs() {
		return trainingMethodDescEs;
	}

	public void setTrainingMethodDescEs(String trainingMethodDescEs) {
		this.trainingMethodDescEs = trainingMethodDescEs;
	}

	public List<Stat> getStats() {
		return stats;
	}

	public void setStats(List<Stat> stats) {
		this.stats = stats;
	}

	@Override
	public int hashCode() {
		return Objects.hash(trainingMethodDescEn, trainingMethodDescEs, trainingMethodDescJa, trainingMethodId,
				trainingMethodNameEn, trainingMethodNameEs, trainingMethodNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrainingMethod other = (TrainingMethod) obj;
		return Objects.equals(trainingMethodDescEn, other.trainingMethodDescEn)
				&& Objects.equals(trainingMethodDescEs, other.trainingMethodDescEs)
				&& Objects.equals(trainingMethodDescJa, other.trainingMethodDescJa)
				&& Objects.equals(trainingMethodId, other.trainingMethodId)
				&& Objects.equals(trainingMethodNameEn, other.trainingMethodNameEn)
				&& Objects.equals(trainingMethodNameEs, other.trainingMethodNameEs)
				&& Objects.equals(trainingMethodNameJa, other.trainingMethodNameJa);
	}

	@Override
	public String toString() {
		return "TrainingMethod [trainingMethodId=" + trainingMethodId + ", trainingMethodNameJa=" + trainingMethodNameJa
				+ ", trainingMethodNameEn=" + trainingMethodNameEn + ", trainingMethodNameEs=" + trainingMethodNameEs
				+ ", trainingMethodDescJa=" + trainingMethodDescJa + ", trainingMethodDescEn=" + trainingMethodDescEn
				+ ", trainingMethodDescEs=" + trainingMethodDescEs + "]";
	}


	

}
