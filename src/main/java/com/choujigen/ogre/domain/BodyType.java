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
@Table(name = "bodyType")
public class BodyType {
	@Column(name = "body_type_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long bodyTypeId;
	@Column(name = "body_type_name_ja")
	private String bodyTypeNameJa;
	@Column(name = "body_type_name_en")
	private String bodyTypeNameEn;
	@Column(name = "body_type_name_es")
	private String bodyTypeNameEs;

	@ManyToMany(mappedBy = "restricBodyType")
	private List<ItemHissatsu> itemHissatsuAll;

	public BodyType() {
	}

	public BodyType(Long bodyTypeId, String bodyTypeNameJa, String bodyTypeNameEn, String bodyTypeNameEs) {
		super();
		this.bodyTypeId = bodyTypeId;
		this.bodyTypeNameJa = bodyTypeNameJa;
		this.bodyTypeNameEn = bodyTypeNameEn;
		this.bodyTypeNameEs = bodyTypeNameEs;
	}

	public String getNameByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			return this.getBodyTypeNameJa();
		case "en":
			return this.getBodyTypeNameEn();
		case "es":
			return this.getBodyTypeNameEs();
		default:
			return this.getBodyTypeNameEn();
		}
	}

	public Long getBodyTypeId() {
		return bodyTypeId;
	}

	public void setBodyTypeId(Long bodyTypeId) {
		this.bodyTypeId = bodyTypeId;
	}

	public String getBodyTypeNameJa() {
		return bodyTypeNameJa;
	}

	public void setBodyTypeNameJa(String bodyTypeNameJa) {
		this.bodyTypeNameJa = bodyTypeNameJa;
	}

	public String getBodyTypeNameEn() {
		return bodyTypeNameEn;
	}

	public void setBodyTypeNameEn(String bodyTypeNameEn) {
		this.bodyTypeNameEn = bodyTypeNameEn;
	}

	public String getBodyTypeNameEs() {
		return bodyTypeNameEs;
	}

	public void setBodyTypeNameEs(String bodyTypeNameEs) {
		this.bodyTypeNameEs = bodyTypeNameEs;
	}

	public List<ItemHissatsu> getItemHissatsuAll() {
		return itemHissatsuAll;
	}

	public void setItemHissatsuAll(List<ItemHissatsu> itemHissatsuAll) {
		this.itemHissatsuAll = itemHissatsuAll;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bodyTypeId, bodyTypeNameEn, bodyTypeNameEs, bodyTypeNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BodyType other = (BodyType) obj;
		return Objects.equals(bodyTypeId, other.bodyTypeId) && Objects.equals(bodyTypeNameEn, other.bodyTypeNameEn)
				&& Objects.equals(bodyTypeNameEs, other.bodyTypeNameEs)
				&& Objects.equals(bodyTypeNameJa, other.bodyTypeNameJa);
	}

	@Override
	public String toString() {
		return "BodyType [bodyTypeId=" + bodyTypeId + ", bodyTypeNameJa=" + bodyTypeNameJa + ", bodyTypeNameEn="
				+ bodyTypeNameEn + ", bodyTypeNameEs=" + bodyTypeNameEs + "]";
	}

}
