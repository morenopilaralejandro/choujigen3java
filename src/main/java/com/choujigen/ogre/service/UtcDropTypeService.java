package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.UtcDropType;

public interface UtcDropTypeService {
	List<UtcDropType> all();

	UtcDropType one(Long id);

	UtcDropType insert(UtcDropType newObj);

	UtcDropType replace(UtcDropType newObj, Long id);

	void delete(Long id);
}
