package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.UtcSessionDrops;
import com.choujigen.ogre.domain.UtcSessionDropsId;

public interface UtcSessionDropsService {
	List<UtcSessionDrops> all();

	UtcSessionDrops one(UtcSessionDropsId utcSessionDropsId);

	UtcSessionDrops insert(UtcSessionDrops newObj);

	UtcSessionDrops replace(UtcSessionDrops newObj, UtcSessionDropsId utcSessionDropsId);

	void delete(UtcSessionDropsId utcSessionDropsId);
}
