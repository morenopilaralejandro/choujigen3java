package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.ItemVscard;

public interface ItemVscardService {
	List<ItemVscard> all();

	ItemVscard one(Long id);

	ItemVscard insert(ItemVscard newObj);

	ItemVscard replace(ItemVscard newObj, Long id);

	void delete(Long id);
}
