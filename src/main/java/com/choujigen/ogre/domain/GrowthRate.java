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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "growth_rate")
public class GrowthRate {
	@Column(name = "growth_rate_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long growthRateId;
	@Column(name = "growth_rate_name_ja")
	private String GrowthRateNameJa;
	@Column(name = "growth_rate_name_en")
	private String GrowthRateNameEn;
	@Column(name = "growth_rate_name_es")
	private String GrowthRateNameEs;

	@OneToMany(mappedBy = "growthRate")
	private List<GrowthTypeAchieveGrowthRate> growthTypeAchieveGrowthRate;
	
	public GrowthRate() {
	}

	public GrowthRate(Long growthRateId, String growthRateNameJa, String growthRateNameEn, String growthRateNameEs) {
		super();
		this.growthRateId = growthRateId;
		GrowthRateNameJa = growthRateNameJa;
		GrowthRateNameEn = growthRateNameEn;
		GrowthRateNameEs = growthRateNameEs;
	}
	
	public String getNameByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			return this.getGrowthRateNameJa();
		case "en":
			return this.getGrowthRateNameEn();
		case "es":
			return this.getGrowthRateNameEs();
		default:
			return this.getGrowthRateNameEn();
		}
	}

	public Long getGrowthRateId() {
		return growthRateId;
	}

	public void setGrowthRateId(Long growthRateId) {
		this.growthRateId = growthRateId;
	}

	public String getGrowthRateNameJa() {
		return GrowthRateNameJa;
	}

	public void setGrowthRateNameJa(String growthRateNameJa) {
		GrowthRateNameJa = growthRateNameJa;
	}

	public String getGrowthRateNameEn() {
		return GrowthRateNameEn;
	}

	public void setGrowthRateNameEn(String growthRateNameEn) {
		GrowthRateNameEn = growthRateNameEn;
	}

	public String getGrowthRateNameEs() {
		return GrowthRateNameEs;
	}

	public void setGrowthRateNameEs(String growthRateNameEs) {
		GrowthRateNameEs = growthRateNameEs;
	}

	public List<GrowthTypeAchieveGrowthRate> getGrowthTypeAchieveGrowthRate() {
		return growthTypeAchieveGrowthRate;
	}

	public void setGrowthTypeAchieveGrowthRate(List<GrowthTypeAchieveGrowthRate> growthTypeAchieveGrowthRate) {
		this.growthTypeAchieveGrowthRate = growthTypeAchieveGrowthRate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(GrowthRateNameEn, GrowthRateNameEs, GrowthRateNameJa, growthRateId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrowthRate other = (GrowthRate) obj;
		return Objects.equals(GrowthRateNameEn, other.GrowthRateNameEn)
				&& Objects.equals(GrowthRateNameEs, other.GrowthRateNameEs)
				&& Objects.equals(GrowthRateNameJa, other.GrowthRateNameJa)
				&& Objects.equals(growthRateId, other.growthRateId);
	}

	@Override
	public String toString() {
		return "GrowthRate [growthRateId=" + growthRateId + ", GrowthRateNameJa=" + GrowthRateNameJa
				+ ", GrowthRateNameEn=" + GrowthRateNameEn + ", GrowthRateNameEs=" + GrowthRateNameEs + "]";
	}
}
