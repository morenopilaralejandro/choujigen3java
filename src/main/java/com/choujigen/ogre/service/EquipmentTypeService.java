package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.EquipmentType;

public interface EquipmentTypeService {
	List<EquipmentType> all();

	EquipmentType one(Long id);

	EquipmentType insert(EquipmentType newObj);

	EquipmentType replace(EquipmentType newObj, Long id);

	void delete(Long id);
}
