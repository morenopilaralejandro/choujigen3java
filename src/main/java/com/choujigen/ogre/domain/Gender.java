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
@Table(name = "gender")
public class Gender {
	@Column(name = "gender_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long genderId;
	@Column(name = "gender_name_ja")
	private String genderNameJa;
	@Column(name = "gender_name_en")
	private String genderNameEn;
	@Column(name = "gender_name_es")
	private String genderNameEs;
	@Column(name = "gender_symbol")
	private String genderSymbol;

	@ManyToMany(mappedBy = "restricGender")
	private List<ItemHissatsu> itemHissatsuAll;

	public Gender() {
	}

	public Gender(Long genderId, String genderNameJa, String genderNameEn, String genderNameEs, String genderSymbol) {
		super();
		this.genderId = genderId;
		this.genderNameJa = genderNameJa;
		this.genderNameEn = genderNameEn;
		this.genderNameEs = genderNameEs;
		this.genderSymbol = genderSymbol;
	}

	public String getNameByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			return this.getGenderNameJa();
		case "en":
			return this.getGenderNameEn();
		case "es":
			return this.getGenderNameEs();
		default:
			return this.getGenderNameEn();
		}
	}
	
	public String getCssClass() {
		return this.genderNameEn.toLowerCase();
	}

	public Long getGenderId() {
		return genderId;
	}

	public void setGenderId(Long genderId) {
		this.genderId = genderId;
	}

	public String getGenderNameJa() {
		return genderNameJa;
	}

	public void setGenderNameJa(String genderNameJa) {
		this.genderNameJa = genderNameJa;
	}

	public String getGenderNameEn() {
		return genderNameEn;
	}

	public void setGenderNameEn(String genderNameEn) {
		this.genderNameEn = genderNameEn;
	}

	public String getGenderNameEs() {
		return genderNameEs;
	}

	public void setGenderNameEs(String genderNameEs) {
		this.genderNameEs = genderNameEs;
	}

	public String getGenderSymbol() {
		return genderSymbol;
	}

	public void setGenderSymbol(String genderSymbol) {
		this.genderSymbol = genderSymbol;
	}

	public List<ItemHissatsu> getItemHissatsuAll() {
		return itemHissatsuAll;
	}

	public void setItemHissatsuAll(List<ItemHissatsu> itemHissatsuAll) {
		this.itemHissatsuAll = itemHissatsuAll;
	}

	@Override
	public int hashCode() {
		return Objects.hash(genderId, genderNameEn, genderNameEs, genderNameJa, genderSymbol);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gender other = (Gender) obj;
		return Objects.equals(genderId, other.genderId) && Objects.equals(genderNameEn, other.genderNameEn)
				&& Objects.equals(genderNameEs, other.genderNameEs) && Objects.equals(genderNameJa, other.genderNameJa)
				&& Objects.equals(genderSymbol, other.genderSymbol);
	}

	@Override
	public String toString() {
		return "Gender [genderId=" + genderId + ", genderNameJa=" + genderNameJa + ", genderNameEn=" + genderNameEn
				+ ", genderNameEs=" + genderNameEs + ", genderSymbol=" + genderSymbol + "]";
	}

}
