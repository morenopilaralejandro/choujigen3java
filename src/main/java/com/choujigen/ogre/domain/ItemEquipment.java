package com.choujigen.ogre.domain;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_equipment")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "item_equipment_id")
public class ItemEquipment extends Item {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "equipment_type_id", referencedColumnName = "equipment_type_id")
	private EquipmentType equipmentType;

	@OneToMany(mappedBy = "itemEquipment", fetch = FetchType.LAZY)
	private List<EquipmentStrengthensStat> equipmentStrengthensStat;

	public ItemEquipment() {
	}

	public ItemEquipment(Long itemId, String itemNameJa, String itemNameEn, String itemNameEs, Long itemPriceBuy,
			Long itemPriceSell, ItemType itemType, EquipmentType equipmentType) {
		super(itemId, itemNameJa, itemNameEn, itemNameEs, itemPriceBuy, itemPriceSell, itemType);
		this.equipmentType = equipmentType;
	}

	public EquipmentType getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(EquipmentType equipmentType) {
		this.equipmentType = equipmentType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(equipmentType);
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
		ItemEquipment other = (ItemEquipment) obj;
		return Objects.equals(equipmentType, other.equipmentType);
	}

	public List<EquipmentStrengthensStat> getEquipmentStrengthensStat() {
		return equipmentStrengthensStat;
	}

	public void setEquipmentStrengthensStat(List<EquipmentStrengthensStat> equipmentStrengthensStat) {
		this.equipmentStrengthensStat = equipmentStrengthensStat;
	}

	@Override
	public String toString() {
		return "ItemEquipment [equipmentType=" + equipmentType + "]";
	}

}
