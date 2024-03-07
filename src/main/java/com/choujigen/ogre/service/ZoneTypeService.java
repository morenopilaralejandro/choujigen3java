package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.ZoneType;

public interface ZoneTypeService {
	List<ZoneType> all();

	ZoneType one(Long id);

	ZoneType insert(ZoneType newObj);

	ZoneType replace(ZoneType newObj, Long id);

	void delete(Long id);
}