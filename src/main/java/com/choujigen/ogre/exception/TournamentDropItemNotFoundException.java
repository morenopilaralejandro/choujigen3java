package com.choujigen.ogre.exception;

import com.choujigen.ogre.domain.TournamentDropItemId;

public class TournamentDropItemNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TournamentDropItemNotFoundException(TournamentDropItemId tournamentDropItemId) {
		super("Could not find TournamentDropItem composite key(tournamentRankId, itemId, amountId) ("
				+ tournamentDropItemId.getTournamentRankId() + ", " + tournamentDropItemId.getItemId() + ", "
				+ tournamentDropItemId.getAmountId() + ")");
	}

}
