package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.ItemEquipment;

public interface ItemEquipmentService {
	List<ItemEquipment> all();

	ItemEquipment one(Long id);

	ItemEquipment insert(ItemEquipment newObj);

	ItemEquipment replace(ItemEquipment newObj, Long id);

	void delete(Long id);
}
