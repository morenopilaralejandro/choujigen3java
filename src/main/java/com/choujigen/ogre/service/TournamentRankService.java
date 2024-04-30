package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.TournamentRank;

public interface TournamentRankService {
	List<TournamentRank> all();

	TournamentRank one(Long id);

	TournamentRank insert(TournamentRank newObj);

	TournamentRank replace(TournamentRank newObj, Long id);

	void delete(Long id);
}
