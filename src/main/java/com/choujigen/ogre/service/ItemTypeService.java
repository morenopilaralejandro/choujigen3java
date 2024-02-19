package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.ItemType;

public interface ItemTypeService {
	List<ItemType> all();

	ItemType one(Long id);

	ItemType insert(ItemType newObj);

	ItemType replace(ItemType newObj, Long id);

	void delete(Long id);
}
