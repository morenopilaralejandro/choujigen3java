package com.choujigen.ogre.exception;

import com.choujigen.ogre.domain.PlayerIsPartOfTeamId;

public class PlayerIsPartOfTeamNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PlayerIsPartOfTeamNotFoundException(PlayerIsPartOfTeamId playerIsPartOfTeamId) {
		super("Could not find PlayerIsPartOfTeam composite key(playerId, teamId) (" + playerIsPartOfTeamId.getPlayerId()
				+ ", " + playerIsPartOfTeamId.getTeamId() + ")");
	}

}
