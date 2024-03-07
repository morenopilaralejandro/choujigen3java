package com.choujigen.ogre.exception;

public class StorTypeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public StorTypeNotFoundException(Long id) {
		super("Could not find StorType " + id);
	}

}
