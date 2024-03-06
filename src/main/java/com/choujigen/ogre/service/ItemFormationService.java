package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.ItemFormation;

public interface ItemFormationService {
	List<ItemFormation> all();

	ItemFormation one(Long id);

	ItemFormation insert(ItemFormation newObj);

	ItemFormation replace(ItemFormation newObj, Long id);

	void delete(Long id);
}
