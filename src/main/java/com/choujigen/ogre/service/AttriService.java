package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.Attri;

public interface AttriService {
	List<Attri> all();

	Attri one(Long id);

	Attri insert(Attri newObj);

	Attri replace(Attri newObj, Long id);

	void delete(Long id);
}
