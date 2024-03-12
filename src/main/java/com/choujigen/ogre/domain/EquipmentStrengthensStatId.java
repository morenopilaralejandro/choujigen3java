package com.choujigen.ogre.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class EquipmentStrengthensStatId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "item_equipment_id")
	private Long itemEquipmentId;

	@Column(name = "stat_id")
	private Long statId;

	public EquipmentStrengthensStatId() {

	}

	public EquipmentStrengthensStatId(Long itemEquipmentId, Long statId) {
		super();
		this.itemEquipmentId = itemEquipmentId;
		this.statId = statId;
	}

	public Long getItemEquipmentId() {
		return itemEquipmentId;
	}

	public void setItemEquipmentId(Long itemEquipmentId) {
		this.itemEquipmentId = itemEquipmentId;
	}

	public Long getStatId() {
		return statId;
	}

	public void setStatId(Long statId) {
		this.statId = statId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemEquipmentId, statId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EquipmentStrengthensStatId other = (EquipmentStrengthensStatId) obj;
		return Objects.equals(itemEquipmentId, other.itemEquipmentId) && Objects.equals(statId, other.statId);
	}

	@Override
	public String toString() {
		return "EquipmentStrengthensStatId [itemEquipmentId=" + itemEquipmentId + ", statId=" + statId + "]";
	}

}
