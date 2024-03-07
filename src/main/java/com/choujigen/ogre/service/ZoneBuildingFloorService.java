package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.ZoneBuildingFloor;

public interface ZoneBuildingFloorService {
	List<ZoneBuildingFloor> all();

	ZoneBuildingFloor one(Long id);

	ZoneBuildingFloor insert(ZoneBuildingFloor newObj);

	ZoneBuildingFloor replace(ZoneBuildingFloor newObj, Long id);

	void delete(Long id);
}
