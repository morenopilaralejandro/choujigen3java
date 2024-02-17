package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.GrowthTypeAchieveGrowthRate;

public interface GrowthTypeAchieveGrowthRateService {
	List<GrowthTypeAchieveGrowthRate> all();
	GrowthTypeAchieveGrowthRate one(Long growthTypeId, Long growthRateId);
	GrowthTypeAchieveGrowthRate insert(GrowthTypeAchieveGrowthRate newObj);
	GrowthTypeAchieveGrowthRate replace(GrowthTypeAchieveGrowthRate newObj, Long growthTypeId, Long growthRateId);
	void delete(Long id);
}
