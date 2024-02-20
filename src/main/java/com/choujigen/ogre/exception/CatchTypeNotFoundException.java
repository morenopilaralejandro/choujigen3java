package com.choujigen.ogre.exception;

public class CatchTypeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CatchTypeNotFoundException(Long id) {
		super("Could not find CatchType " + id);
	}

}
