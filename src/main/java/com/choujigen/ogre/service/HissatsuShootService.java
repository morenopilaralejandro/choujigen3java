package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.HissatsuShoot;

public interface HissatsuShootService {
	List<HissatsuShoot> all();

	HissatsuShoot one(Long id);

	HissatsuShoot insert(HissatsuShoot newObj);

	HissatsuShoot replace(HissatsuShoot newObj, Long id);

	void delete(Long id);
}
