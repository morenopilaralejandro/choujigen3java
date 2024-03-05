package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.Gender;

public interface GenderService {
	List<Gender> all();

	Gender one(Long id);

	Gender insert(Gender newObj);

	Gender replace(Gender newObj, Long id);

	void delete(Long id);
}
