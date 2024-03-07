package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.ZoneOuter;

public interface ZoneOuterService {
	List<ZoneOuter> all();

	ZoneOuter one(Long id);

	ZoneOuter insert(ZoneOuter newObj);

	ZoneOuter replace(ZoneOuter newObj, Long id);

	void delete(Long id);
}
