package com.choujigen.ogre.exception;

import com.choujigen.ogre.domain.EquipmentStrengthensStatId;

public class EquipmentStrengthensStatNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EquipmentStrengthensStatNotFoundException(EquipmentStrengthensStatId equipmentStrengthensStatId) {
		super("Could not find EquipmentStrengthensStat composite key(itemEquipmentId, statId) ("
				+ equipmentStrengthensStatId.getItemEquipmentId() + ", " + equipmentStrengthensStatId.getStatId()
				+ ")");
	}

}
