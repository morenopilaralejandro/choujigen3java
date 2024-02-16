package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.ShootSpecialProperty;

public interface ShootSpecialPropertyService {
	List<ShootSpecialProperty> all();
	ShootSpecialProperty one(Long id);
	ShootSpecialProperty insert(ShootSpecialProperty newObj);
	ShootSpecialProperty replace(ShootSpecialProperty newObj, Long id);
	void delete(Long id);
}
