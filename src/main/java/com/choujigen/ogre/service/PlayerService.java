package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.choujigen.ogre.domain.Player;
import com.choujigen.ogre.form.PlayerSearch;

public interface PlayerService {
	List<Player> all();

	List<Player> findByPlayerIdBetween(Long startId, Long endId);

	List<Player> findByInitialEn(String initial);

	Page<Player> findByCriteriaPlayerSearch(PlayerSearch playerSearch,
			String currentLang, Pageable pageable);

	Player one(Long id);

	Player insert(Player newObj);

	Player replace(Player newObj, Long id);

	void delete(Long id);
}
