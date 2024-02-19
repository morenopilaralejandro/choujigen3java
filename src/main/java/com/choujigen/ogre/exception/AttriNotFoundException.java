package com.choujigen.ogre.exception;

public class AttriNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AttriNotFoundException(Long id) {
		super("Could not find Attri " + id);
	}

}
