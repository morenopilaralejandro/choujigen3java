package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.ItemMap;

public interface ItemMapService {
	List<ItemMap> all();

	ItemMap one(Long id);

	ItemMap insert(ItemMap newObj);

	ItemMap replace(ItemMap newObj, Long id);

	void delete(Long id);
}
