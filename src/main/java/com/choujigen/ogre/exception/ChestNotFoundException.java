package com.choujigen.ogre.exception;

public class ChestNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ChestNotFoundException(Long id) {
		super("Could not find Chest " + id);
	}

}
