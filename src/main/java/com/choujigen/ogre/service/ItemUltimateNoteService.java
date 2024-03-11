package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.ItemUltimateNote;

public interface ItemUltimateNoteService {
	List<ItemUltimateNote> all();

	ItemUltimateNote one(Long id);

	ItemUltimateNote insert(ItemUltimateNote newObj);

	ItemUltimateNote replace(ItemUltimateNote newObj, Long id);

	void delete(Long id);
}
