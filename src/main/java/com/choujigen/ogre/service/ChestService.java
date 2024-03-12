package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.Chest;

public interface ChestService {
	List<Chest> all();

	Chest one(Long id);

	Chest insert(Chest newObj);

	Chest replace(Chest newObj, Long id);

	void delete(Long id);
}
