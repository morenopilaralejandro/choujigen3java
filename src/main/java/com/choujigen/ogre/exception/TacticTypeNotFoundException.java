package com.choujigen.ogre.exception;

public class TacticTypeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TacticTypeNotFoundException(Long id) {
		super("Could not find TacticType " + id);
	}

}
