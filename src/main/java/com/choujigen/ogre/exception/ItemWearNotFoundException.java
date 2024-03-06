package com.choujigen.ogre.exception;

public class ItemWearNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ItemWearNotFoundException(Long id) {
		super("Could not find ItemWear " + id);
	}

}
