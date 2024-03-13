package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.PlayerIsPartOfTeam;
import com.choujigen.ogre.domain.PlayerIsPartOfTeamId;

public interface PlayerIsPartOfTeamService {
	List<PlayerIsPartOfTeam> all();

	PlayerIsPartOfTeam one(PlayerIsPartOfTeamId playerIsPartOfTeamId);

	PlayerIsPartOfTeam insert(PlayerIsPartOfTeam newObj);

	PlayerIsPartOfTeam replace(PlayerIsPartOfTeam newObj, PlayerIsPartOfTeamId playerIsPartOfTeamId);

	void delete(PlayerIsPartOfTeamId playerIsPartOfTeamId);
}
