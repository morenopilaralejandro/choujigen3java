package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.Stor;

public interface StorService {
	List<Stor> all();

	Stor one(Long id);

	Stor insert(Stor newObj);

	Stor replace(Stor newObj, Long id);

	void delete(Long id);
}
