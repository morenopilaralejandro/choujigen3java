package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.ZoneType;
import com.choujigen.ogre.exception.ZoneTypeNotFoundException;
import com.choujigen.ogre.repository.ZoneTypeRepository;

@Service
public class ZoneTypeServiceImpl implements ZoneTypeService {
	@Autowired
	private ZoneTypeRepository zoneTypeRepository;

	@Override
	public List<ZoneType> all() {
		return zoneTypeRepository.findAll();
	}

	@Override
	public ZoneType one(Long id) {
		return zoneTypeRepository.findById(id).orElseThrow(() -> new ZoneTypeNotFoundException(id));
	}

	@Override
	public ZoneType insert(ZoneType newObj) {
		return zoneTypeRepository.save(newObj);
	}

	@Override
	public ZoneType replace(ZoneType newObj, Long id) {
		return zoneTypeRepository.findById(id).map(oldObj -> {
			oldObj.setZoneTypeName(newObj.getZoneTypeName());
			return zoneTypeRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setZoneTypeId(id);
			return zoneTypeRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		zoneTypeRepository.deleteById(id);
	}
}
