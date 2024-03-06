package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.ItemWear;

public interface ItemWearService {
	List<ItemWear> all();

	ItemWear one(Long id);

	ItemWear insert(ItemWear newObj);

	ItemWear replace(ItemWear newObj, Long id);

	void delete(Long id);
}
