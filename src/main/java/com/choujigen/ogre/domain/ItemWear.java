package com.choujigen.ogre.domain;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_wear")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "item_wear_id")
public class ItemWear extends Item {
	@Column(name = "item_wear_hex")
	private String itemWearHex;
	
	@OneToMany(mappedBy = "itemWear", fetch = FetchType.LAZY)
	private List<Team> teams;

	public ItemWear() {
	}

	public ItemWear(Long itemId, String itemNameJa, String itemNameEn, String itemNameEs, Long itemPriceBuy,
			Long itemPriceSell, ItemType itemType, String itemWearHex) {
		super(itemId, itemNameJa, itemNameEn, itemNameEs, itemPriceBuy, itemPriceSell, itemType);
		this.itemWearHex = itemWearHex;
	}

	public String getItemWearHex() {
		return itemWearHex;
	}

	public void setItemWearHex(String itemWearHex) {
		this.itemWearHex = itemWearHex;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(itemWearHex);
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
		ItemWear other = (ItemWear) obj;
		return Objects.equals(itemWearHex, other.itemWearHex);
	}

	@Override
	public String toString() {
		return "ItemWear [itemWearHex=" + itemWearHex + "]";
	}

}
