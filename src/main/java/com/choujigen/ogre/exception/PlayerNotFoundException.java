package com.choujigen.ogre.exception;

public class PlayerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PlayerNotFoundException(Long id) {
		super("Could not find Player " + id);
	}

}
