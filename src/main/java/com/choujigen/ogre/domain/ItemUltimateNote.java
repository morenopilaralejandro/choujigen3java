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
@Table(name = "item_ultimate_note")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "item_ultimate_note_id")
public class ItemUltimateNote extends Item {
	@Column(name = "item_ultimate_note_order")
	private String itemUltimateNoteOrder;
	
	@OneToMany(mappedBy = "itemUltimateNote", fetch = FetchType.LAZY)
	private List<UltimateNoteIncreasesFree> ultimateNoteIncreasesFree;

	public ItemUltimateNote() {
	}

	public ItemUltimateNote(Long itemId, String itemNameJa, String itemNameEn, String itemNameEs, Long itemPriceBuy,
			Long itemPriceSell, ItemType itemType, String itemUltimateNoteOrder) {
		super(itemId, itemNameJa, itemNameEn, itemNameEs, itemPriceBuy, itemPriceSell, itemType);
		this.itemUltimateNoteOrder = itemUltimateNoteOrder;
	}

	public String getItemUltimateNoteOrder() {
		return itemUltimateNoteOrder;
	}

	public void setItemUltimateNoteOrder(String itemUltimateNoteOrder) {
		this.itemUltimateNoteOrder = itemUltimateNoteOrder;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(itemUltimateNoteOrder);
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
		ItemUltimateNote other = (ItemUltimateNote) obj;
		return Objects.equals(itemUltimateNoteOrder, other.itemUltimateNoteOrder);
	}

	@Override
	public String toString() {
		return "ItemUltimateNote [itemUltimateNoteOrder=" + itemUltimateNoteOrder + "]";
	}

}
