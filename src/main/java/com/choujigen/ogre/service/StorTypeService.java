package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.StorType;

public interface StorTypeService {
	List<StorType> all();

	StorType one(Long id);

	StorType insert(StorType newObj);

	StorType replace(StorType newObj, Long id);

	void delete(Long id);
}
