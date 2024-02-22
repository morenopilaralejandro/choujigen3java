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
@Table(name = "growth_type")
public class GrowthType {
	@Column(name = "growth_type_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long growthTypeId;
	@Column(name = "growth_type_name_ja")
	private String GrowthTypeNameJa;
	@Column(name = "growth_type_name_en")
	private String GrowthTypeNameEn;
	@Column(name = "growth_type_name_es")
	private String GrowthTypeNameEs;

	@OneToMany(mappedBy = "growthType")
	private List<GrowthTypeAchieveGrowthRate> growthTypeAchieveGrowthRate;

	public GrowthType() {
	}

	public GrowthType(Long growthTypeId, String growthTypeNameJa, String growthTypeNameEn, String growthTypeNameEs) {
		super();
		this.growthTypeId = growthTypeId;
		GrowthTypeNameJa = growthTypeNameJa;
		GrowthTypeNameEn = growthTypeNameEn;
		GrowthTypeNameEs = growthTypeNameEs;
	}
	
	
	public String getNameByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			return this.getGrowthTypeNameJa();
		case "en":
			return this.getGrowthTypeNameEn();
		case "es":
			return this.getGrowthTypeNameEs();
		default:
			return this.getGrowthTypeNameEn();
		}
	}
	
	public String getSymbolByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			switch(this.growthTypeId.intValue()) {
			case 1:
				return "真";
			case 2:
				return "V3";
			case 3:
				return "G5";	
			}
		case "en":
			switch(this.growthTypeId.intValue()) {
			case 1:
				return "+2 (真)";
			case 2:
				return "V3";
			case 3:
				return "L5 (G5)";	
			}
		case "es":
			switch(this.growthTypeId.intValue()) {
			case 1:
				return "++";
			case 2:
				return "N3";
			case 3:
				return "G5";	
			}
		default:
			switch(this.growthTypeId.intValue()) {
			case 1:
				return "真";
			case 2:
				return "V3";
			case 3:
				return "G5";	
			}
		}
		return null;
	}

	public Long getGrowthTypeId() {
		return growthTypeId;
	}

	public void setGrowthTypeId(Long growthTypeId) {
		this.growthTypeId = growthTypeId;
	}

	public String getGrowthTypeNameJa() {
		return GrowthTypeNameJa;
	}

	public void setGrowthTypeNameJa(String growthTypeNameJa) {
		GrowthTypeNameJa = growthTypeNameJa;
	}

	public String getGrowthTypeNameEn() {
		return GrowthTypeNameEn;
	}

	public void setGrowthTypeNameEn(String growthTypeNameEn) {
		GrowthTypeNameEn = growthTypeNameEn;
	}

	public String getGrowthTypeNameEs() {
		return GrowthTypeNameEs;
	}

	public void setGrowthTypeNameEs(String growthTypeNameEs) {
		GrowthTypeNameEs = growthTypeNameEs;
	}

	public List<GrowthTypeAchieveGrowthRate> getGrowthTypeAchieveGrowthRate() {
		return growthTypeAchieveGrowthRate;
	}

	public void setGrowthTypeAchieveGrowthRate(List<GrowthTypeAchieveGrowthRate> growthTypeAchieveGrowthRate) {
		this.growthTypeAchieveGrowthRate = growthTypeAchieveGrowthRate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(GrowthTypeNameEn, GrowthTypeNameEs, GrowthTypeNameJa, growthTypeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrowthType other = (GrowthType) obj;
		return Objects.equals(GrowthTypeNameEn, other.GrowthTypeNameEn)
				&& Objects.equals(GrowthTypeNameEs, other.GrowthTypeNameEs)
				&& Objects.equals(GrowthTypeNameJa, other.GrowthTypeNameJa)
				&& Objects.equals(growthTypeId, other.growthTypeId);
	}

	@Override
	public String toString() {
		return "GrowthType [growthTypeId=" + growthTypeId + ", GrowthTypeNameJa=" + GrowthTypeNameJa
				+ ", GrowthTypeNameEn=" + GrowthTypeNameEn + ", GrowthTypeNameEs=" + GrowthTypeNameEs + "]";
	}
}
