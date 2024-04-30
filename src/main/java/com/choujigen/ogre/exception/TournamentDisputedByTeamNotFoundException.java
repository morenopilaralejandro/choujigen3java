package com.choujigen.ogre.exception;

import com.choujigen.ogre.domain.TournamentDisputedByTeamId;

public class TournamentDisputedByTeamNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TournamentDisputedByTeamNotFoundException(TournamentDisputedByTeamId tournamentDisputedByTeamId) {
		super("Could not find TournamentDisputedByTeam composite key(tournamentRankId, teamId) ("
				+ tournamentDisputedByTeamId.getTournamentRankId() + ", " + tournamentDisputedByTeamId.getTeamId()
				+ ")");
	}

}
