package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.PlayerFoundAtZone;
import com.choujigen.ogre.exception.PlayerFoundAtZoneNotFoundException;
import com.choujigen.ogre.repository.PlayerFoundAtZoneRepository;

@Service
public class PlayerFoundAtZoneServiceImpl implements PlayerFoundAtZoneService {
	@Autowired
	private PlayerFoundAtZoneRepository playerFoundAtZoneRepository;

	@Override
	public List<PlayerFoundAtZone> all() {
		return playerFoundAtZoneRepository.findAll();
	}

	@Override
	public PlayerFoundAtZone one(Long id) {
		return playerFoundAtZoneRepository.findById(id).orElseThrow(() -> new PlayerFoundAtZoneNotFoundException(id));
	}

	@Override
	public PlayerFoundAtZone insert(PlayerFoundAtZone newObj) {
		return playerFoundAtZoneRepository.save(newObj);
	}

	@Override
	public PlayerFoundAtZone replace(PlayerFoundAtZone newObj, Long id) {
		return playerFoundAtZoneRepository.findById(id).map(oldObj -> {
			oldObj.setPlayer(newObj.getPlayer());
			oldObj.setZone(newObj.getZone());
			oldObj.setRandom(newObj.isRandom());
			oldObj.setHintJa(newObj.getHintJa());
			oldObj.setHintEn(newObj.getHintEn());
			oldObj.setHintEs(newObj.getHintEs());
			return playerFoundAtZoneRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setPlayerId(id);
			return playerFoundAtZoneRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		playerFoundAtZoneRepository.deleteById(id);
	}
}
