package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.ZoneLevel;
import com.choujigen.ogre.exception.ZoneLevelNotFoundException;
import com.choujigen.ogre.repository.ZoneLevelRepository;

@Service
public class ZoneLevelServiceImpl implements ZoneLevelService {
	@Autowired
	private ZoneLevelRepository zoneLevelRepository;

	@Override
	public List<ZoneLevel> all() {
		return zoneLevelRepository.findAll();
	}

	@Override
	public ZoneLevel one(Long id) {
		return zoneLevelRepository.findById(id).orElseThrow(() -> new ZoneLevelNotFoundException(id));
	}

	@Override
	public ZoneLevel insert(ZoneLevel newObj) {
		return zoneLevelRepository.save(newObj);
	}

	@Override
	public ZoneLevel replace(ZoneLevel newObj, Long id) {
		return zoneLevelRepository.findById(id).map(oldObj -> {
			oldObj.setZoneNameJa(newObj.getZoneNameJa());
			oldObj.setZoneNameEn(newObj.getZoneNameEn());
			oldObj.setZoneNameEs(newObj.getZoneNameEs());
			oldObj.setZoneType(newObj.getZoneType());
			oldObj.setZoneInner(newObj.getZoneInner());
			return zoneLevelRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setZoneId(id);
			return zoneLevelRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		zoneLevelRepository.deleteById(id);
	}
}
