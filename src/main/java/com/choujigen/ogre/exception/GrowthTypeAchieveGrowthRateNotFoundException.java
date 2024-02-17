package com.choujigen.ogre.exception;

public class GrowthTypeAchieveGrowthRateNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public GrowthTypeAchieveGrowthRateNotFoundException(Long growthTypeId, Long growthRateId) {
		super("Could not find GrowthTypeAchieveGrowthRate composite key(growthTypeId, growthRateId) (" + growthTypeId + ", " + growthRateId + ")");
	}

}
