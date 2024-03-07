package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.Region;
import com.choujigen.ogre.exception.RegionNotFoundException;
import com.choujigen.ogre.repository.RegionRepository;

@Service
public class RegionServiceImpl implements RegionService {
	@Autowired
	private RegionRepository regionRepository;

	@Override
	public List<Region> all() {
		return regionRepository.findAll();
	}

	@Override
	public Region one(Long id) {
		return regionRepository.findById(id).orElseThrow(() -> new RegionNotFoundException(id));
	}

	@Override
	public Region insert(Region newObj) {
		return regionRepository.save(newObj);
	}

	@Override
	public Region replace(Region newObj, Long id) {
		return regionRepository.findById(id).map(oldObj -> {
			oldObj.setRegionNameJa(newObj.getRegionNameJa());
			oldObj.setRegionNameEn(newObj.getRegionNameEn());
			oldObj.setRegionNameEs(newObj.getRegionNameEs());
			return regionRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setRegionId(id);
			return regionRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		regionRepository.deleteById(id);
	}
}
