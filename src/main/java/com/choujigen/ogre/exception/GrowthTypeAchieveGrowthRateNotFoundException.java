package com.choujigen.ogre.exception;

import com.choujigen.ogre.domain.GrowthTypeAchieveGrowthRateId;

public class GrowthTypeAchieveGrowthRateNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public GrowthTypeAchieveGrowthRateNotFoundException(GrowthTypeAchieveGrowthRateId growthTypeAchieveGrowthRateId) {
		super("Could not find GrowthTypeAchieveGrowthRate composite key(growthTypeId, growthRateId) ("
				+ growthTypeAchieveGrowthRateId.getGrowthTypeId() + ", "
				+ growthTypeAchieveGrowthRateId.getGrowthRateId() + ")");
	}

}
