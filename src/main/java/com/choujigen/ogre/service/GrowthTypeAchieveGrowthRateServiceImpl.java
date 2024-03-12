package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.GrowthTypeAchieveGrowthRate;
import com.choujigen.ogre.domain.GrowthTypeAchieveGrowthRateId;
import com.choujigen.ogre.exception.GrowthTypeAchieveGrowthRateNotFoundException;
import com.choujigen.ogre.repository.GrowthTypeAchieveGrowthRateRepository;

@Service
public class GrowthTypeAchieveGrowthRateServiceImpl implements GrowthTypeAchieveGrowthRateService {
	@Autowired
	private GrowthTypeAchieveGrowthRateRepository growthTypeAchieveGrowthRateRepository;

	@Override
	public List<GrowthTypeAchieveGrowthRate> all() {
		return growthTypeAchieveGrowthRateRepository.findAll();
	}

	@Override
	public GrowthTypeAchieveGrowthRate one(GrowthTypeAchieveGrowthRateId growthTypeAchieveGrowthRateId) {
		return growthTypeAchieveGrowthRateRepository.findById(growthTypeAchieveGrowthRateId)
				.orElseThrow(() -> new GrowthTypeAchieveGrowthRateNotFoundException(growthTypeAchieveGrowthRateId));
	}

	@Override
	public GrowthTypeAchieveGrowthRate insert(GrowthTypeAchieveGrowthRate newObj) {
		return growthTypeAchieveGrowthRateRepository.save(newObj);
	}

	@Override
	public GrowthTypeAchieveGrowthRate replace(GrowthTypeAchieveGrowthRate newObj,
			GrowthTypeAchieveGrowthRateId growthTypeAchieveGrowthRateId) {
		return growthTypeAchieveGrowthRateRepository.findById(growthTypeAchieveGrowthRateId).map(oldObj -> {
			oldObj.setAdditionalPower(newObj.getAdditionalPower());
			oldObj.setNumberOfUses(newObj.getNumberOfUses());
			return growthTypeAchieveGrowthRateRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setId(growthTypeAchieveGrowthRateId);
			return growthTypeAchieveGrowthRateRepository.save(newObj);
		});
	}

	@Override
	public void delete(GrowthTypeAchieveGrowthRateId growthTypeAchieveGrowthRateId) {
		growthTypeAchieveGrowthRateRepository.deleteById(growthTypeAchieveGrowthRateId);
	}
}
