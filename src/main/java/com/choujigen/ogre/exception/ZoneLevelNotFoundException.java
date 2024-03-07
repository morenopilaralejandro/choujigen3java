package com.choujigen.ogre.exception;

public class ZoneLevelNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ZoneLevelNotFoundException(Long id) {
		super("Could not find ZoneLevel " + id);
	}

}
