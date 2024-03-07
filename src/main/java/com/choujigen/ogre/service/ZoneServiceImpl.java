package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.Zone;
import com.choujigen.ogre.exception.ZoneNotFoundException;
import com.choujigen.ogre.repository.ZoneRepository;

@Service
public class ZoneServiceImpl implements ZoneService {
	@Autowired
	private ZoneRepository zoneRepository;

	@Override
	public List<Zone> all() {
		return zoneRepository.findAll();
	}

	@Override
	public Zone one(Long id) {
		return zoneRepository.findById(id).orElseThrow(() -> new ZoneNotFoundException(id));
	}

	@Override
	public Zone insert(Zone newObj) {
		return zoneRepository.save(newObj);
	}

	@Override
	public Zone replace(Zone newObj, Long id) {
		return zoneRepository.findById(id).map(oldObj -> {
			oldObj.setZoneNameJa(newObj.getZoneNameJa());
			oldObj.setZoneNameEn(newObj.getZoneNameEn());
			oldObj.setZoneNameEs(newObj.getZoneNameEs());
			oldObj.setZoneType(newObj.getZoneType());
			return zoneRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setZoneId(id);
			return zoneRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		zoneRepository.deleteById(id);
	}
}
