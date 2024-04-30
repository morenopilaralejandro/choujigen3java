package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.TournamentDisputedByTeam;
import com.choujigen.ogre.domain.TournamentDisputedByTeamId;

public interface TournamentDisputedByTeamService {
	List<TournamentDisputedByTeam> all();

	TournamentDisputedByTeam one(TournamentDisputedByTeamId id);

	TournamentDisputedByTeam insert(TournamentDisputedByTeam newObj);

	TournamentDisputedByTeam replace(TournamentDisputedByTeam newObj, TournamentDisputedByTeamId id);

	void delete(TournamentDisputedByTeamId id);
}
