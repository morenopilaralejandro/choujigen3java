package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.HissatsuDribble;

public interface HissatsuDribbleService {
	List<HissatsuDribble> all();

	HissatsuDribble one(Long id);

	HissatsuDribble insert(HissatsuDribble newObj);

	HissatsuDribble replace(HissatsuDribble newObj, Long id);

	void delete(Long id);
}
