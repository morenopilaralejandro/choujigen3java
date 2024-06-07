package com.choujigen.ogre.exception;

public class UtcDropTypeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UtcDropTypeNotFoundException(Long id) {
		super("Could not find UtcDropType " + id);
	}

}
