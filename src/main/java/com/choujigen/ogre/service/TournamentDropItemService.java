package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.TournamentDropItem;
import com.choujigen.ogre.domain.TournamentDropItemId;

public interface TournamentDropItemService {
	List<TournamentDropItem> all();

	TournamentDropItem one(TournamentDropItemId formationOrganizedAsPositiId);

	TournamentDropItem insert(TournamentDropItem newObj);

	TournamentDropItem replace(TournamentDropItem newObj, TournamentDropItemId formationOrganizedAsPositiId);

	void delete(TournamentDropItemId formationOrganizedAsPositiId);
}
