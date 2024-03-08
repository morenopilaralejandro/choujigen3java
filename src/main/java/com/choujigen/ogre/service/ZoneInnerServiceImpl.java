package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.ZoneInner;
import com.choujigen.ogre.exception.ZoneInnerNotFoundException;
import com.choujigen.ogre.repository.ZoneInnerRepository;

@Service
public class ZoneInnerServiceImpl implements ZoneInnerService {
	@Autowired
	private ZoneInnerRepository zoneInnerRepository;

	@Override
	public List<ZoneInner> all() {
		return zoneInnerRepository.findAll();
	}

	@Override
	public ZoneInner one(Long id) {
		return zoneInnerRepository.findById(id).orElseThrow(() -> new ZoneInnerNotFoundException(id));
	}

	@Override
	public ZoneInner insert(ZoneInner newObj) {
		return zoneInnerRepository.save(newObj);
	}

	@Override
	public ZoneInner replace(ZoneInner newObj, Long id) {
		return zoneInnerRepository.findById(id).map(oldObj -> {
			oldObj.setZoneNameJa(newObj.getZoneNameJa());
			oldObj.setZoneNameEn(newObj.getZoneNameEn());
			oldObj.setZoneNameEs(newObj.getZoneNameEs());
			oldObj.setZoneType(newObj.getZoneType());
			oldObj.setZoneOuter(newObj.getZoneOuter());
			return zoneInnerRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setZoneId(id);
			return zoneInnerRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		zoneInnerRepository.deleteById(id);
	}
}
