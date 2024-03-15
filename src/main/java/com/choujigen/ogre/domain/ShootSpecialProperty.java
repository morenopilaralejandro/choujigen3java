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
@Table(name = "shoot_special_property")
public class ShootSpecialProperty {
	@Column(name = "shoot_special_property_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long shootSpecialPropertyId;
	@Column(name = "shoot_special_property_name_ja")
	private String shootSpecialPropertyNameJa;
	@Column(name = "shoot_special_property_name_en")
	private String shootSpecialPropertyNameEn;
	@Column(name = "shoot_special_property_name_es")
	private String shootSpecialPropertyNameEs;

	@ManyToMany(mappedBy = "shootSpecialProperty")
	private List<HissatsuShoot> hissatsuShootAll;

	public ShootSpecialProperty() {
	}

	public ShootSpecialProperty(Long shootSpecialPropertyId, String shootSpecialPropertyNameJa,
			String shootSpecialPropertyNameEn, String shootSpecialPropertyNameEs) {
		super();
		this.shootSpecialPropertyId = shootSpecialPropertyId;
		this.shootSpecialPropertyNameJa = shootSpecialPropertyNameJa;
		this.shootSpecialPropertyNameEn = shootSpecialPropertyNameEn;
		this.shootSpecialPropertyNameEs = shootSpecialPropertyNameEs;
	}
	
	public String getCssClass() {
		switch (this.shootSpecialPropertyId.intValue()) {
		case 1:
			return "chain";
		case 2:
			return "long";
		case 3:
			return "block";
		default:
			return "";
		}
	}


	public String getOneLetterByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		default:
			switch (this.shootSpecialPropertyId.intValue()) {
			case 1:
				return "C";
			case 2:
				return "L";
			case 3:
				return "B";
			}
		}
		return null;
	}

	public String getTwoLetterByLangByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "es":
			switch (this.shootSpecialPropertyId.intValue()) {
			case 1:
				return "Cadena";
			case 2:
				return "Largo";
			case 3:
				return "Bloqueo";
			}
		default:
			switch (this.shootSpecialPropertyId.intValue()) {
			case 1:
				return "SC";
			case 2:
				return "LS";
			case 3:
				return "SB";
			}
		}
		return null;
	}

	public String getNameByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			return this.getShootSpecialPropertyNameJa();
		case "en":
			return this.getShootSpecialPropertyNameEn();
		case "es":
			return this.getShootSpecialPropertyNameEs();
		default:
			return this.getShootSpecialPropertyNameEn();
		}
	}

	public Long getShootSpecialPropertyId() {
		return shootSpecialPropertyId;
	}

	public void setShootSpecialPropertyId(Long shootSpecialPropertyId) {
		this.shootSpecialPropertyId = shootSpecialPropertyId;
	}

	public String getShootSpecialPropertyNameJa() {
		return shootSpecialPropertyNameJa;
	}

	public void setShootSpecialPropertyNameJa(String shootSpecialPropertyNameJa) {
		this.shootSpecialPropertyNameJa = shootSpecialPropertyNameJa;
	}

	public String getShootSpecialPropertyNameEn() {
		return shootSpecialPropertyNameEn;
	}

	public void setShootSpecialPropertyNameEn(String shootSpecialPropertyNameEn) {
		this.shootSpecialPropertyNameEn = shootSpecialPropertyNameEn;
	}

	public String getShootSpecialPropertyNameEs() {
		return shootSpecialPropertyNameEs;
	}

	public void setShootSpecialPropertyNameEs(String shootSpecialPropertyNameEs) {
		this.shootSpecialPropertyNameEs = shootSpecialPropertyNameEs;
	}

	@Override
	public int hashCode() {
		return Objects.hash(shootSpecialPropertyId, shootSpecialPropertyNameEn, shootSpecialPropertyNameEs,
				shootSpecialPropertyNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShootSpecialProperty other = (ShootSpecialProperty) obj;
		return Objects.equals(shootSpecialPropertyId, other.shootSpecialPropertyId)
				&& Objects.equals(shootSpecialPropertyNameEn, other.shootSpecialPropertyNameEn)
				&& Objects.equals(shootSpecialPropertyNameEs, other.shootSpecialPropertyNameEs)
				&& Objects.equals(shootSpecialPropertyNameJa, other.shootSpecialPropertyNameJa);
	}

	@Override
	public String toString() {
		return "ShootSpecialProperty [shootSpecialPropertyId=" + shootSpecialPropertyId
				+ ", shootSpecialPropertyNameJa=" + shootSpecialPropertyNameJa + ", shootSpecialPropertyNameEn="
				+ shootSpecialPropertyNameEn + ", shootSpecialPropertyNameEs=" + shootSpecialPropertyNameEs + "]";
	}

}
