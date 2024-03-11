package com.choujigen.ogre.exception;

public class ItemMapNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ItemMapNotFoundException(Long id) {
		super("Could not find ItemMap " + id);
	}

}
