package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.TacticSide;

public interface TacticSideService {
	List<TacticSide> all();

	TacticSide one(Long id);

	TacticSide insert(TacticSide newObj);

	TacticSide replace(TacticSide newObj, Long id);

	void delete(Long id);
}
