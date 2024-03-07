package com.choujigen.ogre.exception;

public class ZoneInnerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ZoneInnerNotFoundException(Long id) {
		super("Could not find ZoneInner " + id);
	}

}
