package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.FormationScheme;

public interface FormationSchemeService {
	List<FormationScheme> all();

	FormationScheme one(Long id);

	FormationScheme insert(FormationScheme newObj);

	FormationScheme replace(FormationScheme newObj, Long id);

	void delete(Long id);
}
