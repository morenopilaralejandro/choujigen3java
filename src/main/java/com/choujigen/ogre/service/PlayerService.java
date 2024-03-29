package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.Player;

public interface PlayerService {
	List<Player> all();

	Player one(Long id);

	Player insert(Player newObj);

	Player replace(Player newObj, Long id);

	void delete(Long id);
}
