package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.ZoneBuilding;
import com.choujigen.ogre.exception.ZoneBuildingNotFoundException;
import com.choujigen.ogre.repository.ZoneBuildingRepository;

@Service
public class ZoneBuildingServiceImpl implements ZoneBuildingService {
	@Autowired
	private ZoneBuildingRepository zoneBuildingRepository;

	@Override
	public List<ZoneBuilding> all() {
		return zoneBuildingRepository.findAll();
	}

	@Override
	public ZoneBuilding one(Long id) {
		return zoneBuildingRepository.findById(id).orElseThrow(() -> new ZoneBuildingNotFoundException(id));
	}

	@Override
	public ZoneBuilding insert(ZoneBuilding newObj) {
		return zoneBuildingRepository.save(newObj);
	}

	@Override
	public ZoneBuilding replace(ZoneBuilding newObj, Long id) {
		return zoneBuildingRepository.findById(id).map(oldObj -> {
			oldObj.setZoneLevel(newObj.getZoneLevel());
			return zoneBuildingRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setZoneId(id);
			return zoneBuildingRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		zoneBuildingRepository.deleteById(id);
	}
}
