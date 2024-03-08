package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.ZoneBuildingFloor;
import com.choujigen.ogre.exception.ZoneBuildingFloorNotFoundException;
import com.choujigen.ogre.repository.ZoneBuildingFloorRepository;

@Service
public class ZoneBuildingFloorServiceImpl implements ZoneBuildingFloorService {
	@Autowired
	private ZoneBuildingFloorRepository zoneBuildingFloorRepository;

	@Override
	public List<ZoneBuildingFloor> all() {
		return zoneBuildingFloorRepository.findAll();
	}

	@Override
	public ZoneBuildingFloor one(Long id) {
		return zoneBuildingFloorRepository.findById(id).orElseThrow(() -> new ZoneBuildingFloorNotFoundException(id));
	}

	@Override
	public ZoneBuildingFloor insert(ZoneBuildingFloor newObj) {
		return zoneBuildingFloorRepository.save(newObj);
	}

	@Override
	public ZoneBuildingFloor replace(ZoneBuildingFloor newObj, Long id) {
		return zoneBuildingFloorRepository.findById(id).map(oldObj -> {
			oldObj.setZoneNameJa(newObj.getZoneNameJa());
			oldObj.setZoneNameEn(newObj.getZoneNameEn());
			oldObj.setZoneNameEs(newObj.getZoneNameEs());
			oldObj.setZoneType(newObj.getZoneType());
			oldObj.setZoneBuilding(newObj.getZoneBuilding());
			return zoneBuildingFloorRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setZoneId(id);
			return zoneBuildingFloorRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		zoneBuildingFloorRepository.deleteById(id);
	}
}
