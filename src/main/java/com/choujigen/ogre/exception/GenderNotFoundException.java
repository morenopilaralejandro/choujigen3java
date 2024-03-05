package com.choujigen.ogre.exception;

public class GenderNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public GenderNotFoundException(Long id) {
		super("Could not find Gender " + id);
	}

}
