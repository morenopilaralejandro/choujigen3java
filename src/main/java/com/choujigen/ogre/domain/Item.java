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
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "item")
@Inheritance(strategy = InheritanceType.JOINED)
public class Item {
	@Column(name = "item_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long itemId;
	@Column(name = "item_name_ja")
	private String itemNameJa;
	@Column(name = "item_name_en")
	private String itemNameEn;
	@Column(name = "item_name_es")
	private String itemNameEs;
	@Column(name = "item_price_buy")
	private Long itemPriceBuy;
	@Column(name = "item_price_sell")
	private Long itemPriceSell;
	@ManyToOne
	@JoinColumn(name = "item_type_id", referencedColumnName = "item_type_id")
	private ItemType itemType;

	@ManyToMany
	@JoinTable(name = "item_sold_at_stor", joinColumns = @JoinColumn(name = "item_id"), inverseJoinColumns = @JoinColumn(name = "stor_id"))
	private List<Stor> stors;

	public Item() {
	}

	public Item(Long itemId, String itemNameJa, String itemNameEn, String itemNameEs, Long itemPriceBuy,
			Long itemPriceSell, ItemType itemType) {
		super();
		this.itemId = itemId;
		this.itemNameJa = itemNameJa;
		this.itemNameEn = itemNameEn;
		this.itemNameEs = itemNameEs;
		this.itemPriceBuy = itemPriceBuy;
		this.itemPriceSell = itemPriceSell;
		this.itemType = itemType;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemNameJa() {
		return itemNameJa;
	}

	public void setItemNameJa(String itemNameJa) {
		this.itemNameJa = itemNameJa;
	}

	public String getItemNameEn() {
		return itemNameEn;
	}

	public void setItemNameEn(String itemNameEn) {
		this.itemNameEn = itemNameEn;
	}

	public String getItemNameEs() {
		return itemNameEs;
	}

	public void setItemNameEs(String itemNameEs) {
		this.itemNameEs = itemNameEs;
	}

	public Long getItemPriceBuy() {
		return itemPriceBuy;
	}

	public void setItemPriceBuy(Long itemPriceBuy) {
		this.itemPriceBuy = itemPriceBuy;
	}

	public Long getItemPriceSell() {
		return itemPriceSell;
	}

	public void setItemPriceSell(Long itemPriceSell) {
		this.itemPriceSell = itemPriceSell;
	}

	public ItemType getItemType() {
		return itemType;
	}

	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}

	public List<Stor> getStors() {
		return stors;
	}

	public void setStors(List<Stor> stors) {
		this.stors = stors;
	}

	public String getNameByLang() {
		Locale locale = LocaleContextHolder.getLocale();
		switch (locale.getLanguage()) {
		case "ja":
			return this.getItemNameJa();
		case "en":
			return this.getItemNameEn();
		case "es":
			return this.getItemNameEs();
		default:
			return this.getItemNameEn();
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemId, itemNameEn, itemNameEs, itemNameJa, itemPriceBuy, itemPriceSell, itemType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(itemId, other.itemId) && Objects.equals(itemNameEn, other.itemNameEn)
				&& Objects.equals(itemNameEs, other.itemNameEs) && Objects.equals(itemNameJa, other.itemNameJa)
				&& Objects.equals(itemPriceBuy, other.itemPriceBuy)
				&& Objects.equals(itemPriceSell, other.itemPriceSell) && Objects.equals(itemType, other.itemType);
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemNameJa=" + itemNameJa + ", itemNameEn=" + itemNameEn + ", itemNameEs="
				+ itemNameEs + ", itemPriceBuy=" + itemPriceBuy + ", itemPriceSell=" + itemPriceSell + ", itemType="
				+ itemType + "]";
	}
}
