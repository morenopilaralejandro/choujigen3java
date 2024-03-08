package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.Stat;

public interface StatService {
	List<Stat> all();

	Stat one(Long id);

	Stat insert(Stat newObj);

	Stat replace(Stat newObj, Long id);

	void delete(Long id);
}
