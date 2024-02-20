package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.CatchType;

public interface CatchTypeService {
	List<CatchType> all();

	CatchType one(Long id);

	CatchType insert(CatchType newObj);

	CatchType replace(CatchType newObj, Long id);

	void delete(Long id);
}
