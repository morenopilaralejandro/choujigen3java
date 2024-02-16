package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.GrowthType;
import com.choujigen.ogre.exception.GrowthTypeNotFoundException;
import com.choujigen.ogre.repository.GrowthTypeRepository;

@Service
public class GrowthTypeServiceImpl implements GrowthTypeService {
	@Autowired
	private GrowthTypeRepository growthTypeRepository;

	@Override
	public List<GrowthType> all() {
		return growthTypeRepository.findAll();
	}

	@Override
	public GrowthType one(Long id) {
		return growthTypeRepository.findById(id).orElseThrow(() -> new GrowthTypeNotFoundException(id));
	}

	@Override
	public GrowthType insert(GrowthType newObj) {
		return growthTypeRepository.save(newObj);
	}

	@Override
	public GrowthType replace(GrowthType newObj, Long id) {
		return growthTypeRepository.findById(id).map(oldObj -> {
			oldObj.setGrowthTypeNameJa(newObj.getGrowthTypeNameJa());
			oldObj.setGrowthTypeNameEn(newObj.getGrowthTypeNameEn());
			oldObj.setGrowthTypeNameEs(newObj.getGrowthTypeNameEs());
			return growthTypeRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setGrowthTypeId(id);
			return growthTypeRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		growthTypeRepository.deleteById(id);
	}
}
