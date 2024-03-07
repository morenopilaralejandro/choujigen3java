package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.ZoneOuter;
import com.choujigen.ogre.exception.ZoneOuterNotFoundException;
import com.choujigen.ogre.repository.ZoneOuterRepository;

@Service
public class ZoneOuterServiceImpl implements ZoneOuterService {
	@Autowired
	private ZoneOuterRepository zoneOuterRepository;

	@Override
	public List<ZoneOuter> all() {
		return zoneOuterRepository.findAll();
	}

	@Override
	public ZoneOuter one(Long id) {
		return zoneOuterRepository.findById(id).orElseThrow(() -> new ZoneOuterNotFoundException(id));
	}

	@Override
	public ZoneOuter insert(ZoneOuter newObj) {
		return zoneOuterRepository.save(newObj);
	}

	@Override
	public ZoneOuter replace(ZoneOuter newObj, Long id) {
		return zoneOuterRepository.findById(id).map(oldObj -> {
			oldObj.setRegion(newObj.getRegion());
			return zoneOuterRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setZoneId(id);
			return zoneOuterRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		zoneOuterRepository.deleteById(id);
	}
}
