package com.choujigen.ogre.domain;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_recovery")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "item_recovery_id")
public class ItemRecovery extends Item {
	@Column(name = "item_recovery_gp")
	private Long itemRecoveryGp;

	@Column(name = "item_recovery_tp")
	private Long itemRecoveryTp;

	public ItemRecovery() {
	}

	public ItemRecovery(Long itemId, String itemNameJa, String itemNameEn, String itemNameEs, Long itemPriceBuy,
			Long itemPriceSell, ItemType itemType, Long itemRecoveryGp, Long itemRecoveryTp) {
		super(itemId, itemNameJa, itemNameEn, itemNameEs, itemPriceBuy, itemPriceSell, itemType);
		this.itemRecoveryGp = itemRecoveryGp;
		this.itemRecoveryTp = itemRecoveryTp;
	}

	public Long getItemRecoveryGp() {
		return itemRecoveryGp;
	}

	public void setItemRecoveryGp(Long itemRecoveryGp) {
		this.itemRecoveryGp = itemRecoveryGp;
	}

	public Long getItemRecoveryTp() {
		return itemRecoveryTp;
	}

	public void setItemRecoveryTp(Long itemRecoveryTp) {
		this.itemRecoveryTp = itemRecoveryTp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(itemRecoveryGp, itemRecoveryTp);
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
		ItemRecovery other = (ItemRecovery) obj;
		return Objects.equals(itemRecoveryGp, other.itemRecoveryGp)
				&& Objects.equals(itemRecoveryTp, other.itemRecoveryTp);
	}

	@Override
	public String toString() {
		return "ItemRecovery [itemRecoveryGp=" + itemRecoveryGp + ", itemRecoveryTp=" + itemRecoveryTp + "]";
	}

}
