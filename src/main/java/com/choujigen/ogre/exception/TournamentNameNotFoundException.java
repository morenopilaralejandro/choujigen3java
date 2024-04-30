package com.choujigen.ogre.exception;

public class TournamentNameNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TournamentNameNotFoundException(Long id) {
		super("Could not find TournamentName " + id);
	}

}
