package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.PlayerFoundAtZone;

public interface PlayerFoundAtZoneService {
	List<PlayerFoundAtZone> all();

	PlayerFoundAtZone one(Long id);

	PlayerFoundAtZone insert(PlayerFoundAtZone newObj);

	PlayerFoundAtZone replace(PlayerFoundAtZone newObj, Long id);

	void delete(Long id);
}
