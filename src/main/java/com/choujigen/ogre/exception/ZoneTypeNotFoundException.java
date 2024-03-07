package com.choujigen.ogre.exception;

public class ZoneTypeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ZoneTypeNotFoundException(Long id) {
		super("Could not find ZoneType " + id);
	}

}
