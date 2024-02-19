package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.GrowthType;

public interface GrowthTypeService {
	List<GrowthType> all();

	GrowthType one(Long id);

	GrowthType insert(GrowthType newObj);

	GrowthType replace(GrowthType newObj, Long id);

	void delete(Long id);
}
