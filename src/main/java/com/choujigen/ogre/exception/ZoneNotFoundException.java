package com.choujigen.ogre.exception;

public class ZoneNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ZoneNotFoundException(Long id) {
		super("Could not find Zone " + id);
	}

}
