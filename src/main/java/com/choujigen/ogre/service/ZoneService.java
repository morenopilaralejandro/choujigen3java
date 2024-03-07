package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.Zone;

public interface ZoneService {
	List<Zone> all();

	Zone one(Long id);

	Zone insert(Zone newObj);

	Zone replace(Zone newObj, Long id);

	void delete(Long id);
}
