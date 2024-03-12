package com.choujigen.ogre.domain;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipment_strengthens_stat")
public class EquipmentStrengthensStat {
	@EmbeddedId
	private EquipmentStrengthensStatId id;

	@ManyToOne
	@MapsId("itemEquipmentId")
	@JoinColumn(name = "item_equipment_id")
	private ItemEquipment itemEquipment;

	@ManyToOne
	@MapsId("statId")
	@JoinColumn(name = "stat_id")
	private Stat stat;

	@Column(name = "amount")
	private Long amount;

	public EquipmentStrengthensStat() {
	}

	public EquipmentStrengthensStat(EquipmentStrengthensStatId id, ItemEquipment itemEquipment, Stat stat,
			Long amount) {
		super();
		this.id = id;
		this.itemEquipment = itemEquipment;
		this.stat = stat;
		this.amount = amount;
	}

	public EquipmentStrengthensStat(Long itemEquipmentId, Long statId, ItemEquipment itemEquipment, Stat stat,
			Long amount) {
		super();
		this.id = new EquipmentStrengthensStatId(itemEquipmentId, statId);
		this.itemEquipment = itemEquipment;
		this.stat = stat;
		this.amount = amount;
	}

	public EquipmentStrengthensStatId getId() {
		return id;
	}

	public void setId(EquipmentStrengthensStatId id) {
		this.id = id;
	}

	public ItemEquipment getItemEquipment() {
		return itemEquipment;
	}

	public void setItemEquipment(ItemEquipment itemEquipment) {
		this.itemEquipment = itemEquipment;
	}

	public Stat getStat() {
		return stat;
	}

	public void setStat(Stat stat) {
		this.stat = stat;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, id, itemEquipment, stat);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EquipmentStrengthensStat other = (EquipmentStrengthensStat) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(id, other.id)
				&& Objects.equals(itemEquipment, other.itemEquipment) && Objects.equals(stat, other.stat);
	}

	@Override
	public String toString() {
		return "EquipmentStrengthensStat [id=" + id + ", itemEquipment=" + itemEquipment + ", stat=" + stat
				+ ", amount=" + amount + "]";
	}

}
