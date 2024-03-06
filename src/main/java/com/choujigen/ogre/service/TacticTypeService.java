package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.TacticType;

public interface TacticTypeService {
	List<TacticType> all();

	TacticType one(Long id);

	TacticType insert(TacticType newObj);

	TacticType replace(TacticType newObj, Long id);

	void delete(Long id);
}
