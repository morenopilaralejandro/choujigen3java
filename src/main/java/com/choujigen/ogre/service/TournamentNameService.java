package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.TournamentName;

public interface TournamentNameService {
	List<TournamentName> all();

	TournamentName one(Long id);

	TournamentName insert(TournamentName newObj);

	TournamentName replace(TournamentName newObj, Long id);

	void delete(Long id);
}
