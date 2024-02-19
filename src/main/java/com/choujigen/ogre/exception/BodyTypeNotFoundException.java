package com.choujigen.ogre.exception;

public class BodyTypeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BodyTypeNotFoundException(Long id) {
		super("Could not find BodyType " + id);
	}

}
