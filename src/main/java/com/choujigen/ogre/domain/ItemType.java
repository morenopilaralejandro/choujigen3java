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
@Table(name = "item_type")
public class ItemType {
	@Column(name = "item_type_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long itemTypeId;
	@Column(name = "item_type_name_ja")
	private String itemTypeNameJa;
	@Column(name = "item_type_name_en")
	private String itemTypeNameEn;
	@Column(name = "item_type_name_es")
	private String itemTypeNameEs;

	public Long getItemTypeId() {
		return itemTypeId;
	}

	public void setItemTypeId(Long itemTypeId) {
		this.itemTypeId = itemTypeId;
	}

	public String getItemTypeNameJa() {
		return itemTypeNameJa;
	}

	public void setItemTypeNameJa(String itemTypeNameJa) {
		this.itemTypeNameJa = itemTypeNameJa;
	}

	public String getItemTypeNameEn() {
		return itemTypeNameEn;
	}

	public void setItemTypeNameEn(String itemTypeNameEn) {
		this.itemTypeNameEn = itemTypeNameEn;
	}

	public String getItemTypeNameEs() {
		return itemTypeNameEs;
	}

	public void setItemTypeNameEs(String itemTypeNameEs) {
		this.itemTypeNameEs = itemTypeNameEs;
	}

	public String getNameByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			return this.getItemTypeNameJa();
		case "en":
			return this.getItemTypeNameEn();
		case "es":
			return this.getItemTypeNameEs();
		default:
			return this.getItemTypeNameEn();
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemTypeId, itemTypeNameEn, itemTypeNameEs, itemTypeNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemType other = (ItemType) obj;
		return Objects.equals(itemTypeId, other.itemTypeId) && Objects.equals(itemTypeNameEn, other.itemTypeNameEn)
				&& Objects.equals(itemTypeNameEs, other.itemTypeNameEs)
				&& Objects.equals(itemTypeNameJa, other.itemTypeNameJa);
	}

	@Override
	public String toString() {
		return "ItemType [itemTypeId=" + itemTypeId + ", itemTypeNameJa=" + itemTypeNameJa + ", itemTypeNameEn="
				+ itemTypeNameEn + ", itemTypeNameEs=" + itemTypeNameEs + "]";
	}
}
