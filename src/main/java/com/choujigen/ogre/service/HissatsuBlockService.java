package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.HissatsuBlock;

public interface HissatsuBlockService {
	List<HissatsuBlock> all();

	HissatsuBlock one(Long id);

	HissatsuBlock insert(HissatsuBlock newObj);

	HissatsuBlock replace(HissatsuBlock newObj, Long id);

	void delete(Long id);
}
