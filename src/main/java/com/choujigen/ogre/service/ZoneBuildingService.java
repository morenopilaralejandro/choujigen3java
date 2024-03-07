package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.ZoneBuilding;

public interface ZoneBuildingService {
	List<ZoneBuilding> all();

	ZoneBuilding one(Long id);

	ZoneBuilding insert(ZoneBuilding newObj);

	ZoneBuilding replace(ZoneBuilding newObj, Long id);

	void delete(Long id);
}
