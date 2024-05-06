package com.choujigen.ogre.exception;

public class ItemVscardNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ItemVscardNotFoundException(Long id) {
		super("Could not find ItemVscard " + id);
	}

}
