package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.GrowthTypeAchieveGrowthRate;
import com.choujigen.ogre.domain.GrowthTypeAchieveGrowthRateId;

public interface GrowthTypeAchieveGrowthRateService {
	List<GrowthTypeAchieveGrowthRate> all();

	GrowthTypeAchieveGrowthRate one(GrowthTypeAchieveGrowthRateId growthTypeAchieveGrowthRateId);

	GrowthTypeAchieveGrowthRate insert(GrowthTypeAchieveGrowthRate newObj);

	GrowthTypeAchieveGrowthRate replace(GrowthTypeAchieveGrowthRate newObj, GrowthTypeAchieveGrowthRateId growthTypeAchieveGrowthRateId);

	void delete(GrowthTypeAchieveGrowthRateId growthTypeAchieveGrowthRateId);
}
