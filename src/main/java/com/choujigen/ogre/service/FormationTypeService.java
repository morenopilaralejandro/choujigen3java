package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.FormationType;

public interface FormationTypeService {
	List<FormationType> all();

	FormationType one(Long id);

	FormationType insert(FormationType newObj);

	FormationType replace(FormationType newObj, Long id);

	void delete(Long id);
}
