package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.ZoneLevel;

public interface ZoneLevelService {
	List<ZoneLevel> all();

	ZoneLevel one(Long id);

	ZoneLevel insert(ZoneLevel newObj);

	ZoneLevel replace(ZoneLevel newObj, Long id);

	void delete(Long id);
}
