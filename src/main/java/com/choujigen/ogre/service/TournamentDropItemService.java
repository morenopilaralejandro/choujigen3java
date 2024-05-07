package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.TournamentDropItem;
import com.choujigen.ogre.domain.TournamentDropItemId;

public interface TournamentDropItemService {
	List<TournamentDropItem> all();

	TournamentDropItem one(TournamentDropItemId tournamentDropItemId);

	TournamentDropItem insert(TournamentDropItem newObj);

	TournamentDropItem replace(TournamentDropItem newObj, TournamentDropItemId tournamentDropItemId);

	void delete(TournamentDropItemId tournamentDropItemId);
}
