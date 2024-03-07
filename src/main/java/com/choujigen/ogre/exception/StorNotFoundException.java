package com.choujigen.ogre.exception;

public class StorNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public StorNotFoundException(Long id) {
		super("Could not find Stor " + id);
	}

}
