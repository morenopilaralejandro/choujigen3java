package com.choujigen.ogre.exception;

public class UtcSessionNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UtcSessionNotFoundException(Long id) {
		super("Could not find UtcSession " + id);
	}

}
