package com.choujigen.ogre.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.choujigen.ogre.domain.GrowthTypeAchieveGrowthRate;
import com.choujigen.ogre.domain.GrowthTypeAchieveGrowthRateId;

public interface GrowthTypeAchieveGrowthRateRepository extends JpaRepository<GrowthTypeAchieveGrowthRate, Long> {

	Optional<GrowthTypeAchieveGrowthRate> findById(GrowthTypeAchieveGrowthRateId growthTypeAchieveGrowthRateId);

}
