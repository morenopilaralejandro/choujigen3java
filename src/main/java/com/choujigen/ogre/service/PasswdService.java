package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.Passwd;

public interface PasswdService {
	List<Passwd> all();

	Passwd one(Long id);

	Passwd insert(Passwd newObj);

	Passwd replace(Passwd newObj, Long id);

	void delete(Long id);
}
