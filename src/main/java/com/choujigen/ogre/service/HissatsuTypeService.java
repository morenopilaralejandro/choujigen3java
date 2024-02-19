package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.HissatsuType;

public interface HissatsuTypeService {
	List<HissatsuType> all();

	HissatsuType one(Long id);

	HissatsuType insert(HissatsuType newObj);

	HissatsuType replace(HissatsuType newObj, Long id);

	void delete(Long id);
}
