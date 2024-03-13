package com.choujigen.ogre.exception;

public class TeamNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TeamNotFoundException(Long id) {
		super("Could not find Team " + id);
	}

}
