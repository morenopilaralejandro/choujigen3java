package com.choujigen.ogre.exception;

public class ItemKeyNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ItemKeyNotFoundException(Long id) {
		super("Could not find ItemKey " + id);
	}

}
