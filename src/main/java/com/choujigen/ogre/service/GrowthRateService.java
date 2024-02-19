package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.GrowthRate;

public interface GrowthRateService {
	List<GrowthRate> all();

	GrowthRate one(Long id);

	GrowthRate insert(GrowthRate newObj);

	GrowthRate replace(GrowthRate newObj, Long id);

	void delete(Long id);
}
