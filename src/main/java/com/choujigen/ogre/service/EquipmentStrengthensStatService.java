package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.EquipmentStrengthensStat;
import com.choujigen.ogre.domain.EquipmentStrengthensStatId;

public interface EquipmentStrengthensStatService {
	List<EquipmentStrengthensStat> all();

	EquipmentStrengthensStat one(EquipmentStrengthensStatId equipmentStrengthensStatId);

	EquipmentStrengthensStat insert(EquipmentStrengthensStat newObj);

	EquipmentStrengthensStat replace(EquipmentStrengthensStat newObj, EquipmentStrengthensStatId equipmentStrengthensStatId);

	void delete(EquipmentStrengthensStatId equipmentStrengthensStatId);
}
