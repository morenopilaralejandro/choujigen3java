package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.HissatsuSkill;

public interface HissatsuSkillService {
	List<HissatsuSkill> all();

	HissatsuSkill one(Long id);

	HissatsuSkill insert(HissatsuSkill newObj);

	HissatsuSkill replace(HissatsuSkill newObj, Long id);

	void delete(Long id);
}
