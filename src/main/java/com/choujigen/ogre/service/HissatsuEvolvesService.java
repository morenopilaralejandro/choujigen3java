package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.HissatsuEvolves;

public interface HissatsuEvolvesService {
	List<HissatsuEvolves> all();

	HissatsuEvolves one(Long itemHissatsuId, Long growthTypeId, Long growthRateId);

	HissatsuEvolves insert(HissatsuEvolves newObj);

	HissatsuEvolves replace(HissatsuEvolves newObj, Long itemHissatsuId, Long growthTypeId, Long growthRateId);

	void delete(Long itemHissatsuId, Long growthTypeId, Long growthRateId);
}
