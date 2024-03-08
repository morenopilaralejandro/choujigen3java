package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.PlayerObtentionMethod;

public interface PlayerObtentionMethodService {
	List<PlayerObtentionMethod> all();

	PlayerObtentionMethod one(Long id);

	PlayerObtentionMethod insert(PlayerObtentionMethod newObj);

	PlayerObtentionMethod replace(PlayerObtentionMethod newObj, Long id);

	void delete(Long id);
}
