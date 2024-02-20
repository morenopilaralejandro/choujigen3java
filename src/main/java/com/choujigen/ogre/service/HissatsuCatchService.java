package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.HissatsuCatch;

public interface HissatsuCatchService {
	List<HissatsuCatch> all();

	HissatsuCatch one(Long id);

	HissatsuCatch insert(HissatsuCatch newObj);

	HissatsuCatch replace(HissatsuCatch newObj, Long id);

	void delete(Long id);
}
