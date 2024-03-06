package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.ItemTactic;

public interface ItemTacticService {
	List<ItemTactic> all();

	ItemTactic one(Long id);

	ItemTactic insert(ItemTactic newObj);

	ItemTactic replace(ItemTactic newObj, Long id);

	void delete(Long id);
}
