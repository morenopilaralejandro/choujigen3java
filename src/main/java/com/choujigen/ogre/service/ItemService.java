package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.Item;

public interface ItemService {
	List<Item> all();

	Item one(Long id);

	Item insert(Item newObj);

	Item replace(Item newObj, Long id);

	void delete(Long id);
}
