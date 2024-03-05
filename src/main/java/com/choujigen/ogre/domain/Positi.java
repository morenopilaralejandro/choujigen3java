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
@Table(name = "positi")
public class Positi {
	@Column(name = "positi_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long positiId;
	@Column(name = "positi_name_ja")
	private String positiNameJa;
	@Column(name = "positi_name_en")
	private String positiNameEn;
	@Column(name = "positi_name_es")
	private String positiNameEs;

	@ManyToMany(mappedBy = "restricPositi")
	private List<ItemHissatsu> itemHissatsuAll;

	public Positi() {
	}

	public Positi(Long positiId, String positiNameJa, String positiNameEn, String positiNameEs) {
		super();
		this.positiId = positiId;
		this.positiNameJa = positiNameJa;
		this.positiNameEn = positiNameEn;
		this.positiNameEs = positiNameEs;
	}

	public String getNameByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			return this.getPositiNameJa();
		case "en":
			return this.getPositiNameEn();
		case "es":
			return this.getPositiNameEs();
		default:
			return this.getPositiNameEn();
		}
	}
	
	public String getCssClass() {
		return this.positiNameJa.toLowerCase();
	}

	public Long getPositiId() {
		return positiId;
	}

	public void setPositiId(Long positiId) {
		this.positiId = positiId;
	}

	public String getPositiNameJa() {
		return positiNameJa;
	}

	public void setPositiNameJa(String positiNameJa) {
		this.positiNameJa = positiNameJa;
	}

	public String getPositiNameEn() {
		return positiNameEn;
	}

	public void setPositiNameEn(String positiNameEn) {
		this.positiNameEn = positiNameEn;
	}

	public String getPositiNameEs() {
		return positiNameEs;
	}

	public void setPositiNameEs(String positiNameEs) {
		this.positiNameEs = positiNameEs;
	}

	public List<ItemHissatsu> getItemHissatsuAll() {
		return itemHissatsuAll;
	}

	public void setItemHissatsuAll(List<ItemHissatsu> itemHissatsuAll) {
		this.itemHissatsuAll = itemHissatsuAll;
	}

	@Override
	public int hashCode() {
		return Objects.hash(positiId, positiNameEn, positiNameEs, positiNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Positi other = (Positi) obj;
		return Objects.equals(positiId, other.positiId) && Objects.equals(positiNameEn, other.positiNameEn)
				&& Objects.equals(positiNameEs, other.positiNameEs) && Objects.equals(positiNameJa, other.positiNameJa);
	}

	@Override
	public String toString() {
		return "Positi [positiId=" + positiId + ", positiNameJa=" + positiNameJa + ", positiNameEn=" + positiNameEn
				+ ", positiNameEs=" + positiNameEs + "]";
	}

}
