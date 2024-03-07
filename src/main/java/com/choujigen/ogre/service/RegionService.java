package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.Region;

public interface RegionService {
	List<Region> all();

	Region one(Long id);

	Region insert(Region newObj);

	Region replace(Region newObj, Long id);

	void delete(Long id);
}
