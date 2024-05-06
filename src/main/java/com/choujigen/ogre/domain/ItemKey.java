package com.choujigen.ogre.domain;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_key")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "item_key_id")
public class ItemKey extends Item {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "zone_id", referencedColumnName = "zone_id")
	private Zone zone;

	public ItemKey() {
	}

	public ItemKey(Long itemId, String itemNameJa, String itemNameEn, String itemNameEs, Long itemPriceBuy,
			Long itemPriceSell, ItemType itemType, Zone zone) {
		super(itemId, itemNameJa, itemNameEn, itemNameEs, itemPriceBuy, itemPriceSell, itemType);
		this.zone = zone;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(zone);
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
		ItemKey other = (ItemKey) obj;
		return Objects.equals(zone, other.zone);
	}

	@Override
	public String toString() {
		return "ItemMap [zone=" + zone + "]";
	}

}
