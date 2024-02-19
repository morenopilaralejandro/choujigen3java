package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.BodyType;

public interface BodyTypeService {
	List<BodyType> all();

	BodyType one(Long id);

	BodyType insert(BodyType newObj);

	BodyType replace(BodyType newObj, Long id);

	void delete(Long id);
}
