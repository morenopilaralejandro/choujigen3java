package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.Npc;

public interface NpcService {
	List<Npc> all();

	Npc one(Long id);

	Npc insert(Npc newObj);

	Npc replace(Npc newObj, Long id);

	void delete(Long id);
}
