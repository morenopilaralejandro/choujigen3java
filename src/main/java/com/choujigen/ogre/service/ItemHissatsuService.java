package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.ItemHissatsu;

public interface ItemHissatsuService {
	List<ItemHissatsu> all();

	ItemHissatsu one(Long id);

	ItemHissatsu insert(ItemHissatsu newObj);

	ItemHissatsu replace(ItemHissatsu newObj, Long id);

	void delete(Long id);
}
