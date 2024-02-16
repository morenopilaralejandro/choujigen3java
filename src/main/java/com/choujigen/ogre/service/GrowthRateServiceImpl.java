package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.GrowthRate;
import com.choujigen.ogre.exception.GrowthRateNotFoundException;
import com.choujigen.ogre.repository.GrowthRateRepository;

@Service
public class GrowthRateServiceImpl implements GrowthRateService {
	@Autowired
	private GrowthRateRepository growthRateRepository;

	@Override
	public List<GrowthRate> all() {
		return growthRateRepository.findAll();
	}

	@Override
	public GrowthRate one(Long id) {
		return growthRateRepository.findById(id).orElseThrow(() -> new GrowthRateNotFoundException(id));
	}

	@Override
	public GrowthRate insert(GrowthRate newObj) {
		return growthRateRepository.save(newObj);
	}

	@Override
	public GrowthRate replace(GrowthRate newObj, Long id) {
		return growthRateRepository.findById(id).map(oldObj -> {
			oldObj.setGrowthRateNameJa(newObj.getGrowthRateNameJa());
			oldObj.setGrowthRateNameEn(newObj.getGrowthRateNameEn());
			oldObj.setGrowthRateNameEs(newObj.getGrowthRateNameEs());
			return growthRateRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setGrowthRateId(id);
			return growthRateRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		growthRateRepository.deleteById(id);
	}
}
