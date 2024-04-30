package com.choujigen.ogre.exception;

public class TournamentRankNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TournamentRankNotFoundException(Long id) {
		super("Could not find TournamentRank " + id);
	}

}
