package com.choujigen.ogre.domain;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_currency")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "item_currency_id")
public class ItemCurrency extends Item {
	@Column(name = "item_currency_carry_limit")
	private Long itemCurrencyCarryLimit;

	public ItemCurrency() {
	}

	public ItemCurrency(Long itemId, String itemNameJa, String itemNameEn, String itemNameEs, Long itemPriceBuy,
			Long itemPriceSell, ItemType itemType, Long itemCurrencyCarryLimit) {
		super(itemId, itemNameJa, itemNameEn, itemNameEs, itemPriceBuy, itemPriceSell, itemType);
		this.itemCurrencyCarryLimit = itemCurrencyCarryLimit;
	}

	public Long getItemCurrencyCarryLimit() {
		return itemCurrencyCarryLimit;
	}

	public void setItemCurrencyCarryLimit(Long itemCurrencyCarryLimit) {
		this.itemCurrencyCarryLimit = itemCurrencyCarryLimit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(itemCurrencyCarryLimit);
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
		ItemCurrency other = (ItemCurrency) obj;
		return Objects.equals(itemCurrencyCarryLimit, other.itemCurrencyCarryLimit);
	}

	@Override
	public String toString() {
		return "ItemCurrency [itemCurrencyCarryLimit=" + itemCurrencyCarryLimit + "]";
	}

}
