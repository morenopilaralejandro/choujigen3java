package com.choujigen.ogre.exception;

public class ZoneOuterNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ZoneOuterNotFoundException(Long id) {
		super("Could not find ZoneOuter " + id);
	}

}
