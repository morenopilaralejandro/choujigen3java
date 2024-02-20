package com.choujigen.ogre.domain;

import java.util.Locale;
import java.util.Objects;

import org.springframework.context.i18n.LocaleContextHolder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "hissatsu_skill")
@PrimaryKeyJoinColumn(name = "item_hissatsu_id")
public class HissatsuSkill extends ItemHissatsu {

	@Column(name = "hissatsu_skill_effect_ja")
	private String hissatsuSkillEffectJa;

	@Column(name = "hissatsu_skill_effect_en")
	private String hissatsuSkillEffectEn;

	@Column(name = "hissatsu_skill_effect_es")
	private String hissatsuSkillEffectEs;

	public HissatsuSkill() {
	}

	public HissatsuSkill(String hissatsuSkillEffectJa, String hissatsuSkillEffectEn, String hissatsuSkillEffectEs) {
		super();
		this.hissatsuSkillEffectJa = hissatsuSkillEffectJa;
		this.hissatsuSkillEffectEn = hissatsuSkillEffectEn;
		this.hissatsuSkillEffectEs = hissatsuSkillEffectEs;
	}
	
	public String getEffectByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			return this.getHissatsuSkillEffectJa();
		case "en":
			return this.getHissatsuSkillEffectEn();
		case "es":
			return this.getHissatsuSkillEffectEs();
		default:
			return this.getHissatsuSkillEffectEn();
		}
	}

	public String getHissatsuSkillEffectJa() {
		return hissatsuSkillEffectJa;
	}

	public void setHissatsuSkillEffectJa(String hissatsuSkillEffectJa) {
		this.hissatsuSkillEffectJa = hissatsuSkillEffectJa;
	}

	public String getHissatsuSkillEffectEn() {
		return hissatsuSkillEffectEn;
	}

	public void setHissatsuSkillEffectEn(String hissatsuSkillEffectEn) {
		this.hissatsuSkillEffectEn = hissatsuSkillEffectEn;
	}

	public String getHissatsuSkillEffectEs() {
		return hissatsuSkillEffectEs;
	}

	public void setHissatsuSkillEffectEs(String hissatsuSkillEffectEs) {
		this.hissatsuSkillEffectEs = hissatsuSkillEffectEs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(hissatsuSkillEffectEn, hissatsuSkillEffectEs, hissatsuSkillEffectJa);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		HissatsuSkill other = (HissatsuSkill) obj;
		return Objects.equals(hissatsuSkillEffectEn, other.hissatsuSkillEffectEn)
				&& Objects.equals(hissatsuSkillEffectEs, other.hissatsuSkillEffectEs)
				&& Objects.equals(hissatsuSkillEffectJa, other.hissatsuSkillEffectJa);
	}

	@Override
	public String toString() {
		return "HissatsuSkill [hissatsuSkillEffectJa=" + hissatsuSkillEffectJa + ", hissatsuSkillEffectEn="
				+ hissatsuSkillEffectEn + ", hissatsuSkillEffectEs=" + hissatsuSkillEffectEs + "]";
	}

}
