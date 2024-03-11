package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.ItemKey;

public interface ItemKeyService {
	List<ItemKey> all();

	ItemKey one(Long id);

	ItemKey insert(ItemKey newObj);

	ItemKey replace(ItemKey newObj, Long id);

	void delete(Long id);
}
