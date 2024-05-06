package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.ExtraBattleRoute;

public interface ExtraBattleRouteService {
	List<ExtraBattleRoute> all();

	ExtraBattleRoute one(Long id);

	ExtraBattleRoute insert(ExtraBattleRoute newObj);

	ExtraBattleRoute replace(ExtraBattleRoute newObj, Long id);

	void delete(Long id);
}
